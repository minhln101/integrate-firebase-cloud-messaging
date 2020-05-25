package vn.nerdcode.notification_service.service.impl;

import com.google.auth.oauth2.GoogleCredentials;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import vn.nerdcode.notification_service.dto.request.FcmBasicNotificationTemplate;
import vn.nerdcode.notification_service.dto.request.FcmTopicRequestDto;
import vn.nerdcode.notification_service.dto.response.FcmTopicResponse;
import vn.nerdcode.notification_service.service.FcmNotificationService;
import vn.nerdcode.notification_service.util.Constant;

/**
 * Created by Minh Lee on 22/05/2020.
 */

@Service
@Slf4j
public class FcmNotificationServiceImpl implements FcmNotificationService {

  @Value("${firebase.url}")
  private String firebaseUrl;

  @Value("${firebase.auth-scope}")
  private String authScope;

  @Value("${firebase.credential}")
  private Resource credentialResource;

  @Autowired
  private RestTemplate restTemplate;

  @Override
  public FcmTopicResponse pushToTopic(FcmTopicRequestDto data) {
    JSONObject msgPayload = buildMsgPayload(Constant.FCM_TARGET_TOPIC, data.getTopic(),
        data.getNotificationPayload());
    HttpEntity<String> httpEntity = null;
    try {
      httpEntity = new HttpEntity<>(msgPayload.toString(), buildRequestHeaders());
    } catch (IOException e) {
      log.error(
          "Exception occurred while getting credential from credential resource {}, detail error message: {}",
          credentialResource.getFilename(), e.getMessage());
    }

    log.info("Preparing to push notification from payload {}", msgPayload);

    ResponseEntity<FcmTopicResponse> response = restTemplate
        .postForEntity(firebaseUrl, httpEntity, FcmTopicResponse.class);
    log.info("Push notification to topic {}, got response {}", data.getTopic(), response);

    return response.getBody();
  }

  /**
   * Authorize access to FCM with service-account.json from the provided credential resource.
   *
   * @return GoogleCredentials access token, refresh token if token expired.
   */
  private String getAccessToken() throws IOException {
    GoogleCredentials googleCredentials = GoogleCredentials
        .fromStream(credentialResource.getInputStream())
        .createScoped(authScope);
    googleCredentials.refreshIfExpired();
    return googleCredentials.getAccessToken().getTokenValue();
  }

  /**
   * Build request header with Content-Type as application/json, Authorise with Bearer token.
   *
   * @return httpHeaders.
   */
  private HttpHeaders buildRequestHeaders() throws IOException {
    HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.setContentType(MediaType.APPLICATION_JSON);
    httpHeaders.setBearerAuth(getAccessToken());
    return httpHeaders;
  }

  private static JSONObject buildMsgPayload(String target, String targetValue,
      FcmBasicNotificationTemplate data) {
    JSONObject notification = new JSONObject();
    notification.put(Constant.FCM_NOTIFICATION_OBJECT_KEY, new JSONObject(data));
    JSONObject msgPayload = new JSONObject();
    msgPayload.put(Constant.FCM_MSG_OBJECT_KEY, notification);
    msgPayload.getJSONObject(Constant.FCM_MSG_OBJECT_KEY).put(target, targetValue);
    return msgPayload;
  }

}

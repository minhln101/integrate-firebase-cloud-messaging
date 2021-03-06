package vn.nerdcode.notification_service.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.nerdcode.notification_service.dto.request.FcmConditionRequestDto;
import vn.nerdcode.notification_service.dto.request.FcmTokenRequestDto;
import vn.nerdcode.notification_service.dto.request.FcmTopicRequestDto;
import vn.nerdcode.notification_service.dto.response.FcmSingleResponse;
import vn.nerdcode.notification_service.service.FcmNotificationService;

/**
 * Created by Minh Lee on 22/05/2020.
 */

@RestController
@RequestMapping("api/v1/fcm-notification")
public class FcmNotificationController {

  @Autowired
  private FcmNotificationService fcmNotificationService;

  @PostMapping("single-topic")
  public ResponseEntity<FcmSingleResponse> pushToTopic(@Valid @RequestBody FcmTopicRequestDto data) {
    return ResponseEntity.ok(fcmNotificationService.pushToTopic(data));
  }

  @PostMapping("single-device")
  public ResponseEntity<FcmSingleResponse> pushToToken(@Valid @RequestBody FcmTokenRequestDto data) {
    return ResponseEntity.ok(fcmNotificationService.pushToToken(data));
  }

  @PostMapping("with-condition")
  public ResponseEntity<FcmSingleResponse> pushWithCondition(@Valid @RequestBody
      FcmConditionRequestDto data) {
    return ResponseEntity.ok(fcmNotificationService.pushWithCondition(data));
  }
}

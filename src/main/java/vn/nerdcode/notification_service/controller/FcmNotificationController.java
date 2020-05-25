package vn.nerdcode.notification_service.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.nerdcode.notification_service.dto.request.FcmTopicRequestDto;
import vn.nerdcode.notification_service.dto.response.FcmTopicResponse;
import vn.nerdcode.notification_service.service.FcmNotificationService;

/**
 * Created by Minh Lee on 22/05/2020.
 */

@RestController
@RequestMapping("api/v1/fcm-notification")
public class FcmNotificationController {

  @Autowired
  private FcmNotificationService fcmNotificationService;

  @PostMapping
  public ResponseEntity<FcmTopicResponse> pushToTopic(@Valid @RequestBody FcmTopicRequestDto data) {
    return ResponseEntity.ok(fcmNotificationService.pushToTopic(data));
  }
}

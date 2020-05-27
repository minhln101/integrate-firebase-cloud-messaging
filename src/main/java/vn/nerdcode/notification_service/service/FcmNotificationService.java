package vn.nerdcode.notification_service.service;

import vn.nerdcode.notification_service.dto.request.FcmConditionRequestDto;
import vn.nerdcode.notification_service.dto.request.FcmTokenRequestDto;
import vn.nerdcode.notification_service.dto.request.FcmTopicRequestDto;
import vn.nerdcode.notification_service.dto.response.FcmTopicResponse;

/**
 * Created by Minh Lee on 22/05/2020.
 */
public interface FcmNotificationService {

  /**
   * Push notification to a specific topic.
   *
   * @param data provide a topic and notification payload
   * @return name with Firebase message ID
   */
  FcmTopicResponse pushToTopic(FcmTopicRequestDto data);

  /**
   * Push notification to a specific device.
   *
   * @param data provide a device token and notification payload
   * @return name with Firebase message ID
   */
  FcmTopicResponse pushToToken(FcmTokenRequestDto data);

  /**
   * Push notification with a condition, which is a boolean expression that specifies the target
   * topics.
   *
   * @param data provide a device token and notification payload
   * @return name with Firebase message ID
   */
  FcmTopicResponse pushWithCondition(FcmConditionRequestDto data);

}

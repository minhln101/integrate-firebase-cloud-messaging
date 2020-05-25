package vn.nerdcode.notification_service.service;

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
}

package vn.nerdcode.notification_service.dto.request;

import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by Minh Lee on 22/05/2020.
 *
 * This class defines all required properties to build a message payload so that we can use it as a
 * request body to send via FCM provided API.
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FcmTopicRequestDto extends FcmRequestDto {

  /**
   * This property denotes a specific topic that created on the FCM console.
   *
   * The prefix "/topics/" is optional.
   */
  @NotBlank(message = "err.fcm-request.topic-is-required")
  private String topic;
}

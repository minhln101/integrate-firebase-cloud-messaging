package vn.nerdcode.notification_service.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by Minh Lee on 27/05/2020.
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FcmConditionRequestDto extends FcmRequestDto {

  /**
   * The combination of topics, which is a boolean expression that specifies the target topics.
   *
   * <u>Example: </u> "'TopicA' in topics && ('TopicB' in topics || 'TopicC' in topics)"
   */
  private String condition;
}

package vn.nerdcode.notification_service.dto.request;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.io.Serializable;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by Minh Lee on 22/05/2020.
 *
 * <p>This class defines all properties of the basic notification template
 * to use across all platforms, provided by FCM reference
 * <a>https://firebase.google.com/docs/reference/fcm/rest/v1/projects.messages#Notification</a>.
 * </p>
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonPropertyOrder(value = {"title", "body", "image"})
@ToString
public class FcmBasicNotificationTemplate implements Serializable {

  /**
   * This property denotes the title of notification.
   */
  @NotBlank(message = "err.fcm-notification.title-is-required")
  private String title;

  /**
   * This property denotes the content of notification.
   */
  @NotBlank(message = "err.fcm-notification.body-is-required")
  private String body;

  /**
   * This property denotes the image comes along with notification if it does exist.
   */
  private String image;
}

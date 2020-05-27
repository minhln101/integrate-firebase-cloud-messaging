package vn.nerdcode.notification_service.dto.request;

import java.io.Serializable;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by Minh Lee on 27/05/2020.
 */

@Getter
@Setter
public class FcmRequestDto implements Serializable {

  /**
   * Basic notification template to use across all platforms.
   */
  @NotNull(message = "err.fcm-request.notification-payload-is-required")
  private FcmBasicNotificationTemplate notificationPayload;
}

package vn.nerdcode.notification_service.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import vn.nerdcode.notification_service.dto.request.FcmBasicNotificationTemplate;

/**
 * Created by Minh Lee on 22/05/2020.
 *
 * This object defines all data that may be included inside the response body.
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class FcmTopicResponse implements Serializable {

  private String name;
  private Map<String, String> data;
  private FcmBasicNotificationTemplate notification;

}

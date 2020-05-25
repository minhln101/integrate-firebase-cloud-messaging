package vn.nerdcode.notification_service.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by Minh Lee on 22/05/2020.
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class SendMulticastMsgResponse implements Serializable {

  @JsonProperty("multicast_id")
  private Long multicastId;
  private Integer success;
  private Integer failure;
  private List<String> results;

  @Getter
  @Setter
  @NoArgsConstructor
  @AllArgsConstructor
  @Builder
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class ResponseResult implements Serializable{

    @JsonProperty("message_id")
    private String messageId;
    @JsonProperty("registration_id")
    private String registrationId;
    private String error;
  }
}

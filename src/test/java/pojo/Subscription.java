
package pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.jackson.Jacksonized;

@Getter
@Setter
@Jacksonized
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Subscription {

    @JsonProperty("status")
    public String status;
    @JsonProperty("t")
    public Long t;
    @JsonProperty("prev_status")
    public String prevStatus;

    /**
     * No args constructor for use in serialization
     *
     */
    public Subscription() {
    }

    /**
     *
     * @param t
     * @param status
     * @param prevStatus
     */
    public Subscription(String status, Long t, String prevStatus) {
        super();
        this.status = status;
        this.t = t;
        this.prevStatus = prevStatus;
    }

}

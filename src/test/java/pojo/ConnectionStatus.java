
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
public class ConnectionStatus {

    @JsonProperty("status")
    public Boolean status;
    @JsonProperty("time")
    public Long time;
    @JsonProperty("location")
    public Location location;
    @JsonProperty("info_string")
    public String infoString;

    /**
     * No args constructor for use in serialization
     *
     */
    public ConnectionStatus() {
    }

    /**
     *
     * @param infoString
     * @param location
     * @param time
     * @param status
     */
    public ConnectionStatus(Boolean status, Long time, Location location, String infoString) {
        super();
        this.status = status;
        this.time = time;
        this.location = location;
        this.infoString = infoString;
    }

}

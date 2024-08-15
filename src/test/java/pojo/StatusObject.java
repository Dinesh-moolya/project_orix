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
public class StatusObject {

    @JsonProperty("state")
    public String state;
    @JsonProperty("last_update")
    public Long lastUpdate;

    /**
     * No args constructor for use in serialization
     *
     */
    public StatusObject() {
    }

    /**
     *
     * @param lastUpdate
     * @param state
     */
    public StatusObject(String state, Long lastUpdate) {
        super();
        this.state = state;
        this.lastUpdate = lastUpdate;
    }

}

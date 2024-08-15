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
public class TotalEngineHours {

    @JsonProperty("timestamp")
    public Long timestamp;
    @JsonProperty("value")
    public Float value;

    /**
     * No args constructor for use in serialization
     *
     */
    public TotalEngineHours() {
    }

    /**
     *
     * @param value
     * @param timestamp
     */
    public TotalEngineHours(Long timestamp, Float value) {
        super();
        this.timestamp = timestamp;
        this.value = value;
    }

}

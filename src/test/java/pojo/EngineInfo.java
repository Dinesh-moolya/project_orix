
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
public class EngineInfo {

    @JsonProperty("total_engine_hours")
    public TotalEngineHours totalEngineHours;

    /**
     * No args constructor for use in serialization
     *
     */
    public EngineInfo() {
    }

    /**
     *
     * @param totalEngineHours
     */
    public EngineInfo(TotalEngineHours totalEngineHours) {
        super();
        this.totalEngineHours = totalEngineHours;
    }

}

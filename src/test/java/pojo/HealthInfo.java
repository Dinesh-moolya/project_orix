
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
public class HealthInfo {

    @JsonProperty("score")
    public Integer score;
    @JsonProperty("last_update")
    public Long lastUpdate;

    /**
     * No args constructor for use in serialization
     *
     */
    public HealthInfo() {
    }

    /**
     *
     * @param score
     * @param lastUpdate
     */
    public HealthInfo(Integer score, Long lastUpdate) {
        super();
        this.score = score;
        this.lastUpdate = lastUpdate;
    }

}

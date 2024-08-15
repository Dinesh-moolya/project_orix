
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
public class Fuel {

    @JsonProperty("amount")
    public Integer amount;
    @JsonProperty("last_update")
    public Long lastUpdate;

    /**
     * No args constructor for use in serialization
     *
     */
    public Fuel() {
    }

    /**
     *
     * @param amount
     * @param lastUpdate
     */
    public Fuel(Integer amount, Long lastUpdate) {
        super();
        this.amount = amount;
        this.lastUpdate = lastUpdate;
    }

}

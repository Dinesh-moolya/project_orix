
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
public class LocationPageEnabled {

    @JsonProperty("customer")
    public Boolean customer;
    @JsonProperty("intangles")
    public Boolean intangles;

    /**
     * No args constructor for use in serialization
     *
     */
    public LocationPageEnabled() {
    }

    /**
     *
     * @param intangles
     * @param customer
     */
    public LocationPageEnabled(Boolean customer, Boolean intangles) {
        super();
        this.customer = customer;
        this.intangles = intangles;
    }

}

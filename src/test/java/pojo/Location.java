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
public class Location {

    @JsonProperty("fix")
    public Integer fix;
    @JsonProperty("lat")
    public Float lat;
    @JsonProperty("lng")
    public Float lng;

    /**
     * No args constructor for use in serialization
     *
     */
    public Location() {
    }

    /**
     *
     * @param fix
     * @param lng
     * @param lat
     */
    public Location(Integer fix, Float lat, Float lng) {
        super();
        this.fix = fix;
        this.lat = lat;
        this.lng = lng;
    }

}

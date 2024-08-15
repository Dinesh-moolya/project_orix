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
public class Loc {

    @JsonProperty("lat")
    public String lat;
    @JsonProperty("lng")
    public String lng;

    /**
     * No args constructor for use in serialization
     *
     */
    public Loc() {
    }

    /**
     *
     * @param lng
     * @param lat
     */
    public Loc(String lat, String lng) {
        super();
        this.lat = lat;
        this.lng = lng;
    }

}

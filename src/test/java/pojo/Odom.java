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
public class Odom {

    @JsonProperty("vehicle_odo_km")
    public Integer vehicleOdoKm;
    @JsonProperty("vehicle_odo_km_timestamp")
    public Long vehicleOdoKmTimestamp;

    /**
     * No args constructor for use in serialization
     *
     */
    public Odom() {
    }

    /**
     *
     * @param vehicleOdoKm
     * @param vehicleOdoKmTimestamp
     */
    public Odom(Integer vehicleOdoKm, Long vehicleOdoKmTimestamp) {
        super();
        this.vehicleOdoKm = vehicleOdoKm;
        this.vehicleOdoKmTimestamp = vehicleOdoKmTimestamp;
    }

}

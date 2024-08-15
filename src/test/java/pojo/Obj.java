
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
public class Obj {

    @JsonProperty("formattedAddress")
    public String formattedAddress;
    @JsonProperty("latitude")
    public Float latitude;
    @JsonProperty("longitude")
    public Float longitude;
    @JsonProperty("extra")
    public Extra extra;
    @JsonProperty("administrativeLevels")
    public AdministrativeLevels administrativeLevels;
    @JsonProperty("streetName")
    public String streetName;
    @JsonProperty("city")
    public String city;
    @JsonProperty("country")
    public String country;
    @JsonProperty("countryCode")
    public String countryCode;
    @JsonProperty("zipcode")
    public String zipcode;
    @JsonProperty("provider")
    public String provider;

    /**
     * No args constructor for use in serialization
     *
     */
    public Obj() {
    }

    /**
     *
     * @param zipcode
     * @param country
     * @param streetName
     * @param formattedAddress
     * @param administrativeLevels
     * @param city
     * @param provider
     * @param countryCode
     * @param latitude
     * @param extra
     * @param longitude
     */
    public Obj(String formattedAddress, Float latitude, Float longitude, Extra extra,
            AdministrativeLevels administrativeLevels, String streetName, String city, String country,
            String countryCode, String zipcode, String provider) {
        super();
        this.formattedAddress = formattedAddress;
        this.latitude = latitude;
        this.longitude = longitude;
        this.extra = extra;
        this.administrativeLevels = administrativeLevels;
        this.streetName = streetName;
        this.city = city;
        this.country = country;
        this.countryCode = countryCode;
        this.zipcode = zipcode;
        this.provider = provider;
    }

}

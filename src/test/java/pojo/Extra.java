
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
public class Extra {

    @JsonProperty("googlePlaceId")
    public String googlePlaceId;
    @JsonProperty("confidence")
    public Float confidence;
    @JsonProperty("premise")
    public Object premise;
    @JsonProperty("subpremise")
    public Object subpremise;
    @JsonProperty("neighborhood")
    public String neighborhood;
    @JsonProperty("establishment")
    public Object establishment;

    /**
     * No args constructor for use in serialization
     *
     */
    public Extra() {
    }

    /**
     *
     * @param googlePlaceId
     * @param premise
     * @param confidence
     * @param establishment
     * @param neighborhood
     * @param subpremise
     */
    public Extra(String googlePlaceId, Float confidence, Object premise, Object subpremise, String neighborhood,
            Object establishment) {
        super();
        this.googlePlaceId = googlePlaceId;
        this.confidence = confidence;
        this.premise = premise;
        this.subpremise = subpremise;
        this.neighborhood = neighborhood;
        this.establishment = establishment;
    }

}

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
public class AdBlue {

    @JsonProperty("lvl")
    public Float lvl;
    @JsonProperty("per")
    public Integer per;
    @JsonProperty("t")
    public Long t;

    /**
     * No args constructor for use in serialization
     *
     */
    public AdBlue() {
    }

    /**
     *
     * @param lvl
     * @param t
     * @param per
     */
    public AdBlue(Float lvl, Integer per, Long t) {
        super();
        this.lvl = lvl;
        this.per = per;
        this.t = t;
    }

}

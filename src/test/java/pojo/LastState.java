
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
public class LastState {

    @JsonProperty("timestamp")
    public Long timestamp;
    @JsonProperty("loc")
    public Loc loc;
    @JsonProperty("fix")
    public Integer fix;
    @JsonProperty("hd")
    public Float hd;
    @JsonProperty("sp")
    public Integer sp;
    @JsonProperty("exb")
    public Integer exb;

    /**
     * No args constructor for use in serialization
     *
     */
    public LastState() {
    }

    /**
     *
     * @param loc
     * @param fix
     * @param hd
     * @param sp
     * @param exb
     * @param timestamp
     */
    public LastState(Long timestamp, Loc loc, Integer fix, Float hd, Integer sp, Integer exb) {
        super();
        this.timestamp = timestamp;
        this.loc = loc;
        this.fix = fix;
        this.hd = hd;
        this.sp = sp;
        this.exb = exb;
    }

}

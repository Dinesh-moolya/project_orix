
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
public class DtcsNew {

    @JsonProperty("code")
    public String code;
    @JsonProperty("status")
    public Integer status;
    @JsonProperty("is_sid")
    public Boolean isSid;
    @JsonProperty("mid")
    public Integer mid;
    @JsonProperty("count")
    public Integer count;
    @JsonProperty("protocol")
    public String protocol;
    @JsonProperty("t")
    public Long t;
    @JsonProperty("engine_run_hrs")
    public Float engineRunHrs;
    @JsonProperty("vehicle_odo_info")
    public Integer vehicleOdoInfo;
    @JsonProperty("in_grace_period")
    public Boolean inGracePeriod;
    @JsonProperty("oc")
    public Integer oc;

    /**
     * No args constructor for use in serialization
     *
     */
    public DtcsNew() {
    }

    /**
     *
     * @param engineRunHrs
     * @param inGracePeriod
     * @param protocol
     * @param code
     * @param t
     * @param oc
     * @param count
     * @param isSid
     * @param mid
     * @param vehicleOdoInfo
     * @param status
     */
    public DtcsNew(String code, Integer status, Boolean isSid, Integer mid, Integer count, String protocol, Long t,
            Float engineRunHrs, Integer vehicleOdoInfo, Boolean inGracePeriod, Integer oc) {
        super();
        this.code = code;
        this.status = status;
        this.isSid = isSid;
        this.mid = mid;
        this.count = count;
        this.protocol = protocol;
        this.t = t;
        this.engineRunHrs = engineRunHrs;
        this.vehicleOdoInfo = vehicleOdoInfo;
        this.inGracePeriod = inGracePeriod;
        this.oc = oc;
    }

}

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
public class Idevice {

    @JsonProperty("id")
    public String id;
    @JsonProperty("imei")
    public String imei;
    @JsonProperty("t")
    public Long t;

    /**
     * No args constructor for use in serialization
     *
     */
    public Idevice() {
    }

    /**
     *
     * @param t
     * @param imei
     * @param id
     */
    public Idevice(String id, String imei, Long t) {
        super();
        this.id = id;
        this.imei = imei;
        this.t = t;
    }

}

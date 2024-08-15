
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
public class Dtcs {

    @JsonProperty("t")
    public Long t;
    @JsonProperty("list")
    public java.util.List<List> list;

    /**
     * No args constructor for use in serialization
     *
     */
    public Dtcs() {
    }

    /**
     *
     * @param t
     * @param list
     */
    public Dtcs(Long t, java.util.List<List> list) {
        super();
        this.t = t;
        this.list = list;
    }

}

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
public class Paging {

    @JsonProperty("psize")
    public Integer psize;
    @JsonProperty("pnum")
    public Integer pnum;
    @JsonProperty("total")
    public Integer total;

    /**
     * No args constructor for use in serialization
     *
     */
    public Paging() {
    }

    /**
     *
     * @param psize
     * @param pnum
     * @param total
     */
    public Paging(Integer psize, Integer pnum, Integer total) {
        super();
        this.psize = psize;
        this.pnum = pnum;
        this.total = total;
    }

}

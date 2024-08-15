
package pojo;

import java.util.List;
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
public class Vehicle {

    @JsonProperty("paging")
    public Paging paging;
    @JsonProperty("v")
    public List<V> v;
    @JsonProperty("status")
    public Status status;

    /**
     * No args constructor for use in serialization
     *
     */
    public Vehicle() {
    }

    /**
     *
     * @param v
     * @param paging
     * @param status
     */
    public Vehicle(Paging paging, List<V> v, Status status) {
        super();
        this.paging = paging;
        this.v = v;
        this.status = status;
    }

}

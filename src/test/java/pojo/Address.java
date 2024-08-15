
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
public class Address {

    @JsonProperty("address")
    public String address;
    @JsonProperty("obj")
    public Obj obj;
    @JsonProperty("internal")
    public Boolean internal;
    @JsonProperty("status")
    public Status status;

    /**
     * No args constructor for use in serialization
     *
     */
    public Address() {
    }

    /**
     *
     * @param internal
     * @param address
     * @param obj
     * @param status
     */
    public Address(String address, Obj obj, Boolean internal, Status status) {
        super();
        this.address = address;
        this.obj = obj;
        this.internal = internal;
        this.status = status;
    }

}


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
public class Geofence {

    @JsonProperty("inhub")
    public Boolean inhub;
    @JsonProperty("id")
    public String id;
    @JsonProperty("last_fence")
    public String lastFence;
    @JsonProperty("last_update")
    public Long lastUpdate;
    @JsonProperty("last_entered")
    public String lastEntered;
    @JsonProperty("last_exited")
    public String lastExited;

    /**
     * No args constructor for use in serialization
     *
     */
    public Geofence() {
    }

    /**
     *
     * @param lastFence
     * @param lastUpdate
     * @param inhub
     * @param id
     * @param lastEntered
     * @param lastExited
     */
    public Geofence(Boolean inhub, String id, String lastFence, Long lastUpdate, String lastEntered,
            String lastExited) {
        super();
        this.inhub = inhub;
        this.id = id;
        this.lastFence = lastFence;
        this.lastUpdate = lastUpdate;
        this.lastEntered = lastEntered;
        this.lastExited = lastExited;
    }

}

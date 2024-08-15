
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
public class AdministrativeLevels {

    @JsonProperty("level2long")
    public String level2long;
    @JsonProperty("level2short")
    public String level2short;
    @JsonProperty("level1long")
    public String level1long;
    @JsonProperty("level1short")
    public String level1short;

    /**
     * No args constructor for use in serialization
     *
     */
    public AdministrativeLevels() {
    }

    /**
     *
     * @param level2long
     * @param level2short
     * @param level1long
     * @param level1short
     */
    public AdministrativeLevels(String level2long, String level2short, String level1long, String level1short) {
        super();
        this.level2long = level2long;
        this.level2short = level2short;
        this.level1long = level1long;
        this.level1short = level1short;
    }

}

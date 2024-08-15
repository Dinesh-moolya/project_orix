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
public class Login {
    public Login(String username, String pwd) {
        this.username = username;
        this.pwd = pwd;
    }

    @JsonProperty("username")
    public String username;

    @JsonProperty("pwd")
    public String pwd;

}
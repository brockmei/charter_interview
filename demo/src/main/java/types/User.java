package types;

import com.fasterxml.jackson.annotation.JsonProperty;

public record User(@JsonProperty("password")String password) {

}

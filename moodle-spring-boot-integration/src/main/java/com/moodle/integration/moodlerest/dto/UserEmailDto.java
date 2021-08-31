package com.moodle.integration.moodlerest.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserEmailDto {
    @JsonProperty(required = true)
    String email;
}

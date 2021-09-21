package com.spring.rest.systembankpayments.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;

@Setter
@Getter
public class ClientDto {

    @JsonProperty("id")
    @Null
    private long idClient;

    @JsonProperty("firstName")
    @NotBlank
    private String firstName;

    @JsonProperty("lastName")
    @NotBlank
    private String lastName;

    @JsonProperty("phoneNumber")
    @NotBlank
    private String phoneNumber;

    @JsonProperty("email")
    @NotBlank
    @Email
    private String email;
}

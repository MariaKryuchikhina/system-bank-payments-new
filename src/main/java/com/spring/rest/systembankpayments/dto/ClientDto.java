package com.spring.rest.systembankpayments.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

@Setter
@Getter
public class ClientDto {

    @JsonProperty("idClient")
    @Null
    private long idClient;

    @JsonProperty("firstName")
    @NotBlank
    @Size(min = 2, max = 30)
    private String firstName;

    @JsonProperty("lastName")
    @NotBlank
    @Size(min = 2, max = 30)
    private String lastName;

    @JsonProperty("phoneNumber")
    @NotBlank
    @Size(max = 16)
    private String phoneNumber;

    @JsonProperty("email")
    @NotBlank
    @Email
    private String email;
}

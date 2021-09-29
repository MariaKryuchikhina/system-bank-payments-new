package com.spring.rest.systembankpayments.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Data
@Builder
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
//    @Pattern(regexp = "\\+7[0-9]{10}", message = "Телефонный номер должен начинаться с +7, затем - 10 цифр")
    private String phoneNumber;

    @JsonProperty("email")
    @NotBlank
//    @Email
    private String email;
}

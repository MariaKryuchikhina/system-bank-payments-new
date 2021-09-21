package com.spring.rest.systembankpayments.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.spring.rest.systembankpayments.entity.Type.TypeAccount;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class DepositAccountDto {

    @JsonProperty("id")
    @Null
    private long id;

    @JsonProperty("number")
    @NotBlank
    private String number;

    @JsonProperty("type")
    @NotBlank
    @Enumerated(EnumType.STRING)
    private TypeAccount type;

    @JsonProperty("expirationDate")
    @NotBlank
    private Date expirationDate;

    @JsonProperty("amount")
    @NotBlank
    private int amount;

    @JsonProperty("interestRate")
    @NotBlank
    private double interestRate;
}

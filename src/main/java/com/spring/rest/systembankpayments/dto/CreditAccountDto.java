package com.spring.rest.systembankpayments.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.spring.rest.systembankpayments.entity.Type.TypeAccount;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@Setter
@NoArgsConstructor
public class CreditAccountDto {

    @JsonProperty("id")
    private long id;

    @JsonProperty("number")
    private String number;

    @JsonProperty("type")
    @Enumerated(EnumType.STRING)
    private TypeAccount type;

    @JsonProperty("creditLimit")
    private int creditLimit; //кредитный лимит

    @JsonProperty("interestRate")
    private double interestRate; //процентная ставка

    @JsonProperty("currentDebt")
    private int currentDebt; //текущая задолженность

    @JsonProperty("accruedInterest")
    private double accruedInterest; //начисленные проценты
}

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
public class MainAccountDto {

    @JsonProperty("id")
    private long id;

    @JsonProperty("number")
    private String number;

    @JsonProperty("type")
    @Enumerated(EnumType.STRING)
    private TypeAccount type;

    @JsonProperty("amount")
    private int amount;
}

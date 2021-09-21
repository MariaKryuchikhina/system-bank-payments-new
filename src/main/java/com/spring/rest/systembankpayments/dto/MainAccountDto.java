package com.spring.rest.systembankpayments.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.spring.rest.systembankpayments.entity.Type.TypeAccount;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Positive;
import java.util.Date;

@Getter
@Setter
public class MainAccountDto {

    @JsonProperty("id")
    @Null
    private long id;

    @JsonProperty("number")
    @NotBlank
    private String number;

    @JsonProperty("type")
    @NotNull
    @Enumerated(EnumType.STRING)
    private TypeAccount type;

    @JsonProperty("expirationDate")
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    @NotBlank
    private Date expirationDate;

    @JsonProperty("amount")
    @NotNull
    @Positive
    @JsonFormat(shape= JsonFormat.Shape.STRING)
    private int amount;
}

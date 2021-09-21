package com.spring.rest.systembankpayments.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Setter
@Getter
public class ClientAllDto {

    @JsonProperty("id")
    private long idClient;

    @JsonProperty("firstName")
    private String firstName;

    @JsonProperty("lastName")
    private String lastName;

    @JsonProperty("phoneNumber")
    private String phoneNumber;

    @JsonProperty("email")
    private String email;

    @JsonProperty("mainAccounts")
    private List<MainAccountDto> mainAccounts;

    @JsonProperty("depositAccounts")
    private List<DepositAccountDto> depositAccounts;

    @JsonProperty("creditAccounts")
    private List<CreditAccountDto> creditAccounts;
}

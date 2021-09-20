package com.spring.rest.systembankpayments.mapper;

import com.spring.rest.systembankpayments.dto.*;
import com.spring.rest.systembankpayments.entity.Client;
import com.spring.rest.systembankpayments.entity.CreditAccount;
import com.spring.rest.systembankpayments.entity.DepositAccount;
import com.spring.rest.systembankpayments.entity.MainAccount;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClientMapper {


    ClientDto clientToClientDto(Client client);

    @Mapping(target = "creditAccounts", source = "client.creditAccount")
    @Mapping(target = "depositAccounts", source = "client.depositAccount")
    @Mapping(target = "mainAccounts", source = "client.mainAccount")
    ClientAllDto clientAllToClientDto(Client client);

    MainAccountDto mainAccountToClientDto(MainAccount mainAccount);

    DepositAccountDto depositAccountToClientDto(DepositAccount depositAccount);

    CreditAccountDto creditAccountToClientDto(CreditAccount creditAccount);
}

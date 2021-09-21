package com.spring.rest.systembankpayments.mapper;

import com.spring.rest.systembankpayments.dto.*;
import com.spring.rest.systembankpayments.entity.Client;
import com.spring.rest.systembankpayments.entity.CreditAccount;
import com.spring.rest.systembankpayments.entity.DepositAccount;
import com.spring.rest.systembankpayments.entity.MainAccount;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import java.util.List;

@Mapper()
public interface ClientMapper {

    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    ClientDto clientToClientDto(Client client);

    List<ClientDto> clientsToClientDto(List<Client> clients);

    @Mapping(target = "creditAccounts", source = "client.creditAccount")
    @Mapping(target = "depositAccounts", source = "client.depositAccount")
    @Mapping(target = "mainAccounts", source = "client.mainAccount")
    ClientAllDto clientAllToClientDto(Client client);

    MainAccountDto mainAccountToClientDto(MainAccount mainAccount);

    List<MainAccountDto> mainAccountsDto(List<MainAccount> mainAccounts);

    DepositAccountDto depositAccountToClientDto(DepositAccount depositAccount);

    List<DepositAccountDto> depositAccountsDto(List<DepositAccount> depositAccounts);

    CreditAccountDto creditAccountToClientDto(CreditAccount creditAccount);

    List<CreditAccountDto> creditAccountsDto(List<CreditAccount> creditAccounts);
}

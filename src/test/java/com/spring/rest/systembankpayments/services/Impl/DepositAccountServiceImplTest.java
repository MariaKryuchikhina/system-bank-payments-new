package com.spring.rest.systembankpayments.services.Impl;

import com.spring.rest.systembankpayments.entity.DepositAccount;
import com.spring.rest.systembankpayments.entity.Type.TypeAccount;
import com.spring.rest.systembankpayments.repositories.DepositAccountRepository;
import com.spring.rest.systembankpayments.services.DepositAccountService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Date;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class DepositAccountServiceImplTest {

    @Mock
    private DepositAccountRepository depositAccount;
    private DepositAccountService depositAccountService;

    @BeforeEach
    void setUp() {
        depositAccountService = new DepositAccountServiceImpl(depositAccount);
    }

    @Test
    void findAll() {
        depositAccountService.findAll();
        verify(depositAccount).findAll();
    }

    @Test
    void findById() {
        long id = 1L;
        depositAccountService.findById(id);
        verify(depositAccount).findById(id);
    }

    @Test
    void save() {
        Date date = new Date();

        DepositAccount deposit = DepositAccount.builder()
                .id(2L)
                .expirationDate(date)
                .number("6764643536757")
                .type(TypeAccount.DEPOSIT)
                .interestRate(0.15)
                .amount(300000)
                .build();

        depositAccountService.save(deposit);

        ArgumentCaptor<DepositAccount> depositAccountArgumentCaptor = ArgumentCaptor.forClass(DepositAccount.class);

        verify(depositAccount).save(depositAccountArgumentCaptor.capture());

        DepositAccount depositAccountCaptor = depositAccountArgumentCaptor.getValue();

        assertThat(depositAccountCaptor).isEqualTo(deposit);
    }

    @Test
    void deleteById() {
        long id = 1L;
        depositAccountService.deleteById(id);
        verify(depositAccount).deleteById(id);
    }
}
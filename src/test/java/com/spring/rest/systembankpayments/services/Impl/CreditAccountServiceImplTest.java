package com.spring.rest.systembankpayments.services.Impl;

import com.spring.rest.systembankpayments.entity.CreditAccount;
import com.spring.rest.systembankpayments.entity.MainAccount;
import com.spring.rest.systembankpayments.entity.Type.TypeAccount;
import com.spring.rest.systembankpayments.repositories.CreditAccountRepository;
import com.spring.rest.systembankpayments.services.CreditAccountService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import java.util.Date;

import static org.mockito.Mockito.verify;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CreditAccountServiceImplTest {

    @Mock
    private CreditAccountRepository creditAccountRepository;
    private CreditAccountService creditAccountService;

    @BeforeEach
    void setUp() {
        creditAccountService = new CreditAccountServiceImpl(creditAccountRepository);
    }

    @Test
    void findAll() {
        creditAccountService.findAll();
        verify(creditAccountRepository).findAll();
    }

    @Test
    void findById() {
        long id = 1L;
        creditAccountService.findById(id);
        verify(creditAccountRepository).findById(id);
    }

    @Test
    void save() {
        Date date = new Date();

        CreditAccount credit = CreditAccount.builder()
                .id(2L)
                .creditLimit(120000)
                .expirationDate(date)
                .number("858976349873580349676")
                .type(TypeAccount.CREDIT)
                .accruedInterest(0.12)
                .interestRate(0.15)
                .currentDebt(50000)
                .build();

        creditAccountService.save(credit);

        ArgumentCaptor<CreditAccount> creditAccountArgumentCaptor = ArgumentCaptor.forClass(CreditAccount.class);

        verify(creditAccountRepository).save(creditAccountArgumentCaptor.capture());

        CreditAccount creditAccountCaptor = creditAccountArgumentCaptor.getValue();

        assertThat(creditAccountCaptor).isEqualTo(credit);
    }

    @Test
    void deleteById() {
        long id = 1L;
        creditAccountService.deleteById(id);
        verify(creditAccountRepository).deleteById(id);
    }
}
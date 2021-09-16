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
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CreditAccountServiceImplTest {

    @Mock
    private CreditAccountRepository creditAccountRepository;
    private CreditAccountService creditAccountService;

    Date date1 = new Date();
    Date date2 = new Date();
    Date date3 = new Date();

    CreditAccount creditAccount1 = new CreditAccount(1L, "786534783952", date1, TypeAccount.CREDIT,
            3000000, 0.15, 500000, 0.20);
    CreditAccount creditAccount2 = new CreditAccount(2L, "090754342435", date2, TypeAccount.CREDIT,
            290000, 0.08, 4600000, 0.15);
    CreditAccount creditAccount3 = new CreditAccount(3L, "864354689876", date3, TypeAccount.CREDIT,
            50000, 0.05, 4540, 0.10);

    List<CreditAccount> creditAccountsLists = List.of(creditAccount1, creditAccount2, creditAccount3);

    @BeforeEach
    void setUp() {
        creditAccountService = new CreditAccountServiceImpl(creditAccountRepository);
    }

    @Test
    void findAll() {
        Mockito.when(creditAccountService.findAll()).thenReturn(creditAccountsLists);
        creditAccountService.findAll();
        verify(creditAccountRepository).findAll();
    }

    @Test
    void findById() {
        Mockito.when(creditAccountRepository.findById(creditAccount1.getId())).thenReturn(Optional.of(creditAccount1));

        long id = 1L;
        creditAccountService.findById(id);
        verify(creditAccountRepository).findById(id);
    }

    @Test
    void findByIdNotFound(){

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
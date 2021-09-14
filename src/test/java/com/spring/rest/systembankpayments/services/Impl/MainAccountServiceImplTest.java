package com.spring.rest.systembankpayments.services.Impl;

import com.spring.rest.systembankpayments.entity.MainAccount;
import com.spring.rest.systembankpayments.entity.Type.TypeAccount;
import com.spring.rest.systembankpayments.repositories.MainAccountRepository;
import com.spring.rest.systembankpayments.services.MainAccountService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.mockito.Mockito.verify;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class MainAccountServiceImplTest {

    @Mock
    private MainAccountRepository mainAccountRepository;
    private MainAccountService mainAccountService;

    @BeforeEach
    void setUp() {
        mainAccountService = new MainAccountServiceImpl(mainAccountRepository);
    }

    @Test
    void findAll() {
        mainAccountService.findAll();
        verify(mainAccountRepository).findAll();
    }

    @Test
    void findById() {
        mainAccountService.findById(12L);
        verify(mainAccountRepository).findById(12L);
    }

    @Test
    void save() {
        Date date = new Date();

        MainAccount account = MainAccount.builder()
                .id(1L)
                .amount(12000)
                .expirationDate(date)
                .number("23243543543623124")
                .type(TypeAccount.MAIN)
                .build();

        mainAccountService.save(account);

        ArgumentCaptor<MainAccount> mainAccountArgumentCaptor = ArgumentCaptor.forClass(MainAccount.class);

        verify(mainAccountRepository).save(mainAccountArgumentCaptor.capture());

        MainAccount mainAccountCaptore = mainAccountArgumentCaptor.getValue();

        assertThat(mainAccountCaptore).isEqualTo(account);

    }

    @Test
    void deleteById() {
        long id = 5L;
        mainAccountService.deleteById(id);
        verify(mainAccountRepository).deleteById(id);

    }
}
package com.spring.rest.systembankpayments.services.Impl;

import com.spring.rest.systembankpayments.entity.Client;
import com.spring.rest.systembankpayments.repositories.ClientRepository;
import com.spring.rest.systembankpayments.services.ClientService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.web.WebAppConfiguration;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

//@SpringBootTest
@ExtendWith(MockitoExtension.class)
class ClientServiceImplTest {

    @Mock
    private ClientRepository clientRepository;
    private ClientService clientService;
//    Client client1 = new Client(1L, "Anna", "Vasileva",
//            "65445434", "anna@gmail.com");
//    Client client2 = new Client(2L, "Anton", "Ivanov",
//            "756543", "anton@gmail.com");
//    Client client3 = new Client(3L, "Alla", "Ivanova",
//            "12134", "alla@gmail.com");

    @BeforeEach
    void setUp() {
        clientService = new ClientServiceImpl(clientRepository);
    }

    @Test
    void findAll() {
        clientService.findAll();
        verify(clientRepository).findAll();
//        List<Client> clients = List.of(client1, client2, client3);
////        Assertions.assertAll(()->assertEquals(c1, clients.get(0)),
////                ()->assertEquals(c2, clients.get(1)),
////                ()->assertEquals(c3, clients.get(2)));
////        Mockito.when((clientRepository.findAll())).thenReturn(clients);
//        Assertions.assertEquals(clientRepository.findAll(), clients);
    }

    @Test
    void findById() {
        long id = 1L;
        clientService.findById(id);
        verify(clientRepository).findById(id);
//        Assertions.assertEquals((clientRepository.findById(c1.getIdClient())), c1);
//        Assertions.assertNotNull(clientRepository.findById(12L));
//        assertThat(clientRepository.findById(c1.getIdClient())).isEqualTo(c1);
    }

    @Test
    void save() {
        Client client = Client.builder()
                .idClient(5L)
                .firstName("Olya")
                .lastName("Demina")
                .email("olechka@gmail.com")
                .phoneNumber("121323").build();

        clientService.save(client);

        ArgumentCaptor<Client> clientArgumentCaptor = ArgumentCaptor.forClass(Client.class);

        verify(clientRepository).save(clientArgumentCaptor.capture());

        Client captureClient = clientArgumentCaptor.getValue();

        assertThat(captureClient).isEqualTo(client);
        assertThat(captureClient.getEmail()).isEqualTo("olechka@gmail.com");

    }

    @Test
    void deleteById() {
        long id = 5;
//        given(clientRepository.existsById(id)).willReturn(false);

        clientService.deleteById(id);
        verify(clientRepository).deleteById(id);
    }
}
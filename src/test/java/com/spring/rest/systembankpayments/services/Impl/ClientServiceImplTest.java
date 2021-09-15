package com.spring.rest.systembankpayments.services.Impl;

import com.spring.rest.systembankpayments.entity.Client;
import com.spring.rest.systembankpayments.repositories.ClientRepository;
import com.spring.rest.systembankpayments.services.ClientService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.matchers.NotNull;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.OngoingStubbing;
import java.util.List;
import java.util.Optional;
import static java.util.Optional.empty;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ClientServiceImplTest {

    @Mock
    private ClientRepository clientRepository;
    private ClientService clientService;

    Client client1 = new Client(1L, "Anna", "Vasileva",
            "65445434", "anna@gmail.com");
    Client client2 = new Client(2L, "Anton", "Ivanov",
            "756543", "anton@gmail.com");
    Client client3 = new Client(3L, "Alla", "Ivanova",
            "12134", "alla@gmail.com");
    List<Client> clients1 = List.of(client1, client2, client3);

    @BeforeEach
    void setUp() {
        clientService = new ClientServiceImpl(clientRepository);
    }

    @Test
    void findAll() {
        Mockito.when((clientService.findAll())).thenReturn(clients1);

        List<Client> clients2 = clientService.findAll();
        verify(clientRepository).findAll();

        assertNotNull(clients2);
    }

    @Test
    void findById() {
        Mockito.when(clientRepository.findById(client1.getIdClient())).thenReturn(Optional.of(client1));

        long id = 1L;
        clientService.findById(id);
        verify(clientRepository).findById(id);
//        Assertions.assertEquals((clientService.findById(client1.getIdClient())), client1);
//        Assertions.assertNotNull(clientRepository.findById(12L));
//        assertThat(clientService.findById(client1.getIdClient())).isEqualTo(client1);
    }

    @Test
    void findByIdNotFound(){
        Mockito.when(clientRepository.findById(client1.getIdClient())).thenReturn(empty());

        Client client = clientService.findById(1L);

        assertNull(client);
    }

    @Test
    void save() {
        Client client1 = Client.builder()
                .idClient(5L)
                .firstName("Olya")
                .lastName("Demina")
                .email("olechka@gmail.com")
                .phoneNumber("121323").build();

        clientService.save(client1);

        ArgumentCaptor<Client> clientArgumentCaptor = ArgumentCaptor.forClass(Client.class);

        verify(clientRepository).save(clientArgumentCaptor.capture());

        Client captureClient = clientArgumentCaptor.getValue();

        assertThat(captureClient).isEqualTo(client1);
        assertThat(captureClient.getEmail()).isEqualTo("olechka@gmail.com");
        assertNotNull(captureClient);
    }

    @Test
    void deleteById() {
        long id = 5;
//        given(clientRepository.existsById(id)).willReturn(false);

        clientService.deleteById(id);
        verify(clientRepository).deleteById(id);
    }

//    void deleteByIdNotFound(){
////        Mockito.when(clientRepository.deleteById()).thenReturn(empty());
//
//        Client client = clientService.deleteById(1L);
//
//        assertNull(client);
//    }
}
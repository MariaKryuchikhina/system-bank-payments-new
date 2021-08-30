package com.spring.rest.systembankpayments.entity;

import lombok.*;
import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idClient;

    private String firstName;

    private String lastName;

    private String phoneNumber;

    private String email;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_deposit")
    private DepositAccount depositAccount;

}
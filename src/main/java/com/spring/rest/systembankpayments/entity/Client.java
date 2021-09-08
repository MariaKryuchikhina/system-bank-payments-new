package com.spring.rest.systembankpayments.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@ToString
@Getter
@Entity
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long idClient;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
    private List<DepositAccount> depositAccount;

    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
    private List<MainAccount> mainAccount;

    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
    private List<CreditAccount> creditAccount;
}

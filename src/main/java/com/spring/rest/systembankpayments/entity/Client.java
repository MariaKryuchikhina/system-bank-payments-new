package com.spring.rest.systembankpayments.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;

@Getter
@Entity
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idClient;

    private String firstName;

    private String lastName;

    private String phoneNumber;

    private String email;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<DepositAccount> depositAccount;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<MainAccount> mainAccount;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CreditAccount> creditAccount;
}

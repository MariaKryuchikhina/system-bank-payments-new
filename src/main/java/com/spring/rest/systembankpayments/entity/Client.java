package com.spring.rest.systembankpayments.entity;

import lombok.*;
import lombok.experimental.Accessors;
import javax.persistence.*;
import java.util.List;

@Getter
@Entity
@Setter
//@AllArgsConstructor
@NoArgsConstructor
@Table(name = "client")
@Accessors(chain = true)
public class Client {

    @Builder
    public Client(long idClient, String firstName, String lastName, String phoneNumber, String email) {
        this.idClient = idClient;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long idClient;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id")
    private List<DepositAccount> depositAccount;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id")
    private List<MainAccount> mainAccount;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id")
    private List<CreditAccount> creditAccount;
}

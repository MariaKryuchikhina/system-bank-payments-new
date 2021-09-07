package com.spring.rest.systembankpayments.entity;

import com.spring.rest.systembankpayments.entity.Type.TypeAccount;
import lombok.*;
import javax.persistence.*;
import java.util.List;

@MappedSuperclass
@Setter
@Getter
@NoArgsConstructor

public class Account {

    public Account(long id, String number, double amount, int expirationDate, TypeAccount type, Client client, List<Account> history) {
        this.id = id;
        this.number = number;
        this.amount = amount;
        this.expirationDate = expirationDate;
        this.type = type;
        this.client = client;
        this.history = history;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String number;

    private double amount;

    private int expirationDate;

    @Enumerated(EnumType.STRING)
    private TypeAccount type;

    @ManyToOne(cascade = CascadeType.ALL)
    private Client client;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Account> history;

}

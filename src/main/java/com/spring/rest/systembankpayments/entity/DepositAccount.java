package com.spring.rest.systembankpayments.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DepositAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idDeposit;

    private String numberDeposit; //номер депозита

    private double amountDeposit; //сумма депозита

    private double interestRate; //процентная ставка

    private int expirationDate; //срок действия

    @Enumerated(EnumType.STRING)
    private TypeAccount type;

    @ManyToOne(cascade = CascadeType.ALL)
    private Client client;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ReplenishmentHistory> history;

}

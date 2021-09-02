package com.spring.rest.systembankpayments.entity;

import lombok.*;
import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreditAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idCredit;

    private String numberCredit; //номер кредита

    private double creditLimit; //кредитный лимит

    private double interestRate; //процентная ставка

    private double currentDebt; //текущая задолженность

    private double accruedInterest; //начисленные проценты

    private int expirationDate; //срок действия

    @Enumerated(EnumType.STRING)
    private TypeAccount type;

    @ManyToOne(cascade = CascadeType.ALL)
    private Client client;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ReplenishmentHistory> history;
}
package com.spring.rest.systembankpayments.entity;

import lombok.*;
import javax.persistence.*;

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
    private TypeEnum type;
}
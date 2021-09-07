package com.spring.rest.systembankpayments.entity;

import lombok.*;
import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreditAccount extends Account{

    @Column(name = "CreditLimit")
    private double creditLimit; //кредитный лимит

    private double interestRate; //процентная ставка

    private double currentDebt; //текущая задолженность

    private double accruedInterest; //начисленные проценты

}
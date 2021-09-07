package com.spring.rest.systembankpayments.entity;

import com.spring.rest.systembankpayments.entity.Type.TypeAccount;
import lombok.*;
import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class CreditAccount extends Account{

    @Builder
    public CreditAccount(long id, String number, double amount, int expirationDate, TypeAccount type, Client client,
                         List<Account> history, double creditLimit, double interestRate, double currentDebt,
                         double accruedInterest) {
        super(id, number, amount, expirationDate, type, client, history);
        this.creditLimit = creditLimit;
        this.interestRate = interestRate;
        this.currentDebt = currentDebt;
        this.accruedInterest = accruedInterest;
    }

    @Column(name = "CreditLimit")
    private double creditLimit; //кредитный лимит

    private double interestRate; //процентная ставка

    private double currentDebt; //текущая задолженность

    private double accruedInterest; //начисленные проценты

}
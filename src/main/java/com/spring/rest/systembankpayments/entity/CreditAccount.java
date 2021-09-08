package com.spring.rest.systembankpayments.entity;

import com.spring.rest.systembankpayments.entity.Type.TypeAccount;
import com.spring.rest.systembankpayments.entity.history.History;
import lombok.*;
import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "credit_account")
public class CreditAccount extends Account{

    @Builder
    public CreditAccount(long id, String number, double amount, int expirationDate, TypeAccount type, Client client,
                         double creditLimit, double interestRate, double currentDebt,
                         double accruedInterest) {
        super(id, number, amount, expirationDate, type, client);
        this.creditLimit = creditLimit;
        this.interestRate = interestRate;
        this.currentDebt = currentDebt;
        this.accruedInterest = accruedInterest;
    }

    @Column(name = "credit_limit")
    private double creditLimit; //кредитный лимит

    @Column
    private double interestRate; //процентная ставка

    @Column
    private double currentDebt; //текущая задолженность

    @Column
    private double accruedInterest; //начисленные проценты
}
package com.spring.rest.systembankpayments.entity;

import com.spring.rest.systembankpayments.entity.Type.TypeAccount;
import com.spring.rest.systembankpayments.entity.history.History;
import lombok.*;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "credit_account")
public class CreditAccount extends Account{

    @Builder
    public CreditAccount(long id, String number, Date expirationDate,
                         TypeAccount type, int creditLimit, double interestRate,
                         int currentDebt, double accruedInterest) {
        super(id, number, expirationDate, type);
        this.creditLimit = creditLimit;
        this.interestRate = interestRate;
        this.currentDebt = currentDebt;
        this.accruedInterest = accruedInterest;
    }

    @Column(name = "credit_limit")
    private int creditLimit; //кредитный лимит

    @Column(name = "interest_rate")
    private double interestRate; //процентная ставка

    @Column(name = "current_debt")
    private int currentDebt; //текущая задолженность

    @Column(name = "accrued_interest")
    private double accruedInterest; //начисленные проценты
}
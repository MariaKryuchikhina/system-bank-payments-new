package com.spring.rest.systembankpayments.entity;

import com.spring.rest.systembankpayments.entity.Type.TypeAccount;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "deposit_account")
public class DepositAccount extends Account{

    @Builder
    public DepositAccount(long id, String number, Date expirationDate, TypeAccount type, int amount, double interestRate) {
        super(id, number, expirationDate, type);
        this.amount = amount;
        this.interestRate = interestRate;
    }

    @Column(name = "amount")
    private int amount;

    @Column
    private double interestRate; //процентная ставка
}

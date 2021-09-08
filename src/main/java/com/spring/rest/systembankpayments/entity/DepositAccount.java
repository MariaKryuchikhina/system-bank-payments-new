package com.spring.rest.systembankpayments.entity;

import com.spring.rest.systembankpayments.entity.Type.TypeAccount;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "deposit_account")
public class DepositAccount extends Account{

    @Builder
    public DepositAccount(long id, String number, double amount, int expirationDate, TypeAccount type,
                          Client client, double interestRate) {
        super(id, number, amount, expirationDate, type, client);
        this.interestRate = interestRate;
    }
    @Column
    private double interestRate; //процентная ставка
}

package com.spring.rest.systembankpayments.entity;

import com.spring.rest.systembankpayments.entity.Type.TypeAccount;
import lombok.*;
import javax.persistence.Entity;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class DepositAccount extends Account{

    @Builder
    public DepositAccount(long id, String number, double amount, int expirationDate, TypeAccount type,
                          Client client, List<Account> history, double interestRate) {
        super(id, number, amount, expirationDate, type, client, history);
        this.interestRate = interestRate;
    }

    private double interestRate; //процентная ставка
}

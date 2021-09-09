package com.spring.rest.systembankpayments.entity;

import com.spring.rest.systembankpayments.entity.Type.TypeAccount;
import lombok.*;
import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "main_account")
public class MainAccount extends Account{

    @Builder
    public MainAccount(long id, String number, Date expirationDate, TypeAccount type, int amount) {
        super(id, number, expirationDate, type);
        this.amount = amount;
    }

    @Column(name = "amount")
    private int amount;
}
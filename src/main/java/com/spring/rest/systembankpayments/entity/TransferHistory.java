package com.spring.rest.systembankpayments.entity;

import com.spring.rest.systembankpayments.entity.Type.TypeOperation;
import lombok.*;
import javax.persistence.*;
import java.sql.Date;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class TransferHistory extends History{

    @Builder
    public TransferHistory(long id, String name, Date transferDate, TypeOperation type,
                           double amount, DepositAccount depositAccount,
                           MainAccount mainAccount, CreditAccount creditAccount) {
        super(id, name, transferDate, type);
        this.amount = amount;
        this.depositAccount = depositAccount;
        this.mainAccount = mainAccount;
        this.creditAccount = creditAccount;
    }

    private double amount;

    @ManyToMany(cascade = CascadeType.ALL)
    private DepositAccount depositAccount;

    @ManyToMany(cascade = CascadeType.ALL)
    private MainAccount mainAccount;

    @ManyToMany(cascade = CascadeType.ALL)
    private CreditAccount creditAccount;

}

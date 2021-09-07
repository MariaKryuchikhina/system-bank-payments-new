package com.spring.rest.systembankpayments.entity;

import com.spring.rest.systembankpayments.entity.Type.TypeOperation;
import lombok.*;
import javax.persistence.*;
import java.sql.Date;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class AccountHistory extends History{

    @Builder
    public AccountHistory(long id, String name, Date transferDate, TypeOperation type, boolean condition,
                          DepositAccount depositAccount, MainAccount mainAccount, CreditAccount creditAccount) {
        super(id, name, transferDate, type);
        this.condition = condition;
        this.depositAccount = depositAccount;
        this.mainAccount = mainAccount;
        this.creditAccount = creditAccount;
    }

    private boolean condition; //состояние: открыт или закрыт

    @ManyToOne(cascade = CascadeType.ALL)
    private DepositAccount depositAccount;

    @ManyToOne(cascade = CascadeType.ALL)
    private MainAccount mainAccount;

    @ManyToOne(cascade = CascadeType.ALL)
    private CreditAccount creditAccount;
}

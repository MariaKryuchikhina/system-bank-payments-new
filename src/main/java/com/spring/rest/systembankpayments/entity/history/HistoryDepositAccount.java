package com.spring.rest.systembankpayments.entity.history;

import com.spring.rest.systembankpayments.entity.DepositAccount;
import com.spring.rest.systembankpayments.entity.Type.TypeOperation;
import com.spring.rest.systembankpayments.entity.history.History;
import lombok.*;
import javax.persistence.*;
import java.sql.Date;


@Setter
@Getter
@NoArgsConstructor
public class HistoryDepositAccount extends History {

    @Builder
    public HistoryDepositAccount(long id, String name, Date transferDate, TypeOperation type, boolean condition,
                                 DepositAccount depositAccount) {
        super(id, name, transferDate, type);
        this.condition = condition;
        this.depositAccount = depositAccount;
    }

    private boolean condition; //состояние: открыт или закрыт

    @ManyToOne(cascade = CascadeType.ALL)
    private DepositAccount depositAccount;
}


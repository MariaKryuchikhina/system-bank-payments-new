package com.spring.rest.systembankpayments.entity.history;

import com.spring.rest.systembankpayments.entity.CreditAccount;
import com.spring.rest.systembankpayments.entity.Type.TypeOperation;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.sql.Date;


@Setter
@Getter
@NoArgsConstructor
public class HistoryCreditAccount extends History {

    @Builder
    public HistoryCreditAccount(long id, String name, Date transferDate, TypeOperation type, CreditAccount creditAccount) {
        super(id, name, transferDate, type);
        this.creditAccount = creditAccount;
    }

    private boolean condition; //состояние: открыт или закрыт

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "credit_account_id")
    private CreditAccount creditAccount;
}
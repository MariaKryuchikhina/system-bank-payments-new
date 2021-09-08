package com.spring.rest.systembankpayments.entity.history;

import com.spring.rest.systembankpayments.entity.MainAccount;
import com.spring.rest.systembankpayments.entity.Type.TypeOperation;
import com.spring.rest.systembankpayments.entity.history.History;
import lombok.*;
import javax.persistence.*;
import java.sql.Date;


@Setter
@Getter
@NoArgsConstructor
public class HistoryMainAccount extends History {

    @Builder
    public HistoryMainAccount(long id, String name, Date transferDate, TypeOperation type, MainAccount mainAccount) {
        super(id, name, transferDate, type);
        this.mainAccount = mainAccount;
    }

    private boolean condition; //состояние: открыт или закрыт

    @ManyToOne(cascade = CascadeType.ALL)
    private MainAccount mainAccount;
}

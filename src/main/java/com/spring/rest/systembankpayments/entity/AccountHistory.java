package com.spring.rest.systembankpayments.entity;

import lombok.*;
import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountHistory extends History{

    @Enumerated(EnumType.STRING)
    private TypeOperation type;
    private boolean condition; //состояние: открыт или закрыт

    @ManyToOne(cascade = CascadeType.ALL)
    private DepositAccount depositAccount;

    @ManyToOne(cascade = CascadeType.ALL)
    private MainAccount mainAccount;

    @ManyToOne(cascade = CascadeType.ALL)
    private CreditAccount creditAccount;
}

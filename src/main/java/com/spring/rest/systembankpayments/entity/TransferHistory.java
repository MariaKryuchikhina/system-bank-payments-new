package com.spring.rest.systembankpayments.entity;

import lombok.*;
import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransferHistory extends History{

    private double amount;

    @ManyToMany(cascade = CascadeType.ALL)
    private DepositAccount depositAccount;

    @ManyToMany(cascade = CascadeType.ALL)
    private MainAccount mainAccount;

    @ManyToMany(cascade = CascadeType.ALL)
    private CreditAccount creditAccount;

}

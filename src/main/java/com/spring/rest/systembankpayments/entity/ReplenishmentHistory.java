package com.spring.rest.systembankpayments.entity;

import lombok.*;
import javax.persistence.*;
import java.sql.Date;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ReplenishmentHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Date transferDate;

    private double amount;

    @ManyToOne(cascade = CascadeType.ALL)
    private DepositAccount depositAccount;

    @ManyToOne(cascade = CascadeType.ALL)
    private MainAccount mainAccount;

    @ManyToOne(cascade = CascadeType.ALL)
    private CreditAccount creditAccount;

}
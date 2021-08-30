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

    private String typeAccount;

    private Date transferDate;

    private double amount;

}
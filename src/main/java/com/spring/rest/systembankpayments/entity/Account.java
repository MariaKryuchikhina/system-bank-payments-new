package com.spring.rest.systembankpayments.entity;

import lombok.*;
import javax.persistence.*;
import java.util.List;

@MappedSuperclass
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public abstract class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String number;

    private double amount;

    private int expirationDate;

    @Enumerated(EnumType.STRING)
    private TypeAccount type;

    @ManyToOne(cascade = CascadeType.ALL)
    private Client client;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ReplenishmentHistory> history;

}

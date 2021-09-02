package com.spring.rest.systembankpayments.entity;

import lombok.*;
import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MainAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idMain;

    private String numberMain; //номер депозита

    private double amountMain; //сумма депозита

    private int expirationDate; //срок действия

    @Enumerated(EnumType.STRING)
    private TypeEnum type;

    @ManyToOne(cascade = CascadeType.ALL)
    private Client client;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ReplenishmentHistory> history;
}
package com.spring.rest.systembankpayments.entity;

import lombok.*;
import javax.persistence.*;

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
}
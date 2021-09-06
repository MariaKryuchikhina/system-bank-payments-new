package com.spring.rest.systembankpayments.entity;

import lombok.*;
import javax.persistence.Entity;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DepositAccount extends Account{

    private double interestRate; //процентная ставка
}

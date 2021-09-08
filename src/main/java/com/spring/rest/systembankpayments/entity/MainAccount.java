package com.spring.rest.systembankpayments.entity;

import com.spring.rest.systembankpayments.entity.Type.TypeAccount;
import lombok.*;
import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "main_account")
public class MainAccount extends Account{

    @Builder
    public MainAccount(long id, String number, double amount, int expirationDate, TypeAccount type,
                       Client client) {
        super(id, number, amount, expirationDate, type, client);
    }
}
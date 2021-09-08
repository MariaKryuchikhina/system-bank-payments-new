package com.spring.rest.systembankpayments.entity;

import com.spring.rest.systembankpayments.entity.Type.TypeAccount;
import com.spring.rest.systembankpayments.entity.history.History;
import lombok.*;
import javax.persistence.*;
import java.util.List;

@MappedSuperclass
@Setter
@Getter
@NoArgsConstructor
public class Account {

    public Account(long id, String number, double amount,
                   int expirationDate, TypeAccount type, Client client) {
        this.id = id;
        this.number = number;
        this.amount = amount;
        this.expirationDate = expirationDate;
        this.type = type;
        this.client = client;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;
    @Column
    private String number;
    @Column
    private double amount;
    @Column
    private int expirationDate;
    @Column
    @Enumerated(EnumType.STRING)
    private TypeAccount type;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id")
    private Client client;

//    @OneToMany(fetch = FetchType.LAZY)
//    private List<History> history;

}

package com.spring.rest.systembankpayments.entity;

import com.spring.rest.systembankpayments.entity.Type.TypeAccount;
import com.spring.rest.systembankpayments.entity.history.History;
import lombok.*;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@MappedSuperclass
@Setter
@Getter
@NoArgsConstructor
public class Account {

    public Account(long id, String number, Date expirationDate, TypeAccount type) {
        this.id = id;
        this.number = number;
        this.expirationDate = expirationDate;
        this.type = type;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "number_account")
    private String number;
    @Column(name = "expiration_date")
    private Date expirationDate;
    @Column(name = "type_account")
    @Enumerated(EnumType.STRING)
    private TypeAccount type;

//    @OneToMany(fetch = FetchType.LAZY)
//    private List<History> history;

}

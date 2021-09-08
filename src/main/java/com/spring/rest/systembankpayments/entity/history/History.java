package com.spring.rest.systembankpayments.entity.history;

import com.spring.rest.systembankpayments.entity.Account;
import com.spring.rest.systembankpayments.entity.Type.TypeOperation;
import lombok.*;
import javax.persistence.*;
import java.sql.Date;

@MappedSuperclass
@Setter
@Getter
@NoArgsConstructor
public class History {

    public History(long id, String name, Date transferDate, TypeOperation type) {
        this.id = id;
        this.name = name;
        this.transferDate = transferDate;
        this.type = type;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private Date transferDate;

    @Enumerated(EnumType.STRING)
    private TypeOperation type;
}

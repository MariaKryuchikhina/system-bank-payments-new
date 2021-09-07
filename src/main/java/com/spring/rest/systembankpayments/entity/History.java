package com.spring.rest.systembankpayments.entity;

import lombok.*;
import javax.persistence.*;
import java.sql.Date;

@MappedSuperclass
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public abstract class History {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private Date transferDate;
    @Enumerated(EnumType.STRING)
    private TypeOperation type;
}

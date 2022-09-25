package com.me.librarymanagementsystem.entity;


import com.me.librarymanagementsystem.config.PostgresqlEnumType;
import com.me.librarymanagementsystem.enums.Position;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
@TypeDef(
        name = "pgsql_enum",
        typeClass = PostgresqlEnumType.class
)
@Entity
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "books")
public class Book {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "create_date")
    private Date createDate;


    @Enumerated(EnumType.STRING)
    @Column(name = "position")
    @Type(type = "pgsql_enum")
    private Position position;

    @Column(name = "count")
    private Long count;

    @Column(name = "is_deleted")
    private Boolean isDeleted;



}

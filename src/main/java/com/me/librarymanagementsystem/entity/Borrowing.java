package com.me.librarymanagementsystem.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "borrowings")
public class Borrowing {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private String id;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "end_date")
    private Date end_date;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "librarian_id")
    private Librarian librarian;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;



}

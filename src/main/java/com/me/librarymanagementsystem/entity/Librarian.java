package com.me.librarymanagementsystem.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "librarians")
public class Librarian {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "full_name")
    private String fullName;


    @Column(name = "email")
    private String email;


    @Column(name = "password")
    private String password;

    @Column(name = "born_date")
    private Date bornDate;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "is_deleted")
    private Boolean isDeleted;

   @ManyToOne(fetch = FetchType.EAGER)
   @JoinColumn(name = "admin_id")
   private Admin admin;










}

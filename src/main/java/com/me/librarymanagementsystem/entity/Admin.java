package com.me.librarymanagementsystem.entity;


import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "admins")
@Builder
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "is_deleted")
    private Boolean is_deleted;

    @OneToMany(fetch =FetchType.LAZY ,mappedBy = "admin")
    private List<Librarian> librarians;

}

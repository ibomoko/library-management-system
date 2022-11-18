package com.me.librarymanagementsystem.entity;


import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "users")
@SQLDelete(sql = "UPDATE users set is_deleted=true WHERE id=?")
@Where(clause = "is_deleted=false")
@Builder
public class User {

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

    @Column(name = "create_date")
    private Date createDate;

    @OneToMany(mappedBy = "user",fetch = FetchType.EAGER)
    private List<Borrowing> borrowings;

    @Column(name = "is_deleted")
    private Boolean isDeleted;

}

package com.me.librarymanagementsystem.model.response.librarian;


import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class LibrarianCreateResponse {
    private Long id;
    private String fullName;
    private String email;
    private Date createDate;
}

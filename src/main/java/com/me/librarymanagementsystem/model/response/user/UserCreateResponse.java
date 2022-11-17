package com.me.librarymanagementsystem.model.response.user;


import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class UserCreateResponse {
    private Long id;
    private String fullName;
    private String email;
    private Date createDate;

}

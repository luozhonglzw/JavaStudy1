package com.book.entity;

import lombok.Data;
//用来映射的
@Data
public class User {
    int id;
    String username;
    String nickname;
    String password;
}

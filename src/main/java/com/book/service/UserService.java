package com.book.service;

import javax.servlet.http.HttpSession;
//中间层 用于与数据库与前端返回的
public interface UserService {
    boolean auth(String username, String password, HttpSession session);//在MybatisUtil中出现
}

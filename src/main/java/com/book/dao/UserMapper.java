package com.book.dao;

import com.book.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
//写Sql语句的 用来与数据库进行链接的
public interface UserMapper {

    @Select("select * from user where username=#{username}and password =#{password}")
    User getUser(@Param("username")String username,@Param("password")String password);
}

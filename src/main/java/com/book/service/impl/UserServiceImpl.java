package com.book.service.impl;

import com.book.dao.UserMapper;
import com.book.entity.User;
import com.book.service.UserService;
import com.book.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.http.HttpSession;
//用来实现UserService的
public class UserServiceImpl implements UserService {
    @Override
    public boolean auth(String username, String password, HttpSession session) {
        try(SqlSession sqlSession= MybatisUtil.getSession()){
            UserMapper mapper=sqlSession.getMapper(UserMapper.class);
            User user=mapper.getUser(username,password);//用来与数据库链接的
            if(user == null){
                return false;
            }else {
                session.setAttribute("user",user);//建立起全局的变量
                return true;
            }
        }
    }
}

package com.book.service.impl;

import com.book.dao.ClassMapper;
import com.book.dao.UserMapper;
import com.book.entity.Class;
import com.book.entity.User;
import com.book.service.ClassService;
import com.book.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class ClassServiceImpl implements ClassService {
    @Override
    public List<Class> getClasslist() {
        try(SqlSession sqlSession= MybatisUtil.getSession()){
            ClassMapper mapper=sqlSession.getMapper(ClassMapper.class);
            return mapper.getClasslist();
        }
    }

    @Override
    public void delclass(String id) {
        try(SqlSession sqlSession= MybatisUtil.getSession()){
            ClassMapper mapper=sqlSession.getMapper(ClassMapper.class);
            mapper.delclass(id);
        }
    }

    @Override
    public void addClass(String classid, String classname, String classshijian, String classxingzhi, String xuefen, String teacher) {
        try (SqlSession sqlSession = MybatisUtil.getSession()) {
            ClassMapper mapper = sqlSession.getMapper(ClassMapper.class);
            mapper.addClass(classid, classname, classshijian, classxingzhi, xuefen, teacher);
        }
    }
}

package com.book.service.impl;

import com.book.dao.ClassMapper;
import com.book.dao.StudentMapper;
import com.book.entity.Student;
import com.book.service.StudentService;
import com.book.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    @Override
    public List<Student> selectStudent() {
        try(SqlSession sqlSession= MybatisUtil.getSession()){
            StudentMapper mapper=sqlSession.getMapper(StudentMapper.class);
            return mapper.selectStudent();
        }
    }

    @Override
    public void DelStudent(int id) {
        try(SqlSession sqlSession= MybatisUtil.getSession()){
            StudentMapper mapper=sqlSession.getMapper(StudentMapper.class);
            mapper.DelStudent(id);
        }
    }

    @Override
    public void addStudent(int id, String name, String sex, int age) {
        try(SqlSession sqlSession= MybatisUtil.getSession()){
            StudentMapper mapper=sqlSession.getMapper(StudentMapper.class);
            mapper.addStudent(id, name, sex, age);
        }
    }

}

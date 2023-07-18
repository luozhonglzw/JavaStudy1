package com.book.service.impl;

import com.book.dao.ClassMapper;
import com.book.dao.ClasscjMapper;
import com.book.entity.Class;
import com.book.entity.Classcj;
import com.book.entity.Student;
import com.book.service.ClasscjService;
import com.book.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class ClasscjServiceImpl implements ClasscjService {
    @Override
    public List<Classcj> getClasscjlist() {
        try(SqlSession sqlSession= MybatisUtil.getSession()){
            ClasscjMapper mapper=sqlSession.getMapper(ClasscjMapper.class);
            return mapper.getClasscjlist();
        }
    }

    @Override
    public void delclasscj(int studentid) {
            try(SqlSession sqlSession= MybatisUtil.getSession()){
                ClasscjMapper mapper=sqlSession.getMapper(ClasscjMapper.class);
                mapper.delclasscj(studentid);
            }
    }

    @Override
    public void AddClasscj(int studentid, int math, int Chinese, int English, int py) {
        try(SqlSession sqlSession= MybatisUtil.getSession()){
            ClasscjMapper mapper=sqlSession.getMapper(ClasscjMapper.class);
            mapper.AddClasscj(studentid,math,Chinese,English,py);
        }
    }

    @Override
    public List<Integer> getmathlist() {
        try(SqlSession sqlSession= MybatisUtil.getSession()){
            ClasscjMapper mapper=sqlSession.getMapper(ClasscjMapper.class);
            return mapper.getmathlist();
        }
    }

    @Override
    public List<Integer> getChineselist() {
        try(SqlSession sqlSession= MybatisUtil.getSession()){
            ClasscjMapper mapper=sqlSession.getMapper(ClasscjMapper.class);
            return mapper.getChineselist();
        }
    }

    @Override
    public List<Integer> getEnglishlist() {
        try(SqlSession sqlSession= MybatisUtil.getSession()){
            ClasscjMapper mapper=sqlSession.getMapper(ClasscjMapper.class);
            return mapper.getEnglishlist();
        }
    }

    @Override
    public List<Integer> getpylist() {
        try(SqlSession sqlSession= MybatisUtil.getSession()){
            ClasscjMapper mapper=sqlSession.getMapper(ClasscjMapper.class);
            return mapper.getpylist();
        }
    }

    @Override
    public List<Student> getmath_max(int math_max) {
        try(SqlSession sqlSession= MybatisUtil.getSession()){
            ClasscjMapper mapper=sqlSession.getMapper(ClasscjMapper.class);
            return mapper.getmath_max(math_max);
        }
    }

    @Override
    public List<Student> Chinese_max(int Chinese_max1) {
        try(SqlSession sqlSession= MybatisUtil.getSession()){
            ClasscjMapper mapper=sqlSession.getMapper(ClasscjMapper.class);
            return mapper.Chinese_max(Chinese_max1);
        }
    }

    @Override
    public List<Student> English_max(int English_max1) {
        try(SqlSession sqlSession= MybatisUtil.getSession()){
            ClasscjMapper mapper=sqlSession.getMapper(ClasscjMapper.class);
            return mapper.English_max(English_max1);
        }
    }

    @Override
    public List<Student> py_max(int py_max1) {
        try(SqlSession sqlSession= MybatisUtil.getSession()){
            ClasscjMapper mapper=sqlSession.getMapper(ClasscjMapper.class);
            return mapper.py_max(py_max1);
        }
    }

}

package com.book.service;

import com.book.entity.Classcj;
import com.book.entity.Student;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ClasscjService {
    List<Classcj> getClasscjlist();

    void delclasscj(int studentid);
    void AddClasscj( int studentid, int math,int Chinese,int English, int py);

    List<Integer> getmathlist();

    List<Integer> getChineselist();

    List<Integer> getEnglishlist();

    List<Integer> getpylist();

    List<Student> getmath_max(int math_max);

    List<Student> Chinese_max(int Chinese_max);
    List<Student> English_max(int English_max);
    List<Student> py_max(int py_max);
}

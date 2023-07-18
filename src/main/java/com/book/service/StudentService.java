package com.book.service;

import com.book.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentService {
    List<Student> selectStudent();

    void DelStudent(int id);

    void addStudent( int id,  String name,String sex, int age);
}

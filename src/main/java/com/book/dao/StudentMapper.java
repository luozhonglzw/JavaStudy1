package com.book.dao;

import com.book.entity.Student;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StudentMapper {
    @Select("select * from username")
    List<Student> selectStudent();

    @Delete("delete from username where id=#{id}")
    void DelStudent(int id);

    @Insert("insert into username(id, name, sex,age) values(#{id}, #{name}, #{sex},#{age})")
    void addStudent(@Param("id") int id, @Param("name")  String name, @Param("sex") String sex, @Param("age")int age);
}

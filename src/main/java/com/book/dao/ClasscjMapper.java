package com.book.dao;

import com.book.entity.Class;
import com.book.entity.Classcj;
import com.book.entity.Student;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ClasscjMapper {
    @Select("select * from classcj2 ")
    List<Classcj> getClasscjlist();

    @Delete("delete from classcj2 where studentid=#{studentid}")
    void delclasscj(int studentid);

    @Insert("insert into classcj2(studentid, math, Chinese,English,py) values(#{studentid}, #{math}, #{Chinese},#{English},#{py})")
    void AddClasscj(@Param("studentid") int studentid, @Param("math")int math, @Param("Chinese")int Chinese, @Param("English")int English, @Param("py")int py);

    @Select("select math from classcj2 ")
    List<Integer> getmathlist();

    @Select("select Chinese from classcj2 ")
    List<Integer> getChineselist();

    @Select("select English from classcj2 ")
    List<Integer> getEnglishlist();

    @Select("select py from classcj2 ")
    List<Integer> getpylist();

    @Select("select * from  username join  classcj2 on username.id =classcj2.studentid where classcj2.math=#{math_max}")
    List<Student> getmath_max(int math_max);

    @Select("select * from  username join  classcj2 on username.id =classcj2.studentid where classcj2.Chinese=#{Chinese_max}")
    List<Student> Chinese_max(int Chinese_max);
    @Select("select * from  username join  classcj2 on username.id =classcj2.studentid where classcj2.English=#{English_max}")
    List<Student> English_max(int English_max);
    @Select("select * from  username join  classcj2 on username.id =classcj2.studentid where classcj2.py=#{py_max}")
    List<Student> py_max(int py_max);
}

package com.book.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import com.book.entity.Class;
import java.util.List;

public interface ClassMapper {
    @Select("select * from class ")
    List<Class> getClasslist();

    @Delete("delete from class where classid=#{classid}")
    void delclass(String id);

    @Insert("insert into class( classid,classname,classshijian, classxingzhi,xuefen,teacher) values(#{classid} ,#{classname}, #{classshijian},#{classxingzhi},#{xuefen},#{teacher})")
    void addClass(@Param("classid")String classid, @Param("classname") String classname, @Param("classshijian") String classshijian, @Param("classxingzhi") String classxingzhi, @Param("xuefen") String xuefen, @Param("teacher") String teacher);
}

package com.book.service;

import java.util.List;
import com.book.entity.Class;
import org.apache.ibatis.annotations.Param;

public interface ClassService {
    List<Class> getClasslist();
    void delclass(String id);
    void addClass(String classid,  String classname, String classshijian, String classxingzhi,  String xuefen, String teacher);
}

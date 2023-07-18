package com.book.servlet.pages;

import com.book.entity.User;
import com.book.service.StudentService;
import com.book.service.impl.StudentServiceImpl;
import com.book.utils.ThymeleafUtil;
import org.thymeleaf.context.Context;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/students")
public class StudentServlet extends HttpServlet {
    StudentService service;
    @Override
    public void init() throws ServletException {
        service=new StudentServiceImpl();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        Context context=new Context();
        User user=(User)req.getSession().getAttribute("user");
        context.setVariable("nickname",user.getNickname());
        context.setVariable("Studentlist",service.selectStudent());
        ThymeleafUtil.process("students.html",context, resp.getWriter());
    }
}

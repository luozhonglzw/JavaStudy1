package com.book.servlet.manage;

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
import java.nio.charset.StandardCharsets;

@WebServlet("/add-student")
public class AddStudentServlet extends HttpServlet {
    StudentService service;
    @Override
    public void init() throws ServletException {
        service=new StudentServiceImpl();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        Context context=new Context();
        ThymeleafUtil.process("addstudent.html",context,resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = new String(req.getParameter("name").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        String sex = new String(req.getParameter("sex").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        int age = Integer.parseInt(req.getParameter("age"));
        service.addStudent(id,name,sex,age);
        resp.sendRedirect("students");
    }
}

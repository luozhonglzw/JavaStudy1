package com.book.servlet.manage;

import com.book.service.ClasscjService;
import com.book.service.StudentService;
import com.book.service.impl.ClasscjServiceImpl;
import com.book.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/del-student")
public class DelStudentServlet extends HttpServlet {
    StudentService service;
    @Override
    public void init() throws ServletException {
        service=new StudentServiceImpl();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id= Integer.parseInt(req.getParameter("studentid"));
        service.DelStudent(id);
        resp.sendRedirect("students");
    }
}

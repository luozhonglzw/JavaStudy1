package com.book.servlet.manage;

import com.book.service.ClassService;
import com.book.service.impl.ClassServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/del-class")
public class ReturnServlet extends HttpServlet {
    ClassService service;
    @Override
    public void init() throws ServletException {
        service=new ClassServiceImpl();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id=req.getParameter("classid");
        service.delclass(id);
        resp.sendRedirect("index");
    }
}

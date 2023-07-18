package com.book.servlet.manage;


import com.book.service.ClasscjService;
import com.book.service.impl.ClasscjServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/del-classcj")
public class DelClasscjServlet extends HttpServlet {
    ClasscjService service;
    @Override
    public void init() throws ServletException {
        service=new ClasscjServiceImpl();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id= Integer.parseInt(req.getParameter("studentid"));
        service.delclasscj(id);
        resp.sendRedirect("books");
    }
}

package com.book.servlet.manage;

import com.book.service.ClassService;
import com.book.service.impl.ClassServiceImpl;
import com.book.utils.ThymeleafUtil;
import org.thymeleaf.context.Context;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet("/add-class")
public class AddClassServlet extends HttpServlet {
    ClassService service;
    @Override
    public void init() throws ServletException {
        service=new ClassServiceImpl();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        Context  context=new Context();
        ThymeleafUtil.process("addclass.html",context,resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String classid = new String(req.getParameter("classid").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        String classname = new String(req.getParameter("classname").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        String classshijian = new String(req.getParameter("classshijian").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        String classxingzhi = new String(req.getParameter("classxingzhi").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        String classxuefen = new String(req.getParameter("classxuefen").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        String classteacher = new String(req.getParameter("classteacher").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        service.addClass(classid,classname,classshijian,classxingzhi,classxuefen,classteacher);
        resp.sendRedirect("index");
    }
}

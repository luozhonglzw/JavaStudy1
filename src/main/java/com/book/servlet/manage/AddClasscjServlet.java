package com.book.servlet.manage;

import com.book.service.ClassService;
import com.book.service.ClasscjService;
import com.book.service.impl.ClassServiceImpl;
import com.book.service.impl.ClasscjServiceImpl;
import com.book.utils.ThymeleafUtil;
import org.thymeleaf.context.Context;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet("/add-classcj")
public class AddClasscjServlet extends HttpServlet {
    ClasscjService service;

    @Override
    public void init() throws ServletException {
        service = new ClasscjServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        Context context = new Context();
        ThymeleafUtil.process("addclasscj.html", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int studentid = Integer.parseInt(req.getParameter("studentid"));
        int math = Integer.parseInt(req.getParameter("math"));
        int Chinese = Integer.parseInt(req.getParameter("Chinese"));
        int English = Integer.parseInt(req.getParameter("English"));
        int py = Integer.parseInt(req.getParameter("py"));
        service.AddClasscj(studentid, math, Chinese, English, py);
        resp.sendRedirect("books");
    }
}

package com.book.servlet.pages;

import com.book.entity.User;
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

@WebServlet("/index")
public class IndexServlet extends HttpServlet {
    ClassService service;
    @Override
    public void init() throws ServletException {
        service=new ClassServiceImpl();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        Context context=new Context();
        User user=(User)req.getSession().getAttribute("user");
        context.setVariable("nickname",user.getNickname());
        context.setVariable("Classlist",service.getClasslist());
        ThymeleafUtil.process("index.html",context, resp.getWriter());
    }
}

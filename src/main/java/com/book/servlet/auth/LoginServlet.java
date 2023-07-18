package com.book.servlet.auth;

import com.book.service.UserService;
import com.book.service.impl.UserServiceImpl;
import com.book.utils.ThymeleafUtil;
import org.thymeleaf.context.Context;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
//写页面的 登录页面
public class LoginServlet extends HttpServlet {

    UserService service;

    @Override
    public void init() throws ServletException {
        service=new UserServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        Context context = new Context();
        if(req.getSession().getAttribute("login-failure")!=null){//因为全局的变量不为空 登录失败
            context.setVariable("failure",true);//把前端名为failure的值设置为true
            req.getSession().removeAttribute("login-failure");//移去这个全局变量
        }
        if(req.getSession().getAttribute("user")!=null){//已经登录
            resp.sendRedirect("index");
            return;
        }
        ThymeleafUtil.process("login.html",context, resp.getWriter());//将内容传递给login.html
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username=req.getParameter("username");//这个是获取表单中的数据
        String password=req.getParameter("password");
        String remember=req.getParameter("remember-me");//勾选记住我
        if(service.auth(username,password,req.getSession())){//登录成功 跳转到index
            resp.sendRedirect("index");
        }else {
            req.getSession().setAttribute("login-failure",new Object());//登录失败的话 创建一个全局的变量
            this.doGet(req,resp);
        }
    }
}

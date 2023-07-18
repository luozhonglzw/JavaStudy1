package com.book.filter;

import com.book.entity.User;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
//过滤器 将所有的文件一一筛选
@WebFilter("/*")
public class MainFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        String url=req.getRequestURL().toString();//获取静态资源的url（接口）
        if(!url.contains("/static/")&&!url.endsWith("login")){//如果不是静态资源和不是login页面的话
            HttpSession session=req.getSession();//全局变量session
            User user=(User) session.getAttribute("user");
            if(user==null){
                res.sendRedirect("login");
                return;
            }
        }
        chain.doFilter(req, res);//如果是的话 就放行
    }
}

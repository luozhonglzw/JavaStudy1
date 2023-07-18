package com.book.servlet.pages;


import com.book.entity.Classcj;
import com.book.entity.User;
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
import java.util.List;

@WebServlet("/books")
public class BookServlet extends HttpServlet {

    ClasscjService service;
    @Override
    public void init() throws ServletException {
        service=new ClasscjServiceImpl();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        Context context=new Context();
        User user=(User)req.getSession().getAttribute("user");

        context.setVariable("nickname",user.getNickname());
        context.setVariable("Classcjlist",service.getClasscjlist());
        List<Classcj> list=service.getClasscjlist();
        context.setVariable("studentslistsize",list.size());
        double mathaver=0;
        List<Integer> mathlist=service.getmathlist();
        double sum=0;
        int math_max=0;
        int Chinese_max1=0;
        int English_max=0;
        int py_max=0;
        for (int i = 0; i < mathlist.size(); i++) {
            if(mathlist.get(i)>math_max){
                math_max=mathlist.get(i);
            }
            sum+=mathlist.get(i);
        }
        mathaver=sum/mathlist.size();
        double Chineseaver=0;
        List<Integer> Chineselist=service.getChineselist();
        sum=0;
        for (int i = 0; i < Chineselist.size(); i++) {
            if(Chineselist.get(i)>Chinese_max1){
                Chinese_max1=Chineselist.get(i);
            }
            sum+=Chineselist.get(i);
        }
        Chineseaver=sum/Chineselist.size();
        double Englishaver=0;
        List<Integer> Englishlist=service.getEnglishlist();
        sum=0;
        for (int i = 0; i < Englishlist.size(); i++) {
            if(Englishlist.get(i)>English_max){
                English_max=Englishlist.get(i);
            }
            sum+=Englishlist.get(i);
        }
        Englishaver=sum/Englishlist.size();
        double pyaver=0;
        List<Integer> pylist=service.getpylist();
        sum=0;
        for (int i = 0; i < pylist.size(); i++) {
            if(pylist.get(i)>py_max){
                py_max=pylist.get(i);
            }
            sum+=pylist.get(i);
        }
        pyaver=sum/pylist.size();
        context.setVariable("mathaverage",mathaver);
        context.setVariable("Chineseaverage",Chineseaver);
        context.setVariable("Englishaverage",Englishaver);
        context.setVariable("pyaverage",pyaver);
        context.setVariable("max1",math_max);
        context.setVariable("max2",Chinese_max1);
        context.setVariable("max3",English_max);
        context.setVariable("max4",py_max);
        context.setVariable("math_max",service.getmath_max(math_max));
        context.setVariable("Chinese_max",service.Chinese_max(Chinese_max1));
        context.setVariable("English_max",service.English_max(English_max));
        context.setVariable("py_max",service.py_max(py_max));
        ThymeleafUtil.process("books.html",context, resp.getWriter());
    }
}

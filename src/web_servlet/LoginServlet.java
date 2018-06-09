package web_servlet;

import dao.factory.Factory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<String> list = new ArrayList<>();
        req.setCharacterEncoding("UTF-8");
        String username = req.getParameter("username");
        String pwd = req.getParameter("password");
        if (username == null || "".equals(username))
            list.add("用户名不能为空！");
        if (pwd == null || "".equals(pwd))
            list.add("密码不能为空! ");
        if (list.size()>0){
            req.setAttribute("error",list);
            req.getRequestDispatcher("error.jsp").forward(req,resp);
        }
        try {
            boolean flag = Factory.getUserInfoDAOImplProxy().checkLogin(username,pwd);
            if (flag){
                req.getSession().setAttribute("USER",username);
                resp.sendRedirect("main.jsp");
                System.out.println("登陆成功");

            }else{
                list.add("用户名或密码有误!");
                req.setAttribute("error",list);
                req.getRequestDispatcher("error.jsp").forward(req,resp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}

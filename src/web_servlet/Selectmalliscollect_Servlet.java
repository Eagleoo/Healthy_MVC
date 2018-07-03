package com.cd.mvc.web_servlet;

import com.cd.mvc.dao.factory.Factory;
import com.cd.mvc.dao.vo.Mall;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "Selectmalliscollect_Servlet")
public class Selectmalliscollect_Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("utf-8");
        response.setCharacterEncoding("utf-8");
        List<Mall> list;
        HttpSession session = request.getSession();
        String username= (String) session.getAttribute("USER");
        try {
            list=Factory.getMallDAOImplProxy().selectmallforcollect(username);
            System.out.println("123"+username);
            JSONArray ja=JSONArray.fromObject(list);
            String str = ja.toString();
            PrintWriter out=response.getWriter();
            System.out.println(str);
            out.write(str);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}

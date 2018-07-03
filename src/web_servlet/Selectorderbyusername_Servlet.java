package com.cd.mvc.web_servlet;

import com.cd.mvc.dao.factory.Factory;
import com.cd.mvc.dao.vo.Orderandmall;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

@WebServlet(name = "Selectorderbyusername_Servlet")
public class Selectorderbyusername_Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("utf-8");
        response.setCharacterEncoding("utf-8");
        List<Orderandmall> list=new LinkedList<>();
        HttpSession session = request.getSession();
        String username=(String) session.getAttribute("USER");
        String iswhat=request.getParameter("iswhat");
        System.out.println(iswhat);
        if (iswhat==null){
        try {
            list=Factory.getMallDAOImplProxy().selectorderbyusername(username);
            JSONArray ja=JSONArray.fromObject(list);
            String str = ja.toString();
            PrintWriter out=response.getWriter();
            System.out.println(str);
            out.write(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        }
        else if(iswhat.equals("ispay"))
        {
            try {
                list=Factory.getMallDAOImplProxy().selectorderbyusernamefotype(username,"F","F","F");
                JSONArray ja=JSONArray.fromObject(list);
                String str = ja.toString();
                PrintWriter out=response.getWriter();
                System.out.println(str);
                out.write(str);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if(iswhat.equals("issend"))
        {
            try {
                list=Factory.getMallDAOImplProxy().selectorderbyusernamefotype(username,"T","F","F");
                JSONArray ja=JSONArray.fromObject(list);
                String str = ja.toString();
                PrintWriter out=response.getWriter();
                System.out.println(str);
                out.write(str);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if(iswhat.equals("isreceive"))
        {
            try {
                list=Factory.getMallDAOImplProxy().selectorderbyusernamefotype(username,"T","T","F");
                JSONArray ja=JSONArray.fromObject(list);
                String str = ja.toString();
                PrintWriter out=response.getWriter();
                System.out.println(str);
                out.write(str);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);
    }
}

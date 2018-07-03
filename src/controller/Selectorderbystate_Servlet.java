package com.cd.mvc.controller;

import com.cd.mvc.dao.factory.Factory;
import com.cd.mvc.dao.vo.Orderandmall;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

@WebServlet(name = "Selectorderbystate_Servlet")
public class Selectorderbystate_Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("utf-8");
        response.setCharacterEncoding("utf-8");
        String username=request.getParameter("username");
        String state=request.getParameter("state");
        System.out.println(state+username);
        List<Orderandmall> list=new LinkedList<>();
        if (state.equals("fahuo"))
        {
            try {
                list=Factory.getMallDAOImplProxy().selectorderbyusernamefotype(username,"T","F","F");
                String jsonString=JsonTools.createJsonString("fahuo",list);
                PrintWriter out=response.getWriter();
                out.write(jsonString);
                System.out.println(jsonString);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if (state.equals("fukuan"))
        {
            try {
                list=Factory.getMallDAOImplProxy().selectorderbyusernamefotype(username,"F","F","F");
                String jsonString=JsonTools.createJsonString("fukuan",list);
                PrintWriter out=response.getWriter();
                out.write(jsonString);
                System.out.println(jsonString);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if (state.equals("shouhuo"))
        {
            try {
                list=Factory.getMallDAOImplProxy().selectorderbyusernamefotype(username,"T","T","F");
                String jsonString=JsonTools.createJsonString("shouhuo",list);
                PrintWriter out=response.getWriter();
                out.write(jsonString);
                System.out.println(jsonString);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);
    }
}

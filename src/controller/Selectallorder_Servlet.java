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

@WebServlet(name = "Selectallorder_Servlet")
public class Selectallorder_Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("utf-8");
        response.setCharacterEncoding("utf-8");

        String username=request.getParameter("username");
        List<Orderandmall> list=new LinkedList<>();
        System.out.println("username"+username);
        try {
            list=Factory.getMallDAOImplProxy().selectorderbyusername(username);
            String jsonString=JsonTools.createJsonString("order",list);
            PrintWriter out=response.getWriter();
            out.write(jsonString);
            System.out.println(jsonString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);
    }
}

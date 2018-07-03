package com.cd.mvc.controller;

import com.cd.mvc.dao.factory.Factory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Updateorderstate_Servlet")
public class Updateorderstate_Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("utf-8");
        response.setCharacterEncoding("utf-8");

        String dowhat=request.getParameter("dowhat");
        String order_id=request.getParameter("order_id");
        boolean issuccess=false;
        System.out.println(dowhat+order_id);
        try {
            if(dowhat.equals("updatepay")){
            issuccess=Factory.getMallDAOImplProxy().updateorderstate(order_id,"T","F","F");
            System.out.println(issuccess);
            if (issuccess){
                PrintWriter out=response.getWriter();
                out.write("付款成功");
            }
            }
            if(dowhat.equals("updatereceive")) {
                issuccess=Factory.getMallDAOImplProxy().updateorderstate(order_id,"T","T","T");
                if (issuccess) {
                    PrintWriter out = response.getWriter();
                    out.write("收货成功");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);
    }
}

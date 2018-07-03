package com.cd.mvc.controller;

import com.cd.mvc.dao.factory.Factory;
import com.cd.mvc.dao.vo.Logistics;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

@WebServlet(name = "Selectlogistics_Servlet")
public class Selectlogistics_Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("utf-8");
        response.setCharacterEncoding("utf-8");

        String order_id=request.getParameter("order_id");
        String roof=request.getParameter("roof");
        System.out.println(order_id);
        List<Logistics> list=new LinkedList<>();
        try {
            list= Factory.getMallDAOImplProxy().selectlogistics(order_id);
            if (roof.equals("")) {
                String jsonString = JsonTools.createJsonString("logistics", list);
                PrintWriter out = response.getWriter();
                out.write(jsonString);
                System.out.println(jsonString);
            }else if(roof.equals("web"))
            {
                JSONArray ja=JSONArray.fromObject(list);
                String str = ja.toString();
                PrintWriter out=response.getWriter();
                System.out.println(str);
                out.write(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);
    }
}

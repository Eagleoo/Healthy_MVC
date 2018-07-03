package com.cd.mvc.web_servlet;

import com.cd.mvc.dao.factory.Factory;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "Insertaddress_Servlet")
public class Insertaddress_Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("utf-8");
        response.setCharacterEncoding("utf-8");

        boolean issuccess=false;
        String consignee=request.getParameter("consignee");
        String cellnumber=request.getParameter("cellnumber");
        String address=request.getParameter("address");

        String roof=request.getParameter("roof");
        System.out.println(cellnumber+consignee+address);


        if (roof.equals(""))
        {
            HttpSession session = request.getSession();
            String username=(String) session.getAttribute("USER");
            try {
                issuccess=Factory.getMallDAOImplProxy().insertaddr(username,consignee,cellnumber,address);
                if (issuccess)
                {
                    List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
                    Map<String,Object> map = new HashMap<String, Object>();
                    map.put("insertsuccess","添加收货地址成功" );
                    list.add(map);
                    JSONArray ja=JSONArray.fromObject(list);
                    String str = ja.toString();
                    PrintWriter out=response.getWriter();
                    out.write(str);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if (roof.equals("android"))
        {
            String username=request.getParameter("username");
            try {
                issuccess=Factory.getMallDAOImplProxy().insertaddr(username,consignee,cellnumber,address);
                if (issuccess)
                {
                    PrintWriter out=response.getWriter();
                    out.write("添加收货地址成功");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}

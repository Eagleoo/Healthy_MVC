<<<<<<< HEAD
package com.cd.mvc.web_servlet;

import com.cd.mvc.dao.factory.Factory;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "Updateorder_Servlet")
public class Updateorder_Servlet extends HttpServlet {
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            request.setCharacterEncoding("utf-8");
            response.setContentType("text/xml;charset=UTF-8");
            response.setCharacterEncoding("utf-8");
            String order_id = request.getParameter("order_id");
            String username = request.getParameter("username");
            String mall_id = request.getParameter("mall_id");
            String mall_count = request.getParameter("mall_count");
            String order_allprice = request.getParameter("order_allprice");
            String consignee = request.getParameter("consignee");
            String cellnumber = request.getParameter("cellnumber");
            String address = request.getParameter("address");
            String ispay = request.getParameter("ispay");
            String issend = request.getParameter("issend");
            String isreceive = request.getParameter("isreceive");
            boolean issuccess = false;
            System.out.println(order_id+username+mall_id+mall_count+order_allprice+consignee+cellnumber+address+ispay+issend+isreceive);
            try {
                issuccess = Factory.getMallDAOImplProxy().updateorder(order_id, username, mall_id, address, mall_count, order_allprice, consignee, cellnumber, ispay, issend, isreceive);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (issuccess) {
                List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("success", "修改订单成功");
                list.add(map);
                JSONArray ja = JSONArray.fromObject(list);
                String str = ja.toString();
                PrintWriter out = response.getWriter();
                System.out.println(str);
                out.write(str);
            }
        }
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request,response);
        }
}
=======
package web_servlet;

import dao.factory.Factory;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "Updateorder_Servlet")
public class Updateorder_Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/xml;charset=UTF-8");
        response.setCharacterEncoding("utf-8");
        String order_id = request.getParameter("order_id");
        String username = request.getParameter("username");
        String mall_id = request.getParameter("mall_id");
        String mall_count = request.getParameter("mall_count");
        String order_allprice = request.getParameter("order_allprice");
        String consignee = request.getParameter("consignee");
        String cellnumber = request.getParameter("cellnumber");
        String address = request.getParameter("address");
        String ispay = request.getParameter("ispay");
        String issend = request.getParameter("issend");
        String isreceive = request.getParameter("isreceive");
        boolean issuccess = false;
        System.out.println(order_id+username+mall_id+mall_count+order_allprice+consignee+cellnumber+address+ispay+issend+isreceive);
        try {
            issuccess = Factory.getMallDAOImplProxy().updateorder(order_id, username, mall_id, address, mall_count, order_allprice, consignee, cellnumber, ispay, issend, isreceive);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (issuccess) {
            List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("success", "修改订单成功");
            list.add(map);
            JSONArray ja = JSONArray.fromObject(list);
            String str = ja.toString();
            PrintWriter out = response.getWriter();
            System.out.println(str);
            out.write(str);
        }
    }
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request,response);
        }
}
>>>>>>> f4c6544bb32f7d424737d660696d06e422f893d3

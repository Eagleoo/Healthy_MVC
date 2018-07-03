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

@WebServlet(name = "Updatemall_Servlet")
public class Updatemall_Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/xml;charset=UTF-8");
        response.setCharacterEncoding("utf-8");

        String mall_name = request.getParameter("mall_name");
        String mall_describe = request.getParameter("mall_describe");
        String mall_price = request.getParameter("mall_price");
        String mall_id = request.getParameter("mall_id");
        boolean issuccess = false;
        try {
            issuccess = Factory.getMallDAOImplProxy().updatemall(mall_id,mall_name,mall_describe,mall_price);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (issuccess) {
            List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("success", "修改商品成功");
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

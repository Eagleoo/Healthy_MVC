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

@WebServlet(name = "Insertlogistics_Servlet")
public class Insertlogistics_Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("utf-8");
        response.setCharacterEncoding("utf-8");

        String order_id=request.getParameter("order_id");
        String l_time=request.getParameter("l_time");
        String l_add=request.getParameter("l_add");
        try {
            Factory.getMallDAOImplProxy().inserlogistics(order_id,l_time,l_add);
            List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
            Map<String,Object> map = new HashMap<String, Object>();
            map.put("success","添加物流信息成功" );
            list.add(map);
            JSONArray ja=JSONArray.fromObject(list);
            String str = ja.toString();
            PrintWriter out=response.getWriter();
            out.write(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);
    }
}

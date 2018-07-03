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

@WebServlet(name = "Insertorder_Servlet")
public class Insertorder_Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("utf-8");
        response.setCharacterEncoding("utf-8");

        HttpSession session = request.getSession();
        String username=(String) session.getAttribute("USER");
        String mall_id=request.getParameter("mall_id");
        String address=request.getParameter("address");
        String order_count=request.getParameter("order_count");
        String order_allprice=request.getParameter("order_allprice");
        String consignee=request.getParameter("consignee");
        String cellnumber=request.getParameter("cellnumber");
        String ispay=request.getParameter("ispay");
        String issend=request.getParameter("issend");
        String isreceive=request.getParameter("isreceive");
        try {
            Factory.getMallDAOImplProxy().insertorder(username,mall_id,address,order_count,order_allprice,consignee,cellnumber,ispay,issend,isreceive);
            List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
            Map<String,Object> map = new HashMap<String, Object>();
            map.put("success","提交订单成功" );
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

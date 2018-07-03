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

@WebServlet(name = "Insercollect_Servlet")
public class Insercollect_Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("utf-8");
        response.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        String username= (String) session.getAttribute("USER");

        System.out.println(username);
        String mall_id=request.getParameter("mall_id");
        String iscollect="no";
        boolean issuccess=false;
            try {
                iscollect=Factory.getMallDAOImplProxy().selectmall_collect_iscollect(mall_id,username);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (iscollect.equals("no"))
            {
                try {
                    issuccess=Factory.getMallDAOImplProxy().insertmall_collect(username, mall_id);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        if (issuccess) {
            List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("collect", "收藏成功");
            list.add(map);
            JSONArray ja = JSONArray.fromObject(list);
            String str = ja.toString();
            PrintWriter out = response.getWriter();
            System.out.println(str);
            out.write(str);}
        else {
            List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("collect", "收藏失败,你可能已经收藏过了哦");
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

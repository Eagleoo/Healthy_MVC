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

@WebServlet(name = "Deletemall_Servlet")
public class Deletemall_Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/xml;charset=UTF-8");
        response.setCharacterEncoding("utf-8");
        String mall_id=request.getParameter("mall_id");
        boolean issuccess=false;
        try {
            issuccess= Factory.getMallDAOImplProxy().deletemall(mall_id);
            if (issuccess)
            {
                List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
                Map<String,Object> map = new HashMap<String, Object>();
                map.put("success","下架成功" );
                list.add(map);
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

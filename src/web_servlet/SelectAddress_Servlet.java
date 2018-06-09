package web_servlet;

import dao.factory.Factory;
import dao.vo.Address;
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

@WebServlet(name = "SelectAddress_Servlet")
public class SelectAddress_Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("utf-8");
        response.setCharacterEncoding("utf-8");

        List<Address> list=new LinkedList<Address>();
        String username=request.getParameter("username");
        System.out.println(username);
        try {
            list= Factory.getMallDAOImplProxy().selectaddr(username);
            JSONArray ja=JSONArray.fromObject(list);
            String str = ja.toString();
            PrintWriter out=response.getWriter();
            out.write(str);
            System.out.println(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}

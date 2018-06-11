package controller;

import dao.factory.Factory;
import dao.vo.Address;
import dao.vo.JsonTools;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

@WebServlet(name = "selectaddr_Servlet")
public class selectaddr_Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("utf-8");
        response.setCharacterEncoding("utf-8");

        List<Address> list=new LinkedList<Address>();
        String username=request.getParameter("username");
        System.out.println(username);
        try {
            list= Factory.getMallDAOImplProxy().selectaddr(username);
            String jsonString= JsonTools.createJsonString("address",list);
            PrintWriter out=response.getWriter();
            System.out.println(jsonString);
            out.write(jsonString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}

package controller;

import dao.factory.Factory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Select_mallcollect_iscollect_Servlet")
public class Select_mallcollect_iscollect_Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("utf-8");
        response.setCharacterEncoding("utf-8");
        String username=request.getParameter("username");
        String mall_id=request.getParameter("mall_id");
        try {
            String Tag= Factory.getMallDAOImplProxy().selectmall_collect_iscollect(mall_id,username);
            PrintWriter out=response.getWriter();
            out.write(Tag);
            System.out.println(Tag);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}

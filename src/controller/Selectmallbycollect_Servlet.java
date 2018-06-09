package controller;

import dao.factory.Factory;
import dao.vo.JsonTools;
import dao.vo.Mall;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "Selectmallbycollect_Servlet")
public class Selectmallbycollect_Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("utf-8");
        response.setCharacterEncoding("utf-8");
        List<Mall> list;
        String username=request.getParameter("username");
        try {
            list= Factory.getMallDAOImplProxy().selectmallforcollect(username);
            String jsonString= JsonTools.createJsonString("mall",list);
            PrintWriter out=response.getWriter();
            out.write(jsonString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}

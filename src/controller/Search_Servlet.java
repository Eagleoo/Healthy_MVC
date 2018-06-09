package controller;

import dao.factory.Factory;
import dao.vo.JsonTools;
import dao.vo.Mall_Name;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Search_Servlet")
public class Search_Servlet extends HttpServlet {
    List<Mall_Name> list=new ArrayList<Mall_Name>();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("image/jpeg");
        String mallname=request.getParameter("search");
        try {
            if (mallname==null)
            {
            }
            else {
            list= Factory.getSearchDAOImplProxy().selectmallformallname(mallname);
            String jsonString= JsonTools.createJsonString("mall_name",list);
            PrintWriter out=response.getWriter();
            out.write(jsonString);
            System.out.println(jsonString);}
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}

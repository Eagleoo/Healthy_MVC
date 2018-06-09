package controller;

import dao.factory.Factory;
import dao.vo.Banner;
import dao.vo.JsonTools;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Banner_Servlet")
public class Banner_Servlet extends HttpServlet {
    List<Banner> list=new ArrayList<Banner>();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("image/jpeg");
        try {
            list= Factory.getBannerDAOImpllProxy().selectbanner();
            System.out.println("LIST"+list);
            String jsonString= JsonTools.createJsonString("banner",list);
            System.out.println("bannerjson"+jsonString);
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

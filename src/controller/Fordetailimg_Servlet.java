package controller;

import dao.factory.Factory;
import dao.vo.Detail_img;
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

@WebServlet(name = "Fordetailimg_Servlet")
public class Fordetailimg_Servlet extends HttpServlet {
    List<Detail_img> list=new ArrayList<Detail_img>();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("image/jpeg");

        String mall_id=request.getParameter("mall_id");
        try {
            list= Factory.getMallDAOImplProxy().selectdetailimgbyid(mall_id);
            System.out.println("mall_id"+mall_id);
            String jsonString= JsonTools.createJsonString("detail_img",list);
            PrintWriter out=response.getWriter();
            out.write(jsonString);
            System.out.println("mall_detail_img"+jsonString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);
    }
}

package controller;

import dao.factory.Factory;
import dao.vo.JsonTools;
import dao.vo.Text;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Text_Servlet extends HttpServlet {
    List<Text> list_text=new ArrayList<Text>();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("utf-8");
        response.setCharacterEncoding("utf-8");
        try {
            list_text= Factory.getTextDAOImplProxy().list_text();
            String jsonString= JsonTools.createJsonString("text",list_text);
            PrintWriter out=response.getWriter();
            out.write(jsonString);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
//    public static void main(String[] args) {
//        try {
//            List<dao.vo.Text> list_text=new ArrayList<dao.vo.Text>();
//            list_text= dao.factory.Factory.getTextDAOImplProxy().list_text();
//            String jsonString=dao.vo.JsonTools.createJsonString("text",list_text);
//
//            System.out.println(jsonString);
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//
//    }

}


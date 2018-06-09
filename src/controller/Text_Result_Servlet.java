package controller;

import dao.factory.Factory;
import dao.vo.JsonTools;
import dao.vo.TextResult;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Text_Result_Servlet extends HttpServlet {
    List<TextResult> list=new ArrayList<>();
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
            list= Factory.getTextDAOImplProxy().text_result();
            String result_json= JsonTools.createJsonString("result",list);
            PrintWriter out=response.getWriter();
            out.write(result_json);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
//    public static void main(String[] args) {
//        List<dao.vo.TextResult> list=new ArrayList<>();
//        try {
//            list=dao.factory.Factory.getTextDAOImplProxy().text_result();
//            String result_json=dao.vo.JsonTools.createJsonString("result",list);
//            System.out.println(result_json);
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//
//    }

}


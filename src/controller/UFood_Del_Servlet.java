package controller;

import dao.factory.Factory;
import dao.vo.JsonTools;
import dao.vo.U_Food;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UFood_Del_Servlet extends HttpServlet {
    U_Food u_food=new U_Food();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("utf-8");
        response.setCharacterEncoding("utf-8");

        //action为json数组
        String action=request.getParameter("u_food");


        u_food= JsonTools.Json_To_UFood1("u_food",action);
        System.out.println(action);
        try {
            Factory.getUFoodDAOImplProxy().delete_u_food(u_food);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}

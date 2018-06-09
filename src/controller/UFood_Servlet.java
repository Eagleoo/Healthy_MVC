package controller;

import dao.factory.Factory;
import dao.vo.JsonTools;
import dao.vo.U_Food;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class UFood_Servlet extends HttpServlet {
    List<U_Food> list_u_food=new ArrayList<U_Food>();
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
        if(action!=null){

            u_food= JsonTools.Json_To_UFood("u_food",action);
            try {
                Factory.getUFoodDAOImplProxy().add_u_food(u_food);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        else {
            try {
                list_u_food= Factory.getUFoodDAOImplProxy().list_u_food();
                String jsonString= JsonTools.createJsonString("u_food",list_u_food);
                PrintWriter out=response.getWriter();
                out.write(jsonString);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }




    }

}

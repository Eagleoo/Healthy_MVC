package controller;

import dao.factory.Factory;
import dao.vo.Food;
import dao.vo.JsonTools;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Eat_Servlet extends HttpServlet {
    List<Food> list_food=new ArrayList<Food>();
    Food food=new Food();
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
        String action=request.getParameter("food");

        if(action!=null){
            food= JsonTools.Json_To_Food("food",action);
            System.out.println(food);
            try {
                Factory.getFoodDAOImplProxy().add_food(food);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        else {
            try {
                list_food= Factory.getFoodDAOImplProxy().list_food();
                String jsonString= JsonTools.createJsonString("food",list_food);
                PrintWriter out=response.getWriter();
                out.write(jsonString);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }




    }

}

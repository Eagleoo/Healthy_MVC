package controller;

import dao.factory.Factory;
import dao.vo.JsonTools;
import dao.vo.Plan;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Plan_Servlet extends HttpServlet {
    List<Plan> list_plan=new ArrayList<Plan>();
    Plan plan =new Plan();
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
        String action=request.getParameter("dao.vo.Plan");

        if(action!=null){
            plan= JsonTools.Json_To_PlanList("plan",action);
            try {
                Factory.getPlanDAOImplProxy().add_plan(plan);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        else {
            try {
                list_plan= Factory.getPlanDAOImplProxy().list_plan();
                String jsonString= JsonTools.createJsonString("plan",list_plan);
                PrintWriter out=response.getWriter();
                out.write(jsonString);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }



    }

}

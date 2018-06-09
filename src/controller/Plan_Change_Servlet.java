package controller;

import dao.factory.Factory;
import dao.vo.JsonTools;
import dao.vo.Plan;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Plan_Change_Servlet extends HttpServlet {
    Plan plan =new Plan();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("utf-8");
        response.setCharacterEncoding("utf-8");

        //action为json数组
        String action=request.getParameter("dao.vo.Plan");

        plan= JsonTools.Json_To_PlanList("plan",action);
            try {
                Factory.getPlanDAOImplProxy().update_plan(plan);
            } catch (Exception e) {
                e.printStackTrace();
            }

    }
}

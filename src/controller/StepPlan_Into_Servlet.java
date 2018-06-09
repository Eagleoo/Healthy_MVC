package controller;

import dao.factory.Factory;
import dao.vo.JsonTools;
import dao.vo.StepPlan;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class StepPlan_Into_Servlet extends HttpServlet {
    StepPlan stepPlan =new StepPlan();
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
        String action=request.getParameter("dao.vo.StepPlan");


            stepPlan= JsonTools.Json_To_StepPlan("dao.vo.StepPlan",action);
            try {
                Factory.getPlanDAOImplProxy().add_step_plan(stepPlan);
            } catch (Exception e) {
                e.printStackTrace();
            }


    }
}

package controller;

import dao.factory.Factory;
import dao.vo.JsonTools;
import dao.vo.Step;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Step_Servelet extends HttpServlet {
    List<Step> list=new ArrayList<Step>();
    List<Step> list2=new ArrayList<Step>();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("utf-8");
        response.setCharacterEncoding("utf-8");
        //action为json数组
        String action=request.getParameter("sStep");
        if(action!=null){
            list2= JsonTools.Json_To_StepList("step",action);
            try {
                Factory.getStepDAOImplProxy().add_step(list2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        else {
            try {
                list= Factory.getStepDAOImplProxy().list_step();
                String jsonString= JsonTools.createJsonString("step",list);
                PrintWriter out=response.getWriter();
                out.write(jsonString);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}

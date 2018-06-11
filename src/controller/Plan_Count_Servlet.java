package controller;

import dao.factory.Factory;
import dao.vo.JsonTools;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Plan_Count_Servlet extends HttpServlet {
    int tem=0;
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
                tem= Factory.getPlanDAOImplProxy().count_plan();
                String jsonString= JsonTools.createJsonInt("count",tem);
                PrintWriter out=response.getWriter();
                out.write(jsonString);
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
}

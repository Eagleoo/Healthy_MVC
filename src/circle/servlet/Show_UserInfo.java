package circle.servlet;

import circle.dao.MessageDao;
import circle.model.Dynamics;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

public class Show_Dynamic extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter printWriter=response.getWriter();
        MessageDao messageDao=new MessageDao();
        ArrayList<Dynamics> list= null;
        try {
            list = messageDao.ShowDynamic();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        JSONArray jsonArray=JSONArray.fromObject(list);
        printWriter.println(jsonArray);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}

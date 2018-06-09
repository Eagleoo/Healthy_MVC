package web_servlet;

import dao.factory.Factory;
import dao.vo.Mall;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "Selectmall_Servlet")
public class Selectmall_Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("image/jpeg");


        int mallstart= Integer.parseInt(request.getParameter("mallstart"));
        int mallcount= Integer.parseInt(request.getParameter("mallcount"));
        System.out.println("mallstart"+mallstart+"mallcount"+mallcount);
        List<Mall> list;
        try {
            list= Factory.getMallDAOImplProxy().selectmallallpage(mallstart,mallcount);
            JSONArray ja=JSONArray.fromObject(list);
            String str = ja.toString();
            PrintWriter out=response.getWriter();
            out.write(str);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

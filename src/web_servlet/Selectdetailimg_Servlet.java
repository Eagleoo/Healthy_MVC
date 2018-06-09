package web_servlet;

import dao.factory.Factory;
import dao.vo.Detail_img;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "Selectdetailimg_Servlet")
public class Selectdetailimg_Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("image/jpeg");

        String mall_id=request.getParameter("mall_id");
        List<Detail_img> list;
        try {
            list= Factory.getMallDAOImplProxy().selectdetailimgbyid(mall_id);
            JSONArray ja=JSONArray.fromObject(list);
            String str = ja.toString();
            PrintWriter out=response.getWriter();
            out.write(str);
            System.out.println(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}

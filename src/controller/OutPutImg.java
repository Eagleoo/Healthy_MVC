package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

@WebServlet(name = "OutPutImg")
public class OutPutImg extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("image/jpeg");

        String url=request.getParameter("url");
        FileInputStream fis = new FileInputStream(url);
        int size = fis.available();
        byte data[] = new byte[size];
        String string = String.valueOf(data);
        fis.read(data);
        fis.close();
        OutputStream os = response.getOutputStream();
        os.write(data);
        os.flush();
        os.close();
        System.out.println(url);



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}

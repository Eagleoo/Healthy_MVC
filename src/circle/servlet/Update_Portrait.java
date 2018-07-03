package circle.servlet;


import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class questionDao_file extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        req.setCharacterEncoding("utf-8");

        ServletInputStream is = req.getInputStream();

        File file = new File("E:\\IDEA_Project\\Healthy_MVC - dat\\MVC\\out\\artifacts\\step_war_exploded\\circle_img",req.getHeader("imagename"));

        FileOutputStream fos = new FileOutputStream(file);

        int len=0;
        byte[] buf =new byte[1024];
        while((len = is.read(buf)) != -1){//如果没有读到文件的末尾

            fos.write(buf , 0 , len );
        }
        fos.flush();
        fos.close();


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}

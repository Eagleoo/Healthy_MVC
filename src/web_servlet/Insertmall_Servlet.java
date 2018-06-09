package web_servlet;

import com.jspsmart.upload.File;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
import controller.Utils;
import dao.factory.Factory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Insertmall_Servlet")
public class Insertmall_Servlet extends HttpServlet {
    String imgurl="E:\\IDEA_Project\\step\\web\\detail_img";
    String mimgurl="E:\\IDEA_Project\\step\\web\\mall_img";
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=GB2312");
        response.setCharacterEncoding("utf-8");

        SmartUpload smartUpload = new SmartUpload();
        smartUpload.initialize(getServletConfig(),request,response);
        try {
            smartUpload.upload();
        } catch (SmartUploadException e) {
            e.printStackTrace();
        }
        String mall_name = smartUpload.getRequest().getParameter("mall_name");
        String mall_describe = smartUpload.getRequest().getParameter("mall_describe");
        String mall_price= smartUpload.getRequest().getParameter("mall_price");
        String mall_type = smartUpload.getRequest().getParameter("mall_type");

        File file1 = smartUpload.getFiles().getFile(0);
        String ext = file1.getFileExt();
        //String ip = "192.168.1.111";
//        String ip = "192.168.43.108";
        String ip = "192.168.43.37";
        String fileName = Utils.getPicName(ip)+"."+ext;
        String mall_img="http://"+ip+":8080/mall_img/"+fileName;
        try {
            file1.saveAs("mall_img"+java.io.File.separator+fileName);
            file1.saveAs(mimgurl+java.io.File.separator+fileName);
            Factory.getMallDAOImplProxy().insertmall(mall_name,mall_describe,mall_price,mall_img,mall_type);
        } catch (SmartUploadException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
//------------------------------------------------------------------------------------------------------------------------
      //详情图片1
        File file2=smartUpload.getFiles().getFile(1);
        String ext2=file2.getFileExt();
        String fileName2= Utils.getPicName(ip)+"."+ext2;
        String mall_detail_img1="http://"+ip+":8080/detail_img/"+fileName2;
        try {
            file2.saveAs("detail_img"+java.io.File.separator+fileName2);
            file2.saveAs(imgurl+java.io.File.separator+fileName2);
        } catch (SmartUploadException e) {
            e.printStackTrace();
        }
//详情图片2
        File file3=smartUpload.getFiles().getFile(2);
        String ext3=file3.getFileExt();
        String fileName3=Utils.getPicName(ip)+"."+ext3;
        String mall_detail_img2="http://"+ip+":8080/detail_img/"+fileName3;
        try {
            file3.saveAs("detail_img"+java.io.File.separator+fileName3);
            file3.saveAs(imgurl+java.io.File.separator+fileName3);
        } catch (SmartUploadException e) {
            e.printStackTrace();
        }
//详情图片3
        File file4=smartUpload.getFiles().getFile(3);
        String ext4=file4.getFileExt();
        String fileName4=Utils.getPicName(ip)+"."+ext4;
        String mall_detail_img3="http://"+ip+":8080/detail_img/"+fileName4;
        try {
            file4.saveAs("detail_img"+java.io.File.separator+fileName4);
            file4.saveAs(imgurl+java.io.File.separator+fileName4);
        } catch (SmartUploadException e) {
            e.printStackTrace();
        }
//详情图片4
        File file5=smartUpload.getFiles().getFile(4);
        String ext5=file5.getFileExt();
        String fileName5=Utils.getPicName(ip)+"."+ext5;
        String mall_detail_img4="http://"+ip+":8080/detail_img/"+fileName5;
        try {
            file5.saveAs("detail_img"+java.io.File.separator+fileName5);
            file5.saveAs(imgurl+java.io.File.separator+fileName5);
        } catch (SmartUploadException e) {
            e.printStackTrace();
        }
        //详情图片5
        File file6=smartUpload.getFiles().getFile(5);
        String ext6=file6.getFileExt();
        String fileName6=Utils.getPicName(ip)+"."+ext6;
        String mall_detail_img5="http://"+ip+":8080/detail_img/"+fileName6;
        try {
            file6.saveAs("detail_img"+java.io.File.separator+fileName6);
            file6.saveAs(imgurl+java.io.File.separator+fileName6);
        } catch (SmartUploadException e) {
            e.printStackTrace();
        }
        //详情图片6
        File file7=smartUpload.getFiles().getFile(6);
        String ext7=file7.getFileExt();
        String fileName7=Utils.getPicName(ip)+"."+ext7;
        String mall_detail_img6="http://"+ip+":8080/detail_img/"+fileName7;
        try {
            file7.saveAs("detail_img"+java.io.File.separator+fileName7);
            file7.saveAs(imgurl+java.io.File.separator+fileName7);
        } catch (SmartUploadException e) {
            e.printStackTrace();
        }
        try {
            Factory.getMallDAOImplProxy().insertdetailimg(mall_detail_img1,mall_detail_img2,mall_detail_img3,mall_detail_img4,mall_detail_img5,mall_detail_img6);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.getWriter().print("<script>alert(\"上架成功\");window.location.href='manager.jsp'</script>");

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);
    }
}

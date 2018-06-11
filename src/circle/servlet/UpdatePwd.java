package circle.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import circle.dao.UserDao;

/**
 * Servlet implementation class UpdatePwd
 */
@WebServlet("/UpdatePwd")
public class UpdatePwd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePwd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String newpassword=request.getParameter("newpassword");
		String oldpassword=request.getParameter("oldpassword");
		int id=Integer.parseInt(request.getParameter("user_id"));
		UserDao userDao=new UserDao();
	boolean correct=userDao.Checkpwd(id, oldpassword);
	if(correct==true)
	{
		userDao.UpdatePwd(newpassword, id);
	}else {
		PrintWriter printWriter=response.getWriter();
		printWriter.println("fall");
	}
	}

}

package circle.servlet;

import circle.dao.UserDao;
import circle.model.User;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class ClientRegister
 */
@WebServlet("/ClientRegister")
public class ClientRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientRegister() {
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
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter printWriter=response.getWriter();
		UserDao userDao=new UserDao();
		String usernames=request.getParameter("user_name");
		String passwors=request.getParameter("user_password");
		String sex=request.getParameter("user_sex");
		String portrait=request.getParameter("portrait");
		if(passwors.equals(""))
		{
	     boolean flag=userDao.CheckUsername(usernames);
	     if(flag==false)
	     {
	    	
	    	 userDao.ClientRegisterByname(usernames,sex,portrait);
	    	 ClientQuery clientQuery=new ClientQuery();
			 clientQuery.doPost(request, response);
	     }
	     else{
	    	 ClientQuery clientQuery=new ClientQuery();
			 clientQuery.doPost(request, response);
		      }
		}else {
			boolean check=userDao.CheckUsername(usernames);
			if(check)
			{
				printWriter.println("F");
			}else {
				
				double tall=Double.parseDouble(request.getParameter("user_tall"));
				double weight=Double.parseDouble(request.getParameter("user_weight"));
				int age=Integer.parseInt(request.getParameter("user_age"));
				userDao.ClientRegister(new User(usernames,passwors,sex,tall,weight,age));
			      printWriter.println("OK");
			}
		}
		}
	}

		
		
		
	



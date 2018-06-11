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
 * Servlet implementation class ClientUpdate
 */
@WebServlet("/ClientUpdate")
public class ClientUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientUpdate() {
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
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		UserDao userDao=new UserDao();
		String function=request.getParameter("function");
				if (function.equals("update")) {
					int id=Integer.parseInt(request.getParameter("user_id"));
					String usernames=request.getParameter("user_name");
					String sex=request.getParameter("user_sex");
					double tall=Double.parseDouble(request.getParameter("user_tall"));
					double weight=Double.parseDouble(request.getParameter("user_weight"));
					int age=Integer.parseInt(request.getParameter("user_age"));
					String adress=request.getParameter("user_adress");
					userDao.ClientUpdate(new User(id,usernames,sex,
							tall,weight,age,adress));
					ClientQuery clientQuery=new ClientQuery();
					clientQuery.doPost(request, response);
				}if (function.equals("updateimag")) {
					String url=request.getParameter("url");
					String username=request.getParameter("username");
					userDao.Update(url, username);
				}if (function.equals("imag")) {
					String username=request.getParameter("username");
				String portrait=userDao.QueryImage(username);
					PrintWriter printWriter=response.getWriter();
					printWriter.println(portrait);
					
				}
	
		
	}

}

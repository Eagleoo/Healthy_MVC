package circle.servlet;

import circle.dao.UserDao;
import circle.model.User;
import net.sf.json.JSONObject;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class ClientQuery
 */
@WebServlet("/ClientQuery")
public class ClientQuery extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientQuery() {
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
		PrintWriter printWriter=response.getWriter();
		String username=request.getParameter("user_name");
		User user=new User();
		UserDao userDao=new UserDao();
		user=userDao.ClientQuery(username);
		if (user!=null) {
			JSONObject jsonObject=new JSONObject();
			jsonObject.put("user_id", user.getUser_id());
			jsonObject.put("username", user.getUsername());
			jsonObject.put("user_password", user.getUser_password());
			jsonObject.put("sex", user.getSex());
			jsonObject.put("user_tall", user.getUser_tall());
			jsonObject.put("user_weight", user.getUser_weight());
			jsonObject.put("user_age", user.getUser_age());
			jsonObject.put("portrait", user.getPortrait());
			printWriter.println(jsonObject);
			
		}else {
			printWriter.println("fall");
		}
		
	}

}

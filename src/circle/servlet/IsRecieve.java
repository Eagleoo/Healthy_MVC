package circle.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import circle.dao.RecieveDao;
import circle.model.Order;
import net.sf.json.JSONArray;

/**
 * Servlet implementation class IsRecieve
 */
@WebServlet("/IsRecieve")
public class IsRecieve extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IsRecieve() {
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
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String username=request.getParameter("username");
		RecieveDao recieveDao=new RecieveDao();
		ArrayList<Order> list=new ArrayList<Order>();
		PrintWriter printWriter=response.getWriter();
		list=recieveDao.isreceive(username);
		if (list.size()!=0) {
			JSONArray jsonArray=JSONArray.fromObject(list);
			
			printWriter.println(jsonArray);
		}else {
			printWriter.println("null");
		}
	
	}

}

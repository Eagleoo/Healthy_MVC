package circle.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import circle.dao.MessageDao;
import circle.model.Message;
import circle.model.Order;
import net.sf.json.JSONArray;

/**
 * Servlet implementation class NewConsult
 */
@WebServlet("/NewConsult")
public class New extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public New() {
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
		String id=request.getParameter("num");
		MessageDao messageDao=new MessageDao();
		PrintWriter printWriter=response.getWriter();
		
		if(id.equals("1"))
		{
			ArrayList<Message> list=messageDao.NewConsult();
			JSONArray jsonArray=JSONArray.fromObject(list);
		printWriter.println(jsonArray);
		}
		if(id.equals("2"))
		{
			ArrayList<Order> list=messageDao.NewMall();
			JSONArray jsonArray=JSONArray.fromObject(list);
		printWriter.println(jsonArray);
		}
	}

}

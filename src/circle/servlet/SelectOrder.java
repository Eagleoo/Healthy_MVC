package circle.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import circle.dao.AdressDao;
import circle.dao.RecieveDao;
import circle.model.Adress;
import circle.model.Order;
import net.sf.json.JSONArray;


/**
 * Servlet implementation class SelectOrder
 */
@WebServlet("/SelectOrder")
public class SelectOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectOrder() {
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
		request.setCharacterEncoding("utf-8");
		PrintWriter printWriter=response.getWriter();
		RecieveDao recieveDao=new RecieveDao();
		String function=request.getParameter("function");
		if (function.equals("order")) {
			String username=request.getParameter("username");
		    ArrayList<Order> list=recieveDao.SelectOrder(username);
		    if (list.size()!=0) {
		    	JSONArray jsonArray=JSONArray.fromObject(list);
				printWriter.println(jsonArray);
			}else {
				printWriter.println("null");
			}
			
		}if (function.equals("show")) {
			int order_id=Integer.parseInt(request.getParameter("order_id"));
			ArrayList<Order> list=recieveDao.ShowOrder(order_id);
			JSONArray jsonArray=JSONArray.fromObject(list);
			printWriter.println(jsonArray);
		}if (function.equals("back")) {
			int order_id=Integer.parseInt(request.getParameter("order_id"));
				recieveDao.DeleteGoods(order_id);
			}
			
		}
	

		
	}



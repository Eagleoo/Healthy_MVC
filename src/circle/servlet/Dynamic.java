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
import circle.model.Dynamics;
import circle.model.Responses;
import circle.model.Review;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class Dynamic
 */
@WebServlet("/Dynamic")
public class Dynamic extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Dynamic() {
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
		response.setContentType("text/html;charset=utf-8");
		String function=request.getParameter("function");
		PrintWriter printWriter=response.getWriter();
		MessageDao messageDao=new MessageDao();
		
		if (function.equals("show")) {
			ArrayList<Dynamics> list=messageDao.ShowDynamic();
		JSONArray jsonArray=JSONArray.fromObject(list);
		printWriter.println(jsonArray);
		}
		if(function.equals("newdynamic"))
		{
			
			ArrayList<Dynamics> list=messageDao.NewDynamic();
			JSONArray jsonArray=JSONArray.fromObject(list);
			printWriter.println(jsonArray);
		}
		if (function.equals("review")) {
			int consult_id=Integer.parseInt(request.getParameter("consult_id"));
			ArrayList<Review> list=messageDao.Review(consult_id);
			JSONArray jsonArray=JSONArray.fromObject(list);
			printWriter.println(jsonArray);
		}
		if (function.equals("insertreview")) {
			String username=request.getParameter("username");
			String content=request.getParameter("content");
			int consult_id=Integer.parseInt(request.getParameter("consult_id"));
			messageDao.Announce(new Review(username,consult_id,content));
			printWriter.print(consult_id);
		}
		if (function.equals("response")) {
			int reviewid=Integer.parseInt(request.getParameter("reviewid"));
		ArrayList<Responses> list=messageDao.CheckResponse(reviewid);
		JSONArray jsonArray=JSONArray.fromObject(list);
		printWriter.println(jsonArray);
		}
		if (function.equals("discuss")) {
			String username=request.getParameter("username");
			String responsename=request.getParameter("name");
			String responsecont=request.getParameter("content");
			int reviewid=Integer.parseInt(request.getParameter("reviewid"));
			messageDao.Insertreply(new Responses(username,responsename,responsecont,reviewid));
			
		}
		if (function.equals("delete")) {
			String responsename=request.getParameter("name");
			String responsecont=request.getParameter("content");
			int reviewid=Integer.parseInt(request.getParameter("reviewid"));
			messageDao.Deletereply(responsename, responsecont, reviewid);
		}
		if (function.equals("deletereview")) {
			String username=request.getParameter("name");
			String content=request.getParameter("content");
			int consult_id=Integer.parseInt(request.getParameter("consult_id"));
		    messageDao.DeleteReview(username, content, consult_id);
		}
		if (function.equals("insert")) {
			String title=request.getParameter("title");
			String describe=request.getParameter("describe");
			String content=request.getParameter("content");
			String author=request.getParameter("author");
			messageDao.InsertDynamic(new Dynamics(describe,title,content,author));
		}
	}

}

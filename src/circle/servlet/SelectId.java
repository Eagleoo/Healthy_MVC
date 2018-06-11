package circle.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import circle.dao.AdressDao;
import circle.model.Adress;

/**
 * Servlet implementation class SelectId
 */
@WebServlet("/SelectId")
public class SelectId extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectId() {
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
		String sender=request.getParameter("sender");
		String tel=request.getParameter("tel");
		String address=request.getParameter("address");
		AdressDao adressDao=new AdressDao();
		adressDao.SelectId(new Adress(sender,tel,address));
		PrintWriter printWriter=response.getWriter();
		printWriter.println(adressDao.SelectId(new Adress(sender,tel,address)));
	}

}

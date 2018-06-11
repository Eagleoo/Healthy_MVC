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
 * Servlet implementation class InsertAdress
 */
@WebServlet("/InsertAdress")
public class InsertAdress extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertAdress() {
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
		String clientname=request.getParameter("name");
		String sender=request.getParameter("sender");
		String clienttel=request.getParameter("tel");
		String clientaddress=request.getParameter("address");
		AdressDao adressDao=new AdressDao();
		adressDao.Insertad(new Adress(clientname,sender,clienttel,clientaddress));
		AdressQuery adressQuery=new AdressQuery();
		adressQuery.doPost(request, response);
		
	}

}

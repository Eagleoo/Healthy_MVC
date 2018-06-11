package circle.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import circle.dao.AdressDao;
/**
 * Servlet implementation class AddressDelete
 */
@WebServlet("/AddressDelete")
public class AddressDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddressDelete() {
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
		AdressDao adressDao=new AdressDao();
		String id = request.getParameter("id");
		String s1= id.replace("[","" );
		String s2=s1.replace("]", "");
		String s3=s2.replaceAll(" ", "");
		String str[] = s3.split(",");  
		int array[] = new int[str.length];  
		for(int i=0;i<str.length;i++){  
		    array[i]=Integer.parseInt(str[i]);
		    adressDao.AddressDelete(array[i]);
		    
		}
		AdressQuery adressQuery=new AdressQuery();
		adressQuery.doPost(request, response);
		
	}	
}

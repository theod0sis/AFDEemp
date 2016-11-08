package theoAggelis;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class regServlet
 */
@WebServlet("/regServlet")
public class regServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public regServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html; charset=ISO-8859-7");    
	    
	    try{
	    	
	    	
	    	if ((request.getParameter("email") ==null) || (request.getParameter("password")==null)) {
	    		 response.sendRedirect("/theoAggelis/index.jsp");
	    	      return;
	    	    }
	    	String email = request.getParameter("email");
		    String password = request.getParameter("password");
		    email=new String(email.getBytes("ISO-8859-1"), "ISO-8859-7");
	    	password=new String(password.getBytes("ISO-8859-1"), "ISO-8859-7");
		    
		    sqlConect conn = new sqlConect();
	    	conn.open();
	    	conn.register(email, password);
	    	conn.close();
	    	 HttpSession session = request.getSession(true);
		     session.setAttribute("email", email);
	    	response.sendRedirect("/theoAggelis/index.jsp");
	    	
	    }catch (Exception ex) {
	        ex.getMessage();
	        }
	    }
	   
		
		
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

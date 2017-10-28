package session;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Index extends HttpServlet{

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		HttpSession session = req.getSession();
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("main.jsp");
		Boolean connected = getValue((Boolean)session.getAttribute("connected"));
		if(connected == true){
			requestDispatcher = req.getRequestDispatcher("main");
		}
		if(connected == null || connected == false){
			requestDispatcher = req.getRequestDispatcher("login.jsp");
			connected = false;
			session.setAttribute("connected", connected);
		}
		requestDispatcher.forward(req, resp);
	
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
	}
	
	private Boolean getValue(Boolean boolean1){
		if(boolean1 == null)
			return false;
		return true;
		
	}
}

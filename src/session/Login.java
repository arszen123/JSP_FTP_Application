package session;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import main.FTPClient;
import model.CheckSession;
import model.FTPConnection;

public class Login extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	private static String redirectTo = "main";
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		FTPConnection ftpConnection = null;
		FTPClient ftpClient = null;

		HttpSession session = req.getSession();
		Map<String, String[]> map =  req.getParameterMap();

		if(!CheckSession.isConnected(session.getAttribute("connected"))){
			
			if(map.isEmpty()){
				redirectTo = "login.jsp";
			}
			
			if(!map.isEmpty()){
				ftpConnection = new FTPConnection(map);
			
				try {
					
					ftpClient = ftpConnection.setUpConnection();
					
					session.setAttribute("FTPClient", ftpClient);
					session.setAttribute("CurrentDirectoryFiles", ftpClient.getCurrentDirectoryFiles());
					session.setAttribute("connected", new Boolean(true));
					redirectTo = "main";
					
				} catch (Exception e) {
					session.setAttribute("connected", new Boolean(false));
					session.setAttribute("error_msg", new String("Authentication failed!"));
					redirectTo = "login.jsp";
				}
			}
		}
		
		resp.sendRedirect(req.getContextPath()+"/"+redirectTo);
		
	}

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}

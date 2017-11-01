package ftpController;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.SftpException;

import main.FTPClient;
import main.FTPClientException;

import model.CheckSession;

public class ListDirectoryFiles extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HttpSession session = null;
	private Boolean connected = false;
	private FTPClient ftpClient =null;
	private String path = "";
	private String ErrorMessage = null;
	private RequestDispatcher requestDispatcher = null;
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		session = req.getSession();
		connected = CheckSession.isConnected(session.getAttribute("connected"));
		path = (String) req.getParameter("path");
		requestDispatcher = req.getRequestDispatcher("listFiles");
		
		if(connected){
			ftpClient = CheckSession.getFTPClient(session.getAttribute("FTPClient"));
			
			try {
				
				ftpClient.cd(path);
				
				try {
					
					Vector<ChannelSftp.LsEntry> lsEntries =  ftpClient.getCurrentDirectoryFiles();
					session.setAttribute("CurrentDirectoryFiles",lsEntries);
					
				} catch (SftpException e) {
					ErrorMessage = "Can't list directory files!";
				}
				
			} catch (FTPClientException e) {
				ErrorMessage = "Directory "+path+" does not exists!";
			}
			
			session.setAttribute("ErrorMessage", ErrorMessage);
		}
		
		requestDispatcher.forward(req, resp);
		
	}
	
}

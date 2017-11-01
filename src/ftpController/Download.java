package ftpController;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import main.FTPClient;
import main.GenerateZipFile;
import model.CheckSession;

public class Download extends HttpServlet{

	private HttpSession session = null;
	private FTPClient ftpClient = null;
	private String path = null;
	private OutputStream os = null;
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		session = req.getSession();
		
		if(CheckSession.isConnected(session.getAttribute("connected"))){
			ftpClient = CheckSession.getFTPClient(session.getAttribute("FTPClient"));
			path = (String) req.getParameter("path");
			if(path == null){
				path = ".";
			}
			try {
				resp.setContentType("application/zip");
				resp.setHeader("Content-Disposition", "attachment; filename=download.txt");
				os = resp.getOutputStream();
				GenerateZipFile gzf = new GenerateZipFile(ftpClient, path, os);
				gzf.getZipFile();
				
			} catch (Exception e) {
				resp.setContentType("text/html");
				resp.getWriter().write(e.toString());
			}
		}
	}
}

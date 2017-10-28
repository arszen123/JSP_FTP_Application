package session;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import main.FTPClient;

public class SessionListener implements HttpSessionListener{

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		//Nothing to do
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		HttpSession session = se.getSession();
		Object object = session.getAttribute("FTPClient");
		if(object != null){
			FTPClient ftpClient = (FTPClient) object;
			ftpClient.close();
		}
	}

}

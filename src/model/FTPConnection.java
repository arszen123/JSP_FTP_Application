package model;

import java.util.Map;
import main.ConnectionData;
import main.FTPChannel;
import main.FTPClient;

public class FTPConnection {
	
	private ConnectionData connectionData;
	
	
	public FTPConnection(Map<String, String[]> map) {
		
		connectionData = new ConnectionData();
		connectionData.setHostName(map.get("hostName")[0]);
		connectionData.setPortNumber(map.get("port")[0]);
		connectionData.setUserName(map.get("username")[0]);
		connectionData.setPassword(map.get("password")[0]);
		
	}
	
	public FTPClient setUpConnection() throws Exception{
		FTPChannel ftpChannel = new FTPChannel(connectionData);
		FTPClient ftpClient = null;
		try {
			ftpChannel.connect();
			ftpClient = new FTPClient(ftpChannel);
			
		} catch (Exception e){
			throw new Exception("Failed to set up connection!\n"+e.toString());
		}
		return ftpClient;
	}

}

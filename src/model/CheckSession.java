package model;

import main.FTPClient;

public class CheckSession {

	public static Boolean isConnected(Object object){
		if(object == null)
			return false;
		return (Boolean)object;	
	}
	
	public static Boolean isFTPClientConnected(FTPClient ftpClient){
		if(ftpClient == null)
			return false;
		return true;
	}
	
	public static FTPClient getFTPClient(Object object){
		return (FTPClient)object;
	}
	
}

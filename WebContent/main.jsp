<%@ page language="java" import="java.util.*,com.jcraft.jsch.*,main.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${sessionScope.connected eq false}">
	<c:redirect url="/login.jsp" />
</c:if>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>TITLE</title>
</head>
<body>
	<%
    Object ftpClientObject = session.getAttribute("FTPClient");
    FTPClient ftpClient = null;
    if(ftpClientObject != null)
		  ftpClient = (FTPClient)ftpClientObject;

      if(ftpClient != null){
        try{
          for (ChannelSftp.LsEntry iEntry: (Vector<ChannelSftp.LsEntry>)session.getAttribute("CurrentDirectoryFiles")) {
              out.write(iEntry.getFilename()+"</br>");
          }
        }catch(Exception e){
          out.write(e.toString());
        }

      }
     %>
</body>
</html>

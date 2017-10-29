<%@ page language="java" import="java.util.*,com.jcraft.jsch.*,main.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${sessionScope.connected ne true}">
	<c:redirect url="/login.jsp" />
</c:if>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>TITLE</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="assets/css/table.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>
	
</head>
<body>
${sessionScope.ErrorMessage}
<div class="tg-wrap">
	<table id="tg-wF43d" class="tg">
		<tr>
			<th class="tg-yw4l">Name</th>
			<th class="tg-yw4l">Modified Time</th>
			<th class="tg-yw4l">Size</th>
		</tr>
		<tr>
			<td class="tg-yw4l">..</td>
			<td class="tg-yw4l align-text-center">-</td>
			<td class="tg-yw4l align-text-center">0</td>
		</tr>
     <c:forEach var="iEntry" items="${sessionScope.CurrentDirectoryFiles}">
     	<tr>
	     	<c:set var="fileType" value="glyphicon-file"></c:set>
	     	<c:if test="${iEntry.getAttrs().isDir()}">
	     		<c:set var="fileType" value="glyphicon-folder-open"></c:set>
	     	</c:if>
	     	<td class="tg-yw4l">
		     	<span class="glyphicon ${fileType}">
		     		<span id="name">${iEntry.getFilename()}</span>
		     	</span>
	     	</td>
	     	<td class="tg-j2zy align-text-center">${iEntry.getAttrs().getMtimeString() }</td>
	     	<td class="tg-yw4l align-text-center">${iEntry.getAttrs().getSize()}</td>
	     	
     	</tr>
     </c:forEach>
     </table>
</div>

	<!-- script src="assets/js/table.js"></script-->
	<script src="assets/js/tableManipulation.js"></script>
	<script>
	$(document).ready(function(){
		initNavigation();
	});
	</script>

</body>
</html>

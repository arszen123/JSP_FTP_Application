<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${sessionScope.connected eq true}">
	<c:redirect url="/main" />
</c:if>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html >
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="assets/css/login.css">
	<title>Connect to FTP server</title>
</head>
<body>
	<form action="login" method="POST">
		<div id="userbox">
			<div id="conectTo">
				<input type="text" name="hostName" placeholder="IP Address">/
				<input type="number" name="port" placeholder="Port number" min="1">
			</div>
			<div id="userData">
				<input type="text" name="username" placeholder="Username">
				<input type="password" name="password" placeholder="Password">
			</div>
				<input id="submit" type="submit" name="submit">
	
		</div>
	</form>

</body>
</html>

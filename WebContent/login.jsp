<!DOCTYPE html>
<html >
<head>
<style>
#userbox{
	position:fixed;
    top: 50%;
    left: 50%;
    width:30em;
    height:18em;
    margin-top: -9em; /*set to a negative number 1/2 of your height*/
    margin-left: -15em; /*set to a negative number 1/2 of your width*/
    border: 1px solid #ccc;
    background-color: #f3f3f3;
}
#submit{
	position: absolute;
	bottom: 2%;
	left: 35%;
}
#conectTo{
	position: absolute;
	top: 10%;
	left: 10%;
}
#userData{
	position: absolute;
	top: 35%;
	left: 30%;
}
input{
	margin: 5px;
	text-align: center;
}
</style>
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

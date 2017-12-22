<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
<%@ include file="../../resources/css/main.css" %>
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Picture That</title>
</head>
<body>
	<form align="right" name="form1" method="post" action="log_out.php">
		<label class="logoutLblPos"> <input name="submit2"
			type="submit" id="submit2" value="log out">
		</label>
	</form>
	<center>
		<h1 id="header">Picture That</h1>
		<h2 id="username"> ${name}</h2>
	</center>
</body>
</html>
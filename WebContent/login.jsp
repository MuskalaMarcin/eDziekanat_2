<%@ page language="java" contentType="text/html; charset=ISO-8859-2"
	pageEncoding="ISO-8859-2"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-2">
<title>eDziekanat - Zaloguj się</title>
</head>
<body>
	Witamy w systemie eDziekanat, zaloguj się do swojego konta.
	<form action="loginaction" method=post>
		<p>
			<strong>Login: </strong> <input type="text" name="username" size="25">
		<p>
		<p>
			<strong>Hasło: </strong> <input type="password" size="15"
				name="password">
			<%
			    if (request.getSession().getAttribute("loginError") != null
					    && request.getSession().getAttribute("loginError").equals("true"))
			    {
					out.print("<p>\n<p>\nBłędny login lub hasło, spróbuj ponownie.");
					request.setAttribute("loginError", "false");
			    }
			%>
		<p>
		<p>
			<input type="submit" value="Zaloguj">
	</form>
	<%
	    request.getSession().setAttribute("backURL", request.getAttribute("javax.servlet.forward.request_uri"));
	%>
</body>
</html>
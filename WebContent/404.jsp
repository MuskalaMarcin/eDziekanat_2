<%@ page language="java" contentType="text/html; charset=ISO-8859-2"
    pageEncoding="ISO-8859-2"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-2">
<title>eDziekanat - Błąd 404</title>
</head>
<body>
	<center>
	<font face="verdana" size = "3">
		<p><img src="http://localhost:8080/eDziekanat/images/androiddev101.jpg"/></p>
		<p><b>Kod błędu:</b> ${pageContext.errorData.statusCode}
   		<br><b>Poszukiwany URI:</b> ${pageContext.request.scheme}://${header.host}${pageContext.errorData.requestURI}</p>
   		<p><br><br><font size="5"><a href="/eDziekanat/home">Powrót do strony głównej.</a></font></p>
		<p><br><br><font size="1" color="gray">Obrazek pobrano ze strony: <a href="http://www.404notfound.fr/">http://www.404notfound.fr/</a></font></p>
	</font>
	</center>
</body>
</html>
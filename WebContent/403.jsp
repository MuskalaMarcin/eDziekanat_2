<%@ page language="java" import="edziekanat.bean.LoginBean" contentType="text/html; charset=ISO-8859-2"
    pageEncoding="ISO-8859-2"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-2">
<title>eDziekanat - Odmowa dostępu.</title>
</head>
<body>
	<center>
	<font face="verdana" size = "3">
		<p><font size="7"><b>eDziekanat - Twój wirtualny dziekanat</b></font><br><br><br><br></p>
		<p><img src="http://localhost:8080/eDziekanat/images/Access-Denied-Yoda.jpg"/></p>
		<p><b>Odmowa dostępu!</b></p>
   		<p>Twój poziom dostępu: <b><% out.print(((LoginBean) request.getSession().getAttribute("loginBean")).getUserRole()); %></b> nie jest wystarczający do przeglądania tej podstrony.</p>
   		<p><br><br><font size="5"><a href="/eDziekanat/home">Powrót do strony głównej.</a></font></p>
		<p><br><br><font size="1" color="gray">Obrazek pobrano ze strony: <a href="http://www.jedimarketing.us/">http://www.jedimarketing.us/</a></font></p>
	</font>
	</center>
</body>
</html>
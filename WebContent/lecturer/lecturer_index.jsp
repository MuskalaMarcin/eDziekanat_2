<%@ page language="java" import="edziekanat.bean.LoginBean"
	contentType="text/html; charset=ISO-8859-2" pageEncoding="ISO-8859-2"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-2">
<title>eDziekanat - Wykładowca - strona główna</title>
</head>
<body>
	Strona główna wykładowcy.
	<a href="logout">Wyloguj</a>
	<%
	    LoginBean loginBean = (LoginBean) request.getSession().getAttribute("loginBean");
	    System.out.println(loginBean.getLogin());
	    System.out.println(loginBean.getName());
	    System.out.println(loginBean.getAcademicDegree());
	    System.out.println(loginBean.getAddress());
	    System.out.println(loginBean.geteMail());
	    System.out.println(loginBean.getSurname());
	    System.out.println(loginBean.getUserRole());
	    System.out.println(loginBean.getIsActive());
	    System.out.println(loginBean.getPersonId());
	%>
</body>
</html>
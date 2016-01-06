<%@ page language="java" import="edziekanat.databasemodel.dto.UserDTO,edziekanat.databasemodel.dao.UserDAO, edziekanat.bean.LoginBean" contentType="text/html; charset=ISO-8859-2"
    pageEncoding="ISO-8859-2"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-2">
<title>eDziekanat - Administrator - strona główna</title>
</head>
<body>
	Strona główna administratora.
		<a href="logout">Wyloguj</a>
		<% 
			UserDTO user = new UserDAO().getUser(request.getUserPrincipal().getName());
			System.out.println(user.getLogin());
			System.out.println(user.getPassword());
			System.out.println(user.geteMail());
			System.out.println(user.getUserRole());
			System.out.println(user.getAdministratorId());
			System.out.println(user.getLecturerId());
			System.out.println(user.getStudentId());
			user = new UserDAO().getUser("student");
			System.out.println(user.getLogin());
			System.out.println(user.getPassword());
			System.out.println(user.geteMail());
			System.out.println(user.getUserRole());
			System.out.println(user.getAdministratorId());
			System.out.println(user.getLecturerId());
			System.out.println(user.getStudentId());
			user = new UserDAO().getUser("wykladowca");
			System.out.println(user.getLogin());
			System.out.println(user.getPassword());
			System.out.println(user.geteMail());
			System.out.println(user.getUserRole());
			System.out.println(user.getAdministratorId());
			System.out.println(user.getLecturerId());
			System.out.println(user.getStudentId());
			UserDTO loginBean = (UserDTO)request.getSession().getAttribute("loginBean");
			System.out.println(loginBean.getLogin());
			System.out.println(loginBean.geteMail());
		%>
</body>
</html>
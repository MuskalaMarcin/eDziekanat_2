<%@ page language="java"
	import="edziekanat.databasemodel.dao.UserDAO, edziekanat.databasemodel.dto.UserDTO"
	contentType="text/html; charset=ISO-8859-2" pageEncoding="ISO-8859-2"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-2">
<link rel="stylesheet" href="../resources/styles.css">
<title>eDziekanat - Student - Nowa Wiadomości</title>
</head>
<body>
	<p id="headertext">eDziekanat - Twój wirtualny dziekanat</p>
	<table id="menu">
		<tr>
			<td><a href="http://localhost:8080/eDziekanat/student">Strona
					główna</a></td>
			<td><a href="http://localhost:8080/eDziekanat/studenttranscript">Indeks</a></td>
			<td><a href="http://localhost:8080/eDziekanat/studenttimetable">Plan
					zajęć</a></td>
			<td><a href="http://localhost:8080/eDziekanat/studentsubjects">Moje
					przedmioty</a></td>
			<td><a
				href="http://localhost:8080/eDziekanat/studentscholarships">Stypendia</a></td>
			<td><a href="http://localhost:8080/eDziekanat/studentpayments">Płatności</a></td>
			<td><a
				href="http://localhost:8080/eDziekanat/studentapplications">Wnioski</a></td>
			<td><a href="http://localhost:8080/eDziekanat/studentlecturers">Wykładowcy</a></td>
			<td id="grayCell"><a
				href="http://localhost:8080/eDziekanat/messages">Historia
					komunikatów</a></td>
			<td><a href="logout">Wyloguj</a></td>
		</tr>
	</table>

	<p>
		<%
		    String name = "Error";
		    UserDTO receiver = new UserDAO().getEntity(request.getParameter("receiverLogin"));
		    if (receiver.getUserRole().equals("admin"))
		    {
				name = receiver.getAdministrator().getName() + " " + receiver.getAdministrator().getSurname();
		    }
		    else if (receiver.getUserRole().equals("student"))
		    {
				name = receiver.getStudent().getName() + " " + receiver.getStudent().getSurname();
		    }
		    else if (receiver.getUserRole().equals("lecturer"))
		    {
				name = receiver.getLecturer().getName() + " " + receiver.getLecturer().getSurname();
		    }
		%>
	
	<form action="http://localhost:8080/eDziekanat/sendmessage" method=post>
		<p>
			Tytuł: <input type="text" name="msgtitle" size="25"
				value="RE: <%out.print(request.getParameter("title"));%>" required>
		</p>
		<p>
			Odbiorca: <input type="text" size="25" name="receivername"
				value="<%out.print(name);%>" disabled>
		</p>
		<p>
			Treść: <input type="text" size="25" name="content" required>
		</p>
		<p>
			<input type="hidden" name="msgreceiver"
				value="<%out.print(receiver.getLogin());%>"> <input
				type="submit" value="Wyślij">
		</p>
	</form>
	</p>
</body>
</html>
<%@ page language="java"
	import="edziekanat.databasemodel.dao.UserDAO, edziekanat.databasemodel.dto.UserDTO"
	contentType="text/html; charset=ISO-8859-2" pageEncoding="ISO-8859-2"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-2">
<link rel="stylesheet" href="../resources/styles.css">
<title>eDziekanat - Administrator - Nowa Wiadomości</title>
</head>
<body>
	<p id="headertext">eDziekanat - Twój wirtualny dziekanat</p>
	<table id="menu">
		<tr>
			<td bgcolor="silver"><a href="http://localhost:8080/eDziekanat/admin">Strona główna</a></td>
			<td><a href="http://localhost:8080/eDziekanat/admintimetable">Plan zajęć</a></td>
			<td><a href="http://localhost:8080/eDziekanat/adminusers">Użytkownicy</a></td>
			<td><a href="http://localhost:8080/eDziekanat/adminlecturers">Wykładowcy</a></td>
			<td><a href="http://localhost:8080/eDziekanat/adminsubjects">Przedmioty</a></td>
			<td><a href="http://localhost:8080/eDziekanat/adminstudents">Studenci</a></td>
			<td><a href="http://localhost:8080/eDziekanat/adminbackup">Kopia zapasowa</a></td>
			<td><a href="http://localhost:8080/eDziekanat/adminstatistics">Statystyki</a></td>
			<td><a href="http://localhost:8080/eDziekanat/adminscholarships">Stypendia</a></td>
			<td><a href="http://localhost:8080/eDziekanat/admipayments">Należności</a></td>
			<td><a href="http://localhost:8080/eDziekanat/adminapplications">Wnioski</a></td>
			<td  id="grayCell"><a href="http://localhost:8080/eDziekanat/messages">Historia komunikatów</a></td>
			<td><a href="http://localhost:8080/eDziekanat/logout">Wyloguj</a></td>

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
		<br>
		<br>Wyślij nową wiadomość<br>
		<br>
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
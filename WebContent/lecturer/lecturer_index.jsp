<%@ page language="java" import="edziekanat.bean.LoginBean"
	contentType="text/html; charset=ISO-8859-2" pageEncoding="ISO-8859-2"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-2">
<title>eDziekanat - Wykładowca - strona główna</title>
</head>
<body>
	<font face="Verdana"><center>
		<font size="7"><b>eDziekanat - Twój wirtualny dziekanat</b></font><br><br><br><br>
	
		<table border="1" cellspacing="5" cellpadding="5">
			<tr>
				<td bgcolor="silver"><a href="lecturer">Strona główna</a></td>
				<td><a href="lecturerlearningmaterials">Materiały dydaktyczne</a></td>
				<td><a href="lecturerseestudents">Studenci</a></td>
				<td><a href="lecturerseelecturers">Wykładowcy</a></td>
				<td><a href="lecturerclassrooms">Dostępność sal</a></td>
				<td><a href="lecturertimetable">Plan zajęć</a></td>
				<td><a href="lecturersubjects">Moje przedmioty</a></td>
				<td><a href="lecturermessages">Historia komunikatów</a></td>
				<td><a href="logout">Wyloguj</a></td>
			</tr>
		</table>
		
		<%LoginBean loginBean = (LoginBean) request.getSession().getAttribute("loginBean");%>
		<p>
			<br><br><br>Zalogowany jako:<br><br>
			Login: <b><%out.print(loginBean.getLogin()); %></b><br>
			Imię i nazwisko: <b><%out.print(loginBean.getName());%> <% out.print(loginBean.getSurname()); %></b><br>
			Stopień naukowy: <b><%out.print(loginBean.getAcademicDegree()); %></b><br>
			E-mail: <b><%out.print(loginBean.geteMail()); %></b><br>
			Poziom uprawnień: <b><%out.print(loginBean.getUserRole()); %></b><br>
			Adres: <b><%out.print(loginBean.getAddress()); %></b><br>
		</p>
	</center></font>
</body>
</html>
<%@ page language="java" import="edziekanat.bean.LoginBean"
	contentType="text/html; charset=ISO-8859-2" pageEncoding="ISO-8859-2"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-2">
<link rel="stylesheet" href="../resources/styles.css">
<title>eDziekanat - Wykładowca - Strona główna</title>
</head>
<body>
	<p id="headertext">eDziekanat - Twój wirtualny dziekanat</p>
	<table id="menu">
		<tr>
			<td id="grayCell"><a href="lecturer">Strona główna</a></td>
			<td><a href="lecturerlearningmaterials">Materiały
					dydaktyczne</a></td>
			<td><a href="lecturerseestudents">Studenci</a></td>
			<td><a href="lecturerseelecturers">Wykładowcy</a></td>
			<td><a href="lecturerclassrooms">Dostępność sal</a></td>
			<td><a href="lecturertimetable">Plan zajęć</a></td>
			<td><a href="lecturersubjects">Moje przedmioty</a></td>
			<td><a href="messages">Historia komunikatów</a></td>
			<td><a href="logout">Wyloguj</a></td>
		</tr>
	</table>

	<%
	    LoginBean loginBean = (LoginBean) request.getSession().getAttribute("loginBean");
	%>
	<p>
		<br>
		<br>
		<br>Zalogowany jako:<br>
		<br> Login: <b>
			<%
			    out.print(loginBean.getLogin());
			%>
		</b><br> Imię i nazwisko: <b>
			<%
			    out.print(loginBean.getName());
			%> <%
     out.print(loginBean.getSurname());
 %>
		</b><br> Stopień naukowy: <b>
			<%
			    out.print(loginBean.getAcademicDegree());
			%>
		</b><br> E-mail: <b>
			<%
			    out.print(loginBean.geteMail());
			%>
		</b><br> Poziom uprawnień: <b>
			<%
			    out.print(loginBean.getUserRole());
			%>
		</b><br> Adres: <b>
			<%
			    out.print(loginBean.getAddress());
			%>
		</b><br>
	</p>
</body>
</html>
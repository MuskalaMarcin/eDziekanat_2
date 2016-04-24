<%@ page language="java"
	import="edziekanat.databasemodel.dao.UserDAO, edziekanat.databasemodel.dto.UserDTO"
	contentType="text/html; charset=ISO-8859-2" pageEncoding="ISO-8859-2"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-2">
<link rel="stylesheet"
	href="http://localhost:8080/edziekanat/resources/pure-min.css">
<link rel="stylesheet"
	href="http://localhost:8080/edziekanat/resources/styles.css">
<title>eDziekanat - Wykładowca - Nowa Wiadomość</title>
</head>
<body>
	<div id="layout">
		<div id="menu">
			<div class="pure-menu">
				<a class="pure-menu-heading" href="home">eDziekanat</a>
				<ul class="pure-menu-list">
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="http://localhost:8080/edziekanat/lecturer">Strona główna</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="http://localhost:8080/edziekanat/lecturerlearningmaterials">Materiały
							dydaktyczne</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="http://localhost:8080/edziekanat/lecturerseestudents">Studenci</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="http://localhost:8080/edziekanat/lecturerseelecturers">Wykładowcy</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="http://localhost:8080/edziekanat/classrooms">Dostępność
							sal</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="http://localhost:8080/edziekanat/timetable">Plan zajęć</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="http://localhost:8080/edziekanat/lecturersubjects">Moje
							przedmioty</a></li>
					<li class="pure-menu-item   menu-item-divided"><a
						href="logout" class="pure-menu-link">Wyloguj</a>
					<li class="pure-menu-item menu-item-divided"><a
						href="http://localhost:8080/edziekanat/receivedmessages"
						class="pure-menu-link">Historia komunikatów</a></li>
					<li class="pure-menu-item  pure-menu-selected"><a href="#"
						class="pure-menu-link">Nowa wiadomość</a></li>
					<li class="pure-menu-item menu-item-divided"><a
						href="http://localhost:8080/edziekanat/logout"
						class="pure-menu-link">Wyloguj</a>
				</ul>
			</div>
		</div>
		<div id="main">
			<div class="header">
				<h1>eDziekanat</h1>
				<h2>Twój wirtualny dziekanat.</h2>
			</div>
			<div class="content">
				<h2 class="content-subhead">Wyślij nową wiadomość:</h2>
				<p>
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
				
				<center>
					<form action="http://localhost:8080/edziekanat/sendmessage"
						method=post class="pure-form">
						<fieldset class="pure-group">
							<input type="text" name="msgtitle" class="pure-input-1-2"
								placeholder="Tytuł"
								value="<%out.print(request.getParameter("title") == null ? "" : "RE:" + request.getParameter("title"));%>"
								required> <input type="text" name="receivername"
								class="pure-input-1-2" placeholder="Odbiorca"
								value="<%out.print(name);%>" disabled>
						</fieldset>

						<fieldset class="pure-group">
							<textarea name="content" class="pure-input-1-2"
								placeholder="Treść" required></textarea>
						</fieldset>

						<input type="hidden" name="msgreceiver"
							value="<%out.print(receiver.getLogin());%>">
						<button type="submit"
							class="pure-button pure-input-1-2 pure-button-primary">Wyślij</button>
					</form>
				</center>
			</div>
		</div>
	</div>
</body>
</html>
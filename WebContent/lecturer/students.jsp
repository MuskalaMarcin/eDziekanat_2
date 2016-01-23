<%@ page language="java" contentType="text/html; charset=ISO-8859-2"
	pageEncoding="ISO-8859-2"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-2">
<link rel="stylesheet" href="resources/pure-min.css">
<link rel="stylesheet" href="resources/styles.css">
<title>eDziekanat - Studenci</title>
</head>
<body>
	<div id="layout">
		<div id="menu">
			<div class="pure-menu">
				<a class="pure-menu-heading" href="home">eDziekanat</a>
				<ul class="pure-menu-list">
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="lecturer">Strona główna</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="lecturerlearningmaterials">Materiały dydaktyczne</a></li>
					<li class="pure-menu-item pure-menu-selected"><a class="pure-menu-link"
						href="lecturerseestudents">Studenci</a></li>
					<li class="pure-menu-item"><a
						class="pure-menu-link" href="lecturerseelecturers">Wykładowcy</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="lecturerclassrooms">Dostępność sal</a></li>
					<li class="pure-menu-item"><a href="timetable"
						class="pure-menu-link">Plan zajęć</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="lecturersubjects">Moje przedmioty</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="receivedmessages">Historia komunikatów</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="logout">Wyloguj</a></li>
				</ul>
			</div>
		</div>
		<div id="main">
			<div class="header">
				<h1>eDziekanat</h1>
				<h2>Twój wirtualny dziekanat.</h2>
			</div>
			<div class="content">
				<h2 class="content-subhead">Studenci:</h2>
				<center>
					<form class="pure-form" action="lecturersearchstudents" method=post>
						Imię: <input type="text" name="searchedName"
							class="pure-input-rounded"> 
						Nazwisko: <input type="text" name="searchedSurname" 
							class="pure-input-rounded" required>
						<button type="submit" class="pure-button pure-button-primary">Szukaj</button>
					</form>
				</center>
				<p>
				<table class="responseTable">
					<tr class="grayRow">
						<td>Imię</td>
						<td>Nazwisko</td>
						<td>e-Mail</td>
					</tr>
					<c:forEach items="${students}" var="student">
						<tr>
							<td>${student.name}</td>
							<td>${student.surname}</td>
							<td>${student.user.eMail}</td>
							<td id="respond">
								<form action="lecturer/newmessage" method=post>
									<input type="hidden" name="receiverLogin"
										value="${student.user.login}"> <input
										class="pure-button pure-input-1-2 pure-button-primary"
										type="submit" value="Kontakt">
								</form>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
</body>
</html>
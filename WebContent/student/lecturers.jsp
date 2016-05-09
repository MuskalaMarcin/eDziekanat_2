<%@ page language="java" contentType="text/html; charset=ISO-8859-2"
	pageEncoding="ISO-8859-2"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-2">
<link rel="stylesheet" href="resources/pure-min.css">
<link rel="stylesheet" href="resources/styles.css">
<title>eDziekanat - Wyk�adowcy</title>
</head>
<body>
	<div id="layout">
		<div id="menu">
			<div class="pure-menu">
				<a class="pure-menu-heading" href="home">eDziekanat</a>
				<ul class="pure-menu-list">
					<li class="pure-menu-item"><a href="student"
						class="pure-menu-link">Strona g��wna</a></li>
					<li class="pure-menu-item"><a href="studenttranscript"
						class="pure-menu-link">Indeks</a></li>
					<li class="pure-menu-item"><a href="timetable"
						class="pure-menu-link">Plan zaj��</a></li>
					<li class="pure-menu-item"><a href="studentsubjects"
						class="pure-menu-link">Moje przedmioty</a></li>
					<li class="pure-menu-item"><a href="studentscholarships"
						class="pure-menu-link">Stypendia</a></li>
					<li class="pure-menu-item"><a href="studentwaitingpayments"
						class="pure-menu-link">P�atno�ci</a></li>
					<li class="pure-menu-item"><a href="studentapplications"
						class="pure-menu-link">Wnioski</a></li>
					<li class="pure-menu-item  pure-menu-selected"><a
						href="studentlecturers" class="pure-menu-link">Wyk�adowcy</a></li>
					<li class="pure-menu-item"><a href="receivedmessages"
						class="pure-menu-link">Historia komunikat�w</a></li>
					<li class="pure-menu-item"><a href="logout"
						class="pure-menu-link">Wyloguj</a>
				</ul>
			</div>
		</div>
		<div id="main">
			<div class="header">
				<h1>eDziekanat</h1>
				<h2>Tw�j wirtualny dziekanat.</h2>
			</div>
			<div class="content">
				<h2 class="content-subhead">Wyk�adowcy:</h2>
				<table class="responseTable">
					<tr class="grayRow">
						<td>Imi�</td>
						<td>Nazwisko</td>
						<td>Stopie� naukowy</td>
						<td>Stanowisko</td>
						<td>e-Mail</td>
						<td>Przedmiot(y)</td>
					</tr>
					<c:forEach items="${lecturers}" var="lecturer">
						<tr>
							<td>${lecturer.name}</td>
							<td>${lecturer.surname}</td>
							<td>${lecturer.academicDegree}</td>
							<td>${lecturer.position}</td>
							<td>${lecturer.eMail}</td>
							<td>${lecturer.subject}</td>
							<td id="respond">
								<form action="student/newmessage" method=post>
									<input type="hidden" name="receiverLogin"
										value="${lecturer.login}"> <input
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
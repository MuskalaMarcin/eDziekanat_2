<%@ page language="java" contentType="text/html; charset=ISO-8859-2"
	pageEncoding="ISO-8859-2"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
					<li class="pure-menu-item"><a href="admin"
						class="pure-menu-link">Strona główna</a></li>
					<li class="pure-menu-item"><a href="admintimetable"
						class="pure-menu-link">Plan zajęć</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="adminclassrooms">Dostępność sal</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="admincourses">Kierunki</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="adminstudentgroups">Grupy studenckie</a></li>
					<li class="pure-menu-item menu-item-divided"><a
						class="pure-menu-link" href="#">Wykładowcy</a></li>
					<li class="pure-menu-item pure-menu-selected"><a
						class="pure-menu-link" href="adminlecturers">Przeglądaj</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="admin/newlecturer">Dodaj wykładowcę</a></li>
					<li class="pure-menu-item menu-item-divided"><a
						class="pure-menu-link" href="adminsubjects">Przedmioty</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="adminstudents">Studenci</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="marksstatistics">Statystyki</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="adminscholarships">Stypendia</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="adminpayments">Należności</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="adminapplications">Wnioski</a></li>
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
				<h2 class="content-subhead">Wykładowcy:</h2>
				<center>
					<form class="pure-form" action="adminsearchlecturers" method=post>
						<input type="text" name="subjectId" value="${subject.id}" hidden>
						Imię: <input type="text" name="searchedName"
							class="pure-input-rounded"> Nazwisko: <input type="text"
							name="searchedSurname" class="pure-input-rounded" required>
						<button type="submit" class="pure-button pure-button-primary">Szukaj</button>
					</form>
				</center>
				<p>
					<c:choose>
						<c:when test="${empty lecturers}">
							<center>Nie znaleziono wykładowców pasujących do
								kryteriów wyszukiwania.</center>
						</c:when>
						<c:otherwise>
							<table class="responseTable">
								<tr class="grayRow">
									<td>Imię</td>
									<td>Nazwisko</td>
									<td>e-Mail</td>
									<td>Ilość przedmiotów</td>
								</tr>
								<c:forEach items="${lecturers}" var="lecturer">
									<tr>
										<td>${lecturer.name}</td>
										<td>${lecturer.surname}</td>
										<td>${lecturer.user.eMail}</td>
										<td>${fn:length(lecturer.subject)}</td>
										<td width="70px" id="respond">
											<form action="adminsubjects" method=post>
												<input type="hidden" name="lecturerId"
													value="${lecturer.id}"> <input
													class="pure-button pure-input-1-2 pure-button-primary"
													type="submit" value="Przedmioty">
											</form>
										</td>
										<td width="70px" id="respond">
											<form action="admin/newmessage" method=post>
												<input type="hidden" name="receiverLogin"
													value="${lecturer.user.login}"> <input
													class="pure-button pure-input-1-2 pure-button-primary"
													type="submit" value="Kontakt">
											</form>
										</td>
										<td width="75px" id="respond">
											<form action="deletelecturer" method=post>
												<input type="hidden" name="lecturerId" value="${lecturer.id}"><input
													class="pure-button pure-input-1-2 pure-button-primary"
													type="submit" style="background-color: red" value="Usuń">
											</form>
										</td>
									</tr>
								</c:forEach>
							</table>
						</c:otherwise>
					</c:choose>
			</div>
		</div>
	</div>
</body>
</html>
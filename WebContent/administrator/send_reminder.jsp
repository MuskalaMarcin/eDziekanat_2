<%@ page language="java" contentType="text/html; charset=ISO-8859-2"
	pageEncoding="ISO-8859-2"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-2">
<link rel="stylesheet" href="resources/pure-min.css">
<link rel="stylesheet" href="resources/styles.css">
<title>eDziekanat - Wysyłanie ponagleń</title>
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
						href="classrooms">Dostępność sal</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="admincourses">Kierunki</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="adminstudentgroups">Grupy studenckie</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="adminlecturers">Wykładowcy</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="adminsubjects">Przedmioty</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="adminstudents">Studenci</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="marksstatistics">Statystyki</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="adminscholarships">Stypendia</a></li>
					<li class="pure-menu-item menu-item-divided"><a
						class="pure-menu-link" href="#">Należności</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="adminpayments">Historia należności</a></li>
					<li class="pure-menu-item"><a
						class="pure-menu-link" href="adminwaitingpayments">Oczekujące
							należności</a></li>
					<li class="pure-menu-item  pure-menu-selected"><a
							class="pure-menu-link" href="#">Wyślij ponaglenie</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="admingetstudents">Dodaj należność</a></li>
					<li class="pure-menu-item menu-item-divided"><a
						class="pure-menu-link" href="adminapplications">Wnioski</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="receivedmessages">Historia komunikatów</a></li>
                    <li class="pure-menu-item"><a class="pure-menu-link"
                                                  href="news">Ogłoszenia</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link" href="adminmydata">Moje dane</a></li>
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
				<h2 class="content-subhead">Wysyłanie ponaglenia</h2>
				<center>
					<c:choose>
						<c:when test="${empty payment }">
							BŁĄD.
						</c:when>
						<c:otherwise>
							<h3 class="content-subhead">Adresat ponaglenia:<b> ${payment.student.name} ${payment.student.surname}</b></h3>
							<form action="sendmessage" method="post" class="pure-form">
								<input type="hidden" name="send" value="true">
								<input type="hidden" name="msgreceiver" value="${payment.student.user.login}">
								<fieldset class="pure-group">
								<input type="text" name="msgtitle" class="pure-input-1-2" value="Ponaglenie"/>
								<textarea name="content" rows="6" class="pure-input-1-2" required>Dnia ${payment.issueDate} została wystawiona płatność na kwotę ${payment.amount} złotych tytułem "${payment.title}". Prosimy o jak najszybsze uiszczenie opłaty.</textarea>
									</fieldset>
								<input class="pure-button pure-input-1-2 pure-button-primary"
										type="submit" value="Wyślij">
							</form>
						</c:otherwise>
					</c:choose>
				</center>
			</div>
		</div>
	</div>
</body>
</html>
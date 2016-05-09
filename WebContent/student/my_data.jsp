<%@ page language="java"
	import="edziekanat.databasemodel.dto.ApplicationDTO, java.util.List"
	contentType="text/html; charset=ISO-8859-2" pageEncoding="ISO-8859-2"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-2">
<link rel="stylesheet" href="resources/pure-min.css">
<link rel="stylesheet" href="resources/styles.css">
<title>eDziekanat - Moje dane</title>
</head>
<body>
	<div id="layout">
		<div id="menu">
			<div class="pure-menu">
				<a class="pure-menu-heading" href="home">eDziekanat</a>
				<ul class="pure-menu-list">
					<li class="pure-menu-item"><a href="student"
						class="pure-menu-link">Strona główna</a></li>
					<li class="pure-menu-item"><a href="studenttranscript"
						class="pure-menu-link">Indeks</a></li>
					<li class="pure-menu-item"><a href="timetable"
						class="pure-menu-link">Plan zajęć</a></li>
					<li class="pure-menu-item"><a href="studentsubjects"
						class="pure-menu-link">Moje przedmioty</a></li>
					<li class="pure-menu-item"><a href="studentscholarships"
						class="pure-menu-link">Stypendia</a></li>
					<li class="pure-menu-item"><a href="studentpayments"
						class="pure-menu-link">Płatności</a></li>
					<a href="#"	class="pure-menu-link">Wnioski </a></li>
					<li class="pure-menu-item"><a href="studentlecturers"
						class="pure-menu-link">Wykładowcy</a></li>
					<li class="pure-menu-item"><a href="receivedmessages"
						class="pure-menu-link">Historia komunikatów</a></li>
					<li class="pure-menu-item menu-item-divided">
					<li class="pure-menu-item"><a href="studentmydata"
												  class="pure-menu-item pure-menu-selected">Moje dane</a></li>
					<li class="pure-menu-item"><a href="password"
												  class="pure-menu-link">Zmiana hasła</a></li>
					<li class="pure-menu-item menu-item-divided">
					<li class="pure-menu-item"><a href="logout"
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
				<h2 class="content-subhead">Moje dane:</h2>
				<p>
					<c:choose>
						<c:when test="${editing == \"true\"}">
							<form action="http://localhost:8080/edziekanat/studentmydata" method=post class="pure-form">
							Imię: <input type="text" name="name" value="${studentData.name}" required/><br>
							Nazwisko: <input type="text" name="surname" value="${studentData.surname}" required/><br>
							E-mail: <input type="text" name="email" value="${studentData.user.eMail}" required/><br>
							Adres: <input type="text" name="address" value="${studentData.address}" required/><br>
							<input type="submit" value="Zapisz dane" name="save"/>
							</form>
						</c:when>
					</c:choose>
					<c:choose>
						<c:when test="${editing == \"false\"}">
							<form action="http://localhost:8080/edziekanat/studentmydata" method=post class="pure-form">
								Imię: <b>${studentData.name}</b>  <br>
								Nazwisko: <b>${studentData.surname}</b><br>
								E-mail: <b>${studentData.user.eMail}</b><br>
								Adres: <b> ${studentData.address} </b><br>
								<input type="submit" value="Edytuj dane" name="edit"/>
							</form
						</c:when>
					</c:choose>
				</p>
			</div>
		</div>
	</div>
</body>
</html>
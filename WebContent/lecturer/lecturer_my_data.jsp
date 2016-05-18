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
					<li class="pure-menu-item"><a
							class="pure-menu-link" href="lecturer">Strona główna</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
												  href="lecturerlearningmaterials">Materiały dydaktyczne</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
												  href="lecturerseestudents">Studenci</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
												  href="lecturerseelecturers">Wykładowcy</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
												  href="classrooms">Dostępność sal</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
												  href="timetable">Plan zajęć</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
												  href="lecturersubjects">Moje przedmioty</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
												  href="receivedmessages">Historia komunikatów</a></li>
					<li class="pure-menu-item menu-item-divided">
					<li class="pure-menu-item"><a href="lecturermydata"
												  class="pure-menu-item pure-menu-selected">Moje dane</a></li>
					<li class="pure-menu-item"><a href="password"
												  class="pure-menu-link">Zmiana hasła</a></li>
					<li class="pure-menu-item menu-item-divided">
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
				<h2 class="content-subhead">Moje dane:</h2>
				<p>
					<c:choose>
						<c:when test="${editing == \"true\"}">
							<form action="http://localhost:8080/edziekanat/lecturermydata" method=post class="pure-form">
							Imię: <input type="text" name="name" value="${lecturerData.name}" required/><br>
							Nazwisko: <input type="text" name="surname" value="${lecturerData.surname}" required/><br>
							E-mail: <input type="text" name="email" value="${lecturerData.user.eMail}" required/><br>
							Adres: <input type="text" name="address" value="${lecturerData.address}" required/><br>
                            Strona internetowa: <input type="text" name="website" value="${lecturerData.website}"/><br>
                            Informacje o konsultacjach:
                                <input type="text" name="consultationInfo" value="${lecturerData.consultationInfo}"/><br>
							<input type="submit" value="Zapisz dane" name="save"/>
							</form>
						</c:when>
					</c:choose>
					<c:choose>
						<c:when test="${editing == \"false\"}">
							<form action="http://localhost:8080/edziekanat/lecturermydata" method=post class="pure-form">
								Imię: <b>${lecturerData.name}</b>  <br>
								Nazwisko: <b>${lecturerData.surname}</b><br>
								E-mail: <b>${lecturerData.user.eMail}</b><br>
								Adres: <b> ${lecturerData.address} </b><br>
                                Strona internetowa: <b> ${lecturerData.website} </b><br>
                                Informacje o konsultacjach: <b> ${lecturerData.consultationInfo} </b><br>
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
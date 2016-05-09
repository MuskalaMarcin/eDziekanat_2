<%@ page language="java" contentType="text/html; charset=ISO-8859-2"
	pageEncoding="ISO-8859-2"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-2">
<link rel="stylesheet" href="resources/pure-min.css">
<link rel="stylesheet" href="resources/styles.css">
<title>eDziekanat - Materiały dydaktyczne</title>
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
					<li class="pure-menu-item menu-item-divided"><a
						href="studentsubjects" class="pure-menu-link">Moje przedmioty</a></li>
					<li class="pure-menu-item pure-menu-selected"><a href="#"
						class="pure-menu-link">Materiały dydaktyczne</a></li>
					<c:forEach items="${semesterList}" var="semester">
						<li class="pure-menu-item">
							<form action="studentsubjects" method="post">
								<input type="hidden" name="rqsemester" value="${semester}">
								<button class="linkButton " type="submit">Semestr
									${semester}</button>
							</form>
						</li>
					</c:forEach>
					<li class="pure-menu-item menu-item-divided"><a
						href="studentscholarships" class="pure-menu-link">Stypendia</a></li>
					<li class="pure-menu-item"><a href="studentwaitingpayments"
						class="pure-menu-link">Płatności</a></li>
					<li class="pure-menu-item"><a href="#" class="pure-menu-link">Wnioski</a></li>
					<li class="pure-menu-item"><a href="studentlecturers"
						class="pure-menu-link">Wykładowcy</a></li>
					<li class="pure-menu-item"><a href="receivedmessages"
						class="pure-menu-link">Historia komunikatów</a></li>
					<li class="pure-menu-item"><a href="studentmydata"
												  class="pure-menu-link">Moje dane</a></li>
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
				<h2 class="content-subhead">Materiały dydaktyczne ${subjectName}:</h2>
				<c:choose>
					<c:when test="${empty learningMaterials}">
						<p>Brak dodanych materiałów dydaktycznych.</p>
					</c:when>
					<c:otherwise>
						<center>
							<table class="pure-table pure-table-bordered">
								<thead>
									<tr style="text-align: center;">
										<td>Nr</td>
										<td>Nazwa</td>
										<td>Opis</td>
										<td>Pobierz</td>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${learningMaterials}" var="material"
										varStatus="varStatus">
										<tr style="text-align: center;">
											<td>${varStatus.index + 1}</td>
											<td>${material.name}</td>
											<td>${material.description}</td>
											<td><a class="pure-button pure-button-primary"
												target="_blank" href="${material.file}" download>Pobierz</a></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</center>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</div>
</body>
</html>
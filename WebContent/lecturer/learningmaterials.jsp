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
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="lecturer">Strona główna</a></li>
					<li class="pure-menu-item menu-item-divided"><a
						class="pure-menu-link" href="#">Materiały dydaktyczne</a></li>
					<li class="pure-menu-item pure-menu-selected"><a
						class="pure-menu-link" href="lecturerlearningmaterials ">Moje
							materiały</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="newlearningmaterials">Dodaj materiały</a></li>
					<li class="pure-menu-item menu-item-divided"><a
						class="pure-menu-link" href="lecturerseestudents">Studenci</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="lecturerseelecturers">Wykładowcy</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="lecturerclassrooms">Dostępność sal</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="timetable">Plan zajęć</a></li>
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
				<h2 class="content-subhead">Moje materiały dydaktyczne:</h2>
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
										<td>Przedmiot</td>
										<td>Pobierz</td>
										<td>Usuń</td>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${learningMaterials}" var="material"
										varStatus="varStatus">
										<tr style="text-align: center;">
											<td>${varStatus.index + 1}</td>
											<td>${material.name}</td>
											<td>${material.description}</td>
											<td>${material.subject.name}</td>
											<td><a class="pure-button pure-button-primary" target="_blank" href="${material.file}" download>Pobierz</a></td>
											<td><form action="deletematerial" method=post>
													<input name="materialId" type="text" value="${material.id}" hidden>
													<input class="pure-button pure-button-primary" type="submit" value="Usuń">
												</form></td>
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
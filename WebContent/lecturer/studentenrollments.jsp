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
<title>eDziekanat - Wpisy studenta</title>
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
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="lecturerseestudents">Studenci</a></li>
					<li class="pure-menu-item pure-menu-selected"><a href="#"
						class="pure-menu-link">Wpisy</a></li>
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
					<li class="pure-menu-item"><a class="pure-menu-link" href="lecturermydata">Moje dane</a></li>
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
				<h2 class="content-subhead">Wpisy studenta ${student.name}
					${student.surname}:</h2>
				<center>
					<c:choose>
						<c:when test="${!empty subject}">
							<form action="http://localhost:8080/edziekanat/newenrollment"
								method=post class="pure-form">
								<input type="hidden" name="transcript"
									value="${student.transcript[0].id}"> <select
									name="subject">
									<c:forEach items="${subject}" var="subject"
										varStatus="varStatus">
										<option value="${subject.id}">${subject.name}</option>
									</c:forEach>
								</select> <select name="mark">
									<option value="2">2</option>
									<option value="3">3</option>
									<option value="3.5">3.5</option>
									<option value="4">4</option>
									<option value="4.5">4.5</option>
									<option value="5">5</option>
								</select>
								<button type="submit"
									class="pure-button pure-input-1-2 pure-button-primary"
									style="width: 150px">Dodaj</button>
							</form>
						</c:when>
					</c:choose>
					<p>
						<c:choose>
							<c:when test="${empty enrollments}">
								<center>Brak wpisów do wyświetlenia.</center>
							</c:when>
							<c:otherwise>
								<table class="pure-table pure-table-bordered">
									<thead>
										<tr>
											<td>Nr</td>
											<td>Ocena</td>
											<td>Data wystawienia</td>
											<td>Przedmiot</td>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${enrollments}" var="enrollment"
											varStatus="varStatus">
											<tr>
												<td>${varStatus.index + 1}</td>
												<td>${enrollment.mark}</td>
												<td><fmt:formatDate pattern="dd.MM.yyyy"
														value="${enrollment.issueDate}" /></td>
												<td>${enrollment.subject.name}</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</c:otherwise>
						</c:choose>
				</center>
			</div>
		</div>
	</div>
</body>
</html>
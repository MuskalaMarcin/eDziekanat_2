<%@ page language="java" contentType="text/html; charset=ISO-8859-2"
	pageEncoding="ISO-8859-2"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-2">
<link rel="stylesheet" href="resources/pure-min.css">
<link rel="stylesheet" href="resources/styles.css">
<title>eDziekanat - Moje przedmioty</title>
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
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="lecturerseelecturers">Wykładowcy</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="lecturerclassrooms">Dostępność sal</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="timetable">Plan zajęć</a></li>
					<li class="pure-menu-item pure-menu-selected"><a
						class="pure-menu-link" href="lecturerseelecturers">Moje
							przedmioty</a></li>
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
				<h2 class="content-subhead">Przedmioty</h2>
				<p>
					<c:choose>
						<c:when test="${noSubjects==true}">
					Brak przedmiotów do wyświetlenia.
					</c:when>
						<c:otherwise>
							<table class="responseTable">
								<tr class="grayRow">
									<td>Nr</td>
									<td>Nazwa</td>
									<td>ECTS</td>
									<td>Semestr</td>
									<td>Grupa(y)</td>
								</tr>
								<c:forEach items="${subjects}" var="subject"
									varStatus="varStatus">
									<tr>
										<td>${varStatus.index + 1}</td>
										<td>${subject.name}</td>
										<td>${subject.ECTS}</td>
										<td>${subject.semester}</td>
										<td><c:choose>
												<c:when test="${empty subject.students_group }">Brak</c:when>
												<c:otherwise>
													<c:forEach items="${subject.students_group}"
														var="studentsGroup">${studentsGroup.id} </c:forEach>
												</c:otherwise>
											</c:choose></td>

										<td width="75px" id="respond">
											<form action="lecturerseestudents" method=post>
												<input type="hidden" name="subjectId" value="${subject.id}"><input
													class="pure-button pure-input-1-2 pure-button-primary"
													type="submit" value="Studenci">
											</form>
										</td>
										<td width="80px" id="respond">
											<form action="lecturerlearningmaterials" method=post>
												<input type="hidden" name="subjectId" value="${subject.id}">
												<input
													class="pure-button pure-input-1-2 pure-button-primary"
													type="submit" value="Materiały">
											</form>
										</td>
									</tr>
								</c:forEach>
							</table>
						</c:otherwise>
					</c:choose>
				</p>
			</div>
		</div>
	</div>
</body>
</html>
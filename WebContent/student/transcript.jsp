<%@ page language="java"
	import="edziekanat.databasemodel.dto.SubjectDTO, java.util.List"
	contentType="text/html; charset=ISO-8859-2" pageEncoding="ISO-8859-2"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-2">
<link rel="stylesheet" href="resources/pure-min.css">
<link rel="stylesheet" href="resources/styles.css">
<title>eDziekanat - Indeks</title>
</head>
<body>
	<div id="layout">
		<div id="menu">
			<div class="pure-menu">
				<a class="pure-menu-heading" href="home">eDziekanat</a>
				<ul class="pure-menu-list">
					<li class="pure-menu-item"><a href="student"
						class="pure-menu-link">Strona główna</a></li>
					<li
						class="pure-menu-item  menu-item-divided <c:if test="${noEnrollments==true}">pure-menu-selected</c:if>"><a
						href="#" class="pure-menu-link">Indeks</a></li>
					<c:forEach items="${semesterList}" var="semester">
						<li
							class="pure-menu-item <c:if test="${selectedSemester==semester}">pure-menu-selected</c:if>">
							<form action="studenttranscript" method="post">
								<input type="hidden" name="rqsemester" value="${semester}">
								<button
									class="<c:if test="${selectedSemester==semester}">linkButtonSelected</c:if> linkButton "
									type="submit">Semestr${semester}</button>
							</form>
						</li>
					</c:forEach>
					<li class="pure-menu-item  menu-item-divided"><a
						href="timetable" class="pure-menu-link">Plan zajęć</a></li>
					<li class="pure-menu-item"><a href="studentsubjects"
						class="pure-menu-link">Moje przedmioty</a></li>
					<li class="pure-menu-item"><a href="studentscholarships"
						class="pure-menu-link">Stypendia</a></li>
					<li class="pure-menu-item"><a href="studentwaitingpayments"
						class="pure-menu-link">Płatności</a></li>
					<li class="pure-menu-item"><a href="studentapplications" class="pure-menu-link">Wnioski</a></li>
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
				<h2 class="content-subhead">Wpisy semestr : ${selectedSemester}</h2>
				<p>
					<c:choose>
						<c:when test="${noEnrollments==true}">
					Brak wpisów do wyświetlenia.
					</c:when>
						<c:otherwise>
							<table class="responseTable">
								<tr class="grayRow">
									<td>Nr</td>
									<td>Ocena</td>
									<td>Data wystawienia</td>
									<td>Przedmiot</td>
									<td>Prowadzący</td>
									<td>Kierunek</td>
								</tr>
								<c:forEach items="${enrollments}" var="enrollment"
									varStatus="varStatus">
									<tr>
										<td>${varStatus.index + 1}</td>
										<td>${enrollment.mark}</td>
										<td><fmt:formatDate pattern="dd.MM.yyyy"
											value="${enrollment.issueDate}" /></td>
										<td>${enrollment.subject.name}</td>
										<td>${enrollment.subject.lecturer.name}
											${enrollment.subject.lecturer.surname}</td>
										<td>${enrollment.transcript.studentsGroup.course.name}</td>
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
<%@ page language="java"
	import="edziekanat.databasemodel.dto.SubjectDTO, java.util.List"
	contentType="text/html; charset=ISO-8859-2" pageEncoding="ISO-8859-2"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-2">
<link rel="stylesheet" href="resources/pure-min.css">
<link rel="stylesheet" href="resources/styles.css">
<title>eDziekanat - Przedmioty</title>
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
                    <li class="pure-menu-item"><a href="studentacademicrecordcard"
                        class="pure-menu-link">Karta przebiegu studiów</a></li>
					<li class="pure-menu-item"><a href="timetable"
						class="pure-menu-link">Plan zajęć</a></li>
					<li
						class="pure-menu-item menu-item-divided <c:if test="${noSubjects==true}">pure-menu-selected</c:if>"><a
						href="#" class="pure-menu-link">Moje przedmioty</a></li>
					<c:forEach items="${semesterList}" var="semester">
						<li
							class="pure-menu-item <c:if test="${selectedSemester==semester}">pure-menu-selected</c:if>">
							<form action="studentsubjects" method="post">
								<input type="hidden" name="rqsemester" value="${semester}">
								<button
									class="<c:if test="${selectedSemester==semester}">linkButtonSelected</c:if> linkButton "
									type="submit">Semestr ${semester}</button>
							</form>
						</li>
					</c:forEach>
					<li class="pure-menu-item"><a href="studentscholarships"
						class="pure-menu-link  menu-item-divided">Stypendia</a></li>
					<li class="pure-menu-item"><a href="studentwaitingpayments"
						class="pure-menu-link">Płatności</a></li>
					<li class="pure-menu-item"><a href="#" class="pure-menu-link">Wnioski</a></li>
					<li class="pure-menu-item"><a href="studentlecturers"
						class="pure-menu-link">Wykładowcy</a></li>
					<li class="pure-menu-item"><a href="receivedmessages"
						class="pure-menu-link">Historia komunikatów</a></li>
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
				<h2 class="content-subhead">Przedmioty semestr :
					${selectedSemester}</h2>
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
									<td>Prowadzący</td>
								</tr>
								<c:forEach items="${subjects}" var="subject"
									varStatus="varStatus">
									<tr>
										<td>${varStatus.index + 1}</td>
										<td>${subject.name}</td>
										<td>${subject.ECTS}</td>
										<td>${subject.lecturer.name} ${subject.lecturer.surname}</td>
										<td width="75px" id="respond">
											<form action="studentpartialmarks" method=post>
												<input type="hidden" name="semesterList"
													value="${semesterList}"> <input type="hidden"
													name="subjectId" value="${subject.id}"><input
													class="pure-button pure-input-1-2 pure-button-primary"
													type="submit" value="Oceny">
											</form>
										</td>
										<td width="80px" id="respond">
											<form action="studentlearningmaterials" method=post>
												<input type="hidden" name="semesterList"
													value="${semesterList}"> <input type="hidden"
													name="subjectId" value="${subject.id}"> <input
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
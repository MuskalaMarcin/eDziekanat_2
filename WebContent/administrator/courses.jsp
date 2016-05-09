<%@ page language="java" contentType="text/html; charset=ISO-8859-2"
	pageEncoding="ISO-8859-2"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-2">
<link rel="stylesheet" href="resources/pure-min.css">
<link rel="stylesheet" href="resources/styles.css">
<title>eDziekanat - Administrator - Kierunki</title>
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
					<li class="pure-menu-item pure-menu-selected"><a
						class="pure-menu-link" href="admincourses">Kierunki</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="admingetfaculties">Dodaj kierunek</a></li>
					<li class="pure-menu-item   menu-item-divided">
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
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="adminpayments">Należności</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="adminapplications">Wnioski</a></li>
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
				<h2 class="content-subhead">Kierunki:</h2>
				<center>
						<form class="pure-form" action="adminsearchcourses" method=post>
							Wydział: <input type="text" name="searchedFaculty"
								class="pure-input-rounded" required>
							<button type="submit" class="pure-button pure-button-primary">Szukaj</button>
						</form>
					</center>
				<c:choose>
					<c:when test="${empty courses}">
					<center><p>
					Brak kierunków spełniających podane warunki.
					</p></center>
					</c:when>
					<c:otherwise>
						<center>
							<p>
							<table class="responseTable">
								<tr class="grayRow">
									<td>Nr</td>
									<td>Nazwa</td>
									<td>Wydział</td>
								</tr>
								<c:forEach items="${courses}" var="course" varStatus="varStatus">
									<tr>
										<td>${varStatus.index + 1}</td>
										<td>${course.name}</td>
										<td>${course.faculty.name}</td>
										<td width="75px" id="respond">
											<form action="adminstudentgroups" method=post>
												<input type="hidden" name="courseid" value="${course.id}"><input
													class="pure-button pure-input-1-2 pure-button-primary"
													type="submit" value="Grupy studenckie">
											</form>
										</td>
										<td width="75px" id="respond">
											<form action="deletecourse" method=post>
												<input type="hidden" name="courseid" value="${course.id}"><input
													class="pure-button pure-input-1-2 pure-button-primary"
													type="submit" style="background-color: red" value="Usuń">
											</form>
										</td>
									</tr>
								</c:forEach>
							</table>
						</center>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</div>
</body>
</html>
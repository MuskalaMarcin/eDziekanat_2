<%@ page language="java" contentType="text/html; charset=ISO-8859-2"
	pageEncoding="ISO-8859-2"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-2">
<link rel="stylesheet" href="resources/pure-min.css">
<link rel="stylesheet" href="resources/styles.css">
<title>eDziekanat - Studenci</title>
</head>
<body>
	<div id="layout">
		<div id="menu">
			<div class="pure-menu">
				<a class="pure-menu-heading" href="home">eDziekanat</a>
				<ul class="pure-menu-list">
					<li class="pure-menu-item"><a href="admin"
						class="pure-menu-link">Strona g��wna</a></li>
					<li class="pure-menu-item"><a href="admintimetable"
						class="pure-menu-link">Plan zaj��</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="classrooms">Dost�pno�� sal</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="admincourses">Kierunki</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="adminstudentgroups">Grupy studenckie</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="adminlecturers">Wyk�adowcy</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="adminsubjects">Przedmioty</a></li>
					<li class="pure-menu-item menu-item-divided">
					<li class="pure-menu-item"><a class="pure-menu-link" href="#">Studenci</a></li>
					<li class="pure-menu-item pure-menu-selected"><a
						class="pure-menu-link" href="adminstudents">Przegl�daj</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="admingetstudentsgroup">Dodaj studenta</a></li>
					<li class="pure-menu-item menu-item-divided">
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="marksstatistics">Statystyki</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="adminscholarships">Stypendia</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="adminpayments">Nale�no�ci</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="adminapplications">Wnioski</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="receivedmessages">Historia komunikat�w</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="logout">Wyloguj</a></li>
				</ul>
			</div>
		</div>
		<div id="main">
			<div class="header">
				<h1>eDziekanat</h1>
				<h2>Tw�j wirtualny dziekanat.</h2>
			</div>
			<div class="content">
				<h2 class="content-subhead">
					Studenci:
					<c:if test="${!empty studentsgroup }"> grupa studencka: ${studentsgroup.id } kierunek: ${studentsgroup.course.name }</c:if>
				</h2>
				<center>
					<form class="pure-form" action="adminsearchstudents" method=post>
						<input type="text" name="studentsGroupId"
							value="${studentsGroup.id}" hidden> Imi�: <input
							type="text" name="searchedName" class="pure-input-rounded">
						Nazwisko: <input type="text" name="searchedSurname"
							class="pure-input-rounded" required>
						<button type="submit" class="pure-button pure-button-primary">Szukaj</button>
					</form>
				</center>
				<p>
					<c:choose>
						<c:when test="${empty students }">
							<center>Nie znaleziono student�w pasuj�cych do kryteri�w
								wyszukiwania.</center>
						</c:when>
						<c:otherwise>
							<table class="responseTable">
								<tr class="grayRow">
									<td>Imi�</td>
									<td>Nazwisko</td>
									<td>e-Mail</td>
								</tr>

								<c:forEach items="${students}" var="student">
									<tr>
										<td>${student.name}</td>
										<td>${student.surname}</td>
										<td>${student.user.eMail}</td>
										<td width="70px" id="respond">
											<form action="adminstudentscholarships" method=post>
												<input type="hidden" name="studentId" value="${student.id}">
												<input
													class="pure-button pure-input-1-2 pure-button-primary"
													type="submit" value="Stypendia">
											</form>
										</td>
										<td width="70px" id="respond">
											<form action="adminstudentpayments" method=post>
												<input type="hidden" name="studentId" value="${student.id}">
												<input
													class="pure-button pure-input-1-2 pure-button-primary"
													type="submit" value="Nale�no�ci">
											</form>
										</td>
										<td width="70px" id="respond">
											<form action="adminstudentapplications" method=post>
												<input type="hidden" name="studentId" value="${student.id}">
												<input
													class="pure-button pure-input-1-2 pure-button-primary"
													type="submit" value="Wnioski">
											</form>
										</td>
										<td width="70px" id="respond">
											<form action="admin/newmessage" method=post>
												<input type="hidden" name="receiverLogin"
													value="${student.user.login}"> <input
													class="pure-button pure-input-1-2 pure-button-primary"
													type="submit" value="Kontakt">
											</form>
										</td>
									</tr>
								</c:forEach>
							</table>
						</c:otherwise>
					</c:choose>
			</div>
		</div>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-2"
	pageEncoding="ISO-8859-2"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-2">
<link rel="stylesheet" href="http://localhost:8080/eDziekanat/resources/pure-min.css">
<link rel="stylesheet" href="http://localhost:8080/eDziekanat/resources/styles.css">
<title>eDziekanat - Administrator - Dodaj przedmiot</title>
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
						href="adminclassrooms">Dostępność sal</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="admincourses">Kierunki</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="adminstudentgroups">Grupy studenckie</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="adminlecturers">Wykładowcy</a></li>
					<li class="pure-menu-item   menu-item-divided">
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="adminsubjects">Przedmioty</a></li>
					<li class="pure-menu-item pure-menu-selected"><a
						class="pure-menu-link" href="#">Dodaj przedmiot</a></li>
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
				<h2 class="content-subhead">Dodaj nowy przedmiot:</h2>
				<p>
				<p>
				<center>
					<form action="http://localhost:8080/eDziekanat/adminaddsubject"
						method=post class="pure-form">
						<fieldset class="pure-group">
							Nazwa: <input type="text" name="name" class="pure-input-1-2"
								placeholder="Nazwa" required>
						</fieldset>
						Prowadzący:
						<c:choose>
							<c:when test="${!empty lecturers}">
								<select name="lecturerid">
									<c:forEach items="${lecturers}" var="lecturer"
										varStatus="varStatus">
										<option value="${lecturer.id}">${lecturer.name} ${lecturer.surname}</option>
									</c:forEach>
								</select>
							</c:when>
						</c:choose>
						<p>
						Grupa studencka:
						<c:choose>
							<c:when test="${!empty studentsgroup}">
								<select name="studentsgroupid">
									<c:forEach items="${studentsgroup}" var="studentsgroup"
										varStatus="varStatus">
										<option value="${studentsgroup.id}">${studentsgroup.id}</option>
									</c:forEach>
								</select>
							</c:when>
						</c:choose>
						<p>
						Punkty ECTS: <select name="ECTS">
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
							<option value="6">6</option>
							<option value="7">7</option>
							<option value="8">8</option>
							<option value="9">9</option>
							<option value="10">10</option>
							<option value="11">11</option>
							<option value="12">12</option>
						</select>
						<p>
						Semestr: <select name="semester">
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
							<option value="6">6</option>
							<option value="7">7</option>
							<option value="8">8</option>
							<option value="9">9</option>
							<option value="10">10</option>
						</select>
						<p>
						<button type="submit"
							class="pure-button pure-input-1-2 pure-button-primary">Dodaj</button>
					</form>
				</center>
			</div>
		</div>
	</div>
</body>
</html>
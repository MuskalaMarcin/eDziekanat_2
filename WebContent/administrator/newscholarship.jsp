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
<title>eDziekanat - Przyznaj stypendium</title>
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
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="adminstudents">Studenci</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="marksstatistics">Statystyki</a></li>
					<li class="pure-menu-item   menu-item-divided">
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="adminscholarships">Stypendia</a></li>
					<li class="pure-menu-item pure-menu-selected"><a class="pure-menu-link" href="#">Przyznaj
							stypendium</a></li>
					<li class="pure-menu-item menu-item-divided"><a class="pure-menu-link"
						href="adminpayments">Nale�no�ci</a></li>
					<li class="pure-menu-item"><a
						class="pure-menu-link" href="adminapplications">Wnioski</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="receivedmessages">Historia komunikat�w</a></li>
                    <li class="pure-menu-item"><a class="pure-menu-link"
                                                  href="news">Og�oszenia</a></li>
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
				<h2 class="content-subhead">Przyznaj stypendium:</h2>
				<center>
					<form action="http://localhost:8080/edziekanat/adminaddscholarship"
						method=post class="pure-form">
						<p>
							Dane studenta:
							<c:choose>
								<c:when test="${!empty students}">
									<select name="studentid">
										<c:forEach items="${students}" var="student"
											varStatus="varStatus">
											<option value="${student.id}">${student.name}
												${student.surname}</option>
										</c:forEach>
									</select>
								</c:when>
							</c:choose>
						<p>
							Rodzaj stypendium:
							<c:choose>
								<c:when test="${!empty scholarships}">
									<select name="type">
										<c:forEach items="${scholarships}" var="scholarship"
											varStatus="varStatus">
											<option value="${scholarship.type}">${scholarship.type}</option>
										</c:forEach>
									</select>
								</c:when>
							</c:choose>
						<p>
						<p>
						<jsp:useBean id="now" class="java.util.Date"/>
							Data zako�czenia: <input id="endDate" type="date" name="endDate"  min="<fmt:formatDate pattern="yyyy-MM-dd" value="${now}" />" required>
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
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
<title>eDziekanat - Wyk�adowca - Skrzynka nadawcza</title>
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
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="adminscholarships">Stypendia</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="adminpayments">Nale�no�ci</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="adminapplications">Wnioski</a></li>
					<li class="pure-menu-item menu-item-divided"><a href="#"
						class="pure-menu-link">Historia komunikat�w</a></li>
					<li class="pure-menu-item"><a href="receivedmessages"
						class="pure-menu-link">Skrzynka odbiorcza</a></li>
					<li class="pure-menu-item pure-menu-selected"><a
						href="sentmessages" class="pure-menu-link">Skrzynka nadawcza</a></li>
					<li class="pure-menu-item   menu-item-divided"><a
						href="logout" class="pure-menu-link">Wyloguj</a></li>
				</ul>
			</div>
		</div>
		<div id="main">
			<div class="header">
				<h1>eDziekanat</h1>
				<h2>Tw�j wirtualny dziekanat.</h2>
			</div>
			<div class="content">
				<h2 class="content-subhead">Skrzynka nadawcza:</h2>
				<c:choose>
					<c:when test="${empty sentMessages}">
						<p>Skrzynka nadawcza jest pusta.</p>
					</c:when>
					<c:otherwise>
						<table class="responseTable">
							<c:forEach items="${sentMessages}" var="msg"
								varStatus="varStatus">
								<tr class="grayRow">
									<td colspan="6">Wiadomo�� ${varStatus.index + 1}</td>
								</tr>
								<tr>
									<td>Odbiorca:</td>
									<td>${receiverNames[varStatus.index]}</td>
									<td>Data wys�ania:</td>
									<td><fmt:formatDate pattern="dd.MM.yyyy"
											value="${msg.dispatchDate}" /></td>
									<td>Data dostarczenia:</td>
									<td><c:choose>
											<c:when test="${empty msg.receiveDate}">Nie dostarczono.</c:when>
											<c:otherwise>
												<fmt:formatDate pattern="dd.MM.yyyy"
													value="${msg.receiveDate}" />
											</c:otherwise>
										</c:choose></td>
								</tr>
								<tr>
									<td width="150px">Tytu�:</td>
									<td colspan="5">${msg.title }</td>
								</tr>
								<tr>
									<td>Tre��:</td>
									<td colspan="5" id="content">${msg.content }</td>
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
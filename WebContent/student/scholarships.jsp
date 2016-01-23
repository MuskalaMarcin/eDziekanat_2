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
<title>eDziekanat - Stypendia</title>
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
					<li class="pure-menu-item"><a href="timetable"
						class="pure-menu-link">Plan zajęć</a></li>
					<li class="pure-menu-item"><a href="studentsubjects"
						class="pure-menu-link">Moje przedmioty</a></li>
					<li class="pure-menu-item pure-menu-selected"><a
						href="studentscholarships" class="pure-menu-link">Stypendia</a></li>
					<li class="pure-menu-item"><a href="studentwaitingpayments"
						class="pure-menu-link">Płatności</a></li>
					<li class="pure-menu-item"><a href="studentapplications"
						class="pure-menu-link">Wnioski</a></li>
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
				<h2 class="content-subhead">Aktualne stypendia:</h2>
				<c:choose>
					<c:when test="${empty ownscholarships}">
					Brak aktualnie przyznanych stypendiów.
					</c:when>
					<c:otherwise>
						<table class="responseTable">
							<c:forEach items="${ownscholarships}" var="scholarship"
								varStatus="varStatus">
								<tr class="grayRow">
									<td colspan="2">${varStatus.index + 1}</td>
								</tr>
								<tr>
									<td>Typ:</td>
									<td>${scholarship.scholarshipType.type}</td>
								</tr>
								<tr>
									<td>Kwota:</td>
									<td>${scholarship.scholarshipType.amount}</td>
								</tr>
								<tr>
									<td>Data przyznania:</td>
									<td><fmt:formatDate pattern="dd.MM.yyyy"
											value="${scholarship.grantDate}" /></td>
								</tr>
								<tr>
									<td>Data zakończenia:</td>
									<td><fmt:formatDate pattern="dd.MM.yyyy"
											value="${scholarship.endDate}" /></td>
								</tr>
								<tr>
									<td>Przyznane przez:</td>
									<td>${adminNames[varStatus.index]}</td>
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
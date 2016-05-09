<%@ page language="java"
	import="edziekanat.databasemodel.dto.ApplicationDTO, java.util.List"
	contentType="text/html; charset=ISO-8859-2" pageEncoding="ISO-8859-2"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-2">
<link rel="stylesheet" href="resources/pure-min.css">
<link rel="stylesheet" href="resources/styles.css">
<title>eDziekanat - Wnioski rozpatrzone</title>
</head>
<body>
	<div id="layout">
		<div id="menu">
			<div class="pure-menu">
				<a class="pure-menu-heading" href="home">eDziekanat</a>
				<ul class="pure-menu-list">
					<li class="pure-menu-item"><a href="student"
						class="pure-menu-link">Strona g��wna</a></li>
					<li class="pure-menu-item"><a href="studenttranscript"
						class="pure-menu-link">Indeks</a></li>
					<li class="pure-menu-item"><a href="timetable"
						class="pure-menu-link">Plan zaj��</a></li>
					<li class="pure-menu-item"><a href="studentsubjects"
						class="pure-menu-link">Moje przedmioty</a></li>
					<li class="pure-menu-item"><a href="studentscholarships"
						class="pure-menu-link">Stypendia</a></li>
					<li class="pure-menu-item"><a href="studentpayments"
						class="pure-menu-link">P�atno�ci</a></li>
							<li class="pure-menu-item menu-item-divided">
					<a href="#"
						class="pure-menu-link">Wnioski </a></li>
					<li class="pure-menu-item pure-menu-selected"><a
						href="studentapplications" class="pure-menu-link">Wnioski
							rozpatrzone </a></li>
					<li class="pure-menu-item"><a
						href="studentwaitingapplications" class="pure-menu-link">Wnioski
							nierozpatrzone</a></li>
					<li class="pure-menu-item"><a href="studentgetadministartors"
						class="pure-menu-link">Nowy wniosek</a></li>
					<li class="pure-menu-item   menu-item-divided">
					<li class="pure-menu-item"><a href="studentlecturers"
						class="pure-menu-link">Wyk�adowcy</a></li>
					<li class="pure-menu-item"><a href="receivedmessages"
						class="pure-menu-link">Historia komunikat�w</a></li>
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
				<h2>Tw�j wirtualny dziekanat.</h2>
			</div>
			<div class="content">
				<h2 class="content-subhead">Wnioski rozpatrzone:</h2>
				<c:choose>
					<c:when test="${empty ownapplications}">
						<p>Brak rozpatrzonych wniosk�w.</p>
					</c:when>
					<c:otherwise>
						<table class="responseTable">
							<c:forEach items="${ownapplications}" var="application"
								varStatus="varStatus">
								<tr class="grayRow">
									<c:choose>
										<c:when test="${application.status == 'Odrzucony'}">
											<td id="respond">
												<form action="student/newmessage" method=post>
													<input type="hidden" name="receiverLogin"
														value="${application.administrator.user.login}"> <input
														type="hidden" name="title" value="${application.title }">
													<input
														class="pure-button pure-input-1-2 pure-button-primary"
														type="submit" value="Odpowiedz">
												</form>
											</td>
										</c:when>
										<c:otherwise>
											<td></td>
										</c:otherwise>
									</c:choose>
									
									<td colspan="3">Wniosek ${varStatus.index + 1}</td>
								</tr>
								<tr>
									<td>Status: ${application.status}</td>
									<td>Typ: ${application.application_type.type_name}</td>
									<td>Data z�o�enia:</td>
									<td><fmt:formatDate pattern="dd.MM.yyyy"
											value="${application.dispatchDate}" /></td>
								</tr>
								<tr>
									<td width="150px">Tytu�:</td>
									<td colspan="3">${application.title}</td>
								</tr>
								<tr>
									<td>Tre��:</td>
									<td id="content" colspan="3">${application.content}</td>
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
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
<title>eDziekanat - Student - Wnioski</title>
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
					<li class="pure-menu-item"><a href="studenttimetable"
						class="pure-menu-link">Plan zajęć</a></li>
					<li class="pure-menu-item"><a href="studentsubjects"
						class="pure-menu-link">Moje przedmioty</a></li>
					<li class="pure-menu-item"><a href="studentscholarships"
						class="pure-menu-link">Stypendia</a></li>
					<li class="pure-menu-item"><a href="studentpayments"
						class="pure-menu-link">Płatności</a></li>
					<li class="pure-menu-item menu-item-divided"><a href="#"
						class="pure-menu-link">Wnioski</a></li>
					<li class="pure-menu-item pure-menu-selected"><a
						href="studentapplications" class="pure-menu-link">Wnioski
							rozpatrzone </a></li>
					<li class="pure-menu-item"><a
						href="studentwaitingapplications" class="pure-menu-link">Wnioski
							nierozpatrzone</a></li>
					<li class="pure-menu-item"><a href="studentgetlecturers"
						class="pure-menu-link">Nowy wniosek</a></li>
					<li class="pure-menu-item   menu-item-divided">
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
				<h2 class="content-subhead">Wnioski rozpatrzone:</h2>
				<c:choose>
					<c:when test="${empty ownapplications}">
						<p>Brak rozpatrzonych wniosków.</p>
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
									<td>Status:</td>
									<td>${application.status}</td>
									<td>Data złożenia:</td>
									<td><fmt:formatDate pattern="dd.MM.yyyy"
											value="${application.dispatchDate}" /></td>
								</tr>
								<tr>
									<td width="150px">Tytuł:</td>
									<td colspan="3">${application.title}</td>
								</tr>
								<tr>
									<td>Treść:</td>
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
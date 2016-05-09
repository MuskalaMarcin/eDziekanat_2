<%@ page language="java"
	import="edziekanat.databasemodel.dto.PaymentDTO, java.util.List"
	contentType="text/html; charset=ISO-8859-2" pageEncoding="ISO-8859-2"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-2">
<link rel="stylesheet" href="resources/pure-min.css">
<link rel="stylesheet" href="resources/styles.css">
<title>eDziekanat - Oczekujące płatności</title>
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
                    <li class="pure-menu-item menu-item-divided"><a href="studentacademicrecordcard"
                        class="pure-menu-link">Karta przebiegu studiów</a></li>
					<li class="pure-menu-item"><a href="timetable"
						class="pure-menu-link">Plan zajęć</a></li>
					<li class="pure-menu-item"><a href="studentsubjects"
						class="pure-menu-link">Moje przedmioty</a></li>
					<li class="pure-menu-item"><a href="studentscholarships"
						class="pure-menu-link">Stypendia</a></li>
					<li class="pure-menu-item  menu-item-divided"><a href="#"
						class="pure-menu-link ">Płatności</a></li>
					<li class="pure-menu-item pure-menu-selected"><a
						href="studentwaitingpayments" class="pure-menu-link ">Oczekujące
							płatności</a></li>
					<li class="pure-menu-item"><a href="studentpayments"
						class="pure-menu-link ">Historia płatności</a></li>
					<li class="pure-menu-item menu-item-divided"><a
						href="studentapplications" class="pure-menu-link">Wnioski</a></li>
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
				<h2 class="content-subhead">Oczekujące płatności:</h2>
				<c:choose>
					<c:when test="${empty waitingPayments}">
					Brak oczekujących płatności.
					</c:when>
					<c:otherwise>
						<table class="responseTable">
							<tr class="grayRow">
								<td>Nr</td>
								<td>Tytuł</td>
								<td>Opis</td>
								<td>Kwota</td>
								<td>Data wystawienia</td>
							</tr>
							<c:forEach items="${waitingPayments}" var="payment"
								varStatus="varStatus">
								<tr>
									<td>${varStatus.index + 1}</td>
									<td>${payment.title}</td>
									<td>${payment.description}</td>
									<td>${payment.amount}</td>
									<td><fmt:formatDate pattern="dd.MM.yyyy"
											value="${payment.issueDate}" /></td>
									<td><fmt:formatDate pattern="dd.MM.yyyy"
											value="${payment.paymentDate}" /></td>
									<td id="respond">
										<form action="student/newmessage" method=post>
											<input type="hidden" name="receiverLogin"
												value="${adminLogins[varStatus.index]}">
											<input type="hidden" name="title"
												value="${payment.title}"> <input
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
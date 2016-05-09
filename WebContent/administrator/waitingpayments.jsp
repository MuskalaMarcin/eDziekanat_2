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
<title>eDziekanat - Historia p�atno�ci</title>
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
					<li class="pure-menu-item menu-item-divided"><a
						class="pure-menu-link" href="#">Nale�no�ci</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="adminpayments">Historia nale�no�ci</a></li>
					<li class="pure-menu-item  pure-menu-selected"><a
						class="pure-menu-link" href="adminwaitingpayments">Oczekuj�ce
							nale�no�ci</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="admingetstudents">Dodaj nale�no��</a></li>
					<li class="pure-menu-item menu-item-divided"><a
						class="pure-menu-link" href="adminapplications">Wnioski</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="receivedmessages">Historia komunikat�w</a></li>
                    <li class="pure-menu-item"><a class="pure-menu-link"
                                                  href="news">Og�oszenia</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link" href="adminmydata">Moje dane</a></li>
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
				<h2 class="content-subhead">Oczekuj�ce nale�no�ci:</h2>
				<center>
					<c:choose>
						<c:when test="${empty waitingPayments }">
						Brak wcze�niejszych p�atno�ci.
						</c:when>
						<c:otherwise>
							<table class="pure-table pure-table-bordered">
								<thead>
									<tr>
										<td>Nr</td>
										<td>Tytu�</td>
										<td>Opis</td>
										<td>Kwota</td>
										<td>Data nadania</td>
										<td>Imi� i nazwisko</td>
										<td>Potwierd� p�atno��</td>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${waitingPayments}" var="payment"
										varStatus="varStatus">
										<tr>
											<td>${varStatus.index + 1 }</td>
											<td>${payment.title }</td>
											<td>${payment.description}</td>
											<td>${payment.amount }</td>
											<td><fmt:formatDate pattern="dd.MM.yyyy"
													value="${payment.issueDate }" /></td>
											<td>${payment.student.name } ${payment.student.surname }</td>
											<td><form action="applypayment" method=post>
													<input type="hidden" name="paymentId" value="${payment.id}">
													<input type="hidden" name="studentId"
														value="${payment.student.id }"> <input
														class="pure-button pure-input-1-2 pure-button-primary"
														type="submit" value="Potwierd� p�atno��">
												</form></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</c:otherwise>
					</c:choose>
				</center>
			</div>
		</div>
	</div>
</body>
</html>
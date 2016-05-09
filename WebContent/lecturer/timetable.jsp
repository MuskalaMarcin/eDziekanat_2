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
<title>eDziekanat - Plan zajęć</title>
</head>
<body>
	<div id="layout">
		<div id="menu">
			<div class="pure-menu">
				<a class="pure-menu-heading" href="home">eDziekanat</a>
				<ul class="pure-menu-list">
					<li class="pure-menu-item"><a
						class="pure-menu-link" href="lecturer">Strona główna</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="lecturerlearningmaterials">Materiały dydaktyczne</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="lecturerseestudents">Studenci</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="lecturerseelecturers">Wykładowcy</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="classrooms">Dostępność sal</a></li>
					<li class="pure-menu-item menu-item-divided"><a
						href="timetable" class="pure-menu-link">Plan zajęć</a></li>
					<li class="pure-menu-item">
						<form action="timetable" method="post">
							<input type="hidden" name="rqweek" value="${selectedWeek - 1}">
							<button class="linkButton " type="submit">Poprzedni
								tydzień</button>
						</form>
					</li>
					<li class="pure-menu-item pure-menu-selected"><a href="#"
						class="pure-menu-link"> <c:choose>
								<c:when test="${currentWeek == true}">Aktualny tydzień</c:when>
								<c:otherwise>Tydzień ${selectedWeek}</c:otherwise>
							</c:choose>
					</a></li>
					<li class="pure-menu-item">
						<form action="timetable" method="post">
							<input type="hidden" name="rqweek" value="${selectedWeek + 1}">
							<button class="linkButton" type="submit">Następny
								tydzień</button>
						</form>
					</li>
					<li class="pure-menu-item menu-item-divided"><a
						class="pure-menu-link" href="lecturersubjects">Moje przedmioty</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="receivedmessages">Historia komunikatów</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link" href="lecturermydata">Moje dane</a></li>
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
				<h2 class="content-subhead">Plan zajęć:</h2>

				<c:choose>
					<c:when test="${emptyWeek==true}">
						<center>Plan zajęć na ${selectedWeek} tydzień roku jest
							pusty.</center>
					</c:when>
					<c:otherwise>
						<table class="pure-table timetableTable pure-table-bordered">
							<thead>
								<tr>
									<td>Godziny<br></td>
									<td>Poniedziałek<br> <fmt:formatDate
											pattern="dd.MM.yyyy" value="${dayDates[0]}" /></td>
									<td>Wtorek<br> <fmt:formatDate pattern="dd.MM.yyyy"
											value="${dayDates[1]}" /></td>
									<td>Środa<br> <fmt:formatDate pattern="dd.MM.yyyy"
											value="${dayDates[2]}" /></td>
									<td>Czwartek<br> <fmt:formatDate pattern="dd.MM.yyyy"
											value="${dayDates[3]}" /></td>
									<td>Piątek<br> <fmt:formatDate pattern="dd.MM.yyyy"
											value="${dayDates[4]}" /></td>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>7<sup>30</sup> - 9<sup>00</sup></td>
									<td>${rsClasses[0][0].subject.name}<br> <c:if
											test="${rsClasses[0][0] != null}">sala: ${rsClasses[0][0].classroom.number}</c:if></td>
									<td>${rsClasses[1][0].subject.name}<br> <c:if
											test="${rsClasses[1][0] != null}">sala: ${rsClasses[1][0].classroom.number}</c:if></td>
									<td>${rsClasses[2][0].subject.name}<br> <c:if
											test="${rsClasses[2][0] != null}">sala: ${rsClasses[2][0].classroom.number}</c:if></td>
									<td>${rsClasses[3][0].subject.name}<br> <c:if
											test="${rsClasses[3][0] != null}">sala: ${rsClasses[3][0].classroom.number}</c:if></td>
									<td>${rsClasses[4][0].subject.name}<br> <c:if
											test="${rsClasses[4][0] != null}">sala: ${rsClasses[4][0].classroom.number}</c:if></td>
								</tr>
								<tr class="pure-table-odd">
									<td>9<sup>15</sup> - 10<sup>45</sup></td>
									<td>${rsClasses[0][1].subject.name}<br> <c:if
											test="${rsClasses[0][1] != null}">sala: ${rsClasses[0][1].classroom.number}</c:if></td>
									<td>${rsClasses[1][1].subject.name}<br> <c:if
											test="${rsClasses[1][1] != null}">sala: ${rsClasses[1][1].classroom.number}</c:if></td>
									<td>${rsClasses[2][1].subject.name}<br> <c:if
											test="${rsClasses[2][1] != null}">sala: ${rsClasses[2][1].classroom.number}</c:if></td>
									<td>${rsClasses[3][1].subject.name}<br> <c:if
											test="${rsClasses[3][1] != null}">sala: ${rsClasses[3][1].classroom.number}</c:if></td>
									<td>${rsClasses[4][1].subject.name}<br> <c:if
											test="${rsClasses[4][1] != null}">sala: ${rsClasses[4][1].classroom.number}</c:if></td>
								</tr>
								<tr>
									<td>11<sup>00</sup> - 12<sup>30</sup></td>
									<td>${rsClasses[0][2].subject.name}<br> <c:if
											test="${rsClasses[0][2] != null}">sala: ${rsClasses[0][2].classroom.number}</c:if></td>
									<td>${rsClasses[1][2].subject.name}<br> <c:if
											test="${rsClasses[1][2] != null}">sala: ${rsClasses[1][2].classroom.number}</c:if></td>
									<td>${rsClasses[2][2].subject.name}<br> <c:if
											test="${rsClasses[2][2] != null}">sala: ${rsClasses[2][2].classroom.number}</c:if></td>
									<td>${rsClasses[3][2].subject.name}<br> <c:if
											test="${rsClasses[3][2] != null}">sala: ${rsClasses[3][2].classroom.number}</c:if></td>
									<td>${rsClasses[4][2].subject.name}<br> <c:if
											test="${rsClasses[4][2] != null}">sala: ${rsClasses[4][2].classroom.number}</c:if></td>
								</tr>
								<tr class="pure-table-odd">
									<td>12<sup>45</sup> - 14<sup>15</sup></td>
									<td>${rsClasses[0][3].subject.name}<br> <c:if
											test="${rsClasses[0][3] != null}">sala: ${rsClasses[0][3].classroom.number}</c:if></td>
									<td>${rsClasses[1][3].subject.name}<br> <c:if
											test="${rsClasses[1][3] != null}">sala: ${rsClasses[1][3].classroom.number}</c:if></td>
									<td>${rsClasses[2][3].subject.name}<br> <c:if
											test="${rsClasses[2][3] != null}">sala: ${rsClasses[2][3].classroom.number}</c:if></td>
									<td>${rsClasses[3][3].subject.name}<br> <c:if
											test="${rsClasses[3][3] != null}">sala: ${rsClasses[3][3].classroom.number}</c:if></td>
									<td>${rsClasses[4][3].subject.name}<br> <c:if
											test="${rsClasses[4][3] != null}">sala: ${rsClasses[4][3].classroom.number}</c:if></td>
								</tr>
								<tr>
									<td>14<sup>30</sup> - 16<sup>00</sup></td>
									<td>${rsClasses[0][4].subject.name}<br> <c:if
											test="${rsClasses[0][4] != null}">sala: ${rsClasses[0][4].classroom.number}</c:if></td>
									<td>${rsClasses[1][4].subject.name}<br> <c:if
											test="${rsClasses[1][4] != null}">sala: ${rsClasses[1][4].classroom.number}</c:if></td>
									<td>${rsClasses[2][4].subject.name}<br> <c:if
											test="${rsClasses[2][4] != null}">sala: ${rsClasses[2][4].classroom.number}</c:if></td>
									<td>${rsClasses[3][4].subject.name}<br> <c:if
											test="${rsClasses[3][4] != null}">sala: ${rsClasses[3][4].classroom.number}</c:if></td>
									<td>${rsClasses[4][4].subject.name}<br> <c:if
											test="${rsClasses[4][4] != null}">sala: ${rsClasses[4][4].classroom.number}</c:if></td>
								</tr>
								<tr class="pure-table-odd">
									<td>16<sup>15</sup> - 17<sup>45</sup></td>
									<td>${rsClasses[0][5].subject.name}<br> <c:if
											test="${rsClasses[0][5] != null}">sala: ${rsClasses[0][5].classroom.number}</c:if></td>
									<td>${rsClasses[1][5].subject.name}<br> <c:if
											test="${rsClasses[1][5] != null}">sala: ${rsClasses[1][5].classroom.number}</c:if></td>
									<td>${rsClasses[2][5].subject.name}<br> <c:if
											test="${rsClasses[2][5] != null}">sala: ${rsClasses[2][5].classroom.number}</c:if></td>
									<td>${rsClasses[3][5].subject.name}<br> <c:if
											test="${rsClasses[3][5] != null}">sala: ${rsClasses[3][5].classroom.number}</c:if></td>
									<td>${rsClasses[4][5].subject.name}<br> <c:if
											test="${rsClasses[4][5] != null}">sala: ${rsClasses[4][5].classroom.number}</c:if></td>
								</tr>
								<tr>
									<td>18<sup>00</sup> - 19<sup>30</sup></td>
									<td>${rsClasses[0][6].subject.name}<br> <c:if
											test="${rsClasses[0][6] != null}">sala: ${rsClasses[0][6].classroom.number}</c:if></td>
									<td>${rsClasses[1][6].subject.name}<br> <c:if
											test="${rsClasses[1][6] != null}">sala: ${rsClasses[1][6].classroom.number}</c:if></td>
									<td>${rsClasses[2][6].subject.name}<br> <c:if
											test="${rsClasses[2][6] != null}">sala: ${rsClasses[2][6].classroom.number}</c:if></td>
									<td>${rsClasses[3][6].subject.name}<br> <c:if
											test="${rsClasses[3][6] != null}">sala: ${rsClasses[3][6].classroom.number}</c:if></td>
									<td>${rsClasses[4][6].subject.name}<br> <c:if
											test="${rsClasses[4][6] != null}">sala: ${rsClasses[4][6].classroom.number}</c:if></td>
								</tr>
								<tr class="pure-table-odd">
									<td>19<sup>45</sup> - 21<sup>15</sup></td>
									<td>${rsClasses[0][7].subject.name}<br> <c:if
											test="${rsClasses[0][7] != null}">sala: ${rsClasses[0][7].classroom.number}</c:if></td>
									<td>${rsClasses[1][7].subject.name}<br> <c:if
											test="${rsClasses[1][7] != null}">sala: ${rsClasses[1][7].classroom.number}</c:if></td>
									<td>${rsClasses[2][7].subject.name}<br> <c:if
											test="${rsClasses[2][7] != null}">sala: ${rsClasses[2][7].classroom.number}</c:if></td>
									<td>${rsClasses[3][7].subject.name}<br> <c:if
											test="${rsClasses[3][7] != null}">sala: ${rsClasses[3][7].classroom.number}</c:if></td>
									<td>${rsClasses[4][7].subject.name}<br> <c:if
											test="${rsClasses[4][7] != null}">sala: ${rsClasses[4][7].classroom.number}</c:if></td>
								</tr>
							</tbody>
						</table>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</div>
</body>
</html>
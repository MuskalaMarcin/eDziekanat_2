<%@ page language="java" contentType="text/html; charset=ISO-8859-2"
		 pageEncoding="ISO-8859-2"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-2">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="resources/pure-min.css">
	<link rel="stylesheet" href="resources/styles.css">
	<link rel="stylesheet" href="resources/bootstrap/bootstrap.min.css">
	<script src="resources/jquery/jquery-2.2.3.js"></script>
	<script src="resources/bootstrap/bootstrap.min.js"></script>
	<title>eDziekanat - Dost�pno�� sali</title>
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
				<li class="pure-menu-item menu-item-divided"><a
						class="pure-menu-link" href="classrooms">Dost�pno��
					sal</a></li>
				<c:choose>
					<c:when test="${noClassroom == true}">
						<li class="pure-menu-item pure-menu-selected"><a
								class="pure-menu-link" href="#">Wybierz sal�</a></li>
					</c:when>
					<c:otherwise>
						<li class="pure-menu-item">
							<form action="classrooms" method="post">
								<input type="hidden" name="rqweek" value="${selectedWeek - 1}">
								<input type="hidden" name="classroomId"
									   value="${selectedClassroom.number}">
								<button class="linkButton " type="submit">Poprzedni
									tydzie�</button>
							</form>
						</li>
						<li class="pure-menu-item pure-menu-selected"><a href="#"
																		 class="pure-menu-link"> <c:choose>
							<c:when test="${currentWeek == true}">Aktualny tydzie�</c:when>
							<c:otherwise>Tydzie� ${selectedWeek}</c:otherwise>
						</c:choose>
						</a></li>
						<li class="pure-menu-item">
							<form action="classrooms" method="post">
								<input type="hidden" name="classroomId"
									   value="${selectedClassroom.number}"> <input
									type="hidden" name="rqweek" value="${selectedWeek + 1}">
								<button class="linkButton" type="submit">Nast�pny
									tydzie�</button>
							</form>
						</li>
					</c:otherwise>
				</c:choose>
				<li class="pure-menu-item menu-item-divided"><a
						class="pure-menu-link" href="admincourses">Kierunki</a></li>
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
			<h2 class="content-subhead">
				Dost�pno�� sali: ${selectedClassroom.faculty.name}
				<c:if test="${!empty selectedClassroom }"> sala: </c:if>
				${selectedClassroom.number}
			</h2>

			<form class="pure-form" action="classrooms" method=post>
				<fieldset>
					<center>
						<select name="classroomId" id="state">
							<c:forEach items="${classroomsList}" var="classroom">
								<option
										<c:if test="${selectedClassroom.id == classroom.id}">selected</c:if>
										value="${classroom.id}">${classroom.faculty.name}
									Sala ${classroom.number}</option>
							</c:forEach>
						</select>
						<button type="submit" class="pure-button pure-button-primary">Wy�wietl</button>
					</center>
				</fieldset>
			</form>
			<br> <br>
			<c:choose>
				<c:when test="${emptyWeek == true}">
					<center>Plan zaj�� na ${selectedWeek} tydzie� roku dla
						sali ${selectedClassroom.number} jest pusty.</center>
				</c:when>
				<c:when test="${noClassroom == true}">
					<center>Wybierz sal� z powy�szej listy.</center>
				</c:when>
				<c:otherwise>
					<table class="pure-table timetableTable pure-table-bordered">
						<thead>
						<tr>
							<td>Godziny<br></td>
							<td>Poniedzia�ek<br> <fmt:formatDate
									pattern="dd.MM.yyyy" value="${dayDates[0]}" /></td>
							<td>Wtorek<br> <fmt:formatDate pattern="dd.MM.yyyy"
														   value="${dayDates[1]}" /></td>
							<td>�roda<br> <fmt:formatDate pattern="dd.MM.yyyy"
														  value="${dayDates[2]}" /></td>
							<td>Czwartek<br> <fmt:formatDate pattern="dd.MM.yyyy"
															 value="${dayDates[3]}" /></td>
							<td>Pi�tek<br> <fmt:formatDate pattern="dd.MM.yyyy"
														   value="${dayDates[4]}" /></td>
						</tr>
						</thead>
						<tbody>
						<tr>
							<td>7<sup>30</sup> - 9<sup>00</sup></td>
							<td> <c:if
									test="${rsClasses[0][0] != null}">
								<a data-toggle="popover" title="grupa: <c:forEach items="${rsClasses[0][0].subject.students_group}" var="item">${item.id} </c:forEach>"
								   data-content="kierunek: <c:forEach items="${rsClasses[0][0].subject.students_group}" var="item">
                                        ${item.course.name}</c:forEach>">${rsClasses[0][0].subject.name}<br></a></c:if></td>
							<td> <c:if
									test="${rsClasses[1][0] != null}">
								<a data-toggle="popover" title="grupa: <c:forEach items="${rsClasses[1][0].subject.students_group}" var="item">${item.id} </c:forEach>"
								   data-content="kierunek: <c:forEach items="${rsClasses[1][0].subject.students_group}" var="item">
                                        ${item.course.name}</c:forEach>">${rsClasses[1][0].subject.name}<br></a></c:if></td>
							<td> <c:if
									test="${rsClasses[2][0] != null}">
								<a data-toggle="popover" title="grupa: <c:forEach items="${rsClasses[2][0].subject.students_group}" var="item">${item.id} </c:forEach>"
								   data-content="kierunek: <c:forEach items="${rsClasses[2][0].subject.students_group}" var="item">
                                        ${item.course.name}</c:forEach>">${rsClasses[2][0].subject.name}<br></a></c:if></td>
							<td><c:if
									test="${rsClasses[3][0] != null}">
								<a data-toggle="popover" title="grupa: <c:forEach items="${rsClasses[3][0].subject.students_group}" var="item">${item.id} </c:forEach>"
								   data-content="kierunek: <c:forEach items="${rsClasses[3][0].subject.students_group}" var="item">
                                        ${item.course.name}</c:forEach>">${rsClasses[1][0].subject.name}<br></a></c:if></td>
							<td><c:if
									test="${rsClasses[4][0] != null}">
								<a data-toggle="popover" title="grupa: <c:forEach items="${rsClasses[4][0].subject.students_group}" var="item">${item.id} </c:forEach>"
								   data-content="kierunek: <c:forEach items="${rsClasses[4][0].subject.students_group}" var="item">
                                        ${item.course.name}</c:forEach>">${rsClasses[4][0].subject.name}<br></a></c:if></td>
						</tr>
						<tr>
							<td>9<sup>15</sup> - 10<sup>45</sup></td>
							<td><c:if
									test="${rsClasses[0][1] != null}">
								<a data-toggle="popover" title="grupa: <c:forEach items="${rsClasses[0][1].subject.students_group}" var="item">${item.id} </c:forEach>"
								   data-content="kierunek: <c:forEach items="${rsClasses[0][1].subject.students_group}" var="item">
                                        ${item.course.name}</c:forEach>">${rsClasses[0][1].subject.name}<br></a></c:if></td>
							<td><c:if
									test="${rsClasses[1][1] != null}">
								<a data-toggle="popover" title="grupa: <c:forEach items="${rsClasses[1][1].subject.students_group}" var="item">${item.id} </c:forEach>"
								   data-content="kierunek: <c:forEach items="${rsClasses[1][1].subject.students_group}" var="item">
                                        ${item.course.name}</c:forEach>">${rsClasses[1][1].subject.name}<br></a></c:if></td>
							<td><c:if
									test="${rsClasses[2][1] != null}">
								<a data-toggle="popover" title="grupa: <c:forEach items="${rsClasses[2][1].subject.students_group}" var="item">${item.id} </c:forEach>"
								   data-content="kierunek: <c:forEach items="${rsClasses[2][1].subject.students_group}" var="item">
                                        ${item.course.name}</c:forEach>">${rsClasses[2][1].subject.name}<br></a></c:if></td>
							<td><c:if
									test="${rsClasses[3][1] != null}">
								<a data-toggle="popover" title="grupa: <c:forEach items="${rsClasses[3][1].subject.students_group}" var="item">${item.id} </c:forEach>"
								   data-content="kierunek: <c:forEach items="${rsClasses[3][1].subject.students_group}" var="item">
                                        ${item.course.name}</c:forEach>">${rsClasses[1][1].subject.name}<br></a></c:if></td>
							<td><c:if
									test="${rsClasses[4][1] != null}">
								<a data-toggle="popover" title="grupa: <c:forEach items="${rsClasses[4][1].subject.students_group}" var="item">${item.id} </c:forEach>"
								   data-content="kierunek: <c:forEach items="${rsClasses[4][1].subject.students_group}" var="item">
                                        ${item.course.name}</c:forEach>">${rsClasses[4][1].subject.name}<br></a></c:if></td>
						</tr>
						<tr>
							<td>11<sup>00</sup> - 12<sup>30</sup></td>
							<td><c:if
									test="${rsClasses[0][2] != null}">
								<a data-toggle="popover" title="grupa: <c:forEach items="${rsClasses[0][2].subject.students_group}" var="item">${item.id} </c:forEach>"
								   data-content="kierunek: <c:forEach items="${rsClasses[0][2].subject.students_group}" var="item">
                                        ${item.course.name}</c:forEach>">${rsClasses[0][2].subject.name}<br></a></c:if></td>
							<td> <c:if
									test="${rsClasses[1][2] != null}">
								<a data-toggle="popover" title="grupa: <c:forEach items="${rsClasses[1][2].subject.students_group}" var="item">${item.id} </c:forEach>"
								   data-content="kierunek: <c:forEach items="${rsClasses[1][2].subject.students_group}" var="item">
                                        ${item.course.name}</c:forEach>">${rsClasses[1][2].subject.name}<br></a></c:if></td>
							<td><c:if
									test="${rsClasses[2][2] != null}">
								<a data-toggle="popover" title="grupa: <c:forEach items="${rsClasses[2][2].subject.students_group}" var="item">${item.id} </c:forEach>"
								   data-content="kierunek: <c:forEach items="${rsClasses[2][2].subject.students_group}" var="item">
                                        ${item.course.name}</c:forEach>">${rsClasses[2][2].subject.name}<br></a></c:if></td>
							<td><c:if
									test="${rsClasses[3][2] != null}">
								<a data-toggle="popover" title="grupa: <c:forEach items="${rsClasses[3][2].subject.students_group}" var="item">${item.id} </c:forEach>"
								   data-content="kierunek: <c:forEach items="${rsClasses[3][2].subject.students_group}" var="item">
                                        ${item.course.name}</c:forEach>">${rsClasses[1][2].subject.name}<br></a></c:if></td>
							<td><c:if
									test="${rsClasses[4][2] != null}">
								<a data-toggle="popover" title="grupa: <c:forEach items="${rsClasses[4][2].subject.students_group}" var="item">${item.id} </c:forEach>"
								   data-content="kierunek: <c:forEach items="${rsClasses[4][2].subject.students_group}" var="item">
                                        ${item.course.name}</c:forEach>">${rsClasses[4][2].subject.name}<br></a></c:if></td>
						</tr>
						<tr>
							<td>12<sup>45</sup> - 14<sup>15</sup></td>
							<td><c:if
									test="${rsClasses[0][3] != null}">
								<a data-toggle="popover" title="grupa: <c:forEach items="${rsClasses[0][3].subject.students_group}" var="item">${item.id} </c:forEach>"
								   data-content="kierunek: <c:forEach items="${rsClasses[0][3].subject.students_group}" var="item">
                                        ${item.course.name}</c:forEach>">${rsClasses[0][3].subject.name}<br></a></c:if></td>
							<td> <c:if
									test="${rsClasses[1][3] != null}">
								<a data-toggle="popover" title="grupa: <c:forEach items="${rsClasses[1][3].subject.students_group}" var="item">${item.id} </c:forEach>"
								   data-content="kierunek: <c:forEach items="${rsClasses[1][3].subject.students_group}" var="item">
                                        ${item.course.name}</c:forEach>">${rsClasses[1][3].subject.name}<br></a></c:if></td>
							<td><br> <c:if
									test="${rsClasses[2][3] != null}">
								<a data-toggle="popover" title="grupa: <c:forEach items="${rsClasses[2][3].subject.students_group}" var="item">${item.id} </c:forEach>"
								   data-content="kierunek: <c:forEach items="${rsClasses[2][3].subject.students_group}" var="item">
                                        ${item.course.name}</c:forEach>">${rsClasses[2][3].subject.name}<br></a></c:if></td>
							<td><c:if
									test="${rsClasses[3][3] != null}">
								<a data-toggle="popover" title="grupa: <c:forEach items="${rsClasses[3][3].subject.students_group}" var="item">${item.id} </c:forEach>"
								   data-content="kierunek: <c:forEach items="${rsClasses[3][3].subject.students_group}" var="item">
                                        ${item.course.name}</c:forEach>">${rsClasses[1][3].subject.name}<br></a></c:if></td>
							<td><c:if
									test="${rsClasses[4][3] != null}">
								<a data-toggle="popover" title="grupa: <c:forEach items="${rsClasses[4][3].subject.students_group}" var="item">${item.id} </c:forEach>"
								   data-content="kierunek: <c:forEach items="${rsClasses[4][3].subject.students_group}" var="item">
                                        ${item.course.name}</c:forEach>">${rsClasses[4][3].subject.name}<br></a></c:if></td>
						</tr>
						<tr>
							<td>14<sup>30</sup> - 16<sup>00</sup></td>
							<td> <c:if
									test="${rsClasses[0][4] != null}">
								<a data-toggle="popover" title="grupa: <c:forEach items="${rsClasses[0][4].subject.students_group}" var="item">${item.id} </c:forEach>"
								   data-content="kierunek: <c:forEach items="${rsClasses[0][4].subject.students_group}" var="item">
                                        ${item.course.name}</c:forEach>">${rsClasses[0][4].subject.name}<br></a></c:if></td>
							<td> <c:if
									test="${rsClasses[1][4] != null}">
								<a data-toggle="popover" title="grupa: <c:forEach items="${rsClasses[1][4].subject.students_group}" var="item">${item.id} </c:forEach>"
								   data-content="kierunek: <c:forEach items="${rsClasses[1][4].subject.students_group}" var="item">
                                        ${item.course.name}</c:forEach>">${rsClasses[1][4].subject.name}<br></a></c:if></td>
							<td><c:if
									test="${rsClasses[2][4] != null}">
								<a data-toggle="popover" title="grupa: <c:forEach items="${rsClasses[2][4].subject.students_group}" var="item">${item.id} </c:forEach>"
								   data-content="kierunek: <c:forEach items="${rsClasses[2][4].subject.students_group}" var="item">
                                        ${item.course.name}</c:forEach>">${rsClasses[2][4].subject.name}<br></a></c:if></td>
							<td><c:if
									test="${rsClasses[3][4] != null}">
								<a data-toggle="popover" title="grupa: <c:forEach items="${rsClasses[3][4].subject.students_group}" var="item">${item.id} </c:forEach>"
								   data-content="kierunek: <c:forEach items="${rsClasses[3][4].subject.students_group}" var="item">
                                        ${item.course.name}</c:forEach>">${rsClasses[1][4].subject.name}<br></a></c:if></td>
							<td><c:if
									test="${rsClasses[4][4] != null}">
								<a data-toggle="popover" title="grupa: <c:forEach items="${rsClasses[4][4].subject.students_group}" var="item">${item.id} </c:forEach>"
								   data-content="kierunek: <c:forEach items="${rsClasses[4][4].subject.students_group}" var="item">
                                        ${item.course.name}</c:forEach>">${rsClasses[4][4].subject.name}<br></a></c:if></td>
						</tr>
						<tr>
							<td>16<sup>15</sup> - 17<sup>45</sup></td>
							<td><c:if
									test="${rsClasses[0][5] != null}">
								<a data-toggle="popover" title="grupa: <c:forEach items="${rsClasses[0][5].subject.students_group}" var="item">${item.id} </c:forEach>"
								   data-content="kierunek: <c:forEach items="${rsClasses[0][5].subject.students_group}" var="item">
                                        ${item.course.name}</c:forEach>">${rsClasses[0][5].subject.name}<br></a></c:if></td>
							<td> <c:if
									test="${rsClasses[1][5] != null}">
								<a data-toggle="popover" title="grupa: <c:forEach items="${rsClasses[1][5].subject.students_group}" var="item">${item.id} </c:forEach>"
								   data-content="kierunek: <c:forEach items="${rsClasses[1][5].subject.students_group}" var="item">
                                        ${item.course.name}</c:forEach>">${rsClasses[1][5].subject.name}<br></a></c:if></td>
							<td><c:if
									test="${rsClasses[2][5] != null}">
								<a data-toggle="popover" title="grupa: <c:forEach items="${rsClasses[2][5].subject.students_group}" var="item">${item.id} </c:forEach>"
								   data-content="kierunek: <c:forEach items="${rsClasses[2][5].subject.students_group}" var="item">
                                        ${item.course.name}</c:forEach>">${rsClasses[2][5].subject.name}<br></a></c:if></td>
							<td><c:if
									test="${rsClasses[3][5] != null}">
								<a data-toggle="popover" title="grupa: <c:forEach items="${rsClasses[3][5].subject.students_group}" var="item">${item.id} </c:forEach>"
								   data-content="kierunek: <c:forEach items="${rsClasses[3][5].subject.students_group}" var="item">
                                        ${item.course.name}</c:forEach>">${rsClasses[1][5].subject.name}<br></a></c:if></td>
							<td><c:if
									test="${rsClasses[4][5] != null}">
								<a data-toggle="popover" title="grupa: <c:forEach items="${rsClasses[4][5].subject.students_group}" var="item">${item.id} </c:forEach>"
								   data-content="kierunek: <c:forEach items="${rsClasses[4][5].subject.students_group}" var="item">
                                        ${item.course.name}</c:forEach>">${rsClasses[4][5].subject.name}<br></a></c:if></td>
						</tr>
						<tr>
							<td>18<sup>00</sup> - 19<sup>30</sup></td>
							<td><c:if
									test="${rsClasses[0][6] != null}">
								<a data-toggle="popover" title="grupa: <c:forEach items="${rsClasses[0][6].subject.students_group}" var="item">${item.id} </c:forEach>"
								   data-content="kierunek: <c:forEach items="${rsClasses[0][6].subject.students_group}" var="item">
                                        ${item.course.name}</c:forEach>">${rsClasses[0][6].subject.name}<br></a></c:if></td>
							<td> <c:if
									test="${rsClasses[1][6] != null}">
								<a data-toggle="popover" title="grupa: <c:forEach items="${rsClasses[1][6].subject.students_group}" var="item">${item.id} </c:forEach>"
								   data-content="kierunek: <c:forEach items="${rsClasses[1][6].subject.students_group}" var="item">
                                        ${item.course.name}</c:forEach>">${rsClasses[1][6].subject.name}<br></a></c:if></td>
							<td><c:if
									test="${rsClasses[2][6] != null}">
								<a data-toggle="popover" title="grupa: <c:forEach items="${rsClasses[2][6].subject.students_group}" var="item">${item.id} </c:forEach>"
								   data-content="kierunek: <c:forEach items="${rsClasses[2][6].subject.students_group}" var="item">
                                        ${item.course.name}</c:forEach>">${rsClasses[2][6].subject.name}<br></a></c:if></td>
							<td><c:if
									test="${rsClasses[3][6] != null}">
								<a data-toggle="popover" title="grupa: <c:forEach items="${rsClasses[3][6].subject.students_group}" var="item">${item.id} </c:forEach>"
								   data-content="kierunek: <c:forEach items="${rsClasses[3][6].subject.students_group}" var="item">
                                        ${item.course.name}</c:forEach>">${rsClasses[1][6].subject.name}<br></a></c:if></td>
							<td><c:if
									test="${rsClasses[4][6] != null}">
								<a data-toggle="popover" title="grupa: <c:forEach items="${rsClasses[4][6].subject.students_group}" var="item">${item.id} </c:forEach>"
								   data-content="kierunek: <c:forEach items="${rsClasses[4][6].subject.students_group}" var="item">
                                        ${item.course.name}</c:forEach>">${rsClasses[4][6].subject.name}<br></a></c:if></td>
						<tr>
							<td>19<sup>45</sup> - 21<sup>15</sup></td>
							<td><c:if
									test="${rsClasses[0][7] != null}">
								<a data-toggle="popover" title="grupa: <c:forEach items="${rsClasses[0][7].subject.students_group}" var="item">${item.id} </c:forEach>"
								   data-content="kierunek: <c:forEach items="${rsClasses[0][7].subject.students_group}" var="item">
                                        ${item.course.name}</c:forEach>">${rsClasses[0][7].subject.name}<br></a></c:if></td>
							<td> <c:if
									test="${rsClasses[1][7] != null}">
								<a data-toggle="popover" title="grupa: <c:forEach items="${rsClasses[1][7].subject.students_group}" var="item">${item.id} </c:forEach>"
								   data-content="kierunek: <c:forEach items="${rsClasses[1][7].subject.students_group}" var="item">
                                        ${item.course.name}</c:forEach>">${rsClasses[1][7].subject.name}<br></a></c:if></td>
							<td><c:if
									test="${rsClasses[2][7] != null}">
								<a data-toggle="popover" title="grupa: <c:forEach items="${rsClasses[2][7].subject.students_group}" var="item">${item.id} </c:forEach>"
								   data-content="kierunek: <c:forEach items="${rsClasses[2][7].subject.students_group}" var="item">
                                        ${item.course.name}</c:forEach>">${rsClasses[2][7].subject.name}<br></a></c:if></td>
							<td><c:if
									test="${rsClasses[3][7] != null}">
								<a data-toggle="popover" title="grupa: <c:forEach items="${rsClasses[3][7].subject.students_group}" var="item">${item.id} </c:forEach>"
								   data-content="kierunek: <c:forEach items="${rsClasses[3][7].subject.students_group}" var="item">
                                        ${item.course.name}</c:forEach>">${rsClasses[1][7].subject.name}<br></a></c:if></td>
							<td><c:if
									test="${rsClasses[4][7] != null}">
								<a data-toggle="popover" title="grupa: <c:forEach items="${rsClasses[4][7].subject.students_group}" var="item">${item.id} </c:forEach>"
								   data-content="kierunek: <c:forEach items="${rsClasses[4][7].subject.students_group}" var="item">
                                        ${item.course.name}</c:forEach>">${rsClasses[4][7].subject.name}<br></a></c:if></td>
						</tr>
						</tbody>
					</table>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
</div>
<script>
	$(document).ready(function(){
		$('[data-toggle="popover"]').popover();
	});
</script>
</body>
</html>
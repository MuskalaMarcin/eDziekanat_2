<%@ page language="java" contentType="text/html; charset=ISO-8859-2"
	pageEncoding="ISO-8859-2"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-2">
    <link rel="stylesheet" href="resources/pure-min.css">
    <link rel="stylesheet" href="resources/styles.css">
    <link rel="stylesheet" href="resources/css/bootstrap.css">
    <link rel="stylesheet" href="resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="resources/css/bootstrap-theme.min.css">
    <link rel="stylesheet" href="resources/css/normalize.css">
    <script type='text/javascript' src="resources/jquery/jquery-2.2.3.js"></script>
    <script type='text/javascript' src="resources/js/bootstrap.min.js"></script>
<title>eDziekanat - Studenci</title>
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
						href="classrooms">Dostępność sal</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="admincourses">Kierunki</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="adminstudentgroups">Grupy studenckie</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="adminlecturers">Wykładowcy</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="adminsubjects">Przedmioty</a></li>
					<li class="pure-menu-item menu-item-divided">
					<li class="pure-menu-item"><a class="pure-menu-link" href="#">Studenci</a></li>
					<li class="pure-menu-item pure-menu-selected"><a
						class="pure-menu-link" href="adminstudents">Przeglądaj</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="admingetstudentsgroup?option=new">Dodaj studenta</a></li>
					<li class="pure-menu-item menu-item-divided">
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
                                                  href="news">Ogłoszenia</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link" href="adminmydata">Moje dane</a></li>
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
				<h2 class="content-subhead">
					Studenci:
					<c:if test="${!empty studentsgroup }"> grupa studencka: ${studentsgroup.id } kierunek: ${studentsgroup.course.name }</c:if>
				</h2>
				<center>
                    <p>
                    <form class="form-inline" action="adminsearchstudents" method="post">
                        <div class="form-group">
                            <input type="text" class="form-control" placeholder="Imię" name="searchedName">
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-control" placeholder="Nazwisko" name="searchedSurname" required>
                        </div>
                        <button type="submit" class="btn btn-info">
                            <span class="glyphicon glyphicon-search"></span> Szukaj
                        </button>
                    </form>
                    </p>
				</center>
				<p>
					<c:choose>
						<c:when test="${empty students }">
							<center>Nie znaleziono studentów pasujących do kryteriów
								wyszukiwania.</center>
						</c:when>
						<c:otherwise>
                            <div class="panel-group" id="accordion1">
                                <c:forEach items="${students}" var="student"
                                           varStatus="varStatus">
                                    <div class="panel panel-default">
                                        <div class="panel-heading accordion-toggle collapsed" data-toggle="collapse"
                                             data-parent="#accordion1" data-target="#collapseOne${varStatus.index}">
                                            <h4 class="panel-title">
                                                <div class="text-left" style="display: inline">
                                                        ${student.name} ${student.surname}
                                                </div>
                                            </h4>
                                        </div>
                                        <div id="collapseOne${varStatus.index}" class="panel-collapse collapse">
                                            <div class="panel-body">
                                                <div class="newLine">Email: ${student.user.eMail}</div>
                                                <div class="newLine">Grupa/y studencka:
                                                    <c:choose>
                                                        <c:when test="${empty student.studentsGroup}">Brak</c:when>
                                                        <c:otherwise>
                                                            <c:forEach items="${student.studentsGroup}" var="sg">
                                                                ${sg.id}
                                                            </c:forEach>
                                                        </c:otherwise>
                                                    </c:choose>
                                                </div>
                                                <div class="newLine">Adres:
                                                    <c:choose>
                                                        <c:when test="${empty student.address}">Brak</c:when>
                                                        <c:otherwise>
                                                            ${student.address}
                                                        </c:otherwise>
                                                    </c:choose>
                                                </div>
                                                <div>
                                                    <form style="float: left; padding: 10px 0px 0px 10px" action="adminstudentenrollments" method=post>
                                                        <input type="hidden" name="studentId" value="${student.id}">
                                                        <button type="submit" class="btn btn-primary btn-md" style="width: 113px">
                                                            <span class="glyphicon glyphicon-info-sign"></span> Wpisy
                                                        </button>
                                                    </form>
                                                    <form style="float: left; padding: 10px 0px 0px 10px" action="adminstudentmarks" method=post>
                                                        <input type="hidden" name="studentId" value="${student.id}">
                                                        <button type="submit" class="btn btn-primary btn-md" style="width: 113px">
                                                            <span class="glyphicon glyphicon-info-sign"></span> Oceny
                                                        </button>
                                                    </form>
                                                    <form style="float: left; padding: 10px 0px 0px 10px" action="adminstudentscholarships" method=post>
                                                        <input type="hidden" name="studentId" value="${student.id}">
                                                        <button type="submit" class="btn btn-info btn-md" style="width: 113px">
                                                            <span class="glyphicon glyphicon-education"></span> Stypendia
                                                        </button>
                                                    </form>
                                                    <form style="float: left; padding: 10px 0px 0px 10px" action="adminstudentpayments" method=post>
                                                        <input type="hidden" name="studentId" value="${student.id}">
                                                        <button type="submit" class="btn btn-danger btn-md" style="width: 113px">
                                                            <span class="glyphicon glyphicon-usd"></span> Należności
                                                        </button>
                                                    </form>
                                                    <form style="float: left; padding: 10px 0px 0px 10px" action="adminstudentapplications" method=post>
                                                        <input type="hidden" name="studentId" value="${student.id}">
                                                        <button type="submit" class="btn btn-warning btn-md" style="width: 113px">
                                                            <span class="glyphicon glyphicon-list-alt"></span> Wnioski
                                                        </button>
                                                    </form>
                                                    <form style="float: left; padding: 10px 0px 0px 10px" action="admin/newmessage" method=post>
                                                        <input type="hidden" name="receiverLogin"
                                                               value="${student.user.login}">
                                                        <button type="submit" class="btn btn-success btn-md" style="width: 113px">
                                                            <span class="glyphicon glyphicon-envelope"></span> Kontakt
                                                        </button>
                                                    </form>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>
                            </div>
						</c:otherwise>
					</c:choose>
			</div>
		</div>
	</div>
</body>
</html>
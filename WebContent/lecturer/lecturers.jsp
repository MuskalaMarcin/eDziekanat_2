<%@ page language="java" contentType="text/html; charset=ISO-8859-2"
	pageEncoding="ISO-8859-2"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-2">
    <link rel="stylesheet" href="resources/pure-min.css">
    <link rel="stylesheet" href="resources/styles.css">
    <link rel="stylesheet" href="resources/bootstrap/bootstrap.css">
    <link rel="stylesheet" href="resources/bootstrap/bootstrap.min.css">
    <link rel="stylesheet" href="resources/bootstrap/bootstrap-datepicker3.standalone.css">
    <link rel="stylesheet" href="resources/bootstrap/bootstrap-theme.css">
    <link rel="stylesheet" href="resources/bootstrap/bootstrap-theme.min.css">
    <link rel="stylesheet" href="resources/bootstrap/normalize.css">
    <link rel="stylesheet" href="resources/pure-min.css">
    <link rel="stylesheet" href="resources/styles.css">
    <script type='text/javascript' src="resources/jquery/jquery-2.2.3.js"></script>
    <script type='text/javascript' src="resources/bootstrap/bootstrap.js"></script>
    <script type='text/javascript' src="resources/bootstrap/bootstrap.min.js"></script>
    <script type='text/javascript' src="resources/bootstrap/bootstrap-datepicker.js"></script>
    <script type='text/javascript' src="resources/bootstrap/npm.js"></script>
<title>eDziekanat - Wykładowcy</title>
</head>
<body>
	<div id="layout">
		<div id="menu">
			<div class="pure-menu">
				<a class="pure-menu-heading" href="home">eDziekanat</a>
				<ul class="pure-menu-list">
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="lecturer">Strona główna</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="lecturerlearningmaterials">Materiały dydaktyczne</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="lecturerseestudents">Studenci</a></li>
					<li class="pure-menu-item pure-menu-selected"><a
						class="pure-menu-link" href="lecturerseelecturers">Wykładowcy</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="classrooms">Dostępność sal</a></li>
					<li class="pure-menu-item"><a href="timetable"
						class="pure-menu-link">Plan zajęć</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="lecturersubjects">Moje przedmioty</a></li>
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
				<h2 class="content-subhead">Wykładowcy:</h2>
				<center>
                    <p>
                    <form class="form-inline" action="lecturersearchlecturers" method="post">
                        <div class="form-group">
                            <input type="text" class="form-control" placeholder="Imię" name="searchedName">
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-control" placeholder="Nazwisko" name="searchedSurname" required>
                        </div>
                        <button type="button" class="btn btn-info">
                            <span class="glyphicon glyphicon-search"></span> Szukaj
                        </button>
                    </form>
                    </p>
				</center>
                <c:choose>
                    <c:when test="${empty lecturers}">
                    <center>
                        <p>Brak informacji o wykładowcach do wyświetlenia.</p>
                    </center>
                    </c:when>
                    <c:otherwise>
                        <div class="panel-group" id="accordion1">
                        <c:forEach items="${lecturers}" var="lecturer"
                                   varStatus="varStatus">
                            <div class="panel panel-default">
                                <div class="panel-heading accordion-toggle collapsed" data-toggle="collapse"
                                     data-parent="#accordion1" data-target="#collapseOne${varStatus.index}">
                                    <h4 class="panel-title">
                                        <div class="text-left" style="display: inline">${lecturer.academicDegree}
                                                ${lecturer.name} ${lecturer.surname}
                                        </div>

                                    </h4>
                                </div>
                                <div id="collapseOne${varStatus.index}" class="panel-collapse collapse">
                                    <div class="panel-body">
                                        <div class="newLine">Stanowisko: ${lecturer.position}</div>
                                        <div class="newLine">Email: ${lecturer.user.eMail}</div>
                                        <div class="newLine">
                                            Wydział/y:
                                            <c:choose>
                                                <c:when test="${empty lecturer.faculty}">Brak</c:when>
                                                <c:otherwise>
                                                    <c:forEach items="${lecturer.faculty}" var="faculty" varStatus="status">
                                                        ${faculty.name}<c:if test="${not empty
                                                            lecturer.faculty[status.index+1].name}">, </c:if>
                                                    </c:forEach>
                                                </c:otherwise>
                                            </c:choose>
                                        </div>
                                        <div class="newLine">
                                            Przedmiot/y:
                                            <c:choose>
                                                <c:when test="${empty lecturer.subject}">Brak</c:when>
                                                <c:otherwise>
                                                    <c:forEach items="${lecturer.subject}" var="subject"
                                                               varStatus="status">
                                                        ${subject.name}<c:if test="${not empty
                                                            lecturer.subject[status.index+1].name}">, </c:if>
                                                    </c:forEach>
                                                </c:otherwise>
                                            </c:choose>
                                        </div>
                                        <div class="newLine">Strona internetowa: ${lecturer.website}</div>
                                        <div class="newLine">Konsultacje: ${lecturer.consultationInfo}</div>
                                        <div class="text-right" style="display: inline; float: right">
                                            <form action="lecturer/newmessage" method=post>
                                                <input type="hidden" name="receiverLogin"
                                                       value="${lecturer.user.login}">
                                                <button type="submit" class="btn btn-success btn-md">
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
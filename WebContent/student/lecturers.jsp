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
    <script type='text/javascript' src="resources/jquery/jquery-2.2.3.js"></script>
    <script type='text/javascript' src="resources/js/bootstrap.js"></script>
<title>eDziekanat - Wykładowcy</title>
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
                    <li class="pure-menu-item"><a href="studentacademicrecordcard"
                        class="pure-menu-link">Karta przebiegu studiów</a></li>
					<li class="pure-menu-item"><a href="timetable"
						class="pure-menu-link">Plan zajęć</a></li>
					<li class="pure-menu-item"><a href="studentsubjects"
						class="pure-menu-link">Moje przedmioty</a></li>
					<li class="pure-menu-item"><a href="studentscholarships"
						class="pure-menu-link">Stypendia</a></li>
					<li class="pure-menu-item"><a href="studentwaitingpayments"
						class="pure-menu-link">Płatności</a></li>
					<li class="pure-menu-item"><a href="studentapplications"
						class="pure-menu-link">Wnioski</a></li>
					<li class="pure-menu-item  pure-menu-selected"><a
						href="studentlecturers" class="pure-menu-link">Wykładowcy</a></li>
					<li class="pure-menu-item"><a href="receivedmessages"
						class="pure-menu-link">Historia komunikatów</a></li>
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
				<h2>Twój wirtualny dziekanat.</h2>
			</div>
			<div class="content">
				<h2 class="content-subhead">Wykładowcy:</h2>
                <c:choose>
                    <c:when test="${empty lecturers}">
                        <p>Brak informacji o wykładowcach do wyświetlenia.</p>
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
                                            <div class="newLine">Email: ${lecturer.user.eMail}</div>
                                            <div class="newLine">Strona internetowa:
                                                <c:choose>
                                                    <c:when test="${empty lecturer.website}">Brak</c:when>
                                                    <c:otherwise>
                                                        <a href="http://${lecturer.website}">${lecturer.website}</a>
                                                    </c:otherwise>
                                                </c:choose>
                                            </div>
                                            <div class="newLine">Konsultacje:
                                                <c:choose>
                                                    <c:when test="${empty lecturer.consultationInfo}">Brak</c:when>
                                                    <c:otherwise>
                                                        ${lecturer.consultationInfo}
                                                    </c:otherwise>
                                                </c:choose>
                                            </div>
                                            <div style="display: inline; float: right">
                                                <form action="student/newmessage" method=post>
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
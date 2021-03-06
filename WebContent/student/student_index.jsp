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
    <link rel="stylesheet" href="resources/css/bootstrap.min.css">
    <script src="resources/jquery/jquery-2.2.3.js"></script>
    <script src="resources/js/bootstrap.min.js"></script>
<title>eDziekanat - Strona g��wna</title>
</head>
<body>
	<div id="layout">
		<div id="menu">
			<div class="pure-menu">
				<a class="pure-menu-heading" href="home">eDziekanat</a>
				<ul class="pure-menu-list">
					<li class="pure-menu-item pure-menu-selected"><a
						href="student" class="pure-menu-link">Strona g��wna</a></li>
					<li class="pure-menu-item"><a href="studenttranscript"
						class="pure-menu-link">Indeks</a></li>
                    <li class="pure-menu-item"><a href="studentacademicrecordcard"
                        class="pure-menu-link">Karta przebiegu studi�w</a></li>
					<li class="pure-menu-item"><a href="timetable"
						class="pure-menu-link">Plan zaj��</a></li>
					<li class="pure-menu-item"><a href="studentsubjects"
						class="pure-menu-link">Moje przedmioty</a></li>
					<li class="pure-menu-item"><a href="studentscholarships"
						class="pure-menu-link">Stypendia</a></li>
					<li class="pure-menu-item"><a href="studentwaitingpayments"
						class="pure-menu-link">P�atno�ci</a></li>
					<li class="pure-menu-item"><a href="studentapplications"
						class="pure-menu-link">Wnioski</a></li>
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
                <h2 class="content-subhead">Tablica og�osze�:</h2>
                <c:choose>
                    <c:when test="${empty news}">
                        <p>Brak aktualnych og�osze�.</p>
                    </c:when>
                    <c:otherwise>
                        <div class="panel-group" id="accordion1">
                            <c:forEach items="${news}" var="news"
                                       varStatus="varStatus">
                                <div class="panel panel-default">
                                    <div class="panel-heading accordion-toggle collapsed" data-toggle="collapse"
                                         data-parent="#accordion1" data-target="#collapseOne${varStatus.index}">
                                        <h4 class="panel-title">${news.title}</h4>
                                    </div>
                                    <div id="collapseOne${varStatus.index}" class="panel-collapse collapse">
                                        <div class="panel-body"> ${news.content} </div>
                                        <div class="panel-body">
                                            <fmt:formatDate pattern="dd.MM.yyyy"
                                                            value="${news.dispatchDate}" />, ${senderNames[varStatus.index]}</div>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                    </c:otherwise>
                </c:choose>
                <h2 class="content-subhead">Zalogowano jako:</h2>
                <p>
                    Login: <b> ${loginBean.login} </b><br>
                    Imi� i nazwisko: <b>${loginBean.name} ${loginBean.surname} </b><br>
                    Stopie� naukowy: <b>${loginBean.academicDegree} </b><br>
                    E-mail: <b> ${loginBean.eMail} </b><br>
                    Poziom uprawnie�: <b>${loginBean.userRole}</b><br>
                    Adres: <b> ${loginBean.address} </b><br>
                </p>
			</div>
		</div>
	</div>
</body>
</html>
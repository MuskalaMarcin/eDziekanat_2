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
    <link rel="stylesheet" href="resources/css/bootstrap.css">
    <link rel="stylesheet" href="resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="resources/css/bootstrap-theme.min.css">
    <link rel="stylesheet" href="resources/css/normalize.css">
    <script type='text/javascript' src="resources/jquery/jquery-2.2.3.js"></script>
    <script type='text/javascript' src="resources/js/bootstrap.min.js"></script>
<title>eDziekanat - Wyk�adowca - Strona g��wna</title>
</head>
<body>
	<div id="layout">
		<div id="menu">
			<div class="pure-menu">
				<a class="pure-menu-heading" href="home">eDziekanat</a>
				<ul class="pure-menu-list">
					<li class="pure-menu-item pure-menu-selected"><a
						class="pure-menu-link" href="lecturer">Strona g��wna</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="lecturerlearningmaterials">Materia�y dydaktyczne</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="lecturerseestudents">Studenci</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="lecturerseelecturers">Wyk�adowcy</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="classrooms">Dost�pno�� sal</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="timetable">Plan zaj��</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="lecturersubjects">Moje przedmioty</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="receivedmessages">Historia komunikat�w</a></li>
                    <li class="pure-menu-item"><a class="pure-menu-link" href="lecturermydata">Moje dane</a></li>
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
                    Login: <b> ${loginBean.login} </b><br> Imi� i nazwisko: <b>${loginBean.name}
                    ${loginBean.surname} </b><br> Stopie� naukowy: <b>
                    ${loginBean.academicDegree} </b><br> E-mail: <b>
                    ${loginBean.eMail} </b><br> Poziom uprawnie�: <b>${loginBean.userRole}
                </b><br> Adres: <b> ${loginBean.address} </b><br>
                </p>
			</div>
		</div>
	</div>
</body>
</html>
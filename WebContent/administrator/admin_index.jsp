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
    <title>eDziekanat - Administrator - Strona główna</title>
</head>
<body>
	<div id="layout">
		<div id="menu">
			<div class="pure-menu">
				<a class="pure-menu-heading" href="home">eDziekanat</a>
				<ul class="pure-menu-list">
					<li class="pure-menu-item pure-menu-selected"><a href="admin"
						class="pure-menu-link">Strona główna</a></li>
					<li class="pure-menu-item"><a href="admintimetable"
						class="pure-menu-link">Plan zajęć</a></li>
					<li class="pure-menu-item"><a
						class="pure-menu-link" href="classrooms">Dostępność sal</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="admincourses">Kierunki</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="adminstudentgroups">Grupy studenckie</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="adminlecturers">Wykładowcy</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="adminsubjects">Przedmioty</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="adminstudents">Studenci</a></li>
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
                <h2 class="content-subhead">Tablica ogłoszeń:</h2>
                    <c:choose>
                        <c:when test="${empty news}">
                            <p>Brak aktualnych ogłoszeń.</p>
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
                    Login: <b> ${loginBean.login} </b><br> Imię i nazwisko: <b>${loginBean.name}
                    ${loginBean.surname} </b><br> Stopień naukowy: <b>
                    ${loginBean.academicDegree} </b><br> E-mail: <b>
                    ${loginBean.eMail} </b><br> Poziom uprawnień: <b>${loginBean.userRole}
                </b><br> Adres: <b> ${loginBean.address} </b><br>
                </p>
            </div>
		</div>
	</div>
</body>
</html>
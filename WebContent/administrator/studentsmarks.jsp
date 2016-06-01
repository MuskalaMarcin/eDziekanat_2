<%@ page language="java"
         contentType="text/html; charset=ISO-8859-2" pageEncoding="ISO-8859-2" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
    <title>eDziekanat - Oceny studenta</title>
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
                                              href="admingetstudentsgroup">Dodaj studenta</a></li>
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
            <h2 class="content-subhead">Oceny cząstkowe ${student.name} ${student.surname}:</h2>
            <c:choose>
                <c:when test="${empty semesterList}">
                    <p>Brak ocen do wyświetlenia.</p>
                </c:when>
                <c:otherwise>
                    <c:forEach items="${semesterList}" var="semester"
                               varStatus="varStatus">
                        <div class="table-responsive"
                             style="margin-left: 30px; margin-right: 30px; margin-bottom: 20px">
                            <table class="table table-bordered table-hover">
                                <thead class="thead-inverse">
                                <tr>
                                    <th colspan="5" style="text-align:center">Semestr: ${semester}</th>
                                </tr>
                                <tr>
                                    <th width="25%">Przedmiot</th>
                                    <th width="25%">Oceny</th>
                                    <th width="25%">Średnia ocen</th>
                                    <th width="25%">Prowadzący</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${subjects}" var="subject"
                                           varStatus="theCount">
                                    <c:set var="summark" value="0"/>
                                    <c:set var="marks" value="0"/>
                                    <c:if test="${semester == subject.semester}">
                                        <tr>
                                            <td>${subject.name}</td>
                                            <td>
                                                <c:forEach items="${partialMarks}" var="partialMark"
                                                           varStatus="status">
                                                    <c:if test="${partialMark.subject.name == subject.name}">
                                                        ${partialMark.mark}
                                                        <c:set var="summark" value="${summark + partialMark.mark}"/>
                                                        <c:set var="marks" value="${marks + 1}"/>
                                                    </c:if>
                                                </c:forEach>
                                            </td>
                                            <td>
                                                <c:set var="average" value="${summark / marks}"/>
                                                <fmt:formatNumber value="${average}" maxFractionDigits="2"/>
                                                <c:set var="summark" value="0"/>
                                                <c:set var="marks" value="0"/>
                                            </td>
                                            <td>${subject.lecturer.name}
                                                    ${subject.lecturer.surname}</td>
                                        </tr>
                                    </c:if>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </c:forEach>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</div>
</body>
</html>

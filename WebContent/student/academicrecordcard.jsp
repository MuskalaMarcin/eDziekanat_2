<%@ page language="java"
         contentType="text/html; charset=ISO-8859-2" pageEncoding="ISO-8859-2"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-2">
    <link rel="stylesheet" href="resources/pure-min.css">
    <link rel="stylesheet" href="resources/styles.css">
    <link rel="stylesheet" href="resources/bootstrap/bootstrap.css">
    <script type='text/javascript' src="resources/jquery/jquery-2.2.3.js"></script>
    <script type='text/javascript' src="resources/bootstrap/bootstrap.js"></script>
    <title>eDziekanat - Karta przebiegu studi�w</title>
</head>
<body>
<div id="layout">
    <div id="menu">
        <div class="pure-menu">
            <a class="pure-menu-heading" href="home">eDziekanat</a>
            <ul class="pure-menu-list">
                <li class="pure-menu-item"><a href="student"
                                              class="pure-menu-link">Strona g��wna</a></li>
                <li class="pure-menu-item"><a href="studenttranscript"
                                              class="pure-menu-link">Indeks</a></li>
                <li class="pure-menu-item pure-menu-selected"><a href="studentacademicrecordcard"
                                              class="pure-menu-link">Karta przebiegu studi�w</a></li>
                <li class="pure-menu-item"><a href="timetable"
                                              class="pure-menu-link">Plan zaj��</a></li>
                <li class="pure-menu-item"><a href="studentsubjects"
                                              class="pure-menu-link">Moje przedmioty</a></li>
                <li class="pure-menu-item"><a href="studentscholarships"
                                              class="pure-menu-link">Stypendia</a></li>
                <li class="pure-menu-item"><a href="studentwaitingpayments"
                                              class="pure-menu-link">P�atno�ci</a></li>
                <li class="pure-menu-item"><a href="studentapplications" class="pure-menu-link">Wnioski</a></li>
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
            <h2 class="content-subhead">Karta przebiegu studi�w</h2>
        </div>
        <c:choose>
            <c:when test="${empty semesterList}">
                <p>Brak wpis�w do wy�wietlenia.</p>
            </c:when>
            <c:otherwise>
                <c:forEach items="${semesterList}" var="semester"
                           varStatus="varStatus">
                    <c:set var="summark" value="0"/>
                    <c:set var="sumects" value="0"/>
                    <div class="table-responsive" style="margin-left: 30px; margin-right: 30px; margin-bottom: 20px">
                        <table class="table table-bordered table-hover">
                            <thead class="thead-inverse">
                            <tr>
                                <th colspan="5" style="text-align:center">Semestr: ${semester}</th>
                            </tr>
                            <tr>
                                <th width="25%">Przedmiot</th>
                                <th width="25%">Liczba punkt�w ECTS</th>
                                <th width="25%">Ocena</th>
                                <th width="25%">Prowadz�cy</th>
                            </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${enrollments}" var="enrollment"
                                           varStatus="theCount">
                                    <c:if test="${semester == enrollment.subject.semester}">
                                        <c:set var="summark"
                                               value="${summark + enrollment.subject.ECTS * enrollment.mark}"/>
                                        <c:set var="sumects" value="${sumects + enrollment.subject.ECTS}"/>
                                        <tr>
                                            <td>${enrollment.subject.name}</td>
                                            <td>${enrollment.subject.ECTS}</td>
                                            <td>${enrollment.mark}</td>
                                            <td>${enrollment.subject.lecturer.name}
                                                    ${enrollment.subject.lecturer.surname}</td>
                                        </tr>
                                    </c:if>
                                </c:forEach>
                                <tr>
                                    <td colspan="2" style="text-align:center">
                                        Suma punkt�w ECTS: <c:out value="${sumects}"/>
                                    </td>
                                    <td colspan="2" style="text-align:center">
                                        <c:set var="average" value="${summark / sumects}"/>
                                        �rednia ocen do dyplomu:
                                        <fmt:formatNumber value="${average}" maxFractionDigits="2"/>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </c:forEach>
            </c:otherwise>
        </c:choose>
    </div>
</div>
</body>
</html>
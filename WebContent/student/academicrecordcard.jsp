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
    <link rel="stylesheet" href="resources/css/bootstrap.css">
    <link rel="stylesheet" href="resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="resources/css/bootstrap-theme.min.css">
    <link rel="stylesheet" href="resources/css/normalize.css">
    <script type='text/javascript' src="resources/jquery/jquery-2.2.3.js"></script>
    <script type='text/javascript' src="resources/js/bootstrap.min.js"></script>
    <title>eDziekanat - Karta przebiegu studiów</title>
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
                <li class="pure-menu-item pure-menu-selected"><a href="studentacademicrecordcard"
                                              class="pure-menu-link">Karta przebiegu studiów</a></li>
                <li class="pure-menu-item"><a href="timetable"
                                              class="pure-menu-link">Plan zajęć</a></li>
                <li class="pure-menu-item"><a href="studentsubjects"
                                              class="pure-menu-link">Moje przedmioty</a></li>
                <li class="pure-menu-item"><a href="studentscholarships"
                                              class="pure-menu-link">Stypendia</a></li>
                <li class="pure-menu-item"><a href="studentwaitingpayments"
                                              class="pure-menu-link">Płatności</a></li>
                <li class="pure-menu-item"><a href="studentapplications" class="pure-menu-link">Wnioski</a></li>
                <li class="pure-menu-item"><a href="studentlecturers"
                                              class="pure-menu-link">Wykładowcy</a></li>
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
            <h2 class="content-subhead">Karta przebiegu studiów</h2>
            <c:choose>
                <c:when test="${empty transcripts}">
                    <p>Brak wpisów do wyświetlenia.</p>
                </c:when>
                <c:otherwise>
                    <c:forEach items="${transcripts}" var="transcript"
                               varStatus="varStatus">
                        <c:forEach items="${transcriptToSemesterList[transcript]}" var="semester"
                                   varStatus="varStatus">
                            <c:set var="summark" value="0"/>
                            <c:set var="studentects" value="0"/>
                            <c:set var="isPassed" value="0"/>
                            <div class="table-responsive" style="margin-left: 30px; margin-right: 30px; margin-bottom: 20px">
                                <table class="table table-bordered table-hover">
                                    <thead class="thead-inverse">
                                    <tr>
                                        <th colspan="5" style="text-align:center">Semestr: ${semester}</th>
                                    </tr>
                                    <tr>
                                        <th width="25%">Przedmiot</th>
                                        <th width="25%">Prowadzący</th>
                                        <th width="25%">Liczba punktów ECTS</th>
                                        <th width="25%">Ocena</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${transcript.enrollment}" var="enrollment" varStatus="theCount">
                                        <c:if test="${semester == enrollment.subject.semester}">
                                            <c:set var="summark"
                                                   value="${summark + enrollment.subject.ECTS * enrollment.mark}"/>
                                            <c:if test="${enrollment.mark > 2}">
                                                <c:set var="studentects" value="${studentects + enrollment.subject.ECTS}"/>
                                            </c:if>
                                            <tr>
                                                <td>${enrollment.subject.name}</td>
                                                <td>${enrollment.subject.lecturer.name}
                                                        ${enrollment.subject.lecturer.surname}</td>
                                                <td>${enrollment.subject.ECTS}</td>
                                                <td>${enrollment.mark}</td>
                                            </tr>
                                        </c:if>
                                    </c:forEach>
                                    <tr>
                                        <td colspan="2" style="text-align:center">
                                            <c:forEach items="${transcript.passed_semester}" var="passedSemester">
                                                <c:if test="${passedSemester.semester == semester}">
                                                    <c:set var="isPassed" value="1"/>
                                                </c:if>
                                            </c:forEach>
                                            <c:choose>
                                                <c:when test="${isPassed == 0}">
                                                    <span class="glyphicon glyphicon-remove"></span> Semester niezaliczony
                                                </c:when>
                                                <c:otherwise>
                                                    <span class="glyphicon glyphicon glyphicon-ok"></span> Semester zaliczony
                                                </c:otherwise>
                                            </c:choose>
                                        </td>
                                        <td colspan="1" style="text-align:center">
                                            Punkty ECTS: <c:out value="${studentects}"/> / <c:out value="${semesterToSumECTS[semester]}"/>
                                        </td>
                                        <td colspan="1" style="text-align:center">
                                            <c:set var="average" value="${summark / semesterToSumECTS[semester]}"/>
                                            Średnia do dyplomu:
                                            <fmt:formatNumber value="${average}" maxFractionDigits="2"/>
                                        </td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                        </c:forEach>
                    </c:forEach>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-2"
         pageEncoding="ISO-8859-2"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-2">
    <link rel="stylesheet"
          href="resources/pure-min.css">
    <link rel="stylesheet"
          href="resources/styles.css">
    <title>eDziekanat - Dodaj studenta</title>
</head>
<body>
<div id="layout">
    <div id="menu">
        <div class="pure-menu">
            <a class="pure-menu-heading" href="home">eDziekanat</a>
            <ul class="pure-menu-list">
                <li class="pure-menu-item"><a
                        href="http://localhost:8080/edziekanat/admin"
                        class="pure-menu-link">Strona g��wna</a></li>
                <li class="pure-menu-item"><a
                        href="http://localhost:8080/edziekanat/admintimetable"
                        class="pure-menu-link">Plan zaj��</a></li>
                <li class="pure-menu-item"><a class="pure-menu-link"
                                              href="http://localhost:8080/ediekanat/classrooms">Dost�pno��
                    sal</a></li>
                <li class="pure-menu-item"><a class="pure-menu-link"
                                              href="http://localhost:8080/edziekanat/admincourses">Kierunki</a></li>
                <li class="pure-menu-item"><a class="pure-menu-link"
                                              href="http://localhost:8080/edziekanat/adminstudentgroups">Grupy
                    studenckie</a></li>
                <li class="pure-menu-item"><a class="pure-menu-link"
                                              href="http://localhost:8080/edziekanat/adminlecturers">Wyk�adowcy</a>
                </li>
                <li class="pure-menu-item"><a class="pure-menu-link"
                                              href="http://localhost:8080/edziekanat/adminsubjects">Przedmioty</a>
                </li>
                <li class="pure-menu-item menu-item-divided">
                <li class="pure-menu-item pure-menu-selected"><a class="pure-menu-link" href="#">Studenci</a></li>
                <li class="pure-menu-item"><a class="pure-menu-link"
                                              href="http://localhost:8080/edziekanat/adminstudents">Przegl�daj</a></li>
                <li class="pure-menu-item"><a
                        class="pure-menu-link"
                        href="http://localhost:8080/edziekanat/admin/newstudent">Dodaj
                    studenta</a></li>
                <li class="pure-menu-item"><a class="pure-menu-link"
                                              href="http://localhost:8080/edziekanat/marksstatistics">Statystyki</a></li>
                <li class="pure-menu-item"><a class="pure-menu-link"
                                              href="http://localhost:8080/edziekanat/adminscholarships">Stypendia</a></li>
                <li class="pure-menu-item"><a class="pure-menu-link"
                                              href="http://localhost:8080/edziekanat/adminpayments">Nale�no�ci</a></li>
                <li class="pure-menu-item"><a class="pure-menu-link"
                                              href="http://localhost:8080/edziekanat/adminapplications">Wnioski</a></li>
                <li class="pure-menu-item"><a class="pure-menu-link"
                                              href="http://localhost:8080/edziekanat/receivedmessages">Historia
                    komunikat�w</a></li>
                <li class="pure-menu-item"><a class="pure-menu-link"
                                              href="news">Og�oszenia</a></li>
                <li class="pure-menu-item"><a class="pure-menu-link" href="adminmydata">Moje dane</a></li>
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
            <h2 class="content-subhead">Przenie� studenta</h2>
            <p>
            <p>
                <center>
            <form action="http://localhost:8080/edziekanat/movestudent"
                  method=post class="pure-form">
                Grupa studencka:
                <c:choose>
                    <c:when test="${!empty studentsgroup}">
                        <select name="studentsgroupid">
                            <c:forEach items="${studentsgroup}" var="studentsgroup"
                                       varStatus="varStatus">
                                <option value="${studentsgroup.id}">${studentsgroup.id}</option>
                            </c:forEach>
                        </select>
                    </c:when>
                </c:choose>
                <input type="hidden" name="studentId" value="${sId}">
                <input
                        class="pure-button pure-input-1-2 pure-button-primary"
                        type="submit" value="Przenie�">
            </form>
                </center>
        </div>
    </div>
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-2"
         pageEncoding="ISO-8859-2" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-2">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="resources/pure-min.css">
    <link rel="stylesheet" href="resources/styles.css">
    <link rel="stylesheet" href="resources/css/bootstrap.min.css">
    <script src="resources/jquery/jquery-2.2.3.js"></script>
    <script src="resources/js/bootstrap.min.js"></script>
    <title>eDziekanat - Dostępność sali</title>
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
                <li class="pure-menu-item menu-item-divided"><a
                        class="pure-menu-link" href="classrooms">Dostępność
                    sal</a></li>
                <li class="pure-menu-item"><a
                        class="pure-menu-link" href="classrooms">Wybierz salę</a></li>
                <li class="pure-menu-item"><a
                        class="pure-menu-link" href="adminreservations">Oczekujące rezerwacje</a></li>
                <li class="pure-menu-item">
                    <form action="adminreservations" method="post">
                        <input type="hidden" name="action"
                               value="history">
                        <button class="linkButton" type="submit">Historia rezerwacji
                        </button>
                    </form>
                </li>
                <li class="pure-menu-item pure-menu-selected">
                    <form action="#" method="post">
                        <button class="linkButton" type="submit">Dodaj salę
                        </button>
                    </form>
                </li>
                <li class="pure-menu-item">
                    <form action="adminlockclassroom" method="post">
                        <button class="linkButton" type="submit">Blokuj/usuń salę
                        </button>
                    </form>
                </li>
                <li class="pure-menu-item menu-item-divided"><a
                        class="pure-menu-link" href="admincourses">Kierunki</a></li>
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
            <h2 class="content-subhead">Dodaj nową salę:</h2>
            <p></p>
            <p></p>
            <center>
                <form action="http://localhost:8080/edziekanat/adminaddclassroom"
                      method=post class="pure-form">
                    <fieldset class="pure-group">
                        <input type="number" name="number" class="pure-input-1-2" min="1"
                               placeholder="Numer" required>
                    </fieldset>
                    <fieldset class="pure-group">
                        <input type="number" name="capacity" class="pure-input-1-2" min="1"
                               placeholder="Pojemność" required>
                    </fieldset>
                    Wydział:
                    <c:choose>
                        <c:when test="${!empty faculties}">
                            <select name="facultyId">
                                <c:forEach items="${faculties}" var="faculty"
                                           varStatus="varStatus">
                                    <option value="${faculty.id}">${faculty.name}</option>
                                </c:forEach>
                            </select>
                        </c:when>
                    </c:choose>
                    <p>
                    <p>
                    Typ:
                    <c:choose>
                        <c:when test="${!empty types}">
                            <select name="type">
                                <c:forEach items="${types}" var="type"
                                           varStatus="varStatus">
                                    <option value="${type}">${type}</option>
                                </c:forEach>
                            </select>
                        </c:when>
                    </c:choose>
                    <p>
                    <input type="hidden" name="addToDatabase" value="true">
                    <button type="submit"
                            class="pure-button pure-input-1-2 pure-button-primary">Dodaj
                    </button>
                </form>
            </center>
        </div>
    </div>
</div>
</body>
</html>
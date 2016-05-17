<%@ page language="java" contentType="text/html; charset=ISO-8859-2"
         pageEncoding="ISO-8859-2" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-2">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="resources/pure-min.css">
    <link rel="stylesheet" href="resources/styles.css">
    <link rel="stylesheet" href="resources/bootstrap/bootstrap.min.css">
    <script src="resources/jquery/jquery-2.2.3.js"></script>
    <script src="resources/bootstrap/bootstrap.min.js"></script>
    <title>eDziekanat - Moje rezerwacje</title>
</head>
<body>
<div id="layout">
    <div id="menu">
        <div class="pure-menu">
            <a class="pure-menu-heading" href="home">eDziekanat</a>
            <ul class="pure-menu-list">
                <li class="pure-menu-item"><a class="pure-menu-link"
                                              href="lecturer">Strona g��wna</a></li>
                <li class="pure-menu-item"><a class="pure-menu-link"
                                              href="lecturerlearningmaterials">Materia�y dydaktyczne</a></li>
                <li class="pure-menu-item"><a class="pure-menu-link"
                                              href="lecturerseestudents">Studenci</a></li>
                <li class="pure-menu-item"><a class="pure-menu-link"
                                              href="lecturerseelecturers">Wyk�adowcy</a></li>
                <li class="pure-menu-item menu-item-divided"><a
                        class="pure-menu-link" href="classrooms">Dost�pno��
                    sal</a></li>
                <li class="pure-menu-item pure-menu-selected"><a
                        class="pure-menu-link" href="myreservations">Moje rezerwacje</a></li>
                <li class="pure-menu-item  menu-item-divided"><a
                        href="timetable" class="pure-menu-link">Plan zaj��</a></li>
                <li class="pure-menu-item "><a class="pure-menu-link"
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
            <h3 class="content-subhead">
                Moje rezerwacje
            </h3>
            <br>
            <c:if test="${successMsg != null}">
                <div class="alert alert-success fade in">
                    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                    <strong>Sukces!</strong> ${successMsg}
                </div>
            </c:if>
            <c:if test="${errorMsg != null}">
                <div class="alert alert-danger fade in">
                    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                    <strong>B��d!</strong> ${errorMsg}
                </div>
            </c:if>
            <br>
            <c:choose>
                <c:when test="${empty reservationsList }">
                    <center>Nie znaleziono wcze�niejszych rezerwacji.</center>
                </c:when>
                <c:otherwise>
                    <table class="table table-striped table-bordered text-center">
                        <thead>
                        <tr>
                            <td>Id</td>
                            <td>Przedmiot</td>
                            <td>Sala</td>
                            <td>Data wys�ania</td>
                            <td>Pocz�tkowa data zaj��</td>
                            <td>Ko�cowa data zaj��</td>
                            <td>Powtarzanie</td>
                            <td>Status</td>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${reservationsList}" var="res">
                            <tr>
                                <td>${res.id}</td>
                                <td>${res.subject.name}</td>
                                <td>${res.classroom.number}</td>
                                <td><fmt:formatDate pattern="dd.MM.yyyy" value="${res.requestDate }"/></td>
                                <td><fmt:formatDate pattern="H:mm dd.MM.yyyy" value="${res.classesDate }"/></td>
                                <td>
                                    <c:choose>
                                        <c:when test="${res.classesEndDate == null}">
                                            Brak
                                        </c:when>
                                        <c:otherwise>
                                            <fmt:formatDate pattern="H:mm dd.MM.yyyy" value="${res.classesEndDate }"/>
                                        </c:otherwise>
                                    </c:choose>
                                </td>
                                <td>
                                    <c:choose>
                                        <c:when test="${res.repeatClasses == 0}">
                                            Brak
                                        </c:when>
                                        <c:when test="${res.repeatClasses == 1}">
                                            Co tydzie�
                                        </c:when>
                                        <c:otherwise>
                                            Co dwa tygodnie
                                        </c:otherwise>
                                    </c:choose>
                                </td>
                                <td>
                                    <c:choose>
                                        <c:when test="${res.status == 'sent'}">
                                            Oczekuj�cy
                                        </c:when>
                                        <c:when test="${res.status == 'accepted'}">
                                            Przyj�ty
                                        </c:when>
                                        <c:otherwise>
                                            Odrzucony
                                        </c:otherwise>
                                    </c:choose>
                                </td>
                                <c:if test="${res.status == 'sent'}">
                                    <td>
                                        <form action="myreservations" method="post">
                                            <input type="text" name="action" value="delete" hidden>
                                            <input type="text" name="reservationId" value="${res.id}" hidden>
                                            <button class="btn btn-danger" type="submit">Anuluj</button>
                                        </form>
                                    </td>
                                </c:if>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</div>
</body>
</html>
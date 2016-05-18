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
    <link rel="stylesheet" href="resources/bootstrap/bootstrap.min.css">
    <script src="resources/jquery/jquery-2.2.3.js"></script>
    <script src="resources/bootstrap/bootstrap.min.js"></script>
    <title>eDziekanat - Oczekujące rezerwacje</title>
</head>
<body>
<div id="layout">
    <div id="menu">
        <div class="pure-menu">
            <a class="pure-menu-heading" href="home">eDziekanat</a>
            <ul class="pure-menu-list">
                <li class="pure-menu-item"><a href="admin" class="pure-menu-link">Strona główna</a></li>
                <li class="pure-menu-item"><a href="admintimetable" class="pure-menu-link">Plan zajęć</a></li>
                <li class="pure-menu-item menu-item-divided"><a class="pure-menu-link" href="classrooms">Dostępność
                    sal</a></li>
                <li class="pure-menu-item"><a
                        class="pure-menu-link" href="classrooms">Wybierz salę</a></li>
                <li class="pure-menu-item pure-menu-selected"><a class="pure-menu-link" href="adminreservations">Oczekujące
                    rezerwacje</a></li>
                <li class="pure-menu-item">
                    <form action="adminreservations" method="post">
                        <input type="hidden" name="action" value="history">
                        <button class="linkButton" type="submit">Historia rezerwacji</button>
                    </form>
                </li>
                <li class="pure-menu-item menu-item-divided"><a class="pure-menu-link" href="admincourses">
                    Kierunki</a></li>
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
            <h2 class="content-subhead">
                Oczekujące rezerwacje sal
            </h2>
            <br>
            <c:if test="${successMsg != null}">
                <div class="alert alert-success fade in">
                    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                    <strong>Sukces!</strong> ${successMsg}
                </div>
            </c:if>
            <c:if test="${warningMsg != null}">
                <div class="alert alert-warning fade in">
                    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                    <strong>Ostrzeżenie!</strong> ${warningMsg}
                </div>
            </c:if>
            <c:if test="${errorMsg != null}">
                <div class="alert alert-danger fade in">
                    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                    <strong>Błąd!</strong> ${errorMsg}
                </div>
            </c:if>
            <br>
            <c:choose>
                <c:when test="${empty reservationsList}">
                    <center>
                        Brak oczekujących na rozpatrzenie rezerwacji.
                    </center>
                </c:when>
                <c:otherwise>
                    <table class="table table-striped table-bordered text-center">
                        <thead>
                        <tr>
                            <td>Id</td>
                            <td>Przedmiot</td>
                            <td>Nadawca</td>
                            <td>Sala</td>
                            <td>Data wysłania</td>
                            <td>Początkowa data zajęć</td>
                            <td>Końcowa data zajęć</td>
                            <td>Powtarzanie</td>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${reservationsList}" var="res">
                            <tr>
                                <td>${res.id}</td>
                                <td>${res.subject.name}</td>
                                <td>${res.subject.lecturer.name} ${res.subject.lecturer.surname}</td>
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
                                            Co tydzień
                                        </c:when>
                                        <c:otherwise>
                                            Co dwa tygodnie
                                        </c:otherwise>
                                    </c:choose>
                                </td>
                                <td>
                                    <form action="managereservations" method="post">
                                        <input type="hidden" name="action" value="accepted">
                                        <input type="hidden" name="getPage" value="${currentPage}">
                                        <input type="text" name="reservationId" value="${res.id}" hidden>
                                        <button class="btn btn-success" type="submit">Akceptuj</button>
                                    </form>
                                </td>
                                <td>
                                    <form action="managereservations" method="post">
                                        <input type="hidden" name="action" value="rejected">
                                        <input type="hidden" name="getPage" value="${currentPage}">
                                        <input type="text" name="reservationId" value="${res.id}" hidden>
                                        <button class="btn btn-danger" type="submit">Odrzuć</button>
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>

                    <div style="margin-top: 10px; margin-left: 47%" class="btn-toolbar" role="toolbar">
                        <div class="btn-group" role="group" aria-label="1">
                            <c:forEach begin="1" end="${pagesNumber}" varStatus="loop">
                            <c:choose>
                            <c:when test="${(loop.index-1)==currentPage}">
                            <form style="width:30px;height:30px;padding:0" class="btn btn-primary"
                                  action="adminreservations" method=post>
                                </c:when>
                                <c:otherwise>
                                <form style="width:30px;height:30px;padding:0" class="btn btn-default"
                                      action="adminreservations" method=post>
                                    </c:otherwise>
                                    </c:choose>
                                    <input type="hidden" name="action" value="history">
                                    <input type="hidden" name="getPage" value="${loop.index - 1}">
                                    <button style="margin:0px; padding: 0; border:0;background: none; width: 30px; height: 30px"
                                            type="submit">${loop.index}</button>
                                </form>
                                </c:forEach>
                        </div>
                    </div>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</div>
</body>
</html>
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
    <title>eDziekanat - Administrator - Plan zaj��</title>
</head>
<body>
<div id="layout">
    <div id="menu">
        <div class="pure-menu">
            <a class="pure-menu-heading" href="home">eDziekanat</a>
            <ul class="pure-menu-list">
                <li class="pure-menu-item"><a href="admin"
                                              class="pure-menu-link">Strona g��wna</a></li>
                <li class="pure-menu-item"><a href="admintimetable"
                                              class="pure-menu-link menu-item-divided">Plan zaj��</a></li>
                <c:choose>
                    <c:when test="${noStudentGroup == true}">
                        <li class="pure-menu-item pure-menu-selected"><a
                                class="pure-menu-link" href="#">Wybierz grup�</a></li>
                    </c:when>
                    <c:otherwise>
                        <li class="pure-menu-item">
                            <form action="admintimetable" method="post">
                                <input type="hidden" name="rqweek" value="${selectedWeek - 1}">
                                <input type="hidden" name="studentsGroupId"
                                       value="${selectedStudentGroup.id}">
                                <button class="linkButton " type="submit">Poprzedni
                                    tydzie�
                                </button>
                            </form>
                        </li>
                        <li class="pure-menu-item pure-menu-selected"><a href="#"
                                                                         class="pure-menu-link"> <c:choose>
                            <c:when test="${currentWeek == true}">Aktualny tydzie�</c:when>
                            <c:otherwise>Tydzie� ${selectedWeek}</c:otherwise>
                        </c:choose>
                        </a></li>
                        <li class="pure-menu-item">
                            <form action="admintimetable" method="post">
                                <input type="hidden" name="studentsGroupId"
                                       value="${selectedStudentGroup.id}"> <input
                                    type="hidden" name="rqweek" value="${selectedWeek + 1}">
                                <button class="linkButton" type="submit">Nast�pny
                                    tydzie�
                                </button>
                            </form>
                        </li>
                        <li class="pure-menu-item">
                            <form action="planclasses" method="post">
                                <input type="hidden" name="studentsGroupId"
                                       value="${selectedStudentGroup.id}">
                                <button class="linkButton" type="submit">Zaplanuj nowe
                                    zaj�cia
                                </button>
                            </form>
                        </li>
                    </c:otherwise>
                </c:choose>
                <li class="pure-menu-item menu-item-divided"><a
                        class="pure-menu-link" href="classrooms">Dost�pno�� sal</a></li>
                <li class="pure-menu-item"><a class="pure-menu-link"
                                              href="admincourses">Kierunki</a></li>
                <li class="pure-menu-item"><a class="pure-menu-link"
                                              href="adminstudentgroups">Grupy studenckie</a></li>
                <li class="pure-menu-item"><a class="pure-menu-link"
                                              href="adminlecturers">Wyk�adowcy</a></li>
                <li class="pure-menu-item"><a class="pure-menu-link"
                                              href="adminsubjects">Przedmioty</a></li>
                <li class="pure-menu-item"><a class="pure-menu-link"
                                              href="adminstudents">Studenci</a></li>
                <li class="pure-menu-item"><a class="pure-menu-link"
                                              href="marksstatistics">Statystyki</a></li>
                <li class="pure-menu-item"><a class="pure-menu-link"
                                              href="adminscholarships">Stypendia</a></li>
                <li class="pure-menu-item"><a class="pure-menu-link"
                                              href="adminpayments">Nale�no�ci</a></li>
                <li class="pure-menu-item"><a class="pure-menu-link"
                                              href="adminapplications">Wnioski</a></li>
                <li class="pure-menu-item"><a class="pure-menu-link"
                                              href="receivedmessages">Historia komunikat�w</a></li>
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
            <h2 class="content-subhead">Zaj�cia grupy studenckiej:
                ${selectedStudentGroup.id} kierunek:
                ${selectedStudentGroup.course.name }</h2>

            <form class="pure-form" action="admintimetable" method=post>
                <fieldset>
                    <center>
                        <select name="studentsGroupId" id="state">
                            <c:forEach items="${studentsGroupList}" var="sg">
                                <option
                                        <c:if test="${selectedStudentGroup.id == sg.id}">selected</c:if>
                                        value="${sg.id}">Grupa: ${sg.id} Kierunek:
                                        ${sg.course.name }</option>
                            </c:forEach>
                        </select>
                        <button type="submit" class="pure-button pure-button-primary">Wy�wietl</button>
                    </center>
                </fieldset>
            </form>
            <br> <br>
            <c:choose>
                <c:when test="${emptyWeek == true}">
                    <center>Plan zaj�� na ${selectedWeek} tydzie� roku dla
                        grupy studenckiej ${selectedStudentGroup.id} jest pusty.
                    </center>
                </c:when>
                <c:when test="${noStudentGroup == true}">
                    <center>Wybierz grup� studenck� z powy�szej listy.</center>
                </c:when>
                <c:otherwise>
                    <table class="table table-striped timetableTable table-bordered">
                        <thead>
                        <tr class="info">
                            <td>Godziny<br></td>
                            <td>Poniedzia�ek<br> <fmt:formatDate pattern="dd.MM.yyyy" value="${dayDates[0]}"/></td>
                            <td>Wtorek<br> <fmt:formatDate pattern="dd.MM.yyyy" value="${dayDates[1]}"/></td>
                            <td>�roda<br> <fmt:formatDate pattern="dd.MM.yyyy" value="${dayDates[2]}"/></td>
                            <td>Czwartek<br> <fmt:formatDate pattern="dd.MM.yyyy" value="${dayDates[3]}"/></td>
                            <td>Pi�tek<br> <fmt:formatDate pattern="dd.MM.yyyy" value="${dayDates[4]}"/></td>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach begin="0" end="${fn:length(classesStart) - 1}" varStatus="i">
                            <tr>
                                <td>
                                    <fmt:formatDate pattern="H:mm" value="${classesStart[i.index]}"/>
                                    - <fmt:formatDate pattern="H:mm" value="${classesEnd[i.index]}"/>
                                </td>
                                <c:forEach begin="0" end="4" varStatus="j">
                                    <td>
                                        <c:if test="${rsClasses[j.index][i.index] != null}">
                                            <a data-toggle="popover" data-trigger="focus" tabindex="0"
                                               data-placement="auto bottom" data-html="true"
                                               title="${rsClasses[j.index][i.index].subject.name}"
                                               data-content="
                                               ${groups[j.index][i.index]}<br />
                                               ${courses[j.index][i.index]}<br />
                                               ${lecturers[j.index][i.index]}<br />
                                               sala: ${rsClasses[j.index][i.index].classroom.number}<br />
                                               <center><form action='deleteclasses' method='post'>
                                                    <input type='hidden' name='classes' value='${rsClasses[j.index][i.index].id}'>
                                                    <input class='btn btn-danger' type='submit' value='Usu�'>
                                                </form></center>
                                                ">
                                                    ${rsClasses[j.index][i.index].subject.name}
                                            </a>
                                        </c:if>
                                    </td>
                                </c:forEach>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</div>
<script>
    $('[data-toggle="popover"]').popover();
</script>
</body>
</html>
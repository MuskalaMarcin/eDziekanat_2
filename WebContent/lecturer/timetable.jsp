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
    <title>eDziekanat - Plan zajęć</title>
</head>
<body>
<div id="layout">
    <div id="menu">
        <div class="pure-menu">
            <a class="pure-menu-heading" href="home">eDziekanat</a>
            <ul class="pure-menu-list">
                <li class="pure-menu-item"><a
                        class="pure-menu-link" href="lecturer">Strona główna</a></li>
                <li class="pure-menu-item"><a class="pure-menu-link"
                                              href="lecturerlearningmaterials">Materiały dydaktyczne</a></li>
                <li class="pure-menu-item"><a class="pure-menu-link"
                                              href="lecturerseestudents">Studenci</a></li>
                <li class="pure-menu-item"><a class="pure-menu-link"
                                              href="lecturerseelecturers">Wykładowcy</a></li>
                <li class="pure-menu-item"><a class="pure-menu-link"
                                              href="classrooms">Dostępność sal</a></li>
                <li class="pure-menu-item menu-item-divided"><a
                        href="timetable" class="pure-menu-link">Plan zajęć</a></li>
                <li class="pure-menu-item">
                    <form action="timetable" method="post">
                        <input type="hidden" name="rqweek" value="${selectedWeek - 1}">
                        <button class="linkButton " type="submit">Poprzedni
                            tydzień
                        </button>
                    </form>
                </li>
                <li class="pure-menu-item pure-menu-selected"><a href="#"
                                                                 class="pure-menu-link"> <c:choose>
                    <c:when test="${currentWeek == true}">Aktualny tydzień</c:when>
                    <c:otherwise>Tydzień ${selectedWeek}</c:otherwise>
                </c:choose>
                </a></li>
                <li class="pure-menu-item">
                    <form action="timetable" method="post">
                        <input type="hidden" name="rqweek" value="${selectedWeek + 1}">
                        <button class="linkButton" type="submit">Następny
                            tydzień
                        </button>
                    </form>
                </li>
                <li class="pure-menu-item menu-item-divided"><a
                        class="pure-menu-link" href="lecturersubjects">Moje przedmioty</a></li>
                <li class="pure-menu-item"><a class="pure-menu-link"
                                              href="receivedmessages">Historia komunikatów</a></li>
                <li class="pure-menu-item"><a class="pure-menu-link" href="lecturermydata">Moje dane</a></li>
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
            <h2 class="content-subhead">Plan zajęć:</h2>

            <c:choose>
                <c:when test="${emptyWeek==true}">
                    <center>Plan zajęć na ${selectedWeek} tydzień roku jest
                        pusty.
                    </center>
                </c:when>
                <c:otherwise>
                    <table class="table table-striped timetableTable table-bordered">
                        <thead>
                        <tr class="info">
                            <td>Godziny<br></td>
                            <td>Poniedziałek<br> <fmt:formatDate pattern="dd.MM.yyyy" value="${dayDates[0]}"/></td>
                            <td>Wtorek<br> <fmt:formatDate pattern="dd.MM.yyyy" value="${dayDates[1]}"/></td>
                            <td>Środa<br> <fmt:formatDate pattern="dd.MM.yyyy" value="${dayDates[2]}"/></td>
                            <td>Czwartek<br> <fmt:formatDate pattern="dd.MM.yyyy" value="${dayDates[3]}"/></td>
                            <td>Piątek<br> <fmt:formatDate pattern="dd.MM.yyyy" value="${dayDates[4]}"/></td>
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
                                            <a data-toggle="popover" data-trigger="click" tabindex="0"
                                               data-placement="auto bottom" data-html="true"
                                               title="${rsClasses[j.index][i.index].subject.name}"
                                               data-content="${groups[j.index][i.index]}<br />
                                               ${courses[j.index][i.index]}<br />
                                               sala: ${rsClasses[j.index][i.index].classroom.number}<br />
                                               <div id='seeTopic'>
                                               temat:
                                               <c:choose>
                                                    <c:when test="${rsClasses[j.index][i.index].topic == null}">Brak</c:when>
                                                    <c:otherwise>${rsClasses[j.index][i.index].topic}</c:otherwise>
                                                </c:choose><br>
                                                <center>
                                                <button type='button' class='btn btn-warning btn-sm'>Edytuj</button>
                                                </center>
                                                </div>
                                                <div id='editTopic' style='display:none'>
                                                 <form class='form-horizontal' role='form'>
                                                    <div class='form-group'>
                                                        <label style='font-weight: normal !important' class='control-label col-sm-2' for='topic'>temat: </label>
                                                <div class='col-sm-10'>
                                                    <input type='topic' class='form-control' id='topic' placeholder='     <c:choose>
                                               <c:when test="${rsClasses[j.index][i.index].topic == null}">Brak</c:when>
                                                <c:otherwise>${rsClasses[j.index][i.index].topic}</c:otherwise>
                                            </c:choose>'>
                                                </div>
                                            </div>
                                            <center>
                                              <div class='form-group'>
                                               <button type='submit' class='btn btn-success btn-sm'>Zapisz</button>
                                              </div>
                                              </center>
                                            </form>
                                                </div>
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
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
    <link rel="stylesheet" href="resources/bootstrap/bootstrap-datepicker3.standalone.css">
    <script src="resources/bootstrap/bootstrap-datepicker.js"></script>
    <script src="resources/timetable.js"></script>
    <title>eDziekanat - Dostępność sali</title>
</head>
<body onload="setMultipleDatePickers()">
<div id="layout">
    <div id="menu">
        <div class="pure-menu">
            <a class="pure-menu-heading" href="home">eDziekanat</a>
            <ul class="pure-menu-list">
                <li class="pure-menu-item"><a class="pure-menu-link"
                                              href="lecturer">Strona główna</a></li>
                <li class="pure-menu-item"><a class="pure-menu-link"
                                              href="lecturerlearningmaterials">Materiały dydaktyczne</a></li>
                <li class="pure-menu-item"><a class="pure-menu-link"
                                              href="lecturerseestudents">Studenci</a></li>
                <li class="pure-menu-item"><a class="pure-menu-link"
                                              href="lecturerseelecturers">Wykładowcy</a></li>
                <li class="pure-menu-item menu-item-divided"><a
                        class="pure-menu-link" href="classrooms">Dostępność
                    sal</a></li>
                <c:choose>
                    <c:when test="${noClassroom == true}">
                        <li class="pure-menu-item pure-menu-selected"><a
                                class="pure-menu-link" href="#">Wybierz salę</a></li>
                    </c:when>
                    <c:otherwise>
                        <li class="pure-menu-item">
                            <form action="classrooms" method="post">
                                <input type="hidden" name="rqweek" value="${selectedWeek - 1}">
                                <input type="hidden" name="classroomId"
                                       value="${selectedClassroom.number}">
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
                            <form action="classrooms" method="post">
                                <input type="hidden" name="classroomId"
                                       value="${selectedClassroom.number}"> <input
                                    type="hidden" name="rqweek" value="${selectedWeek + 1}">
                                <button class="linkButton" type="submit">Następny
                                    tydzień
                                </button>
                            </form>
                        </li>
                    </c:otherwise>
                </c:choose>
                <li class="pure-menu-item"><a
                        class="pure-menu-link" href="myreservations">Moje rezerwacje</a></li>
                <li class="pure-menu-item  menu-item-divided"><a
                        href="timetable" class="pure-menu-link">Plan zajęć</a></li>
                <li class="pure-menu-item "><a class="pure-menu-link"
                                               href="lecturersubjects">Moje przedmioty</a></li>
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
            <h3 class="content-subhead">
                Dostępność sali: ${selectedClassroom.faculty.name}
                <c:if test="${!empty selectedClassroom }"> sala: </c:if>
                ${selectedClassroom.number}
            </h3>

            <form class="pure-form"
                  action="classrooms" method=post>
                <fieldset>
                    <center>
                        <select name="classroomId" id="state">
                            <c:forEach items="${classroomsList}" var="classroom">
                                <option
                                        <c:if test="${selectedClassroom.id == classroom.id}">selected</c:if>
                                        value="${classroom.id}">${classroom.faculty.name}
                                    Sala ${classroom.number}</option>
                            </c:forEach>
                        </select>
                        <button type="submit"
                                class="pure-button pure-button-primary">Wyświetl
                        </button>
                    </center>
                </fieldset>
            </form>
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
                    <strong>Błąd!</strong> ${errorMsg}
                </div>
            </c:if>
            <br>
            <c:choose>
                <c:when test="${noClassroom == true}">
                    <center>Wybierz salę z powyższej listy.</center>
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
                        <jsp:useBean id="now" class="java.util.Date"/>
                        <c:forEach begin="0" end="${fn:length(classesStart) - 1}" varStatus="i">
                            <tr>
                                <td>
                                    <fmt:formatDate pattern="H:mm" value="${classesStart[i.index]}"/>
                                    - <fmt:formatDate pattern="H:mm" value="${classesEnd[i.index]}"/>
                                </td>
                                <c:forEach begin="0" end="4" varStatus="j">
                                    <td>
                                        <c:choose>
                                        <c:when test="${rsClasses[j.index][i.index] != null}">
                                            <a data-toggle="popover" data-trigger="focus" tabindex="0"
                                               data-placement="auto bottom" data-html="true"
                                               title="${rsClasses[j.index][i.index].subject.name}"
                                               data-content="${groups[j.index][i.index]}<br />${courses[j.index][i.index]}<br />${lecturers[j.index][i.index]}">
                                                    ${rsClasses[j.index][i.index].subject.name}</a>
                                        </c:when>
                                        <c:when test="${reservations[j.index][i.index] != null}">
                                            <a data-toggle="popover" data-trigger="focus" tabindex="0"
                                               data-placement="auto bottom" data-html="true" title="REZERWACJA"
                                               data-content="Przedmiot: ${reservations[j.index][i.index].subject.name}<br />
                                                   Wykładowca: ${reservations[j.index][i.index].subject.lecturer.name}
                                                   ${reservations[j.index][i.index].subject.lecturer.surname}">
                                                REZERWACJA</a>
                                        </c:when>
                                        <c:when test="${dayDates[j.index] gt now}">
                                        <button type="button" class="btn btn-default btn-sm" data-toggle="modal"
                                                data-target="#modalWindow_${i.index}_${j.index}">Zarezerwuj
                                        </button>
                                        <div class="modal fade" id="modalWindow_${i.index}_${j.index}" role="dialog">
                                            <div class="modal-dialog" style="width: 700px">
                                                <div class="modal-content">
                                                    <div class="modal-header">
                                                        <button type="button" class="close"
                                                                data-dismiss="modal">&times;</button>
                                                        <h4 class="modal-title">Zarezerwuj salę</h4>
                                                    </div>

                                                    <form class="form-horizontal" role="form" method="post"
                                                          action="reserveclasses">
                                                        <input type="hidden" name="classroomId"
                                                               value="${selectedClassroom.number}">
                                                        <input type="hidden" name="rqweek"
                                                               value="${selectedWeek}">
                                                        <div class="modal-body">
                                                            <div class="form-group">
                                                                <label class="col-sm-3 control-label"
                                                                       for="subjectId">Przedmiot</label>
                                                                <div class="col-sm-9">
                                                                    <select class="form-control" id="subjectId"
                                                                            name="subjectId">
                                                                        <c:forEach items="${subjects}"
                                                                                   var="subject">
                                                                            <option value="${subject.id}">${subject.name}</option>
                                                                        </c:forEach>
                                                                    </select>
                                                                </div>
                                                            </div>

                                                            <div class="form-group">
                                                                <label class="col-sm-3 control-label"
                                                                       for="classroomId">Sala</label>
                                                                <div class="col-sm-9">
                                                                    <input type="text" value="${subject.id}"
                                                                           hidden name="classroomId">
                                                                    <input id="classroomId"
                                                                           class="form-control" type="text"
                                                                           value=" Nr: ${selectedClassroom.number} typ: ${selectedClassroom.type }"
                                                                           readonly>
                                                                </div>
                                                            </div>

                                                            <div class="form-group">
                                                                <label class="col-sm-3 control-label"
                                                                       for="repeat_${i.index}_${j.index}">Powtarzaj</label>
                                                                <div class="col-sm-9">
                                                                    <select class="form-control" name="repeat"
                                                                            id="repeat_${i.index}_${j.index}"
                                                                            onchange="showHideEndDate(${i.index}, ${j.index})">
                                                                        <option value="0">Nie powtarzaj</option>
                                                                        <option value="1">Co tydzień</option>
                                                                        <option value="2">Co dwa tygodnie
                                                                        </option>
                                                                    </select>
                                                                </div>
                                                            </div>

                                                            <div class="form-group">
                                                                <label class="col-sm-3 control-label"
                                                                       for="startTime">Godzina
                                                                    rozpoczęcia</label>
                                                                <div class="col-sm-9">
                                                                    <select class="form-control" name="startTime" id="startTime">
                                                                        <option value="0" <c:if test="${i.index == 0}">selected</c:if>>7:30</option>
                                                                        <option value="1" <c:if test="${i.index == 1}">selected</c:if>>9:15</option>
                                                                        <option value="2" <c:if test="${i.index == 2}">selected</c:if>>11:00</option>
                                                                        <option value="3" <c:if test="${i.index == 3}">selected</c:if>>12:45</option>
                                                                        <option value="4" <c:if test="${i.index == 4}">selected</c:if>>14:30</option>
                                                                        <option value="5" <c:if test="${i.index == 5}">selected</c:if>>16:15</option>
                                                                        <option value="6" <c:if test="${i.index == 6}">selected</c:if>>18:00</option>
                                                                        <option value="7" <c:if test="${i.index == 7}">selected</c:if>>19:45</option>
                                                                    </select>
                                                                </div>
                                                            </div>

                                                            <div class="input-daterange input-group datepickers"
                                                                 id="datepicker_${i.index}_${j.index}">
                                                                <div class="form-group">
                                                                    <label class="col-sm-3 control-label"
                                                                           id="startDateLabel"
                                                                           for="startDate_${i.index}_${j.index}">Data
                                                                        rozpoczęcia </label>
                                                                    <div class="col-sm-9">
                                                                        <input id="startDate_${i.index}_${j.index}"
                                                                               style="border-radius: 4px; text-align: left"
                                                                               type="text"
                                                                               value="<fmt:formatDate pattern="dd.MM.yyyy" value="${dayDates[j.index]}"/>"
                                                                               class="form-control pure-input-1-2 "
                                                                               name="startDate"/>
                                                                    </div>
                                                                </div>
                                                                <div class="form-group">
                                                                    <label class="col-sm-3 control-label"
                                                                           id="endDateLabel_${i.index}_${j.index}"
                                                                           style="display:none"
                                                                           for="endDate_${i.index}_${j.index}">Data
                                                                        zakończenia </label>
                                                                    <div class=" col-sm-9">
                                                                        <input id="endDate_${i.index}_${j.index}"
                                                                               style="display:none; border-radius: 4px; text-align: left"
                                                                               type="text"
                                                                               class="form-control pure-input-1-2"
                                                                               name="endDate"/>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="modal-footer">
                                                            <button type="button" class="btn btn-default"
                                                                    data-dismiss="modal">Anuluj
                                                            </button>
                                                            <button type="submit" class="btn btn-primary">
                                                                Wyślij
                                                            </button>
                                                        </div>
                                                    </form>
                                                </div>
                                            </div>
                                            </c:when>
                                            </c:choose>
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
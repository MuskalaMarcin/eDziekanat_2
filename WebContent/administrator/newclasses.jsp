<%@ page language="java" contentType="text/html; charset=ISO-8859-2"
         pageEncoding="ISO-8859-2" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-2">
    <link rel="stylesheet" href="resources/pure-min.css">
    <link rel="stylesheet" href="resources/bootstrap/bootstrap.min.css">
    <link rel="stylesheet" href="resources/bootstrap/bootstrap-datepicker3.standalone.css">
    <script src="resources/jquery/jquery-2.2.3.js"></script>
    <script src="resources/bootstrap/bootstrap.min.js"></script>
    <script src="resources/bootstrap/bootstrap-datepicker.js"></script>
    <link rel="stylesheet" href="resources/styles.css">
    <title>eDziekanat - Administrator - Nowe zajęcia</title>

    <script type="text/javascript">
        function showHideEndDate() {
            var endDateLabel = document.getElementById("endDateLabel");
            var endDateInput = document.getElementById("endDate");

            if (document.getElementById("repeat").value > 0) {
                endDateLabel.style.display = "block";
                endDateInput.style.display = "block";
                endDateInput.required = true;
            }
            else {
                endDateLabel.style.display = "none";
                endDateInput.style.display = "none";
                endDateInput.required = false;
            }
        }

        function setDatePicker() {
            var minDate = new Date();
            $('#datepicker').datepicker({
                language: "pl",
                format: "dd.mm.yyyy",
                startDate: ("0" + minDate.getDate()).slice(-2) + "." + ("0" + (minDate.getMonth() + 1)).slice(-2) + "." + minDate.getFullYear(),
                daysOfWeekDisabled: "0,6",
                autoclose: true,
                orientation: "bottom auto",
                todayHighlight: true,
                toggleActive: true
            });
        }
    </script>
</head>
<body onload="setDatePicker()">
<div id="layout">
    <div id="menu">
        <div class="pure-menu">
            <a class="pure-menu-heading" href="home">eDziekanat</a>
            <ul class="pure-menu-list">
                <li class="pure-menu-item">
                    <a href="admin" class="pure-menu-link">Strona główna</a>
                </li>
                <li class="pure-menu-item">
                    <a href="admintimetable" class="pure-menu-link menu-item-divided">Plan zajęć</a>
                </li>
                <li class="pure-menu-item">
                    <form action="admintimetable" method="post">
                        <input type="hidden" name="studentsGroupId"
                               value="${studentsGroup.id}">
                        <button class="linkButton " type="submit">Pokaż plan</button>
                    </form>
                </li>
                <li class="pure-menu-item pure-menu-selected"><a class="pure-menu-link" href="#">Zaplanuj
                    nowe zajęcia</a></li>

                <li class="pure-menu-item menu-item-divided"><a
                        class="pure-menu-link" href="classrooms">Dostępność sal</a></li>
                <li class="pure-menu-item"><a class="pure-menu-link"
                                              href="admincourses">Kierunki</a></li>
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
            <h2 class="content-subhead">Nowe zajęcia dla grupy:
                ${studentsGroup.id} kierunek: ${studentsGroup.course.name }</h2>
            <center>
                <form class="pure-form pure-form-stacked" action="addnewclasses">
                    <fieldset>

                        <label for="sg">Grupa studencka </label>
                        <input id="sg" type="text" name="nothing" class="pure-input-1-2" style="width: 50%"
                               value="grupa: ${studentsGroup.id} kierunek: ${studentsGroup.course.name }"
                               disabled> <label for="state">Przedmiot </label>
                        <select name="subjectId" style="width: 50%" id="state">
                            <c:forEach items="${subjects}" var="subject">
                                <option value="${subject.id}">${subject.name}</option>
                            </c:forEach>
                        </select>
                        <label for="classstate">Sala </label>
                        <select style="width: 50%" name="classroomId" id="classstate">
                            <c:forEach items="${classrooms}" var="classroom">
                                <option value="${classroom.id}">Nr:
                                        ${classroom.number} typ: ${classroom.type }</option>
                            </c:forEach>
                        </select>

                        <label for="repeat">Powtarzaj </label>
                        <select style="width:219px" name="repeat" id="repeat" onchange="showHideEndDate()">
                            <option value="0">Nie powtarzaj</option>
                            <option value="1">Co tydzień</option>
                            <option value="2">Co dwa tygodnie</option>
                        </select>

                        <label for="startTime">Godzina rozpoczęcia</label>
                        <select style="width:219px" name="startTime" id="startTime">
                            <option value="0">7:30</option>
                            <option value="1">9:15</option>
                            <option value="2">11:00</option>
                            <option value="3">12:45</option>
                            <option value="4">14:30</option>
                            <option value="5">16:15</option>
                            <option value="6">18:00</option>
                            <option value="7">19:45</option>
                        </select>

                        <div style="width: 219px" class="input-daterange input-group" id="datepicker">
                            <label id="startDateLabel" for="startDate">Data rozpoczęcia </label>
                            <input id="startDate" style="width: 219px; border-radius: 4px" type="text" class="input-sm form-control pure-input-1-2 " name="startDate" required/>
                            <label id="endDateLabel" style="display:none" for="endDate">Data zakończenia </label>
                            <input id="endDate" style="width: 219px; display:none; border-radius: 4px" type="text" class="input-sm form-control pure-input-1-2 " name="endDate"/>
                        </div>
                    </fieldset>

                    <button type=" submit"
                            class="pure-button pure-input-1-2 pure-button-primary">Wyślij
                    </button>
                </form>
            </center>
        </div>
    </div>
</div>
</body>
</html>
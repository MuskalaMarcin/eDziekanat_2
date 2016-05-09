<%@ page language="java"
         import="edziekanat.databasemodel.dao.UserDAO, edziekanat.databasemodel.dto.UserDTO"
         contentType="text/html; charset=ISO-8859-2" pageEncoding="ISO-8859-2" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-2">
    <link rel="stylesheet"
          href="http://localhost:8080/edziekanat/resources/pure-min.css">
    <link rel="stylesheet"
          href="http://localhost:8080/edziekanat/resources/styles.css">
    <title>eDziekanat - Student - Nowy wniosek</title>
</head>
<body>
<div id="layout">
    <div id="menu">
        <div class="pure-menu">
            <a class="pure-menu-heading" href="home">eDziekanat</a>
            <ul class="pure-menu-list">
                <li class="pure-menu-item"><a href="http://localhost:8080/edziekanat/student"
                                              class="pure-menu-link">Strona główna</a></li>
                <li class="pure-menu-item"><a href="http://localhost:8080/edziekanat/studenttranscript"
                                              class="pure-menu-link">Indeks</a></li>
                <li class="pure-menu-item"><a href="http://localhost:8080/edziekanat/timetable"
                                              class="pure-menu-link">Plan zajęć</a></li>
                <li class="pure-menu-item"><a href="http://localhost:8080/edziekanat/studentsubjects"
                                              class="pure-menu-link">Moje przedmioty</a></li>
                <li class="pure-menu-item"><a href="http://localhost:8080/edziekanat/studentscholarships"
                                              class="pure-menu-link">Stypendia</a></li>
                <li class="pure-menu-item"><a href="http://localhost:8080/edziekanat/studentpayments"
                                              class="pure-menu-link">Płatności</a></li>
                <li class="pure-menu-item menu-item-divided">
                    <a href="#" class="pure-menu-link">Wnioski </a></li>
                <li class="pure-menu-item"><a href="http://localhost:8080/edziekanat/studentapplications"
                                              class="pure-menu-link">Wnioski rozpatrzone </a></li>
                <li class="pure-menu-item"><a href="http://localhost:8080/edziekanat/studentwaitingapplications"
                                              class="pure-menu-link">Wnioski nierozpatrzone</a></li>
                <li class="pure-menu-item  pure-menu-selected"><a href="studentgetadministartors"
                                                                  class="pure-menu-link">Nowy wniosek</a></li>
                <li class="pure-menu-item"><a href="http://localhost:8080/edziekanat/studentlecturers"
                                              class="pure-menu-link">Wykładowcy</a></li>
                <li class="pure-menu-item"><a href="http://localhost:8080/edziekanat/messages"
                                              class="pure-menu-link">Historia komunikatów</a></li>
                <li class="pure-menu-item"><a href="http://localhost:8080/edziekanat/logout"
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
            <h2 class="content-subhead">Wyślij nowy wniosek:</h2>
            <p>
            <p>
            <center>
                <form action="http://localhost:8080/edziekanat/studentnewapplication" method=post class="pure-form">
                    <c:choose>
                        <c:when test="${!empty adminList}">
                            <fieldset class="pure-group">
                                <label for="select1">Adresat:
                                    <select id="select1" name="id">
                                        <c:forEach items="${adminList}" var="admin"
                                                   varStatus="varStatus">
                                            <option value="${admin.id}">${admin.name}
                                                    ${admin.surname}</option>
                                        </c:forEach>
                                    </select>
                                </label>
                            </fieldset>
                        </c:when>
                    </c:choose>
                    <c:choose>
                        <c:when test="${!empty typeList}">
                            <fieldset class="pure-group">
                                <label for="select2">Typ:
                                    <select id="select2" name="type">
                                        <c:forEach items="${typeList}" var="type"
                                                   varStatus="varStatus2">
                                            <option value="${type.type_id}">${type.type_name}</option>
                                        </c:forEach>
                                    </select>
                                </label>
                            </fieldset>
                        </c:when>
                    </c:choose>
                    <fieldset class="pure-group">
                        <input type="text" name="title" class="pure-input-1-2"
                               placeholder="Tytuł" required>
							<textarea name="content" class="pure-input-1-2"
                                      placeholder="Treść" required></textarea>
                    </fieldset>
                    <button type="submit"
                            class="pure-button pure-input-1-2 pure-button-primary">Wyślij
                    </button>
                </form>
            </center>
        </div>
    </div>
</div>
</body>
</html>
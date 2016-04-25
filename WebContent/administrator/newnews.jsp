<%@ page language="java" contentType="text/html; charset=ISO-8859-2"
         pageEncoding="ISO-8859-2" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-2">
    <link rel="stylesheet"
          href="http://localhost:8080/edziekanat/resources/pure-min.css">
    <link rel="stylesheet"
          href="http://localhost:8080/edziekanat/resources/styles.css">
    <title>eDziekanat - Administrator - Nowe og�oszenie</title>
</head>
<body>
<div id="layout">
    <div id="menu">
        <div class="pure-menu">
            <a class="pure-menu-heading" href="home">eDziekanat</a>
            <ul class="pure-menu-list">
                <li class="pure-menu-item"><a href="http://localhost:8080/edziekanat/admin"
                                              class="pure-menu-link">Strona g��wna</a></li>
                <li class="pure-menu-item"><a href="http://localhost:8080/edziekanat/admintimetable"
                                              class="pure-menu-link">Plan zaj��</a></li>
                <li class="pure-menu-item"><a class="pure-menu-link"
                                              href="http://localhost:8080/edziekanat/adminclassrooms">Dost�pno�� sal</a>
                </li>
                <li class="pure-menu-item"><a class="pure-menu-link"
                                              href="http://localhost:8080/edziekanat/admincourses">Kierunki</a></li>
                <li class="pure-menu-item"><a class="pure-menu-link"
                                              href="http://localhost:8080/edziekanat/adminstudentgroups">Grupy
                    studenckie</a></li>
                <li class="pure-menu-item"><a class="pure-menu-link"
                                              href="http://localhost:8080/edziekanat/adminlecturers">Wyk�adowcy</a></li>
                <li class="pure-menu-item"><a class="pure-menu-link"
                                              href="http://localhost:8080/edziekanat/adminsubjects">Przedmioty</a></li>
                <li class="pure-menu-item"><a class="pure-menu-link"
                                              href="http://localhost:8080/edziekanat/adminstudents">Studenci</a></li>
                <li class="pure-menu-item"><a class="pure-menu-link"
                                              href="http://localhost:8080/edziekanat/marksstatistics">Statystyki</a>
                </li>
                <li class="pure-menu-item"><a class="pure-menu-link"
                                              href="http://localhost:8080/edziekanat/adminscholarships">Stypendia</a>
                </li>
                <li class="pure-menu-item"><a class="pure-menu-link"
                                              href="http://localhost:8080/edziekanat/adminpayments">Nale�no�ci</a></li>
                <li class="pure-menu-item"><a class="pure-menu-link"
                                              href="http://localhost:8080/edziekanat/adminapplications">Wnioski</a></li>
                <li class="pure-menu-item"><a
                        href="http://localhost:8080/edziekanat/receivedmessages"
                        class="pure-menu-link">Historia komunikat�w</a></li>
                <li class="pure-menu-item menu-item-divided"><a class="pure-menu-link"
                                              href="http://localhost:8080/edziekanat/news">Og�oszenia</a></li>
                <li class="pure-menu-item pure-menu-selected"><a class="pure-menu-link"
                                                                 href="#">Nowe og�oszenie</a></li>
                <li class="pure-menu-item"><a
                        href="http://localhost:8080/edziekanat/logout"
                        class="pure-menu-link">Wyloguj</a>
            </ul>
        </div>
    </div>
    <div id="main">
        <div class="header">
            <h1>eDziekanat</h1>
            <h2>Tw�j wirtualny dziekanat.</h2>
        </div>
        <div class="content">
            <h2 class="content-subhead">Dodaj nowe og�oszenie:</h2>
            <p>
            <p>
            <center>
                <form action="http://localhost:8080/edziekanat/adminaddnews"
                      method=post class="pure-form">
                    <fieldset class="pure-group">
                        <input type="text" name="title" class="pure-input-1-2"
                               placeholder="Tytu� og�oszenia" required>
                    </fieldset>

                    <fieldset class="pure-group">
							<textarea name="content" class="pure-input-1-2"
                                      placeholder="Tre��" required></textarea>
                    </fieldset>
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

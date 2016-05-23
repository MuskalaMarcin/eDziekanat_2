<%@ page language="java"
         import="edziekanat.databasemodel.dto.ApplicationDTO, java.util.List"
         contentType="text/html; charset=ISO-8859-2" pageEncoding="ISO-8859-2"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-2">
    <link rel="stylesheet" href="resources/pure-min.css">
    <link rel="stylesheet" href="resources/styles.css">
    <title>eDziekanat - Zmiana hasła</title>
    <script type="text/javascript">
        function validate() {
            var password = document.newpassword.password;
            var passwordrepeat = document.newpassword.passwordrepeat;
            var errorText1 = document.getElementById("errorText1");
            var errorText2 = document.getElementById("errorText2");

            errorText1.style.display = "none";
            errorText2.style.display = "none";

            if (password.value === passwordrepeat.value) {
                if (password.value.length >= 5) {
                    return true;
                }
                else
                {
                    errorText2.style.display = "block";
                    return false;
                }
            }
            else
            {
                errorText1.style.display = "block";
                return false;
            }
        }
    </script>
</head>
<body>
<div id="layout">
    <div id="menu">
        <div class="pure-menu">
            <a class="pure-menu-heading" href="home">eDziekanat</a>
            <ul class="pure-menu-list">
                <li class="pure-menu-item"><a href="student"
                                              class="pure-menu-link">Strona główna</a></li>
                <li class="pure-menu-item"><a href="studenttranscript"
                                              class="pure-menu-link">Indeks</a></li>
                <li class="pure-menu-item"><a href="studentacademicrecordcard"
                                              class="pure-menu-link">Karta przebiegu studiów</a></li>
                <li class="pure-menu-item"><a href="timetable"
                                              class="pure-menu-link">Plan zajęć</a></li>
                <li class="pure-menu-item"><a href="studentsubjects"
                                              class="pure-menu-link">Moje przedmioty</a></li>
                <li class="pure-menu-item"><a href="studentscholarships"
                                              class="pure-menu-link">Stypendia</a></li>
                <li class="pure-menu-item"><a href="studentpayments"
                                              class="pure-menu-link">Płatności</a></li>
                <a href="#"	class="pure-menu-link">Wnioski </a></li>
                <li class="pure-menu-item"><a href="studentlecturers"
                                              class="pure-menu-link">Wykładowcy</a></li>
                <li class="pure-menu-item"><a href="receivedmessages"
                                              class="pure-menu-link">Historia komunikatów</a></li>
                <li class="pure-menu-item menu-item-divided">
                <li class="pure-menu-item"><a href="studentmydata"
                                              class="pure-menu-link">Moje dane</a></li>
                <li class="pure-menu-item"><a href="password"
                                              class="pure-menu-item pure-menu-selected">Zmiana hasła</a></li>
                <li class="pure-menu-item menu-item-divided">
                <li class="pure-menu-item"><a href="logout"
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
            <h2 class="content-subhead">Wprowadź dwukrotnie nowe hasło do konta.</h2>
            <p>
            <center>
                <form name="newpassword" action="password" method=post class="pure-form"
                      onsubmit="return validate();">
                    <fieldset class="pure-group">
                        <input type="password" name="currentpassword" class="pure-input-1-2" placeholder="Aktualne hasło" required>
                        <input type="password" name="password" class="pure-input-1-2" placeholder="Hasło" required>
                        <input type="password" name="passwordrepeat" class="pure-input-1-2" placeholder="Powtórz hasło"
                               required>
                    </fieldset>
                    <fieldset id="errorText1" class="pure-group" style="display: none">
                        <font color="red">Hasła nie zgadzają się ze sobą!</font>
                    </fieldset>
                    <fieldset id="errorText2" class="pure-group" style="display: none">
                        <font color="red">Minimalna długość hasła: 5 znaków!</font>
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
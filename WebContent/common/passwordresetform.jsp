<%@ page language="java" contentType="text/html; charset=ISO-8859-2"
         pageEncoding="ISO-8859-2" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-2">
    <link rel="stylesheet" href="resources/pure-min.css">
    <link rel="stylesheet" href="resources/styles2.css">
    <title>eDziekanat - Resetuj hasło</title>
</head>
<body>
<div id="layout">
    <div id="main">
        <div class="header">
            <h1>eDziekanat</h1>
            <h2>Twój wirtualny dziekanat.</h2>
        </div>
        <div class="content">
            <h3 class="content-subhead">Wprowadź adres e-mail lub login swojego konta, aby zresetować hasło.</h3>
            <p>
            <center>
                <form action="sendresetemailaction" method=post class="pure-form">
                    <fieldset class="pure-group">
                        <input type="text" name="login-email" class="pure-input-1-2" placeholder="E-mail / Login"
                               required>
                    </fieldset>

                    <c:if test="${resetError == true}">
                        <fieldset class="pure-group">
                            <font color='red'><b>Błędny login lub adres e-mail, spróbuj ponownie.</b></font>
                        </fieldset>
                    </c:if>
                    <button type="submit" class="pure-button pure-input-1-2 pure-button-primary">Wyślij</button>
                </form>
            </center>
        </div>
    </div>
</div>
</body>
</html>
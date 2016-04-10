<%@ page language="java" contentType="text/html; charset=ISO-8859-2"
         pageEncoding="ISO-8859-2" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-2">
    <link rel="stylesheet" href="resources/pure-min.css">
    <link rel="stylesheet" href="resources/styles2.css">
    <title>eDziekanat - Zaloguj się</title>
</head>
<body>
<div id="layout">
    <div id="main">
        <div class="header">
            <h1>eDziekanat</h1>
            <h2>Twój wirtualny dziekanat.</h2>
        </div>
        <div class="content">
            <h2 class="content-subhead">
                Zaloguj się do systemu, aby uzyskać dostęp do swoich danych
            </h2>
            <p>
            <center>
                <form action="loginaction" method=post class="pure-form">
                    <fieldset class="pure-group">
                        <input type="text" name="username" class="pure-input-1-2" placeholder="Login" required>
                        <input type="password" name="password" class="pure-input-1-2" placeholder="Hasło" required>
                    </fieldset>

                    <c:if test="${loginError == true}">
                        <fieldset class="pure-group">
                            <font color='red'><b>Błędny login lub hasło, spróbuj ponownie.</b></font>
                        </fieldset>
                    </c:if>
                    <fieldset class="pure-group">
                        <a href="sendresetemail">Przypomnij hasło</a>
                    </fieldset>
                    <button type="submit" class="pure-button pure-input-1-2 pure-button-primary">Zaloguj</button>
                </form>
                <%
                    request.getSession()
                            .setAttribute("backURL", request.getAttribute("javax.servlet.forward.request_uri"));
                %>
            </center>
        </div>
    </div>
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-2"
         pageEncoding="ISO-8859-2"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-2">
    <link rel="stylesheet" href="resources/pure-min.css">
    <link rel="stylesheet" href="resources/styles2.css">
    <title>eDziekanat - Nowe hasło</title>
</head>
<body>
<div id="layout">
    <div id="main">
        <div class="header">
            <h1>eDziekanat</h1>
            <h2>Twój wirtualny dziekanat.</h2>
        </div>
        <div class="content">
            <h2 class="content-subhead">Wprowadź dwukrotnie nowe hasło do konta.</h2>
            <p>
            <center>
                <form name="newpassword" action="setnewpassword" method=post class="pure-form">
                    <fieldset class="pure-group">
                        <input type="hidden" name="resetid" value="${resetid}">
                        <input type="password" name="password" class="pure-input-1-2" placeholder="Hasło" required>
                        <input type="password" name="passwordrepeat" class="pure-input-1-2" placeholder="Powtórz hasło" required>
                    </fieldset>

                    <button type="submit"
                            class="pure-button pure-input-1-2 pure-button-primary">Wyślij</button>
                </form>
            </center>
        </div>
    </div>
</div>
</body>
</html>
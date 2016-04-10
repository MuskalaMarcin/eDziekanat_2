<%@ page language="java" contentType="text/html; charset=ISO-8859-2"
         pageEncoding="ISO-8859-2"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-2">
    <link rel="stylesheet" href="resources/pure-min.css">
    <link rel="stylesheet" href="resources/styles2.css">
    <title>eDziekanat - Nowe has�o</title>
</head>
<body>
<div id="layout">
    <div id="main">
        <div class="header">
            <h1>eDziekanat</h1>
            <h2>Tw�j wirtualny dziekanat.</h2>
        </div>
        <div class="content">
            <h2 class="content-subhead">Zaloguj si� do systemu, aby uzyska�
                dost�p do swoich danych</h2>
            <p>
            <center>
                <form action="loginaction" method=post class="pure-form">
                    <fieldset class="pure-group">
                        <input type="text" name="username" class="pure-input-1-2" placeholder="Login" required>
                        <input type="password" name="password" class="pure-input-1-2" placeholder="Has�o" required>
                    </fieldset>

                    <fieldset class="pure-group">
                        <%
                            if (request.getSession().getAttribute("loginError") != null
                                    && request.getSession().getAttribute("loginError").equals("true"))
                            {
                                out.print("<font color='red'><b>B��dny login lub has�o, spr�buj ponownie.</b></font>");
                                request.getSession().invalidate();
                            }
                        %>
                    </fieldset>

                    <button type="submit"
                            class="pure-button pure-input-1-2 pure-button-primary">Zaloguj</button>
                </form>
            </center>
        </div>
    </div>
</div>
</body>
</html>
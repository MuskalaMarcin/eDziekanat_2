<%@ page language="java" import="edziekanat.bean.LoginBean"
         contentType="text/html; charset=ISO-8859-2" pageEncoding="ISO-8859-2" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-2">
    <link rel="stylesheet" href="resources/pure-min.css">
    <link rel="stylesheet" href="resources/styles2.css">
    <title>eDziekanat - B��d 404</title>
</head>
<body>
<div id="layout">
    <div id="main">
        <div class="header">
            <h1>eDziekanat</h1>
            <h2>Tw�j wirtualny dziekanat.</h2>
        </div>
        <div class="content">
            <center>
                <p>
                    <img width="500" src="http://localhost:8080/edziekanat/images/Access-Denied-Yoda.jpg"/>
                </p>
                <p>
                    <b><font color="red">Odmowa dost�pu!</font></b>
                </p>
                <p>
                    Tw�j poziom dost�pu: <b>${loginBean.userRole}</b> nie jest wystarczaj�cy do przegl�dania tej
                    podstrony.
                </p>
                <p>
                    <br> <br><a class="pure-button pure-button-primary" href="http://localhost:8080/edziekanat/">
                    Powr�t do strony g��wnej</a>
                </p>
                <p>
                    <br> <br> <font size="1" color="gray">Obrazek
                    pobrano ze strony: <a href="http://www.jedimarketing.us/">http://www.jedimarketing.us/</a>
                </font>
                </p>
            </center>
        </div>
    </div>
</div>
</body>
</html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-2"
         pageEncoding="ISO-8859-2" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-2">
    <link rel="stylesheet" href="resources/pure-min.css">
    <link rel="stylesheet" href="resources/styles2.css">
    <title>eDziekanat - ${msgshort}</title>
</head>
<body>
<div id="layout">
    <div id="main">
        <div class="header">
            <h1>eDziekanat</h1>
            <h2>Twój wirtualny dziekanat.</h2>
        </div>
        <div class="content">
            <center>
                <p>
                    <img width="250"
                         src="http://localhost:8080/edziekanat/images/Infobox_info_icon.svg.png"/>
                </p>
                <p><b>${msglong}</b></p>
                <p>
                    <br> <br> <a class="pure-button pure-button-primary"
                                 href="<c:choose>
                                 <c:when test="${empty previousUrl}">http://localhost:8080/edziekanat/</c:when>
                                 <c:otherwise>${previousUrl}</c:otherwise>
                                 </c:choose>">Powrót</a>

                </p>
                <p>
                    <br> <br> <font size="1" color="gray">Obrazek
                    pobrano ze strony: <a href="https://upload.wikimedia.org/">https://upload.wikimedia.org/</a>
                </font>
                </p>
            </center>
        </div>
    </div>
</div>
</body>
</html>
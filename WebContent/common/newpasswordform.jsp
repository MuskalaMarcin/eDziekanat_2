<%@ page language="java" contentType="text/html; charset=ISO-8859-2"
         pageEncoding="ISO-8859-2" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-2">
    <link rel="stylesheet" href="resources/pure-min.css">
    <link rel="stylesheet" href="resources/styles2.css">
    <title>eDziekanat - Nowe has�o</title>

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
    <div id="main">
        <div class="header">
            <h1>eDziekanat</h1>
            <h2>Tw�j wirtualny dziekanat.</h2>
        </div>
        <div class="content">
            <h2 class="content-subhead">Wprowad� dwukrotnie nowe has�o do konta.</h2>
            <p>
            <center>
                <form name="newpassword" action="setnewpassword" method=post class="pure-form"
                      onsubmit="return validate();">
                    <fieldset class="pure-group">
                        <input type="hidden" name="resetid" value="${resetid}">
                        <input type="password" name="password" class="pure-input-1-2" placeholder="Has�o" required>
                        <input type="password" name="passwordrepeat" class="pure-input-1-2" placeholder="Powt�rz has�o"
                               required>
                    </fieldset>
                    <fieldset id="errorText1" class="pure-group" style="display: none">
                        <font color="red">Has�a nie zgadzaj� si� ze sob�!</font>
                    </fieldset>
                    <fieldset id="errorText2" class="pure-group" style="display: none">
                        <font color="red">Minimalna d�ugo�� has�a: 5 znak�w!</font>
                    </fieldset>
                    <button type="submit"
                            class="pure-button pure-input-1-2 pure-button-primary">Wy�lij
                    </button>
                </form>
            </center>
        </div>
    </div>
</div>
</body>
</html>
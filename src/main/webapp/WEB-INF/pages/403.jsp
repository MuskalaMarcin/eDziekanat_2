<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
	<h1>eDziekanat - odmowa dostepu</h1>

	<c:choose>
		<c:when test="${empty username}">
			<h2>Nie masz uprawnien dostepu do tej podstrony!</h2>
		</c:when>
		<c:otherwise>
			<h2>Zalogowano jako : ${username} <br/>Nie masz uprawnien dostepu do tej podstrony!</h2>
		</c:otherwise>
	</c:choose>

</body>
</html>
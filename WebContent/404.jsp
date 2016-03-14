<%@ page language="java" contentType="text/html; charset=ISO-8859-2"
	pageEncoding="ISO-8859-2"%>
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
						<img width="600"
							src="http://localhost:8080/edziekanat/images/androiddev101.jpg" />
					</p>
					<p>
						<b>Kod b��du:</b> ${pageContext.errorData.statusCode} <br>
						<b>Poszukiwany URI:</b>
						${pageContext.request.scheme}://${header.host}${pageContext.errorData.requestURI}
					</p>
					<p>
						<a class="pure-button pure-button-primary"
							href="http://localhost:8080/edziekanat/">Powr�t do strony
							g��wnej</a>
					</p>
					<p>
						<br> <br> <font size="1" color="gray">Obrazek
							pobrano ze strony: <a href="http://www.404notfound.fr/">http://www.404notfound.fr/</a>
						</font>
					</p>
				</center>
			</div>
		</div>
	</div>
</body>
</html>
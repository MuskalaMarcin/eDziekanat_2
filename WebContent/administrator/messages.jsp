<%@ page language="java" contentType="text/html; charset=ISO-8859-2"
    pageEncoding="ISO-8859-2"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-2">
<title>eDziekanat - Wiadomości</title>
</head>
<body>
	<form action="newMessage" method=post>
		<p>
			<strong>Adresat: </strong> <input type="text" value="adresat" size="25" disabled>
		<p>
		<p>
		<select name="cars">
  <option value="volvo">Volvo</option>
  <option value="saab">Saab</option>
  <option value="fiat">Fiat</option>
  <option value="audi">Audi</option>
</select>
		<p>
		<p>
			<strong>Tytuł: </strong> <input type="password" size="15" name="title">
		<p>
		<p>
			<strong>Treść: </strong> <input type="password" size="15" name="title">
		<p>
		<p>
			<input type="submit" value="Zaloguj">
	</form>
</body>
</html>
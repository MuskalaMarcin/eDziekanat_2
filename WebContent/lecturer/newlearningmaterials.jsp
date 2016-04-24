<%@ page language="java" contentType="text/html; charset=ISO-8859-2"
	pageEncoding="ISO-8859-2"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-2">
<link rel="stylesheet" href="resources/pure-min.css">
<link rel="stylesheet" href="resources/styles.css">
<title>eDziekanat - Materia�y dydaktyczne</title>
</head>
<body>
	<div id="layout">
		<div id="menu">
			<div class="pure-menu">
				<a class="pure-menu-heading" href="home">eDziekanat</a>
				<ul class="pure-menu-list">
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="lecturer">Strona g��wna</a></li>
					<li class="pure-menu-item menu-item-divided"><a
						class="pure-menu-link" href="#">Materia�y dydaktyczne</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="lecturerlearningmaterials">Moje materia�y</a></li>
					<li class="pure-menu-item pure-menu-selected"><a
						class="pure-menu-link" href="newlearningmaterials">Dodaj
							materia�y</a></li>
					<li class="pure-menu-item menu-item-divided"><a
						class="pure-menu-link" href="lecturerseestudents">Studenci</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="lecturerseelecturers">Wyk�adowcy</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="classrooms">Dost�pno�� sal</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="timetable">Plan zaj��</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="lecturersubjects">Moje przedmioty</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="receivedmessages">Historia komunikat�w</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="logout">Wyloguj</a></li>
				</ul>
			</div>
		</div>
		<div id="main">
			<div class="header">
				<h1>eDziekanat</h1>
				<h2>Tw�j wirtualny dziekanat.</h2>
			</div>
			<div class="content">
				<h2 class="content-subhead">Dodaj materia�y dydaktyczne:</h2>
				<center>
					<form class="pure-form pure-form-aligned"
						action="addlearningmaterials" method=post enctype="multipart/form-data">
						<fieldset class="pure-group">
							<center>
								<label for="state">Przedmiot</label> <select name="subjectId"
									style="width: 42%" id="state">
									<c:forEach items="${subjects}" var="subject">
										<option value="${subject.id}">${subject.name}</option>
									</c:forEach>
								</select>
							</center>
						</fieldset>
						<fieldset class="pure-group">
							<input type="text" name="name" class="pure-input-1-2"
								placeholder="Nazwa" required>

							<textarea name="description" class="pure-input-1-2"
								placeholder="Opis" required></textarea>

							<input type="file" name="newFile" class="pure-input-1-2" required>
						</fieldset>

						<button type="submit"
							class="pure-button pure-input-1-2 pure-button-primary">Wy�lij</button>
					</form>
				</center>
			</div>
		</div>
	</div>
</body>
</html>
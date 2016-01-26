<%@ page language="java" contentType="text/html; charset=ISO-8859-2"
	pageEncoding="ISO-8859-2"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-2">
<link rel="stylesheet"
	href="http://localhost:8080/eDziekanat/resources/pure-min.css">
<link rel="stylesheet"
	href="http://localhost:8080/eDziekanat/resources/styles.css">
<title>eDziekanat - Dodaj studenta</title>
</head>
<body>
	<div id="layout">
		<div id="menu">
			<div class="pure-menu">
				<a class="pure-menu-heading" href="home">eDziekanat</a>
				<ul class="pure-menu-list">
					<li class="pure-menu-item"><a
						href="http://localhost:8080/eDziekanat/admin"
						class="pure-menu-link">Strona główna</a></li>
					<li class="pure-menu-item"><a
						href="http://localhost:8080/eDziekanat/admintimetable"
						class="pure-menu-link">Plan zajęć</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="http://localhost:8080/eDziekanat/adminclassrooms">Dostępność
							sal</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="http://localhost:8080/eDziekanat/admincourses">Kierunki</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="http://localhost:8080/eDziekanat/adminstudentgroups">Grupy
							studenckie</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="http://localhost:8080/eDziekanat/adminlecturers">Wykładowcy</a>
					</li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="http://localhost:8080/eDziekanat/adminsubjects">Przedmioty</a>
					</li>
					<li class="pure-menu-item menu-item-divided">
					<li class="pure-menu-item"><a class="pure-menu-link" href="#">Studenci</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="http://localhost:8080/eDziekanat/adminstudents">Przeglądaj</a></li>
					<li class="pure-menu-item pure-menu-selected"><a
						class="pure-menu-link"
						href="http://localhost:8080/eDziekanat/admin/newstudent">Dodaj
							studenta</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="http://localhost:8080/eDziekanat/adminstatistics">Statystyki</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="http://localhost:8080/eDziekanat/adminscholarships">Stypendia</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="http://localhost:8080/eDziekanat/adminpayments">Należności</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="http://localhost:8080/eDziekanat/adminapplications">Wnioski</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="http://localhost:8080/eDziekanat/receivedmessages">Historia
							komunikatów</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="logout">Wyloguj</a></li>
				</ul>
			</div>
		</div>
		<div id="main">
			<div class="header">
				<h1>eDziekanat</h1>
				<h2>Twój wirtualny dziekanat.</h2>
			</div>
			<div class="content">
				<h2 class="content-subhead">Dodaj studenta</h2>
				<p>
				<p>
				<center>
					<form action="http://localhost:8080/eDziekanat/adminaddstudent"
						method=post class="pure-form">
						<p>
							Grupa studencka:
							<c:choose>
								<c:when test="${!empty studentsgroup}">
									<select name="studentsgroupid">
										<c:forEach items="${studentsgroup}" var="studentsgroup"
											varStatus="varStatus">
											<option value="${studentsgroup.id}">${studentsgroup.id}</option>
										</c:forEach>
									</select>
								</c:when>
							</c:choose>
						<fieldset class="pure-group">
							<input type="text" name="name" class="pure-input-1-2"
								placeholder="Imię" required>
							</textarea>
						</fieldset>
						<p>
						<fieldset class="pure-group">
							<input type="text" name="surname" class="pure-input-1-2"
								placeholder="Nazwisko" required>
							</textarea>
						</fieldset>
						<p>
						<fieldset class="pure-group">
							<input type="text" name="address" class="pure-input-1-2"
								placeholder="Adres" required>
							</textarea>
						</fieldset>
						<p>
						<fieldset class="pure-group">
							<input type="text" name="academicdegree" class="pure-input-1-2"
								placeholder="Stopień naukowy" required>
							</textarea>
						</fieldset>
						<p>Dane nowego użytkownika:
						<p>
						<fieldset class="pure-group">
							<input type="text" name="login" class="pure-input-1-2"
								placeholder="Login" required>
							</textarea>
						</fieldset>
						<p>
						<fieldset class="pure-group">
							<input type="password" name="password" class="pure-input-1-2"
								placeholder="Hasło" required>
							</textarea>
						</fieldset>
						<p>
						<fieldset class="pure-group">
							<input type="text" name="email" class="pure-input-1-2"
								placeholder="Adres e-mail" required>
							</textarea>
						</fieldset>
						<p>
							<button type="submit"
								class="pure-button pure-input-1-2 pure-button-primary">Dodaj</button>
					</form>
				</center>
			</div>
		</div>
	</div>
</body>
</html>
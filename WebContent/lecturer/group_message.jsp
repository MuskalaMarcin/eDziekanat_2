<%@ page language="java" contentType="text/html; charset=ISO-8859-2"
	pageEncoding="ISO-8859-2"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-2">
<link rel="stylesheet" href="resources/pure-min.css">
<link rel="stylesheet" href="resources/styles.css">
<title>eDziekanat - Moje przedmioty</title>
</head>
<body>
	<div id="layout">
		<div id="menu">
			<div class="pure-menu">
				<a class="pure-menu-heading" href="home">eDziekanat</a>
				<ul class="pure-menu-list">
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="lecturer">Strona g��wna</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="lecturerlearningmaterials">Materia�y dydaktyczne</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="lecturerseestudents">Studenci</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="lecturerseelecturers">Wyk�adowcy</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="classrooms">Dost�pno�� sal</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="timetable">Plan zaj��</a></li>
					<li class="pure-menu-item pure-menu-selected"><a
						class="pure-menu-link" href="lecturersubjects">Moje
							przedmioty</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="receivedmessages">Historia komunikat�w</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link" href="lecturermydata">Moje dane</a></li>
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
				<h2 class="content-subhead">Wiadomo�� do grupy</h2>
				<center>
					<c:choose>
						<c:when test="${empty groups}">
							<h3 class="content-subhead">Brak grup dla tego przedmiotu</h3>
						</c:when>
						<c:otherwise>
							<form action="lecturergroupmessage" class="pure-form" method="post">
							<fieldset class="pure-group">
								<label for="select1"><strong>Grupa docelowa:</strong>
									<select id="select1" name="group">
										<c:forEach items="${groups}" var="studentsGroup"
												   varStatus="varStatus">
											<option value="${studentsGroup.id}">Grupa ${studentsGroup.id}</option>
										</c:forEach>
									</select>
								</label>
								<fieldset class="pure-group">
									<strong>Tytu�</strong><br/>
									<input type="text" name="msgtitle" class="pure-input-1-2" required/>
									<strong>Tre��</strong><br/>
									<textarea name="content" rows="6" class="pure-input-1-2" required></textarea>
									<br/>
									<input	class="pure-button pure-input-1-2 pure-button-primary"
											type="submit" value="Wy�lij">
								</fieldset>
							</fieldset>

							</form>
						</c:otherwise>
					</c:choose>
				</center>
			</div>
		</div>
	</div>
</body>
</html>
<%@ page language="java"
	import="edziekanat.databasemodel.dto.SubjectDTO, java.util.List"
	contentType="text/html; charset=ISO-8859-2" pageEncoding="ISO-8859-2"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-2">
<link rel="stylesheet" href="resources/pure-min.css">
<link rel="stylesheet" href="resources/styles.css">
<title>eDziekanat - Student - Przedmioty</title>
</head>
<body>
	<div id="layout">
		<div id="menu">
			<div class="pure-menu">
				<a class="pure-menu-heading" href="home">eDziekanat</a>
				<ul class="pure-menu-list">
					<li class="pure-menu-item"><a href="student"
						class="pure-menu-link">Strona główna</a></li>
					<li class="pure-menu-item"><a href="studenttranscript"
						class="pure-menu-link">Indeks</a></li>
					<li class="pure-menu-item"><a href="studenttimetable"
						class="pure-menu-link">Plan zajęć</a></li>
					<li class="pure-menu-item"><a href="studentsubjects"
						class="pure-menu-link  pure-menu-selected">Moje przedmioty</a></li>
					<li class="pure-menu-item"><a href="studentscholarships"
						class="pure-menu-link">Stypendia</a></li>
					<li class="pure-menu-item"><a href="studentpayments"
						class="pure-menu-link">Płatności</a></li>
					<li class="pure-menu-item"><a href="studentapplications"
						class="pure-menu-link">Wnioski</a></li>
					<li class="pure-menu-item"><a href="studentlecturers"
						class="pure-menu-link">Wykładowcy</a></li>
					<li class="pure-menu-item"><a href="messages"
						class="pure-menu-link">Historia komunikatów</a></li>
					<li class="pure-menu-item"><a href="logout"
						class="pure-menu-link">Wyloguj</a>
				</ul>
			</div>
		</div>
		<div id="main">
			<div class="header">
				<h1>eDziekanat</h1>
				<h2>Twój wirtualny dziekanat.</h2>
			</div>
			<div class="content">
				<h2 class="content-subhead">Zalogowano jako:</h2>
				<p>
				<p>
					<font color="red"> TODO: <br> 1. Wyświetlanie
						informacji o przedmiotach<br> 2. Przy każdym przedmiocie
						odnośnik do wyświetlenia materiałów dydaktycznych.
					</font>
				</p>

				<%
				    List<SubjectDTO> subjects = (List<SubjectDTO>) request.getAttribute("ownsubjects");

				    if (subjects != null)
				    {
				%>
				<p>Przedmioty:
				<table border="1">
					<%
					    for (int i = 0; i < subjects.size(); i++)
							{
							    SubjectDTO sbs = subjects.get(i);
					%>
					<tr>
						<td colspan="2">Nr: <%
						    out.print(i + 1);
						%></td>
					</tr>
					<tr>
						<td>Nazwa:</td>
						<td>
							<%
							    out.print(sbs.getName());
							%>
						</td>
					</tr>
					<tr>
						<td>Semestr:</td>
						<td>
							<%
							    out.print(sbs.getSemester());
							%>
						</td>
					</tr>
					<tr>
						<td>ECTS:</td>
						<td>
							<%
							    out.print(sbs.getECTS());
							%>
						</td>
					</tr>
					<tr>
						<td>Prowadzący:</td>
						<td>
							<%
							    out.print(sbs.getLecturer().getName() + " " + sbs.getLecturer().getSurname());
							%>
						</td>
					</tr>
					<%
					    }
					%>
				</table>

				<%
				    }
				%>
				</center>
				</p>
			</div>
		</div>
	</div>
</body>
</html>
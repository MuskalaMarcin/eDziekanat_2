<%@ page language="java"
	import="edziekanat.databasemodel.dto.ScholarshipDTO, java.util.List, java.util.Date"
	contentType="text/html; charset=ISO-8859-2" pageEncoding="ISO-8859-2"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-2">
<link rel="stylesheet" href="resources/pure-min.css">
<link rel="stylesheet" href="resources/styles.css">
<title>eDziekanat - Student - Stypendia</title>
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
						class="pure-menu-link">Moje przedmioty</a></li>
					<li class="pure-menu-item pure-menu-selected"><a
						href="studentscholarships" class="pure-menu-link">Stypendia</a></li>
					<li class="pure-menu-item"><a href="studentwaitingpayments"
						class="pure-menu-link">Płatności</a></li>
					<li class="pure-menu-item"><a href="studentapplications"
						class="pure-menu-link">Wnioski</a></li>
					<li class="pure-menu-item"><a href="studentlecturers"
						class="pure-menu-link">Wykładowcy</a></li>
					<li class="pure-menu-item"><a href="receivedmessages"
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
				<h2 class="content-subhead">Aktualne stypendia:</h2>
				<%
				    List<ScholarshipDTO> scholarships = (List<ScholarshipDTO>) request.getAttribute("ownscholarships");

				    if (scholarships != null)
				    {
						List<String> adminNames = (List<String>) request.getAttribute("adminNames");
				%>
				<table class="responseTable">
					<%
					    for (int i = 0; i < scholarships.size(); i++)
							{
							    ScholarshipDTO schls = scholarships.get(i);
					%>
					<tr class="grayRow">
						<td colspan="2">Nr. <%
						    out.print(i + 1);
						%></td>
					</tr>
					<tr>
						<td>Typ:</td>
						<td>
							<%
							    out.print(schls.getScholarshipType().getType());
							%>
						</td>
					</tr>
					<tr>
						<td>Kwota:</td>
						<td>
							<%
							    out.print(schls.getScholarshipType().getAmount() + " zł");
							%>
						</td>
					</tr>
					<tr>
						<td>Data przyznania:</td>
						<td>
							<%
							    Date grantDate = schls.getGrantDate();
									    out.print(grantDate.getDate() + "." + (grantDate.getMonth() + 1) + "."
										    + (grantDate.getYear() + 1900) + "r.");
							%>
						</td>
					</tr>
					<tr>
						<td>Data zakończenia:</td>
						<td>
							<%
							    Date endDate = schls.getEndDate();
									    out.print(endDate.getDate() + "." + (endDate.getMonth() + 1) + "." + (endDate.getYear() + 1900)
										    + "r.");
							%>
						</td>
					</tr>
					<tr>
						<td>Przyznane przez:</td>
						<td>
							<%
							    out.print(adminNames.get(i));
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
			</div>
		</div>
	</div>
</body>
</html>
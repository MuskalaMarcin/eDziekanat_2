<%@ page language="java"
	import="edziekanat.databasemodel.dto.ApplicationDTO, java.util.List"
	contentType="text/html; charset=ISO-8859-2" pageEncoding="ISO-8859-2"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-2">
<title>eDziekanat - Student - Wnioski</title>
</head>
<body>
	<font face="Verdana"><center>
			<font size="7"><b>eDziekanat - Twój wirtualny dziekanat</b></font><br>
			<br>
			<br>
			<br>

			<table border="1" cellspacing="5" cellpadding="5">
				<tr>
					<td><a href="student">Strona główna</a></td>
					<td><a href="studenttranscript">Indeks</a></td>
					<td><a href="studenttimetable">Plan zajęć</a></td>
					<td><a href="studentsubjects">Moje przedmioty</a></td>
					<td><a href="studentscholarships">Stypendia</a></td>
					<td><a href="studentpayments">Płatności</a></td>
					<td bgcolor="silver"><a href="studentapplications">Wnioski</a></td>
					<td><a href="studentlecturers">Wykładowcy</a></td>
					<td><a href="messages">Historia komunikatów</a></td>
					<td><a href="logout">Wyloguj</a></td>
				</tr>
			</table>

			<p>
				<font color="red"> TODO: <br> 1. Wyświetlanie informacji
					o wysłanych wnioskach łącznie z info czy jest przyjęty i kiedy<br>
					2. Kontakt do administratora który się nim zajmował.
				</font>
			</p>

			<%
			    List<ApplicationDTO> applications = (List<ApplicationDTO>) request.getAttribute("ownapplications");

			    if (applications != null)
			    {
			%>
			<p>Wnioski:
			<table border="1">
				<%
				    for (int i = 0; i < applications.size(); i++)
						{
						    ApplicationDTO apps = applications.get(i);
				%>
				<tr>
					<td colspan="2">Nr: <%
					    out.print(i + 1);
					%></td>
				</tr>
				<tr>
					<td>Tytuł:</td>
					<td>
						<%
						    out.print(apps.getTitle());
						%>
					</td>
				</tr>
				<tr>
					<td>Treść wniosku:</td>
					<td>
						<%
						    out.print(apps.getContent());
						%>
					</td>
				</tr>
				<tr>
					<td>Data złożenia:</td>
					<td>
						<%
						    out.print(apps.getDispatchDate());
						%>
					</td>
				</tr>
				<tr>
					<td>Status:</td>
					<td>
						<%
						    out.print(apps.getStatus());
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

		</center></font>
</body>
</html>
<%@ page language="java"
	import="edziekanat.databasemodel.dto.ScholarshipDTO, java.util.List"
	contentType="text/html; charset=ISO-8859-2" pageEncoding="ISO-8859-2"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-2">
<title>eDziekanat - Student - Stypendia</title>
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
					<td bgcolor="silver"><a href="studentscholarships">Stypendia</a></td>
					<td><a href="studentpayments">Płatności</a></td>
					<td><a href="studentapplications">Wnioski</a></td>
					<td><a href="studentlecturers">Wykładowcy</a></td>
					<td><a href="messages">Historia komunikatów</a></td>
					<td><a href="logout">Wyloguj</a></td>
				</tr>
			</table>

			<p>
				<font color="red"> TODO: <br> 1. Wyświetlanie informacji
					o aktualnych stypendiach.<br>
				</font>
			</p>
			<%
			    List<ScholarshipDTO> scholarships = (List<ScholarshipDTO>) request.getAttribute("ownscholarships");
			    
				if (scholarships != null)
			    {
				    List<String> adminNames = (List<String>) request.getAttribute("adminNames");
			%>
			<p>Stypendia:
			<table border="1">
				<%
				    for (int i = 0; i < scholarships.size(); i++)
						{
						    ScholarshipDTO schls = scholarships.get(i);
				%>
				<tr>
					<td colspan="2">Nr: <%
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
					<td>Typ:</td>
					<td>
						<%
						    out.print(schls.getScholarshipType().getAmount() + " zł");
						%>
					</td>
				</tr>
				<tr>
					<td>Data otrzymania:</td>
					<td>
						<%
						    out.print(schls.getGrantDate());
						%>
					</td>
				</tr>
				<tr>
					<td>Data zakończenia:</td>
					<td>
						<%
						    out.print(schls.getEndDate());
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

		</center></font>
</body>
</html>
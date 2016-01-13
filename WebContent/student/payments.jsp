<%@ page language="java" 
	import="edziekanat.databasemodel.dto.PaymentDTO, java.util.List"
	contentType="text/html; charset=ISO-8859-2" pageEncoding="ISO-8859-2"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-2">
<title>eDziekanat - Student - Płatności</title>
</head>
<body>
	<font face="Verdana"><center>
		<font size="7"><b>eDziekanat - Twój wirtualny dziekanat</b></font><br><br><br><br>
	
		<table border="1" cellspacing="5" cellpadding="5">
			<tr>
				<td><a href="student">Strona główna</a></td>
				<td><a href="studenttranscript">Indeks</a></td>
				<td><a href="studenttimetable">Plan zajęć</a></td>
				<td><a href="studentsubjects">Moje przedmioty</a></td>
				<td><a href="studentscholarships">Stypendia</a></td>
				<td bgcolor="silver"><a href="studentpayments">Płatności</a></td>
				<td><a href="studentapplications">Wnioski</a></td>
				<td><a href="studentlecturers">Wykładowcy</a></td>
				<td><a href="messages">Historia komunikatów</a></td>
				<td><a href="logout">Wyloguj</a></td>
			</tr>
		</table>
		
		<p>
			<font color="red">
				TODO: <br>
				1. Wyświetlanie historii płatności<br>
				2. Wyświetlanie aktualnie oczekujących na płatności<br>
				3. W przypadku oczekujących możliwość kontaktu z administratorem.
			</font>
		</p>
		<%
			    List<PaymentDTO> payments = (List<PaymentDTO>) request.getAttribute("ownpayments");
			    
				if (payments != null)
			    {
			%>
			<p>Płatności:
			<table border="1">
				<%
				    for (int i = 0; i < payments.size(); i++)
						{
							PaymentDTO pmnts = payments.get(i);
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
						    out.print(pmnts.getTitle());
						%>
					</td>
				</tr>
				<tr>
					<td>Opis:</td>
					<td>
						<%
						    out.print(pmnts.getDescription());
						%>
					</td>
				</tr>
				<tr>
					<td>Kwota:</td>
					<td>
						<%
						    out.print(pmnts.getAmount());
						%>
					</td>
				</tr>
				<tr>
					<td>Data polecenia zapłaty:</td>
					<td>
						<%
						    out.print(pmnts.getIssueDate());
						%>
					</td>
				</tr>
				<tr>
					<td>Data płatności:</td>
					<td>
						<%
						    out.print(pmnts.getPaymentDate());
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
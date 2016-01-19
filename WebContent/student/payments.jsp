<%@ page language="java"
	import="edziekanat.databasemodel.dto.PaymentDTO, java.util.List"
	contentType="text/html; charset=ISO-8859-2" pageEncoding="ISO-8859-2"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-2">
<link rel="stylesheet" href="resources/pure-min.css">
<link rel="stylesheet" href="resources/styles.css">
<title>eDziekanat - Student - Płatności</title>
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
					<li class="pure-menu-item"><a href="studentscholarships"
						class="pure-menu-link">Stypendia</a></li>
					<li class="pure-menu-item pure-menu-selected"><a
						href="studentpayments" class="pure-menu-link ">Płatności</a></li>
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
				<h2 class="content-subhead">Płatności:</h2>
				<p>
				<p>
					<font color="red"> TODO: <br> 1. Wyświetlanie historii
						płatności<br> 2. Wyświetlanie aktualnie oczekujących na
						płatności<br> 3. W przypadku oczekujących możliwość kontaktu
						z administratorem.
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
			</div>
		</div>
	</div>
</body>
</html>
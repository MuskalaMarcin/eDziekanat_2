<%@ page language="java"
	import="edziekanat.databasemodel.dto.MessageDTO, java.util.List, java.util.Date"
	contentType="text/html; charset=ISO-8859-2" pageEncoding="ISO-8859-2"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-2">
<link rel="stylesheet" href="resources/pure-min.css">
<link rel="stylesheet" href="resources/styles.css">
<title>eDziekanat - Skrzynka odbiorcza</title>
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
					<li class="pure-menu-item"><a href="studentwaitingpayments"
						class="pure-menu-link ">Płatności</a></li>
					<li class="pure-menu-item"><a href="studentapplications"
						class="pure-menu-link">Wnioski</a></li>
					<li class="pure-menu-item"><a href="studentlecturers"
						class="pure-menu-link">Wykładowcy</a></li>
					<li class="pure-menu-item menu-item-divided"><a
						href="#" class="pure-menu-link">Historia komunikatów</a></li>
					<li class="pure-menu-item pure-menu-selected"><a
						href="receivedmessages" class="pure-menu-link">Skrzynka odbiorcza</a></li>
					<li class="pure-menu-item"><a
						href="sentmessages" class="pure-menu-link">Skrzynka nadawcza</a></li>
					<li class="pure-menu-item   menu-item-divided"><a href="logout"
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
				<h2 class="content-subhead">Skrzynka odbiorcza:</h2>
				<%
				    List<MessageDTO> received = (List<MessageDTO>) request.getAttribute("receivedMessages");
				    if (received == null)
				    {
				%>

				<P>Brak odebranych wiadomości</P>
				<%
				    }
				    else
				    {
						List<String> senderNames = (List<String>) request.getAttribute("senderNames");
				%>
				<table class="responseTable">
					<%
					    for (int i = 0; i < received.size(); i++)
							{
							    MessageDTO rcvd = received.get(i);
					%>
					<tr class="grayRow">
						<td id="respond">
							<form action="student/newmessage" method=post>
								<input type="hidden" name="receiverLogin"
									value="<%out.print(rcvd.getSender().getLogin());%>"> <input
									type="hidden" name="title"
									value="<%out.print(rcvd.getTitle());%>"> <input
									class="pure-button pure-input-1-2 pure-button-primary"
									type="submit" value="Odpowiedz">
							</form>
						</td>
						<td colspan="3">Wiadomość <%
						    out.print(i + 1);
						%></td>
					</tr>
					<tr>
						<td>Nadawca:</td>
						<td>
							<%
							    out.print(senderNames.get(i));
							%>
						</td>
						<td>Data nadania:</td>
						<td>
							<%
							    Date date = rcvd.getDispatchDate();
									    out.print(date.getDate() + "." + (date.getMonth() + 1) + "." + (date.getYear() + 1900));
							%>
						</td>
					</tr>
					<tr>
						<td width="150px">Tytuł:</td>
						<td colspan="3">
							<%
							    out.print(rcvd.getTitle());
							%>
						</td>
					</tr>
					<tr>
						<td>Treść:</td>
						<td id="content" colspan="3">
							<%
							    out.print(rcvd.getContent());
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
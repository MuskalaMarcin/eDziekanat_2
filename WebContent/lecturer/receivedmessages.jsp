<%@ page language="java"
	import="edziekanat.databasemodel.dto.MessageDTO, java.util.List, java.util.Date"
	contentType="text/html; charset=ISO-8859-2" pageEncoding="ISO-8859-2"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-2">
<link rel="stylesheet" href="./resources/styles.css">
<title>eDziekanat - Wykładowca - Wiadomości</title>
</head>
<body>
	<p id="headertext">eDziekanat - Twój wirtualny dziekanat</p>
	<table id="menu">
		<tr>
			<td><a href="lecturer">Strona główna</a></td>
			<td><a href="lecturerlearningmaterials">Materiały
					dydaktyczne</a></td>
			<td><a href="lecturerseestudents">Studenci</a></td>
			<td><a href="lecturerseelecturers">Wykładowcy</a></td>
			<td><a href="lecturerclassrooms">Dostępność sal</a></td>
			<td><a href="lecturertimetable">Plan zajęć</a></td>
			<td><a href="lecturersubjects">Moje przedmioty</a></td>
			<td  id="grayCell"><a href="messages">Historia komunikatów</a></td>
			<td><a href="logout">Wyloguj</a></td>
		</tr>
	</table>

	<p>
		<font color="red"> TODO: 4. Podział na strony. </font>
	</p>
	<p>
		Skrzynka odbiorcza:
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
		<tr>
			<td id="grayCell" colspan="2">Wiadomość <%
			    out.print(i + 1);
			%></td>
		</tr>
		<tr>
			<td width="150px">Tytuł:</td>
			<td>
				<%
				    out.print(rcvd.getTitle());
				%>
			</td>
		</tr>
		<tr>
			<td>Nadawca:</td>
			<td>
				<%
				    out.print(senderNames.get(i));
				%>
			</td>
		</tr>
		<tr>
			<td>Data nadania:</td>
			<td>
				<%
				    Date date = rcvd.getDispatchDate();
						    out.print(date.getDate() + "." + (date.getMonth() + 1) + "." + (date.getYear() + 1900));
				%>
			</td>
		</tr>
		<tr>
			<td colspan="2">Treść:</td>
		</tr>
		<tr>
			<td id="content" colspan="2">
				<%
				    out.print(rcvd.getContent());
				%>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<form action="lecturer/newmessage" method=post>
					<input type="hidden" name="receiverLogin"
						value="<%out.print(rcvd.getSender().getLogin());%>"> <input
						type="hidden" name="title"
						value="<%out.print(rcvd.getTitle());%>"> <input
						type="submit" value="Odpowiedz">
				</form>
			</td>
		</tr>
		<%
		    }
		%>
	</table>
	<%
	    }
	%>
	<p>
		Skrzynka nadawcza:
		<%
	    List<MessageDTO> sent = (List<MessageDTO>) request.getAttribute("sentMessages");
	    if (sent == null)
	    {
	%>
	
	<P>Brak wysłanych wiadomości.</P>
	<%
	    }
	    else
	    {
			List<String> receiverNames = (List<String>) request.getAttribute("receiverNames");
	%>
	<table class="responseTable">
		<%
		    for (int i = 0; i < sent.size(); i++)
				{
				    MessageDTO snd = sent.get(i);
		%>
		<tr>
			<td id="grayCell" colspan="2">Wiadomość <%
			    out.print(i + 1);
			%></td>
		</tr>
		<tr>
			<td width="150px">Tytuł:</td>
			<td>
				<%
				    out.print(snd.getTitle());
				%>
			</td>
		</tr>
		<tr>
			<td>Odbiorca:</td>
			<td>
				<%
				    out.print(receiverNames.get(i));
				%>
			</td>
		</tr>
		<tr>
			<td>Data wysłania:</td>
			<td>
				<%
				    Date dateSnd = snd.getDispatchDate();
						    out.print(
							    dateSnd.getDate() + "." + (dateSnd.getMonth() + 1) + "." + (dateSnd.getYear() + 1900));
				%>
			</td>
		</tr>
		<tr>
			<td>Data dostarczenia:</td>
			<td>
				<%
				    if (snd.getReceiveDate() == null)
						    {
				%> Nie dostarczono. <%
				    }
						    else
						    {
							Date dateRcv = snd.getReceiveDate();
							out.print(dateRcv.getDate() + "." + (dateRcv.getMonth() + 1) + "."
								+ (dateRcv.getYear() + 1900));
						    }
				%>
			</td>
		</tr>
		<tr>
			<td colspan="2">Treść:</td>
		</tr>
		<tr>
			<td id="content" colspan="2">
				<%
				    out.print(snd.getContent());
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
</body>
</html>
<%@ page language="java"
	import="edziekanat.databasemodel.dto.MessageDTO, java.util.List, java.util.Date"
	contentType="text/html; charset=ISO-8859-2" pageEncoding="ISO-8859-2"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-2">
<link rel="stylesheet" href="resources/pure-min.css">
<link rel="stylesheet" href="resources/styles.css">
<title>eDziekanat - Student - Skrzynka nadawcza</title>
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
					<li class="pure-menu-item"><a
						href="receivedmessages" class="pure-menu-link">Skrzynka odbiorcza</a></li>
					<li class="pure-menu-item pure-menu-selected"><a
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
				<h2 class="content-subhead">Skrzynka nadawcza:</h2>
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
					<tr class="grayRow">
						<td colspan="6">Wiadomość <%
						    out.print(i + 1);
						%></td>
					</tr>
					<tr>
						<td>Odbiorca:</td>
						<td>
							<%
							    out.print(receiverNames.get(i));
							%>
						</td>
						<td>Data wysłania:</td>
						<td>
							<%
							    Date dateSnd = snd.getDispatchDate();
									    out.print(
										    dateSnd.getDate() + "." + (dateSnd.getMonth() + 1) + "." + (dateSnd.getYear() + 1900)
											    + "r.");
							%>
						</td>
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
											+ (dateRcv.getYear() + 1900) + "r.");
									    }
							%>
						</td>
					</tr>
					<tr>
						<td width="150px">Tytuł:</td>
						<td  colspan = "5">
							<%
							    out.print(snd.getTitle());
							%>
						</td>
					</tr>
					<tr>
						<td>Treść:</td>
						<td colspan = "5" id="content">
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
			</div>
		</div>
	</div>
</body>
</html>
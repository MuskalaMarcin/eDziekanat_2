 <%@ page language="java" contentType="text/html; charset=ISO-8859-2"
	pageEncoding="ISO-8859-2"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-2">
	<link rel="stylesheet" href="resources/pure-min.css">
	<link rel="stylesheet" href="resources/css/bootstrap.min.css">
	<link rel="stylesheet" href="resources/styles.css">
	<script src="resources/jquery/jquery-2.2.3.js"></script>
	<script src="resources/js/bootstrap.min.js"></script>
<title>eDziekanat - Skrzynka odbiorcza</title>
</head>
<body>
	<div id="layout">
		<div id="menu">
			<div class="pure-menu">
				<a class="pure-menu-heading" href="home">eDziekanat</a>
				<ul class="pure-menu-list">
					<li class="pure-menu-item"><a href="admin"
						class="pure-menu-link">Strona główna</a></li>
					<li class="pure-menu-item"><a href="admintimetable"
						class="pure-menu-link">Plan zajęć</a></li>
					<li class="pure-menu-item"><a
						class="pure-menu-link" href="classrooms">Dostępność sal</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="admincourses">Kierunki</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="adminstudentgroups">Grupy studenckie</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="adminlecturers">Wykładowcy</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="adminsubjects">Przedmioty</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="adminstudents">Studenci</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="marksstatistics">Statystyki</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="adminscholarships">Stypendia</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="adminpayments">Należności</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="adminapplications">Wnioski</a></li>
					<li class="pure-menu-item menu-item-divided"><a href="#"
						class="pure-menu-link">Historia komunikatów</a></li>
					<li class="pure-menu-item pure-menu-selected"><a
						href="receivedmessages" class="pure-menu-link">Skrzynka
							odbiorcza</a></li>
					<li class="pure-menu-item"><a href="sentmessages"
						class="pure-menu-link">Skrzynka nadawcza</a></li>
                    <li class="pure-menu-item  menu-item-divided"><a class="pure-menu-link"
                                                  href="news">Ogłoszenia</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link" href="adminmydata">Moje dane</a></li>
					<li class="pure-menu-item"><a href="logout"
						class="pure-menu-link">Wyloguj</a></li>
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
				<c:choose>
					<c:when test="${empty receivedMessages}">
						<p>Skrzynka odbiorcza jest pusta.</p>
					</c:when>
					<c:otherwise>
                        <div class="panel-group" id="accordion1">
                            <c:forEach items="${receivedMessages}" var="msg"
                                       varStatus="varStatus">
                                <div class="panel panel-default">
                                    <div class="panel-heading accordion-toggle collapsed" data-toggle="collapse"
                                         data-parent="#accordion1" data-target="#collapseOne${varStatus.index}">
                                        <h4 class="panel-title"><c:choose>
                                            <c:when test="${empty msg.receiveDate}">
                                            <div class="nieodebrane">
                                                </c:when>
                                                <c:otherwise>
                                                <div class="odebrane">
                                                    </c:otherwise>
                                                    </c:choose>
                                                    <div class="tytul">${varStatus.index + 1 + (currentPage*10)}. ${msg.title }</div>
                                                    <div class="data"><fmt:formatDate pattern="dd.MM.yyyy" value="${msg.dispatchDate}"/></div>
                                                    <div class="nadawca">${senderNames[varStatus.index]}</div>
                                                </div>
                                        </h4>
                                    </div>
                                    <div id="collapseOne${varStatus.index}" class="panel-collapse collapse">
                                        <div class="panel-body"> ${msg.content}
                                            <div id="deletenews" align="right">
                                                <form action="administrator/newmessage" method=post>
                                                    <input type="hidden" name="receiverLogin"
                                                           value="${msg.sender.login}"> <input type="hidden"
                                                                                               name="title" value="${msg.title }"> <input
                                                        class="pure-button pure-input-1-2 pure-button-primary"
                                                        type="submit" value="Odpowiedz">
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>

						<div style="margin-top: 10px; margin-left: 47%" class="btn-toolbar" role="toolbar">
							<div class="btn-group" role="group" aria-label="1">
								<c:forEach begin="1" end="${pagesNumber}" varStatus="loop">
								<c:choose>
								<c:when test="${(loop.index-1)==currentPage}">
								<form style="width:30px;height:30px;padding:0" class="btn btn-primary" action="receivedmessages" method=post>
									</c:when>
									<c:otherwise>
									<form style="width:30px;height:30px;padding:0" class="btn btn-default" action="receivedmessages" method=post>
										</c:otherwise>
										</c:choose>
										<input type="hidden" name="getPage" value="${loop.index - 1}">
										<button style="margin:0px; padding: 0; border:0;background: none; width: 30px; height: 30px" type="submit">${loop.index}</button>
									</form>
									</c:forEach>
							</div>
						</div>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</div>
</body>
</html>
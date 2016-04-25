<%@ page language="java" contentType="text/html; charset=ISO-8859-2"
         pageEncoding="ISO-8859-2" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-2">
<link rel="stylesheet" href="resources/pure-min.css">
<link rel="stylesheet" href="resources/bootstrap/bootstrap.min.css">
<link rel="stylesheet" href="resources/styles.css">
<script src="resources/jquery/jquery-2.2.3.js"></script>
<script src="resources/bootstrap/bootstrap.min.js"></script>
<title>eDziekanat - Wykładowca - Skrzynka nadawcza</title>
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
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="classrooms">Dostępność sal</a></li>
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
					<li class="pure-menu-item"><a href="receivedmessages"
						class="pure-menu-link">Skrzynka odbiorcza</a></li>
					<li class="pure-menu-item pure-menu-selected"><a
						href="sentmessages" class="pure-menu-link">Skrzynka nadawcza</a></li>
					<li class="pure-menu-item   menu-item-divided"><a
						href="logout" class="pure-menu-link">Wyloguj</a></li>
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
				<c:choose>
					<c:when test="${empty sentMessages}">
						<p>Skrzynka nadawcza jest pusta.</p>
					</c:when>
					<c:otherwise>
						<table class="responseTable">
							<c:forEach items="${sentMessages}" var="msg"
								varStatus="varStatus">
								<a data-toggle="collapse" data-target="#demo${varStatus.index + 1}" >
									<c:choose>
									<c:when test="${empty msg.receiveDate}">
									<div class="nieodebrane">
										</c:when>
										<c:otherwise>
										<div class="odebrane">
											</c:otherwise>
											</c:choose>
										<div class="tytul">${varStatus.index + 1}.${msg.title }</div>
										<div class="data"><fmt:formatDate pattern="dd.MM.yyyy" value="${msg.dispatchDate}"/></div>
										<div class="nadawca">${receiverNames[varStatus.index]}</div>
									</div>
								</a>
								<div class="tresc" id="demo${varStatus.index + 1}" class="collapse">${msg.content}
									<div class="doreczenie">
										<c:choose>
											<c:when test="${empty msg.receiveDate}">Nie dostarczono.</c:when>
											<c:otherwise>
												<fmt:formatDate pattern="dd.MM.yyyy"
																value="${msg.receiveDate}" />
											</c:otherwise>
										</c:choose>
									</div>
								</div>

							</c:forEach>
						</table>

                    <div style="margin-top: 10px" class="btn-toolbar" role="toolbar">
                        <div class="btn-group" role="group" aria-label="1">
                            <c:forEach begin="1" end="${pagesNumber}" varStatus="loop">
                                <c:choose>
                                    <c:when test="${(loop.index-1)==currentPage}">
                                        <form style="width:30px;height:30px;padding:0" class="btn btn-primary" action="sentmessages" method=post>
                                    </c:when>
                                    <c:otherwise>
                                        <form style="width:30px;height:30px;padding:0" class="btn btn-default" action="sentmessages" method=post>
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
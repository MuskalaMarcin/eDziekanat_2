<%@ page language="java" contentType="text/html; charset=ISO-8859-2"
	pageEncoding="ISO-8859-2"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-2">\
<link rel="stylesheet" href="resources/pure-min.css">
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/styles.css">
<script src="resources/jquery/jquery-2.2.3.js"></script>
<script src="resources/js/bootstrap.min.js"></script>

<title>eDziekanat - Skrzynka nadawcza</title>
</head>
<body>
	<div id="layout">
		<div id="menu">
			<div class="pure-menu">
				<a class="pure-menu-heading" href="home">eDziekanat</a>
				<ul class="pure-menu-list">
					<li class="pure-menu-item"><a href="student"
						class="pure-menu-link">Strona g��wna</a></li>
					<li class="pure-menu-item"><a href="studenttranscript"
						class="pure-menu-link">Indeks</a></li>
                    <li class="pure-menu-item"><a href="studentacademicrecordcard"
                        class="pure-menu-link">Karta przebiegu studi�w</a></li>
					<li class="pure-menu-item"><a href="timetable"
						class="pure-menu-link">Plan zaj��</a></li>
					<li class="pure-menu-item"><a href="studentsubjects"
						class="pure-menu-link">Moje przedmioty</a></li>
					<li class="pure-menu-item"><a href="studentscholarships"
						class="pure-menu-link">Stypendia</a></li>
					<li class="pure-menu-item"><a href="studentwaitingpayments"
						class="pure-menu-link ">P�atno�ci</a></li>
					<li class="pure-menu-item"><a href="studentapplications"
						class="pure-menu-link">Wnioski</a></li>
					<li class="pure-menu-item"><a href="studentlecturers"
						class="pure-menu-link">Wyk�adowcy</a></li>
					<li class="pure-menu-item menu-item-divided"><a href="#"
						class="pure-menu-link">Historia komunikat�w</a></li>
					<li class="pure-menu-item"><a href="receivedmessages"
						class="pure-menu-link">Skrzynka odbiorcza</a></li>
					<li class="pure-menu-item pure-menu-selected"><a
						href="sentmessages" class="pure-menu-link">Skrzynka nadawcza</a></li>
					<li class="pure-menu-item menu-item-divided"><a href="studentmydata"
												  class="pure-menu-link">Moje dane</a></li>
					<li class="pure-menu-item"><a
						href="logout" class="pure-menu-link">Wyloguj</a>
				</ul>
			</div>
		</div>
		<div id="main">
			<div class="header">
				<h1>eDziekanat</h1>
				<h2>Tw�j wirtualny dziekanat.</h2>
			</div>
			<div class="content">
				<h2 class="content-subhead">Skrzynka nadawcza:</h2>
				<c:choose>
					<c:when test="${empty sentMessages}">
						<p>Skrzynka nadawcza jest pusta.</p>
					</c:when>
					<c:otherwise>
                        <div class="panel-group" id="accordion1">
                            <c:forEach items="${sentMessages}" var="msg"
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
                                                    <div class="nadawca">${receiverNames[varStatus.index][0]}</div>
                                                </div>
                                        </h4>
                                    </div>
                                    <div id="collapseOne${varStatus.index}" class="panel-collapse collapse">
                                        <div class="panel-body"> ${msg.content}
                                            <div id="deletenews" align="right">
                                                <c:choose>
                                                    <c:when test="${empty msg.receiveDate}">Nie dostarczono.</c:when>
                                                    <c:otherwise>
                                                        Dostarczono: <fmt:formatDate pattern="dd.MM.yyyy"
                                                                                     value="${msg.receiveDate}" />
                                                    </c:otherwise>
                                                </c:choose>
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
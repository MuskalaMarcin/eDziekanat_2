<%@ page language="java" contentType="text/html; charset=ISO-8859-2"
	pageEncoding="ISO-8859-2"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-2">
<link rel="stylesheet" href="resources/pure-min.css">
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/styles.css">
<script src="resources/jquery/jquery-2.2.3.js"></script>
<script src="resources/js/bootstrap.min.js"></script>
<title>eDziekanat - Wykładowca - Skrzynka nadawcza</title>
</head>
<body>
	<div id="layout">
		<div id="menu">
			<div class="pure-menu">
				<a class="pure-menu-heading" href="home">eDziekanat</a>
				<ul class="pure-menu-list">
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="lecturer">Strona główna</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="lecturerlearningmaterials">Materiały dydaktyczne</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="lecturerseestudents">Studenci</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="lecturerseelecturers">Wykładowcy</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="classrooms">Dostępność sal</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="timetable">Plan zajęć</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="lecturersubjects">Moje przedmioty</a></li>
					<li class="pure-menu-item menu-item-divided"><a href="#"
						class="pure-menu-link">Historia komunikatów</a></li>
					<li class="pure-menu-item"><a href="receivedmessages"
						class="pure-menu-link">Skrzynka odbiorcza</a></li>
					<li class="pure-menu-item pure-menu-selected"><a
						href="sentmessages" class="pure-menu-link">Skrzynka nadawcza</a></li>
					<li class="pure-menu-item   menu-item-divided">
					<li class="pure-menu-item"><a class="pure-menu-link" href="lecturermydata">Moje dane</a></li><a
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
													<c:when test="${receiverNames[varStatus.index][1] != null}">

														<button type="button" class="btn btn-primary" data-toggle="popover"
																data-placement="bottom" data-trigger="focus" data-html="true"
																title="Status doręczenia" data-content="
																<table>
																<tr><td>Adresat</td><td>Data odebrania</td></tr>
																<c:forEach items="${receiverNames[varStatus.index]}" var="reciever" varStatus="recieverNum">
																	<c:set var="msgStatus" value="${fn:split(reciever,':')}"/>
																	<c:set var="msgStatusRec" value="${fn:split(msgStatus[0],'-')}"/>
																	<c:choose>
																		<c:when test="${msgStatus[0].trim().length()>8}">
																			<tr>
																			<td style='width: 130px'>
																			${msgStatusRec[0]}
																			 </td><td>
																			 <c:choose>
																				 <c:when test="${msgStatus[1].trim().equals(\"nie\")}">
																					<b class='text-danger'>Nie odebrano</b>
																				 </c:when>
																				 <c:otherwise>
																					<b class='text-success'>${msgStatus[1]}</b>
																				 </c:otherwise>
																			 </c:choose>
																			 </td>
																			 </tr>
																		 </c:when>
																	 </c:choose>
																</c:forEach>
																</table>
																">
																	Status doręczenia
																</button>
													</c:when>
													<c:otherwise>
														<c:choose>
															<c:when test="${empty msg.receiveDate}">Nie dostarczono.</c:when>
															<c:otherwise>
																Dostarczono: <fmt:formatDate pattern="dd.MM.yyyy"
																							 value="${msg.receiveDate}" />
															</c:otherwise>
														</c:choose>
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
	<script>
		$('[data-toggle="popover"]').popover();

		$('.popover-dismiss').popover({
			trigger: 'focus'
		})

		$('[data-toggle="popover"]').on('click', function (e) {
			$('[data-toggle="popover"]').not(this).popover('hide');
		});
	</script>
</body>
</html>
<%@ page language="java" import="java.util.List"
	contentType="text/html; charset=ISO-8859-2" pageEncoding="ISO-8859-2"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-2">
<link rel="stylesheet" href="resources/pure-min.css">
<link rel="stylesheet" href="resources/styles.css">
<title>eDziekanat - Statystyki stypendi�w</title>
<%
	@SuppressWarnings("unchecked")
    List<List<String>> list = (List<List<String>>) request.getAttribute("schlByFaculty");
%>
<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<script type="text/javascript">
	google.load('visualization', '1.0', {
		'packages' : [ 'corechart' ]
	});
	google.setOnLoadCallback(drawChart);
	function drawChart() {

		var data = new google.visualization.DataTable();
		data.addColumn('string', 'Wydzia�');
		data.addColumn('number', 'Ilo�� stypendi�w');

		data.addRows([ 		<%for (int i = 0; i < list.size(); i++) {
				List<String> smallerList = list.get(i);
				if (i != 0)
					out.print(",");%> ['<%out.print(smallerList.get(0));%>', <%out.print(smallerList.get(1));%>]<%}%> ]);

		var data3 = new google.visualization.DataTable();
		data3.addColumn('string', 'Wydzia�');
		data3.addColumn('number', '�rednia wysoko��');
		data3.addRows([<%for (int i = 0; i < list.size(); i++) {
				List<String> smallerList = list.get(i);
				if (i != 0)
					out.print(",");%> ['<%out.print(smallerList.get(0));%>', <%out.print(smallerList.get(2));%>]<%}%>  ]);

		var options = {
			'title' : 'Ilo�� stypendi�w na wydzia�',
			'width' : 500,
			'height' : 400
		};

		var options3 = {
			'title' : '�rednia wysoko�� stypendium',
			'width' : 500,
			'height' : 400
		};

		
		var chart = new google.visualization.PieChart(document
				.getElementById('chart_div'));
		chart.draw(data, options);
		
		var chart3 = new google.visualization.ColumnChart(document
				.getElementById('chart_div3'));
		chart3.draw(data3, options3);

	}
</script>
</head>
<body>
	<div id="layout">
		<div id="menu">
			<div class="pure-menu">
				<a class="pure-menu-heading" href="home">eDziekanat</a>
				<ul class="pure-menu-list">
					<li class="pure-menu-item "><a href="admin"
						class="pure-menu-link">Strona g��wna</a></li>
					<li class="pure-menu-item"><a href="admintimetable"
						class="pure-menu-link">Plan zaj��</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="classrooms">Dost�pno�� sal</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="admincourses">Kierunki</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="adminstudentgroups">Grupy studenckie</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="adminlecturers">Wyk�adowcy</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="adminsubjects">Przedmioty</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="adminstudents">Studenci</a></li>
					<li class="pure-menu-item menu-item-divided"><a
						class="pure-menu-link" href="#">Statystyki</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="marksstatistics">Statystyki ocen</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="applicationsstatistics">Statystyki wniosk�w</a></li>
					<li class="pure-menu-item pure-menu-selected"><a
						class="pure-menu-link" href="scholarshipstatistics">Statystyki
							stypendi�w</a></li>
					<li class="pure-menu-item menu-item-divided"><a
						class="pure-menu-link" href="adminscholarships">Stypendia</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="adminpayments">Nale�no�ci</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="adminapplications">Wnioski</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="receivedmessages">Historia komunikat�w</a></li>
                    <li class="pure-menu-item"><a class="pure-menu-link"
                                                  href="news">Og�oszenia</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link" href="adminmydata">Moje dane</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="logout">Wyloguj</a></li>
				</ul>
			</div>
		</div>
		<div id="main">
			<div class="header">
				<h1>eDziekanat</h1>
				<h2>Tw�j wirtualny dziekanat.</h2>
			</div>
			<div class="content">
				<h2 class="content-subhead">Statystyki stypendi�w:</h2>
				<center>
					<div id="chart_div"></div>
					<div id="chart_div3"></div>
				</center>
			</div>
		</div>
	</div>
</body>
</html>
<%@ page language="java" import="java.util.List"
	contentType="text/html; charset=ISO-8859-2" pageEncoding="ISO-8859-2"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-2">
<link rel="stylesheet" href="resources/pure-min.css">
<link rel="stylesheet" href="resources/styles.css">
<title>eDziekanat - Statystyki ocen</title>
<%
    @SuppressWarnings("unchecked")
			List<List<String>> list = (List<List<String>>) request.getAttribute("marksByFaculty");
%>
<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<script type="text/javascript">
	google.load('visualization', '1.0', {
		'packages' : [ 'corechart' ]
	});
	google.setOnLoadCallback(drawChart);
	function drawChart() {

		var data = new google.visualization.DataTable();
		data.addColumn('string', 'Wydział');
		data.addColumn('number', 'Średnia ocen');

		data.addRows([ 		<%for (int i = 0; i < list.size(); i++) {
				List<String> smallerList = list.get(i);
				if (i != 0)
					out.print(",");%> ['<%out.print(smallerList.get(0));%>', <%out.print(smallerList.get(5));%>]<%}%> ]);
		
		var data2 = new google.visualization.DataTable();
		data2.addColumn('string', 'Wydział');
		data2.addColumn('number', 'Średnia ocen we wpisach');

		data2.addRows([ 		<%for (int i = 0; i < list.size(); i++) {
				List<String> smallerList = list.get(i);
				if (i != 0)
					out.print(",");%> ['<%out.print(smallerList.get(0));%>', <%out.print(smallerList.get(10));%>]<%}%> ]);

		var data3 = new google.visualization.DataTable();
		data3.addColumn('string', 'Wydział');
		data3.addColumn('number', '2');
		data3.addColumn('number', '3');
		data3.addColumn('number', '4');
		data3.addColumn('number', '5');
		data3.addRows([<%for (int i = 0; i < list.size(); i++) {
				List<String> smallerList = list.get(i);
				if (i != 0)
					out.print(",");%> ['<%out.print(smallerList.get(0));%>', <%out.print(smallerList.get(1));%> , <%out.print(smallerList.get(2));%> , <%out.print(smallerList.get(3));%>, <%out.print(smallerList.get(4));%>]<%}%>  ]);

		var data4 = new google.visualization.DataTable();
		data4.addColumn('string', 'Wydział');
		data4.addColumn('number', '2');
		data4.addColumn('number', '3');
		data4.addColumn('number', '4');
		data4.addColumn('number', '5');
		data4.addRows([<%for (int i = 0; i < list.size(); i++) {
				List<String> smallerList = list.get(i);
				if (i != 0)
					out.print(",");%> ['<%out.print(smallerList.get(0));%>', <%out.print(smallerList.get(6));%> , <%out.print(smallerList.get(7));%> , <%out.print(smallerList.get(8));%>, <%out.print(smallerList.get(9));%>]<%}%>  ]);

		
		var options = {
			'title' : 'Średnia ocen na wydziale',
			'width' : 600,
			'height' : 350
		};

		var options2 = {
				'title' : 'Średnia ocen we wpisach na wydziale',
				'width' : 600,
				'height' : 350
			};
		
		var options3 = {
			'title' : 'Oceny cząstkowe według wydziału',
			'width' : 850,
			'height' : 350
		};
		
		var options4 = {
				'title' : 'Oceny we wpisach według wydziału',
				'width' : 850,
				'height' : 350
			};

		var chart1 = new google.visualization.ColumnChart(document
				.getElementById('chart_div'));
		chart1.draw(data, options);
		
		var chart2 = new google.visualization.ColumnChart(document
				.getElementById('chart_div2'));
		chart2.draw(data2, options2);
		
		var chart3 = new google.visualization.ColumnChart(document
				.getElementById('chart_div3'));
		chart3.draw(data3, options3);
		
		var chart4 = new google.visualization.ColumnChart(document
				.getElementById('chart_div4'));
		chart4.draw(data4, options4);

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
					<li class="pure-menu-item menu-item-divided"><a
						class="pure-menu-link" href="#">Statystyki</a></li>
					<li class="pure-menu-item pure-menu-selected"><a
						class="pure-menu-link" href="marksstatistics">Statystyki ocen</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="applicationsstatistics">Statystyki wniosków</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="scholarshipstatistics">Statystyki stypendiów</a></li>
					<li class="pure-menu-item menu-item-divided"><a
						class="pure-menu-link" href="adminscholarships">Stypendia</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="adminpayments">Należności</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="adminapplications">Wnioski</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="receivedmessages">Historia komunikatów</a></li>
					<li class="pure-menu-item"><a class="pure-menu-link"
						href="logout">Wyloguj</a></li>
				</ul>
			</div>
		</div>
		<div id="main">
			<div class="header">
				<h1>eDziekanat</h1>
				<h2>Twój wirtualny dziekanat.</h2>
			</div>
			<div class="content">
				<h2 class="content-subhead">Statystyki ocen:</h2>
				<center>
					<div id="chart_div"></div>
					<div id="chart_div3"></div>
					<div id="chart_div2"></div>
					<div id="chart_div4"></div>
				</center>
			</div>
		</div>
	</div>
</body>
</html>
# eDziekanat_2
<b>"eDziekanat_2"</b> is a virtual dean's office web app project. It is developed as a second version of previously developed web app with the same title.

<p><b>Cracow University of Technology</b><br>
Authors: Marcin Muskala, Marek Nawrot, Michal Sliwa, Rafal Zieba</p>

<p><b>Scrum board:</b><br>
https://trello.com/b/1ChhvqM5/edziekanat</p>

<p><b>Tools needed:</b><br>
JDK SE 8 http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html<br>
IntelliJ IDEA Ultimate: https://www.jetbrains.com/idea/download/download-thanks.html<br>
Apache Tomcat 9.0.0.M3 http://ftp.piotrkosoft.net/pub/mirrors/ftp.apache.org/tomcat/tomcat-9/v9.0.0.M3/bin/apache-tomcat-9.0.0.M3-windows-x64.zip<br>
PostgreSQL 9.5.1 http://www.enterprisedb.com/postgresql-951-installers-win64?ls=Crossover&type=Crossover<br>
PostgreSQL JDBC 42 JAR https://jdbc.postgresql.org/download/postgresql-9.4.1208.jar <i>(put this jar into %TOMCAT_HOME/lib directory)</i></p>

<p><b>Database configuration:</b><br>
dbName: edziekanat<br>
user: postgres<br>
password: Haslo123<br>
<i>Scripts creating tables, sequences and inserting data are located in "databaseScripts" directory</p></i>

<p><b>Default logins for users with specified user roles:</b><br>
1. admin: login: "admin" password: "admin"<br>
2. student: login: "student" password: "student"<br>
3. lecturer login: "wykladowca" password: "wykladowca"</p>

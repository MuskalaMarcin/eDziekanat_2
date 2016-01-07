Insert into UNIVERSITY (ID,NAME,ADDRESS) values (university_id_seq.nextval,'Politechnika Krakowska','Krakow');

Insert into FACULTY (ID,NAME,ADDRESS,UNIVERSITY_ID) values (faculty_id_seq.nextval,'Wydzial Komputerowy','Krakow','1');
Insert into FACULTY (ID,NAME,ADDRESS,UNIVERSITY_ID) values (faculty_id_seq.nextval,'Wydzial Architektury','Krakow','1');
Insert into FACULTY (ID,NAME,ADDRESS,UNIVERSITY_ID) values (faculty_id_seq.nextval,'Wydzial Mechaniczny','Krakow','1');


Insert into COURSE (ID,NAME,STATIONARY,FACULTY_ID) values (course_id_seq.nextval,'Informatyka','1','1');
Insert into COURSE (ID,NAME,STATIONARY,FACULTY_ID) values (course_id_seq.nextval,'Elektrotechnika','1','1');
Insert into COURSE (ID,NAME,STATIONARY,FACULTY_ID) values (course_id_seq.nextval,'Energetyka','1','1');
Insert into COURSE (ID,NAME,STATIONARY,FACULTY_ID) values (course_id_seq.nextval,'Architektura','1','2');
Insert into COURSE (ID,NAME,STATIONARY,FACULTY_ID) values (course_id_seq.nextval,'Architektura krajobrazu','1','2');
Insert into COURSE (ID,NAME,STATIONARY,FACULTY_ID) values (course_id_seq.nextval,'Automatyka i robotyka','1','3');
Insert into COURSE (ID,NAME,STATIONARY,FACULTY_ID) values (course_id_seq.nextval,'Transport','1','3');


Insert into STUDENTS_GROUP (ID,YEAR,COURSE_ID) values (students_group_id_seq.nextval,'2','1');
Insert into STUDENTS_GROUP (ID,YEAR,COURSE_ID) values (students_group_id_seq.nextval,'3','2');
Insert into STUDENTS_GROUP (ID,YEAR,COURSE_ID) values (students_group_id_seq.nextval,'1','3');
Insert into STUDENTS_GROUP (ID,YEAR,COURSE_ID) values (students_group_id_seq.nextval,'5','4');
Insert into STUDENTS_GROUP (ID,YEAR,COURSE_ID) values (students_group_id_seq.nextval,'3','5');
Insert into STUDENTS_GROUP (ID,YEAR,COURSE_ID) values (students_group_id_seq.nextval,'2','6');
Insert into STUDENTS_GROUP (ID,YEAR,COURSE_ID) values (students_group_id_seq.nextval,'1','7');
Insert into STUDENTS_GROUP (ID,YEAR,COURSE_ID) values (students_group_id_seq.nextval,'3','2');
Insert into STUDENTS_GROUP (ID,YEAR,COURSE_ID) values (students_group_id_seq.nextval,'2','4');


Insert into STUDENT (ID,NAME,SURNAME,ACADEMIC_DEGREE,ADDRESS) values (student_id_seq.nextval,'Konrad','Studencki','in¿ynier','Poznañ');
Insert into STUDENT (ID,NAME,SURNAME,ACADEMIC_DEGREE,ADDRESS) values (student_id_seq.nextval,'Adam','Ambitny','in¿ynier','Katowice');
Insert into STUDENT (ID,NAME,SURNAME,ACADEMIC_DEGREE,ADDRESS) values (student_id_seq.nextval,'Bartosz','Mi³y','in¿ynier','Czêstochowa');
Insert into STUDENT (ID,NAME,SURNAME,ACADEMIC_DEGREE,ADDRESS) values (student_id_seq.nextval,'Cezary','Kowalski','in¿ynier','Kraków');
Insert into STUDENT (ID,NAME,SURNAME,ACADEMIC_DEGREE,ADDRESS) values (student_id_seq.nextval,'Dominik','W³och','in¿ynier','£ódŸ');
Insert into STUDENT (ID,NAME,SURNAME,ACADEMIC_DEGREE,ADDRESS) values (student_id_seq.nextval,'Ryszard','Pachulski','in¿ynier','Nowy S¹cz');
Insert into STUDENT (ID,NAME,SURNAME,ACADEMIC_DEGREE,ADDRESS) values (student_id_seq.nextval,'Anna','Jêdrusik','in¿ynier','Zakopane');
Insert into STUDENT (ID,NAME,SURNAME,ACADEMIC_DEGREE,ADDRESS) values (student_id_seq.nextval,'Bogdan','Wicha','in¿ynier','D¹browa Górnicza');
Insert into STUDENT (ID,NAME,SURNAME,ACADEMIC_DEGREE,ADDRESS) values (student_id_seq.nextval,'Rafa³','Szota','in¿ynier','Szczawnica');
Insert into STUDENT (ID,NAME,SURNAME,ACADEMIC_DEGREE,ADDRESS) values (student_id_seq.nextval,'Euzebiusz','Gucwa','in¿ynier','Zabierzów');
Insert into STUDENT (ID,NAME,SURNAME,ACADEMIC_DEGREE,ADDRESS) values (student_id_seq.nextval,'Natalia','Abramczyk','in¿ynier','Wadowice');
Insert into STUDENT (ID,NAME,SURNAME,ACADEMIC_DEGREE,ADDRESS) values (student_id_seq.nextval,'Piotr','Burak','in¿ynier','Radom');
Insert into STUDENT (ID,NAME,SURNAME,ACADEMIC_DEGREE,ADDRESS) values (student_id_seq.nextval,'Krzysztof','Gryz','in¿ynier','Gliwice');
Insert into STUDENT (ID,NAME,SURNAME,ACADEMIC_DEGREE,ADDRESS) values (student_id_seq.nextval,'Mi³osz','Stodulski','in¿ynier','Kraków');
Insert into STUDENT (ID,NAME,SURNAME,ACADEMIC_DEGREE,ADDRESS) values (student_id_seq.nextval,'Artur','Sobiech','in¿ynier','Nowy Targ');
Insert into STUDENT (ID,NAME,SURNAME,ACADEMIC_DEGREE,ADDRESS) values (student_id_seq.nextval,'Pawe³','Tobolski','in¿ynier','Opole');
Insert into STUDENT (ID,NAME,SURNAME,ACADEMIC_DEGREE,ADDRESS) values (student_id_seq.nextval,'Wojciech','£yczkowski','in¿ynier','Oœwiêcim');
Insert into STUDENT (ID,NAME,SURNAME,ACADEMIC_DEGREE,ADDRESS) values (student_id_seq.nextval,'Kamila','Komosa','in¿ynier','Olkusz');
Insert into STUDENT (ID,NAME,SURNAME,ACADEMIC_DEGREE,ADDRESS) values (student_id_seq.nextval,'Barbara','Szczêsna','in¿ynier','Kraków');
Insert into STUDENT (ID,NAME,SURNAME,ACADEMIC_DEGREE,ADDRESS) values (student_id_seq.nextval,'Janusz','P³aczek','in¿ynier','Sosnowiec');


Insert into STUDENTS_GROUP_STUDENT (STUDENTS_GROUP_ID,STUDENT_ID) values ('1','1');
Insert into STUDENTS_GROUP_STUDENT (STUDENTS_GROUP_ID,STUDENT_ID) values ('2','2');
Insert into STUDENTS_GROUP_STUDENT (STUDENTS_GROUP_ID,STUDENT_ID) values ('3','3');
Insert into STUDENTS_GROUP_STUDENT (STUDENTS_GROUP_ID,STUDENT_ID) values ('4','4');
Insert into STUDENTS_GROUP_STUDENT (STUDENTS_GROUP_ID,STUDENT_ID) values ('5','5');
Insert into STUDENTS_GROUP_STUDENT (STUDENTS_GROUP_ID,STUDENT_ID) values ('6','6');
Insert into STUDENTS_GROUP_STUDENT (STUDENTS_GROUP_ID,STUDENT_ID) values ('7','7');
Insert into STUDENTS_GROUP_STUDENT (STUDENTS_GROUP_ID,STUDENT_ID) values ('8','8');
Insert into STUDENTS_GROUP_STUDENT (STUDENTS_GROUP_ID,STUDENT_ID) values ('9','9');
Insert into STUDENTS_GROUP_STUDENT (STUDENTS_GROUP_ID,STUDENT_ID) values ('1','10');
Insert into STUDENTS_GROUP_STUDENT (STUDENTS_GROUP_ID,STUDENT_ID) values ('2','11');
Insert into STUDENTS_GROUP_STUDENT (STUDENTS_GROUP_ID,STUDENT_ID) values ('3','12');
Insert into STUDENTS_GROUP_STUDENT (STUDENTS_GROUP_ID,STUDENT_ID) values ('4','13');
Insert into STUDENTS_GROUP_STUDENT (STUDENTS_GROUP_ID,STUDENT_ID) values ('5','14');
Insert into STUDENTS_GROUP_STUDENT (STUDENTS_GROUP_ID,STUDENT_ID) values ('6','15');
Insert into STUDENTS_GROUP_STUDENT (STUDENTS_GROUP_ID,STUDENT_ID) values ('7','16');
Insert into STUDENTS_GROUP_STUDENT (STUDENTS_GROUP_ID,STUDENT_ID) values ('8','17');
Insert into STUDENTS_GROUP_STUDENT (STUDENTS_GROUP_ID,STUDENT_ID) values ('9','18');
Insert into STUDENTS_GROUP_STUDENT (STUDENTS_GROUP_ID,STUDENT_ID) values ('1','19');
Insert into STUDENTS_GROUP_STUDENT (STUDENTS_GROUP_ID,STUDENT_ID) values ('2','20');


Insert into LECTURER (ID,NAME,SURNAME,ADDRESS,ACADEMIC_DEGREE,POSITION) values (lecturer_id_seq.nextval,'Zbigniew','Wykladowczy','Warszawa', 'Magister','Starszy wyk³adowca');
Insert into LECTURER (ID,NAME,SURNAME,ADDRESS,ACADEMIC_DEGREE,POSITION) values (lecturer_id_seq.nextval,'Maja','Koz³owska','Kraków','Magister','Wyk³adowca');
Insert into LECTURER (ID,NAME,SURNAME,ADDRESS,ACADEMIC_DEGREE,POSITION) values (lecturer_id_seq.nextval,'Filip','Kamiñski','Wroc³aw','Magister','Wyk³adowca');
Insert into LECTURER (ID,NAME,SURNAME,ADDRESS,ACADEMIC_DEGREE,POSITION) values (lecturer_id_seq.nextval,'Julia','Klimek','Kraków','Magister','Profesor zwyczajny');
Insert into LECTURER (ID,NAME,SURNAME,ADDRESS,ACADEMIC_DEGREE,POSITION) values (lecturer_id_seq.nextval,'Kacper','Baran','Kraków','Magister','Adiunkt');
Insert into LECTURER (ID,NAME,SURNAME,ADDRESS,ACADEMIC_DEGREE,POSITION) values (lecturer_id_seq.nextval,'Jan','Czy¿','Chorzów','Magister','Wyk³adowca');
Insert into LECTURER (ID,NAME,SURNAME,ADDRESS,ACADEMIC_DEGREE,POSITION) values (lecturer_id_seq.nextval,'Ernest','Jakubowski','Inowroc³aw','Magister','Docent');
Insert into LECTURER (ID,NAME,SURNAME,ADDRESS,ACADEMIC_DEGREE,POSITION) values (lecturer_id_seq.nextval,'Stefan','Olszewski','Kraków','Magister','Wyk³adowca');
Insert into LECTURER (ID,NAME,SURNAME,ADDRESS,ACADEMIC_DEGREE,POSITION) values (lecturer_id_seq.nextval,'Ignacy','Jasiñski','Kraków','Magister','Asystent');
Insert into LECTURER (ID,NAME,SURNAME,ADDRESS,ACADEMIC_DEGREE,POSITION) values (lecturer_id_seq.nextval,'Jakub','Stêpieñ','Katowice','Magister','Wyk³adowca');


Insert into FACULTY_LECTURER (FACULTY_ID,LECTURER_ID) values ('1','1');
Insert into FACULTY_LECTURER (FACULTY_ID,LECTURER_ID) values ('2','2');
Insert into FACULTY_LECTURER (FACULTY_ID,LECTURER_ID) values ('3','3');
Insert into FACULTY_LECTURER (FACULTY_ID,LECTURER_ID) values ('1','4');
Insert into FACULTY_LECTURER (FACULTY_ID,LECTURER_ID) values ('2','5');
Insert into FACULTY_LECTURER (FACULTY_ID,LECTURER_ID) values ('3','6');
Insert into FACULTY_LECTURER (FACULTY_ID,LECTURER_ID) values ('1','7');
Insert into FACULTY_LECTURER (FACULTY_ID,LECTURER_ID) values ('2','8');
Insert into FACULTY_LECTURER (FACULTY_ID,LECTURER_ID) values ('3','9');
Insert into FACULTY_LECTURER (FACULTY_ID,LECTURER_ID) values ('1','10');


Insert into ADMINISTRATOR (ID,NAME,SURNAME,ADDRESS,ACADEMIC_DEGREE,POSITION,UNIVERSITY_ID) values (administrator_id_seq.nextval,'Stefan','Administratorski','Kraków', 'Magister','admin','1');
Insert into ADMINISTRATOR (ID,NAME,SURNAME,ADDRESS,ACADEMIC_DEGREE,POSITION,UNIVERSITY_ID) values (administrator_id_seq.nextval,'Jadwiga','Odpowiedzialna','Kraków', 'Magister','admin','1');
Insert into ADMINISTRATOR (ID,NAME,SURNAME,ADDRESS,ACADEMIC_DEGREE,POSITION,UNIVERSITY_ID) values (administrator_id_seq.nextval,'Norbert','Bielecki','Kraków', 'Magister','admin','1');

Insert into "USER" (LOGIN,PASSWORD,E_MAIL,IS_ACTIVE,USER_ROLE,LECTURER_ID,STUDENT_ID,ADMINISTRATOR_ID) values ('admin','admin','Stefan@Administratorski.com','1','admin',null,null,'1');
Insert into "USER" (LOGIN,PASSWORD,E_MAIL,IS_ACTIVE,USER_ROLE,LECTURER_ID,STUDENT_ID,ADMINISTRATOR_ID) values ('Jadwiga','Odpowiedzialna','Jadwiga@Odpowiedzialna.com','1','admin',null,null,'1');
Insert into "USER" (LOGIN,PASSWORD,E_MAIL,IS_ACTIVE,USER_ROLE,LECTURER_ID,STUDENT_ID,ADMINISTRATOR_ID) values ('Norbert','Bielecki','Norbert@Bielecki.com','1','admin',null,null,'1');

Insert into "USER" (LOGIN,PASSWORD,E_MAIL,IS_ACTIVE,USER_ROLE,LECTURER_ID,STUDENT_ID,ADMINISTRATOR_ID) values ('student','student','Konrad@Studencki.com','1','student',null,'1',null);
Insert into "USER" (LOGIN,PASSWORD,E_MAIL,IS_ACTIVE,USER_ROLE,LECTURER_ID,STUDENT_ID,ADMINISTRATOR_ID) values ('Adam','Ambitny','Adam@Ambitny.com','1','student',null,'1',null);
Insert into "USER" (LOGIN,PASSWORD,E_MAIL,IS_ACTIVE,USER_ROLE,LECTURER_ID,STUDENT_ID,ADMINISTRATOR_ID) values ('Bartosz','Mi³y','Bartosz@Mi³y.com','1','student',null,'1',null);
Insert into "USER" (LOGIN,PASSWORD,E_MAIL,IS_ACTIVE,USER_ROLE,LECTURER_ID,STUDENT_ID,ADMINISTRATOR_ID) values ('Cezary','Kowalski','Cezary@Kowalski.com','1','student',null,'1',null);
Insert into "USER" (LOGIN,PASSWORD,E_MAIL,IS_ACTIVE,USER_ROLE,LECTURER_ID,STUDENT_ID,ADMINISTRATOR_ID) values ('Dominik','W³och','Dominik@W³och.com','1','student',null,'1',null);
Insert into "USER" (LOGIN,PASSWORD,E_MAIL,IS_ACTIVE,USER_ROLE,LECTURER_ID,STUDENT_ID,ADMINISTRATOR_ID) values ('Ryszard','Pachulski','Ryszard@Pachulski.com','1','student',null,'1',null);
Insert into "USER" (LOGIN,PASSWORD,E_MAIL,IS_ACTIVE,USER_ROLE,LECTURER_ID,STUDENT_ID,ADMINISTRATOR_ID) values ('Anna','Jêdrusik','Anna@Jêdrusik.com','1','student',null,'1',null);
Insert into "USER" (LOGIN,PASSWORD,E_MAIL,IS_ACTIVE,USER_ROLE,LECTURER_ID,STUDENT_ID,ADMINISTRATOR_ID) values ('Bogdan','Wicha','Bogdan@Wicha.com','1','student',null,'1',null);
Insert into "USER" (LOGIN,PASSWORD,E_MAIL,IS_ACTIVE,USER_ROLE,LECTURER_ID,STUDENT_ID,ADMINISTRATOR_ID) values ('Rafa³','Szota','Rafa³@Szota.com','1','student',null,'1',null);
Insert into "USER" (LOGIN,PASSWORD,E_MAIL,IS_ACTIVE,USER_ROLE,LECTURER_ID,STUDENT_ID,ADMINISTRATOR_ID) values ('Euzebiusz','Gucwa','Euzebiusz@Gucwa.com','1','student',null,'1',null);
Insert into "USER" (LOGIN,PASSWORD,E_MAIL,IS_ACTIVE,USER_ROLE,LECTURER_ID,STUDENT_ID,ADMINISTRATOR_ID) values ('Natalia','Abramczyk','Natalia@Abramczyk.com','1','student',null,'1',null);
Insert into "USER" (LOGIN,PASSWORD,E_MAIL,IS_ACTIVE,USER_ROLE,LECTURER_ID,STUDENT_ID,ADMINISTRATOR_ID) values ('Piotr','Burak','Piotr@Burak.com','1','student',null,'1',null);
Insert into "USER" (LOGIN,PASSWORD,E_MAIL,IS_ACTIVE,USER_ROLE,LECTURER_ID,STUDENT_ID,ADMINISTRATOR_ID) values ('Krzysztof','Gryz','Krzysztof@Gryz.com','1','student',null,'1',null);
Insert into "USER" (LOGIN,PASSWORD,E_MAIL,IS_ACTIVE,USER_ROLE,LECTURER_ID,STUDENT_ID,ADMINISTRATOR_ID) values ('Mi³osz','Stodulski','Mi³osz@Stodulski.com','1','student',null,'1',null);
Insert into "USER" (LOGIN,PASSWORD,E_MAIL,IS_ACTIVE,USER_ROLE,LECTURER_ID,STUDENT_ID,ADMINISTRATOR_ID) values ('Artur','Sobiech','Artur@Sobiech.com','1','student',null,'1',null);
Insert into "USER" (LOGIN,PASSWORD,E_MAIL,IS_ACTIVE,USER_ROLE,LECTURER_ID,STUDENT_ID,ADMINISTRATOR_ID) values ('Pawe³','Tobolski','Pawe³@Tobolski.com','1','student',null,'1',null);
Insert into "USER" (LOGIN,PASSWORD,E_MAIL,IS_ACTIVE,USER_ROLE,LECTURER_ID,STUDENT_ID,ADMINISTRATOR_ID) values ('Wojciech','£yczkowski','Wojciech@£yczkowski.com','1','student',null,'1',null);
Insert into "USER" (LOGIN,PASSWORD,E_MAIL,IS_ACTIVE,USER_ROLE,LECTURER_ID,STUDENT_ID,ADMINISTRATOR_ID) values ('Kamila','Komosa','Kamila@Komosa.com','1','student',null,'1',null);
Insert into "USER" (LOGIN,PASSWORD,E_MAIL,IS_ACTIVE,USER_ROLE,LECTURER_ID,STUDENT_ID,ADMINISTRATOR_ID) values ('Barbara','Szczêsna','Barbara@Szczêsna.com','1','student',null,'1',null);
Insert into "USER" (LOGIN,PASSWORD,E_MAIL,IS_ACTIVE,USER_ROLE,LECTURER_ID,STUDENT_ID,ADMINISTRATOR_ID) values ('Janusz','P³aczek','Janusz@P³aczek.com','1','student',null,'1',null);


Insert into "USER" (LOGIN,PASSWORD,E_MAIL,IS_ACTIVE,USER_ROLE,LECTURER_ID,STUDENT_ID,ADMINISTRATOR_ID) values ('wykladowca','wykladowca','Zbigniew@Wykladowczy.com','1','lecturer','1',null,null);
Insert into "USER" (LOGIN,PASSWORD,E_MAIL,IS_ACTIVE,USER_ROLE,LECTURER_ID,STUDENT_ID,ADMINISTRATOR_ID) values ('Maja','Koz³owska','Maja@Koz³owska.com','1','lecturer','1',null,null);
Insert into "USER" (LOGIN,PASSWORD,E_MAIL,IS_ACTIVE,USER_ROLE,LECTURER_ID,STUDENT_ID,ADMINISTRATOR_ID) values ('Filip','Kamiñski','Filip@Kamiñski.com','1','lecturer','1',null,null);
Insert into "USER" (LOGIN,PASSWORD,E_MAIL,IS_ACTIVE,USER_ROLE,LECTURER_ID,STUDENT_ID,ADMINISTRATOR_ID) values ('Julia','Klimek','Julia@Klimek.com','1','lecturer','1',null,null);
Insert into "USER" (LOGIN,PASSWORD,E_MAIL,IS_ACTIVE,USER_ROLE,LECTURER_ID,STUDENT_ID,ADMINISTRATOR_ID) values ('Kacper','Baran','Kacper@Baran.com','1','lecturer','1',null,null);
Insert into "USER" (LOGIN,PASSWORD,E_MAIL,IS_ACTIVE,USER_ROLE,LECTURER_ID,STUDENT_ID,ADMINISTRATOR_ID) values ('Jan','Czy¿','Jan@Czy¿.com','1','lecturer','1',null,null);
Insert into "USER" (LOGIN,PASSWORD,E_MAIL,IS_ACTIVE,USER_ROLE,LECTURER_ID,STUDENT_ID,ADMINISTRATOR_ID) values ('Ernest','Jakubowski','Ernest@Jakubowski.com','1','lecturer','1',null,null);
Insert into "USER" (LOGIN,PASSWORD,E_MAIL,IS_ACTIVE,USER_ROLE,LECTURER_ID,STUDENT_ID,ADMINISTRATOR_ID) values ('Stefan','Olszewski','Stefan@Olszewski.com','1','lecturer','1',null,null);
Insert into "USER" (LOGIN,PASSWORD,E_MAIL,IS_ACTIVE,USER_ROLE,LECTURER_ID,STUDENT_ID,ADMINISTRATOR_ID) values ('Ignacy','Jasiñski','Ignacy@Jasiñski.com','1','lecturer','1',null,null);
Insert into "USER" (LOGIN,PASSWORD,E_MAIL,IS_ACTIVE,USER_ROLE,LECTURER_ID,STUDENT_ID,ADMINISTRATOR_ID) values ('Jakub','Stêpieñ','Jakub@Stêpieñ.com','1','lecturer','1',null,null);


Insert into CLASSROOM (ID,CAPACITY,TYPE,FACULTY_ID) values (classroom_id_seq.nextval, '100', 'Aula wykladowa','1');
Insert into CLASSROOM (ID,CAPACITY,TYPE,FACULTY_ID) values (classroom_id_seq.nextval, '30', 'Sala dydaktyczna','2');
Insert into CLASSROOM (ID,CAPACITY,TYPE,FACULTY_ID) values (classroom_id_seq.nextval, '15', 'Laboratorium komputerowe','3');
Insert into CLASSROOM (ID,CAPACITY,TYPE,FACULTY_ID) values (classroom_id_seq.nextval, '100', 'Aula wykladowaa','1');
Insert into CLASSROOM (ID,CAPACITY,TYPE,FACULTY_ID) values (classroom_id_seq.nextval, '30', 'Sala dydaktyczna','2');
Insert into CLASSROOM (ID,CAPACITY,TYPE,FACULTY_ID) values (classroom_id_seq.nextval, '15', 'Laboratorium komputerowe','3');
Insert into CLASSROOM (ID,CAPACITY,TYPE,FACULTY_ID) values (classroom_id_seq.nextval, '100', 'Aula wykladowawa','1');
Insert into CLASSROOM (ID,CAPACITY,TYPE,FACULTY_ID) values (classroom_id_seq.nextval, '30', 'Sala dydaktyczna','2');
Insert into CLASSROOM (ID,CAPACITY,TYPE,FACULTY_ID) values (classroom_id_seq.nextval, '15', 'Laboratorium komputerowe','3');


Insert into SUBJECT (ID,NAME,SEMESTER,ECTS,LECTURER_ID,STUDENTS_GROUP_ID) values (subject_id_seq.nextval, 'Analiza matematyczna', '1', '6', '1','1');

Insert into TRANSCRIPT (ID,ISSUE_DATE,STUDENT_ID,STUDENTS_GROUP_ID) values (transcript_id_seq.nextval, '2013-09-25'), '1', '1'); 

Insert into ENROLLMENT (ID, MARK, ISSUE_DATE, SUBJECT_ID, TRANSCRIPT_ID) values (enrollment_id_seq.nextval, '4','2014-11-10', '1', '1');

Insert into PARTIAL_MARK (ID, MARK, ISSUE_DATE, SUBJECT_ID, TRANSCRIPT_ID) values (partial_mark_id_seq.nextval, '4', '2015-12-09', '1', '1');

Insert into SCHOLARSHIP_TYPE (TYPE, REQUIREMENTS, AMOUNT) values ('Stypendium rektora', 'Œrednia powy¿ej 4.5', '500');

Insert into SCHOLARSHIP (ID, GRANT_DATE, END_DATE, SCHOLARSHIP_TYPE, STUDENT_ID, ADMINISTRATOR_ID) values (scholarship_id_seq.nextval, '2014-09-10', '2015-09-09', 'Stypendium rektora', '1', '1');

Insert into PAYMENT (ID, TITLE, DESCRIPTION, AMOUNT, ISSUE_DATE, PAYMENT_DATE, STUDENT_ID, ADMINISTRATOR_ID) values (payment_id_seq.nextval, 'Legitymacja studencka', 'P³atnoœæ za legitymacjê studenck¹', '50', '2013-08-25', '2013-09-10', '1', '1');

Insert into MESSAGE (ID, TITLE, CONTENT, DISPATCH_DATE, RECEIVE_DATE, SENDER_ID, RECEIVER_ID) values (message_id_seq.nextval, 'Termin poprawy', 'Szanowny Panie Profesorze...', '2015-12-09', '2015-12-09', );

Insert into APPLICATION (ID, TITLE, CONTENT, DISPATCH_DATE, RECEIVE_DATE, STUDENT_ID, ADMINISTRATOR_ID) values (application_id_seq.nextval, 'Wniosek o urlop dziekañski', 'Szanowna...', '2015-09-09', '2015-09-09', '1', '1');

-------------------
TO FIX:

Insert into SCHEDULED_CLASSES (ID, DATE, TIME, DURATION, CLASSROOM_ID, SUBJECT_ID) values (scheduled_classes_id_seq.nextval, '2016-02-02', '11:00:00', '90', '1', '1');







CREATE TABLE administrator
  (
    id              INTEGER NOT NULL ,
    name            VARCHAR(256) NOT NULL ,
    surname         VARCHAR(256) NOT NULL ,
    address         VARCHAR(512) NOT NULL ,
    academic_degree VARCHAR(256) ,
    position        VARCHAR(256) NOT NULL ,
    university_id   INTEGER NOT NULL
  ) ;
ALTER TABLE administrator ADD CONSTRAINT administrator_PK PRIMARY KEY ( id ) ;


CREATE TABLE app_user
  (
    login            VARCHAR(128) NOT NULL ,
    password         VARCHAR(256) NOT NULL ,
	salt 			 VARCHAR(128) NOT NULL ,
    e_mail           VARCHAR(128) NOT NULL ,
    is_active        INTEGER NOT NULL ,
    user_role        VARCHAR(64) NOT NULL ,
    lecturer_id      INTEGER ,
    student_id       INTEGER ,
    administrator_id INTEGER
  ) ;
ALTER TABLE app_user ADD CONSTRAINT users_PK PRIMARY KEY ( login ) ;
ALTER TABLE app_user ADD CONSTRAINT users_UN UNIQUE ( e_mail ) ;

CREATE TABLE password_reset
  (
    id            	 VARCHAR(256) NOT NULL ,
    is_active        INTEGER NOT NULL ,
	request_date     DATE NOT NULL,
	app_user_login   VARCHAR(128) NOT NULL
  ) ;
ALTER TABLE password_reset ADD CONSTRAINT password_reset_PK PRIMARY KEY ( id ) ;

CREATE TABLE application_type
  (
    type_id    INTEGER NOT NULL ,
    type_name VARCHAR(256) NOT NULL
  ) ;
ALTER TABLE application_type ADD CONSTRAINT application_type_PK PRIMARY KEY ( type_id ) ;

CREATE TABLE application
  (
    id    INTEGER NOT NULL ,
    title VARCHAR(256) NOT NULL ,
    content TEXT NOT NULL ,
    dispatch_date    DATE NOT NULL ,
    status           VARCHAR(256) NOT NULL ,
    student_id       INTEGER NOT NULL ,
    administrator_id INTEGER NOT NULL ,
    application_type_id INTEGER NOT NULL
  ) ;
ALTER TABLE application ADD CONSTRAINT application_PK PRIMARY KEY ( id ) ;


CREATE TABLE classroom
  (
    id         INTEGER NOT NULL ,
    nr         INTEGER NOT NULL ,
    capacity   INTEGER NOT NULL ,
    type       VARCHAR(256) NOT NULL ,
    faculty_id INTEGER NOT NULL
  ) ;
ALTER TABLE classroom ADD CONSTRAINT classroom_PK PRIMARY KEY ( id ) ;


CREATE TABLE course
  (
    id         INTEGER NOT NULL ,
    name       VARCHAR(256) NOT NULL ,
    stationary INTEGER NOT NULL ,
    faculty_id INTEGER NOT NULL
  ) ;
ALTER TABLE course ADD CONSTRAINT course_PK PRIMARY KEY ( id ) ;
ALTER TABLE course ADD CONSTRAINT course__UN UNIQUE ( name , stationary ) ;


CREATE TABLE enrollment
  (
    id            INTEGER NOT NULL ,
    mark          NUMERIC (3,2) NOT NULL ,
    issue_date    DATE NOT NULL ,
    subject_id    INTEGER NOT NULL ,
    transcript_id INTEGER NOT NULL
  ) ;
ALTER TABLE enrollment ADD CONSTRAINT enrollment_PK PRIMARY KEY ( id ) ;


CREATE TABLE faculty
  (
    id            INTEGER NOT NULL ,
    name          VARCHAR(256) NOT NULL ,
    address       VARCHAR(1024) NOT NULL ,
    university_id INTEGER NOT NULL
  ) ;
ALTER TABLE faculty ADD CONSTRAINT faculty_PK PRIMARY KEY ( id ) ;
ALTER TABLE faculty ADD CONSTRAINT faculty__UN UNIQUE ( name ) ;


CREATE TABLE faculty_lecturer
  (
    faculty_id  INTEGER NOT NULL ,
    lecturer_id INTEGER NOT NULL
  ) ;
ALTER TABLE faculty_lecturer ADD CONSTRAINT faculty_lecturer_PK PRIMARY KEY ( faculty_id, lecturer_id ) ;


CREATE TABLE learning_materials
  (
    id   INTEGER NOT NULL ,
    name VARCHAR(256) NOT NULL ,
    description TEXT NOT NULL ,
    file_link  VARCHAR(2048) NOT NULL ,
    subject_id INTEGER NOT NULL
  ) ;
ALTER TABLE learning_materials ADD CONSTRAINT learning_materials_PK PRIMARY KEY ( id ) ;


CREATE TABLE lecturer
  (
    id              INTEGER NOT NULL ,
    name            VARCHAR(256) NOT NULL ,
    surname         VARCHAR(256) NOT NULL ,
    address         VARCHAR(512) NOT NULL ,
    academic_degree VARCHAR(256) NOT NULL ,
    position        VARCHAR(256) NOT NULL ,
    website         VARCHAR(256) ,
    consultation_info VARCHAR(256)
  ) ;
ALTER TABLE lecturer ADD CONSTRAINT lecturer_PK PRIMARY KEY ( id ) ;


CREATE TABLE message
  (
    id    INTEGER NOT NULL ,
    title VARCHAR(256) NOT NULL ,
    content TEXT NOT NULL ,
    dispatch_date DATE NOT NULL ,
    receive_date  DATE ,
    sender_id     VARCHAR(256) NOT NULL ,
    receiver_id   VARCHAR(256) NOT NULL
  ) ;
ALTER TABLE message ADD CONSTRAINT message_PK PRIMARY KEY ( id ) ;

CREATE TABLE news
  (
    id    INTEGER NOT NULL ,
    title VARCHAR(256) NOT NULL ,
    content TEXT NOT NULL ,
    dispatch_date DATE NOT NULL ,
    sender_id     VARCHAR(256) NOT NULL 
  ) ;
ALTER TABLE news ADD CONSTRAINT news_PK PRIMARY KEY ( id ) ;

CREATE TABLE partial_mark
  (
    id            INTEGER NOT NULL ,
    mark          NUMERIC (3,2) NOT NULL ,
    issue_date    DATE NOT NULL ,
    subject_id    INTEGER NOT NULL ,
    transcript_id INTEGER NOT NULL
  ) ;
ALTER TABLE partial_mark ADD CONSTRAINT partial_mark_PK PRIMARY KEY ( id ) ;


CREATE TABLE payment
  (
    id    INTEGER NOT NULL ,
    title VARCHAR(256) NOT NULL ,
    description TEXT NOT NULL ,
    amount           NUMERIC (8,2) NOT NULL ,
    issue_date       DATE NOT NULL ,
    payment_date     DATE ,
    student_id       INTEGER NOT NULL ,
    administrator_id INTEGER NOT NULL
  ) ;
ALTER TABLE payment ADD CONSTRAINT payment_PK PRIMARY KEY ( id ) ;

CREATE TABLE reservation_request
  (
    id	INTEGER NOT NULL ,
    subject_id	INTEGER NOT NULL,
	classroom_id	INTEGER NOT NULL ,
	request_date	DATE NOT NULL ,
	classes_date TIMESTAMP (0) NOT NULL ,
	classes_end_date TIMESTAMP (0) ,
	repeat_classes INTEGER NOT NULL,
	status VARCHAR(256) NOT NULL
  ) ;
ALTER TABLE reservation_request ADD CONSTRAINT reservation_request_PK PRIMARY KEY ( id ) ;

CREATE TABLE scheduled_classes
  (
    id           INTEGER NOT NULL ,
    classes_date TIMESTAMP (0) NOT NULL ,
    duration     INTEGER NOT NULL ,
    classroom_id INTEGER NOT NULL ,
    subject_id   INTEGER NOT NULL
  ) ;
ALTER TABLE scheduled_classes ADD CONSTRAINT scheduled_classes_PK PRIMARY KEY ( id ) ;


CREATE TABLE scholarship
  (
    id               INTEGER NOT NULL ,
    grant_date       DATE NOT NULL ,
    end_date         DATE NOT NULL ,
    scholarship_type VARCHAR(256) NOT NULL ,
    student_id       INTEGER NOT NULL ,
    administrator_id INTEGER NOT NULL
  ) ;
ALTER TABLE scholarship ADD CONSTRAINT schollarship_PK PRIMARY KEY ( id ) ;


CREATE TABLE scholarship_type
  (
    type VARCHAR(256) NOT NULL ,
    requirements TEXT NOT NULL ,
    amount NUMERIC (8,2) NOT NULL
  ) ;
ALTER TABLE scholarship_type ADD CONSTRAINT schollarship_type_PK PRIMARY KEY ( type ) ;


CREATE TABLE student
  (
    id              INTEGER NOT NULL ,
    name            VARCHAR(256) NOT NULL ,
    surname         VARCHAR(256) NOT NULL ,
    academic_degree VARCHAR(256) ,
    address         VARCHAR(256) NOT NULL
  ) ;
ALTER TABLE student ADD CONSTRAINT student_PK PRIMARY KEY ( id ) ;


CREATE TABLE students_group
  (
    id        INTEGER NOT NULL ,
    semester  INTEGER NOT NULL ,
    course_id INTEGER NOT NULL
  ) ;
ALTER TABLE students_group ADD CONSTRAINT students_group_PK PRIMARY KEY ( id ) ;


CREATE TABLE students_group_student
  (
    students_group_id INTEGER NOT NULL ,
    student_id        INTEGER NOT NULL
  ) ;
ALTER TABLE students_group_student ADD CONSTRAINT students_group_student_PK PRIMARY KEY ( students_group_id, student_id ) ;


CREATE TABLE students_group_subject
  (
    students_group_id INTEGER NOT NULL ,
    subject_id        INTEGER NOT NULL
  ) ;
ALTER TABLE students_group_subject ADD CONSTRAINT students_group_subject_PK PRIMARY KEY ( students_group_id, subject_id ) ;

CREATE TABLE subject
  (
    id          INTEGER NOT NULL ,
    name        VARCHAR(256) NOT NULL ,
    semester    INTEGER NOT NULL ,
    ECTS        INTEGER NOT NULL ,
    lecturer_id INTEGER NOT NULL
  ) ;
ALTER TABLE subject ADD CONSTRAINT subject_PK PRIMARY KEY ( id ) ;


CREATE TABLE transcript
  (
    id                INTEGER NOT NULL ,
    issue_date        DATE NOT NULL ,
    student_id        INTEGER NOT NULL ,
    students_group_id INTEGER NOT NULL
  ) ;
ALTER TABLE transcript ADD CONSTRAINT transcript_PK PRIMARY KEY ( id ) ;


CREATE TABLE university
  (
    id      INTEGER NOT NULL ,
    name    VARCHAR(256) NOT NULL ,
    address VARCHAR(512) NOT NULL
  ) ;
ALTER TABLE university ADD CONSTRAINT university_PK PRIMARY KEY ( id ) ;
ALTER TABLE university ADD CONSTRAINT university__UN UNIQUE ( name ) ;


ALTER TABLE administrator ADD CONSTRAINT administrator_university_FK FOREIGN KEY ( university_id ) REFERENCES university ( id ) ON
DELETE CASCADE ;

ALTER TABLE password_reset ADD CONSTRAINT password_reset_appuser_FK FOREIGN KEY ( app_user_login ) REFERENCES app_user ( login ) ON
DELETE CASCADE ;

ALTER TABLE application ADD CONSTRAINT application_administrator_FK FOREIGN KEY ( administrator_id ) REFERENCES administrator ( id ) ON
DELETE CASCADE ;

ALTER TABLE application ADD CONSTRAINT application_student_FK FOREIGN KEY ( student_id ) REFERENCES student ( id ) ON
DELETE CASCADE ;

ALTER TABLE application ADD CONSTRAINT application_type_FK FOREIGN KEY (application_type_id) REFERENCES application_type (type_id) ON
DELETE CASCADE ;

ALTER TABLE classroom ADD CONSTRAINT classroom_faculty_FK FOREIGN KEY ( faculty_id ) REFERENCES faculty ( id ) ON
DELETE CASCADE ;

ALTER TABLE course ADD CONSTRAINT course_faculty_FK FOREIGN KEY ( faculty_id ) REFERENCES faculty ( id ) ON
DELETE CASCADE ;

ALTER TABLE enrollment ADD CONSTRAINT enrollment_subject_FK FOREIGN KEY ( subject_id ) REFERENCES subject ( id ) ON
DELETE CASCADE ;

ALTER TABLE enrollment ADD CONSTRAINT enrollment_transcript_FK FOREIGN KEY ( transcript_id ) REFERENCES transcript ( id ) ON
DELETE CASCADE ;

ALTER TABLE faculty_lecturer ADD CONSTRAINT faculty_lecturer_faculty_FK FOREIGN KEY ( faculty_id ) REFERENCES faculty ( id ) ON
DELETE CASCADE ;

ALTER TABLE faculty_lecturer ADD CONSTRAINT faculty_lecturer_lecturer_FK FOREIGN KEY ( lecturer_id ) REFERENCES lecturer ( id ) ON
DELETE CASCADE ;

ALTER TABLE faculty ADD CONSTRAINT faculty_university_FK FOREIGN KEY ( university_id ) REFERENCES university ( id ) ON
DELETE CASCADE ;

ALTER TABLE learning_materials ADD CONSTRAINT learning_materials_subject_FK FOREIGN KEY ( subject_id ) REFERENCES subject ( id ) ON
DELETE CASCADE ;

ALTER TABLE message ADD CONSTRAINT message_users_FK FOREIGN KEY ( sender_id ) REFERENCES app_user ( login ) ON
DELETE CASCADE ;

ALTER TABLE message ADD CONSTRAINT message_users_FKv1 FOREIGN KEY ( receiver_id ) REFERENCES app_user ( login ) ON
DELETE CASCADE ;

ALTER TABLE news ADD CONSTRAINT news_users_FK FOREIGN KEY ( sender_id ) REFERENCES app_user ( login ) ON
DELETE CASCADE ;

ALTER TABLE partial_mark ADD CONSTRAINT partial_mark_subject_FK FOREIGN KEY ( subject_id ) REFERENCES subject ( id ) ON
DELETE CASCADE ;

ALTER TABLE partial_mark ADD CONSTRAINT partial_mark_transcript_FK FOREIGN KEY ( transcript_id ) REFERENCES transcript ( id ) ON
DELETE CASCADE ;

ALTER TABLE payment ADD CONSTRAINT payment_administrator_FK FOREIGN KEY ( administrator_id ) REFERENCES administrator ( id ) ;

ALTER TABLE payment ADD CONSTRAINT payment_student_FK FOREIGN KEY ( student_id ) REFERENCES student ( id ) ON
DELETE CASCADE ;

ALTER TABLE reservation_request ADD CONSTRAINT reservation_request_subject_FK FOREIGN KEY ( subject_id ) REFERENCES subject ( id ) ON
DELETE CASCADE ;

ALTER TABLE reservation_request ADD CONSTRAINT reservation_request_classroom_FK FOREIGN KEY ( classroom_id ) REFERENCES classroom ( id ) ON
DELETE CASCADE ;

ALTER TABLE scheduled_classes ADD CONSTRAINT scheduled_classes_classroom_FK FOREIGN KEY ( classroom_id ) REFERENCES classroom ( id ) ON
DELETE CASCADE ;

ALTER TABLE scheduled_classes ADD CONSTRAINT scheduled_classes_subject_FK FOREIGN KEY ( subject_id ) REFERENCES subject ( id ) ON
DELETE CASCADE ;

ALTER TABLE scholarship ADD CONSTRAINT schollarship_administrator_FK FOREIGN KEY ( administrator_id ) REFERENCES administrator ( id ) ON
DELETE CASCADE ;

ALTER TABLE scholarship ADD CONSTRAINT schollarship_student_FK FOREIGN KEY ( student_id ) REFERENCES student ( id ) ON
DELETE CASCADE ;

ALTER TABLE scholarship ADD CONSTRAINT schollarship_type_FK FOREIGN KEY ( scholarship_type ) REFERENCES scholarship_type ( type ) ON
DELETE CASCADE ;

ALTER TABLE students_group_subject ADD CONSTRAINT sg_subject_students_group_FK FOREIGN KEY ( students_group_id ) REFERENCES students_group ( id ) ;

ALTER TABLE students_group_subject ADD CONSTRAINT sg_subject_subject_FK FOREIGN KEY ( subject_id ) REFERENCES subject ( id ) ;

ALTER TABLE students_group_student ADD CONSTRAINT sgs_student_FK FOREIGN KEY ( student_id ) REFERENCES student ( id ) ON
DELETE CASCADE ;

ALTER TABLE students_group_student ADD CONSTRAINT sgs_students_group_FK FOREIGN KEY ( students_group_id ) REFERENCES students_group ( id ) ON
DELETE CASCADE ;

ALTER TABLE students_group ADD CONSTRAINT students_group_course_FK FOREIGN KEY ( course_id ) REFERENCES course ( id ) ON
DELETE CASCADE ;

ALTER TABLE subject ADD CONSTRAINT subject_lecturer_FK FOREIGN KEY ( lecturer_id ) REFERENCES lecturer ( id ) ON
DELETE CASCADE ;

ALTER TABLE transcript ADD CONSTRAINT transcript_student_FK FOREIGN KEY ( student_id ) REFERENCES student ( id ) ON
DELETE CASCADE ;

ALTER TABLE transcript ADD CONSTRAINT transcript_students_group_FK FOREIGN KEY ( students_group_id ) REFERENCES students_group ( id ) ON
DELETE CASCADE ;

ALTER TABLE app_user ADD CONSTRAINT users_administrator_FK FOREIGN KEY ( administrator_id ) REFERENCES administrator ( id ) ON
DELETE CASCADE ;

ALTER TABLE app_user ADD CONSTRAINT users_lecturer_FK FOREIGN KEY ( lecturer_id ) REFERENCES lecturer ( id ) ON
DELETE CASCADE ;

ALTER TABLE app_user ADD CONSTRAINT users_student_FK FOREIGN KEY ( student_id ) REFERENCES student ( id ) ON
DELETE CASCADE ;
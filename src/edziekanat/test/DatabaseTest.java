package edziekanat.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edziekanat.databasemodel.dao.AdministratorDAO;
import edziekanat.databasemodel.dao.ApplicationDAO;
import edziekanat.databasemodel.dao.ClassroomDAO;
import edziekanat.databasemodel.dao.CourseDAO;
import edziekanat.databasemodel.dao.EnrollmentDAO;
import edziekanat.databasemodel.dao.FacultyDAO;
import edziekanat.databasemodel.dao.LearningMaterialsDAO;
import edziekanat.databasemodel.dao.LecturerDAO;
import edziekanat.databasemodel.dao.MessageDAO;
import edziekanat.databasemodel.dao.PartialMarkDAO;
import edziekanat.databasemodel.dao.PaymentDAO;
import edziekanat.databasemodel.dao.ScheduledClassesDAO;
import edziekanat.databasemodel.dao.ScholarshipDAO;
import edziekanat.databasemodel.dao.ScholarshipTypeDAO;
import edziekanat.databasemodel.dao.StudentDAO;
import edziekanat.databasemodel.dao.SubjectDAO;
import edziekanat.databasemodel.dao.TranscriptDAO;
import edziekanat.databasemodel.dao.UniversityDAO;
import edziekanat.databasemodel.dao.UserDAO;
import edziekanat.databasemodel.dto.AdministratorDTO;
import edziekanat.databasemodel.dto.ApplicationDTO;
import edziekanat.databasemodel.dto.ClassroomDTO;
import edziekanat.databasemodel.dto.CourseDTO;
import edziekanat.databasemodel.dto.EnrollmentDTO;
import edziekanat.databasemodel.dto.FacultyDTO;
import edziekanat.databasemodel.dto.LearningMaterialsDTO;
import edziekanat.databasemodel.dto.LecturerDTO;
import edziekanat.databasemodel.dto.MessageDTO;
import edziekanat.databasemodel.dto.PartialMarkDTO;
import edziekanat.databasemodel.dto.PaymentDTO;
import edziekanat.databasemodel.dto.ScheduledClassesDTO;
import edziekanat.databasemodel.dto.ScholarshipDTO;
import edziekanat.databasemodel.dto.ScholarshipTypeDTO;
import edziekanat.databasemodel.dto.StudentDTO;
import edziekanat.databasemodel.dto.SubjectDTO;
import edziekanat.databasemodel.dto.TranscriptDTO;
import edziekanat.databasemodel.dto.UniversityDTO;
import edziekanat.databasemodel.dto.UserDTO;

/**
 * Servlet implementation class DatabaseTest
 */
@WebServlet("/test")
public class DatabaseTest extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
	doPost(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
	response.setContentType("text/html");
	PrintWriter out = response.getWriter();

	out.println("<p>ONE ADMIN");
	AdministratorDTO admin = new AdministratorDAO().getEntity(1);
	out.println("<br>" + admin.getName());
	out.println("<br>" + admin.getPosition());
	out.println("<br>" + admin.getAddress());
	out.println("<br>" + admin.getSurname());
	out.println("<br>" + admin.getId());
	out.println("<br>" + admin.getUniversity().getName());

	out.println("<p>ALL ADMINS");
	new AdministratorDAO().getAllEntities().forEach(item -> {
	    out.println("<br>" + item.getName());
	    out.println("<br>" + item.getPosition());
	    out.println("<br>" + item.getAddress());
	    out.println("<br>" + item.getSurname());
	    out.println("<br>" + item.getId());
	    out.println("<br>" + item.getUniversity().getName());
	    out.println("<br> nastepny");
	});
	out.println("ONE APPLICATION");
	ApplicationDTO app = new ApplicationDAO().getEntity(1);
	out.println("<br>" + app.getContent());
	out.println("<br>" + app.getTitle());
	out.println("<br>" + app.getAdministrator().getName());
	out.println("<br>" + app.getId());
	out.println("<br>" + app.getStudent().getName());
	out.println("<br>" + app.getDispatchDate());
	out.println("<br>" + app.getStatus());

	out.println("<p>ALL APPLICATIONS");
	new ApplicationDAO().getAllEntities().forEach(item -> {
	    out.println("<br>" + item.getContent());
	    out.println("<br>" + item.getTitle());
	    out.println("<br>" + item.getAdministrator().getName());
	    out.println("<br>" + item.getId());
	    out.println("<br>" + item.getStudent().getName());
	    out.println("<br>" + item.getDispatchDate());
	    out.println("<br>" + item.getStatus());
	    out.println("<br> nastepny");
	});
	out.println("ONE Classroom");
	ClassroomDTO classroom = new ClassroomDAO().getEntity(1);
	out.println("<br>" + classroom.getType());
	out.println("<br>" + classroom.getCapacity());
	out.println("<br>" + classroom.getFaculty().getName());
	out.println("<br>" + classroom.getId());

	out.println("<p>ALL Classrooms");
	new ClassroomDAO().getAllEntities().forEach(item -> {
	    out.println("<br>" + item.getType());
	    out.println("<br>" + item.getCapacity());
	    out.println("<br>" + item.getFaculty().getName());
	    out.println("<br>" + item.getId());
	    out.println("<br> nastepny");
	});
	out.println("ONE Course");
	CourseDTO course = new CourseDAO().getEntity(1);
	out.println("<br>" + course.getName());
	out.println("<br>" + course.getFaculty().getName());
	out.println("<br>" + course.getId());
	out.println("<br>" + course.getStationary());

	out.println("<p>ALL Courses");
	new CourseDAO().getAllEntities().forEach(item -> {
	    out.println("<br>" + item.getName());
	    out.println("<br>" + item.getFaculty().getName());
	    out.println("<br>" + item.getId());
	    out.println("<br>" + item.getStationary());
	    out.println("<br> nastepny");
	});
	out.println("ONE Enrollment");
	EnrollmentDTO enrollment = new EnrollmentDAO().getEntity(1);
	out.println("<br>" + enrollment.getId());
	out.println("<br>" + enrollment.getMark());
	out.println("<br>" + enrollment.getSubject());
	out.println("<br>" + enrollment.getTranscript());
	out.println("<br>" + enrollment.getIssueDate());

	out.println("<p>ALL Enrollments");
	new EnrollmentDAO().getAllEntities().forEach(item -> {
	    out.println("<br>" + item.getId());
	    out.println("<br>" + item.getMark());
	    out.println("<br>" + item.getSubject());
	    out.println("<br>" + item.getTranscript());
	    out.println("<br>" + item.getIssueDate());
	    out.println("<br> nastepny");
	});

	out.println("ONE Faculty");
	FacultyDTO faculty = new FacultyDAO().getEntity(1);
	out.println("<br>" + faculty.getAddress());
	out.println("<br>" + faculty.getName());
	out.println("<br>" + faculty.getId());
	out.println("<br>" + faculty.getUniversity().getName());

	out.println("<p>ALL Facultys");
	new FacultyDAO().getAllEntities().forEach(item -> {
	    out.println("<br>" + item.getAddress());
	    out.println("<br>" + item.getName());
	    out.println("<br>" + item.getId());
	    out.println("<br>" + item.getUniversity().getName());
	    out.println("<br> nastepny");
	});

	out.println("ONE LearningMaterials");
	LearningMaterialsDTO learningMaterials = new LearningMaterialsDAO().getEntity(1);
	out.println("<br>" + learningMaterials.getDescription());
	out.println("<br>" + learningMaterials.getName());
	out.println("<br>" + learningMaterials.getId());
	out.println("<br>" + learningMaterials.getSubject().getName());
	out.println("<br>" + learningMaterials.getFile());

	out.println("<p>ALL LearningMaterialss");
	new LearningMaterialsDAO().getAllEntities().forEach(item -> {
	    out.println("<br>" + item.getDescription());
	    out.println("<br>" + item.getName());
	    out.println("<br>" + item.getId());
	    out.println("<br>" + item.getSubject().getName());
	    out.println("<br>" + item.getFile());
	    out.println("<br> nastepny");
	});

	out.println("ONE Lecturer");
	LecturerDTO lecturer = new LecturerDAO().getEntity(1);
	out.println("<br>" + lecturer.getAcademicDegree());
	out.println("<br>" + lecturer.getAddress());
	out.println("<br>" + lecturer.getName());
	out.println("<br>" + lecturer.getPosition());
	out.println("<br>" + lecturer.getSurname());
	out.println("<br>" + lecturer.getId());

	out.println("<p>ALL Lecturers");
	new LecturerDAO().getAllEntities().forEach(item -> {
	    out.println("<br>" + item.getAcademicDegree());
	    out.println("<br>" + item.getAddress());
	    out.println("<br>" + item.getName());
	    out.println("<br>" + item.getPosition());
	    out.println("<br>" + item.getSurname());
	    out.println("<br>" + item.getId());
	    out.println("<br> nastepny");
	});

	out.println("ONE Message");
	MessageDTO message = new MessageDAO().getEntity(1);
	out.println("<br>" + message.getContent());
	out.println("<br>" + message.getTitle());
	out.println("<br>" + message.getReceiver().getLogin());
	out.println("<br>" + message.getId());
	out.println("<br>" + message.getSender().getLogin());
	out.println("<br>" + message.getDispatchDate());
	out.println("<br>" + message.getReceiveDate());

	out.println("<p>ALL Messages");
	new MessageDAO().getAllEntities().forEach(item -> {
	    out.println("<br>" + item.getContent());
	    out.println("<br>" + item.getTitle());
	    out.println("<br>" + item.getReceiver().getLogin());
	    out.println("<br>" + item.getId());
	    out.println("<br>" + item.getSender().getLogin());
	    out.println("<br>" + item.getDispatchDate());
	    out.println("<br>" + item.getReceiveDate());
	    out.println("<br> nastepny");
	});

	out.println("ONE PartialMark");
	PartialMarkDTO partialMark = new PartialMarkDAO().getEntity(1);
	out.println("<br>" + partialMark.getId());
	out.println("<br>" + partialMark.getMark());
	out.println("<br>" + partialMark.getSubject().getName());
	out.println("<br>" + partialMark.getTranscript().getId());
	out.println("<br>" + partialMark.getIssueDate());

	out.println("<p>ALL PartialMarks");
	new PartialMarkDAO().getAllEntities().forEach(item -> {
	    out.println("<br>" + item.getId());
	    out.println("<br>" + item.getMark());
	    out.println("<br>" + item.getSubject().getName());
	    out.println("<br>" + item.getTranscript().getId());
	    out.println("<br>" + item.getIssueDate());
	    out.println("<br> nastepny");
	});

	out.println("ONE Payment");
	PaymentDTO payment = new PaymentDAO().getEntity(1);
	out.println("<br>" + payment.getAmount());
	out.println("<br>" + payment.getTitle());
	out.println("<br>" + payment.getAdministrator().getName());
	out.println("<br>" + payment.getId());
	out.println("<br>" + payment.getStudent().getName());
	out.println("<br>" + payment.getDescription());
	out.println("<br>" + payment.getIssueDate());
	out.println("<br>" + payment.getPaymentDate());

	out.println("<p>ALL Payments");
	new PaymentDAO().getAllEntities().forEach(item -> {
	    out.println("<br>" + item.getAmount());
	    out.println("<br>" + item.getTitle());
	    out.println("<br>" + item.getAdministrator().getName());
	    out.println("<br>" + item.getId());
	    out.println("<br>" + item.getStudent().getName());
	    out.println("<br>" + item.getDescription());
	    out.println("<br>" + item.getIssueDate());
	    out.println("<br>" + item.getPaymentDate());
	    out.println("<br> nastepny");
	});

	out.println("ONE ScheduledClasses");
	ScheduledClassesDTO scheduledClasses = new ScheduledClassesDAO().getEntity(1);
	out.println("<br>" + scheduledClasses.getClassroom().getId());
	out.println("<br>" + scheduledClasses.getDuration());
	out.println("<br>" + scheduledClasses.getId());
	out.println("<br>" + scheduledClasses.getSubject().getName());
	out.println("<br>" + scheduledClasses.getDate());
	out.println("<br>" + scheduledClasses.getTime());

	out.println("<p>ALL ScheduledClassess");
	new ScheduledClassesDAO().getAllEntities().forEach(item -> {
	    out.println("<br>" + item.getClassroom().getId());
	    out.println("<br>" + item.getDuration());
	    out.println("<br>" + item.getId());
	    out.println("<br>" + item.getSubject().getName());
	    out.println("<br>" + item.getDate());
	    out.println("<br>" + item.getTime());
	    out.println("<br> nastepny");
	});
	out.println("ONE Scholarship");
	ScholarshipDTO scholarship = new ScholarshipDAO().getEntity(1);
	out.println("<br>" + scholarship.getScholarshipType());
	out.println("<br>" + scholarship.getAdministrator());
	out.println("<br>" + scholarship.getId());
	out.println("<br>" + scholarship.getStudent());
	out.println("<br>" + scholarship.getEndDate());
	out.println("<br>" + scholarship.getGrantDate());

	out.println("<p>ALL Scholarships");
	new ScholarshipDAO().getAllEntities().forEach(item -> {
	    out.println("<br>" + item.getScholarshipType());
	    out.println("<br>" + item.getAdministrator());
	    out.println("<br>" + item.getId());
	    out.println("<br>" + item.getStudent());
	    out.println("<br>" + item.getEndDate());
	    out.println("<br>" + item.getGrantDate());
	    out.println("<br> nastepny");
	});
	out.println("ONE ScholarshipType");
	ScholarshipTypeDTO scholarshipType = new ScholarshipTypeDAO().getEntity(1);
	out.println("<br>" + scholarshipType.getRequirements());
	out.println("<br>" + scholarshipType.getType());
	out.println("<br>" + scholarshipType.getAmount());

	out.println("<p>ALL ScholarshipTypes");
	new ScholarshipTypeDAO().getAllEntities().forEach(item -> {
	    out.println("<br>" + item.getRequirements());
	    out.println("<br>" + item.getType());
	    out.println("<br>" + item.getAmount());
	    out.println("<br> nastepny");
	});
	out.println("ONE Student");
	StudentDTO student = new StudentDAO().getEntity(1);
	out.println("<br>" + student.getAcademicDegree());
	out.println("<br>" + student.getAddress());
	out.println("<br>" + student.getName());
	out.println("<br>" + student.getSurname());
	out.println("<br>" + student.getId());

	out.println("<p>ALL Students");
	new StudentDAO().getAllEntities().forEach(item -> {
	    out.println("<br>" + item.getAcademicDegree());
	    out.println("<br>" + item.getAddress());
	    out.println("<br>" + item.getName());
	    out.println("<br>" + item.getSurname());
	    out.println("<br>" + item.getId());
	    out.println("<br> nastepny");
	});

	out.println("ONE Subject");
	SubjectDTO subject = new SubjectDAO().getEntity(1);
	out.println("<br>" + subject.getName());
	out.println("<br>" + subject.getECTS());
	out.println("<br>" + subject.getId());
	out.println("<br>" + subject.getLecturer().getName());
	out.println("<br>" + subject.getSemester());
	out.println("<br>" + subject.getStudentsGroup().get(0).getId());

	out.println("<p>ALL Subjects");
	new SubjectDAO().getAllEntities().forEach(item -> {
	    out.println("<br>" + item.getName());
	    out.println("<br>" + item.getECTS());
	    out.println("<br>" + item.getId());
	    out.println("<br>" + item.getLecturer().getName());
	    out.println("<br>" + item.getSemester());
	    out.println("<br>" + item.getStudentsGroup().get(0).getId());
	    out.println("<br> nastepny");
	});

	out.println("ONE Transcript");
	TranscriptDTO transcript = new TranscriptDAO().getEntity(1);
	out.println("<br>" + transcript.getId());
	out.println("<br>" + transcript.getStudent().getName());
	out.println("<br>" + transcript.getStudentsGroup().getId());
	out.println("<br>" + transcript.getIssueDate());

	out.println("<p>ALL Transcripts");
	new TranscriptDAO().getAllEntities().forEach(item -> {
	    out.println("<br>" + item.getId());
	    out.println("<br>" + item.getStudent().getName());
	    out.println("<br>" + item.getStudentsGroup().getId());
	    out.println("<br>" + item.getIssueDate());
	    out.println("<br> nastepny");
	});

	out.println("ONE University");
	UniversityDTO university = new UniversityDAO().getEntity(1);
	out.println("<br>" + university.getAddress());
	out.println("<br>" + university.getName());
	out.println("<br>" + university.getId());

	out.println("<p>ALL Universitys");
	new UniversityDAO().getAllEntities().forEach(item -> {
	    out.println("<br>" + item.getAddress());
	    out.println("<br>" + item.getName());
	    out.println("<br>" + item.getId());
	    out.println("<br> nastepny");
	});

	out.println("ONE USER");
	UserDTO user = new UserDAO().getEntity("admin");
	out.println("<br>" + user.getLogin());
	out.println("<br>" + user.getPassword());
	out.println("<br>" + user.geteMail());
	out.println("<br>" + user.getUserRole());
	out.println("<br>" + user.getAdministrator().getName());
	out.println("<br>" + user.getLecturer().getName());
	out.println("<br>" + user.getStudent().getName());

	out.println("<p>ALL USERS");
	new UserDAO().getAllEntities().forEach(item -> {
	    out.println("<br>" + item.getLogin());
	    out.println("<br>" + item.getPassword());
	    out.println("<br>" + item.geteMail());
	    out.println("<br>" + item.getUserRole());
	    out.println("<br>" + item.getAdministrator().getName());
	    out.println("<br>" + item.getLecturer().getName());
	    out.println("<br>" + item.getStudent().getName());
	    out.println("<br> nastepny");
	});

    }

}

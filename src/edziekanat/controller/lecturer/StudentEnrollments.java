package edziekanat.controller.lecturer;

import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edziekanat.bean.LoginBean;
import edziekanat.databasemodel.dao.EnrollmentDAO;
import edziekanat.databasemodel.dao.StudentDAO;
import edziekanat.databasemodel.dao.SubjectDAO;
import edziekanat.databasemodel.dto.EnrollmentDTO;
import edziekanat.databasemodel.dto.SubjectDTO;

/**
 * Servlet showing all enrollments received by student.
 */
@WebServlet("/studentenrollments")
public class StudentEnrollments extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
	doPost(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
	SubjectDAO subjectDAO = new SubjectDAO();
	StudentDAO studentDAO = new StudentDAO();
	EnrollmentDAO enrollmentDAO = new EnrollmentDAO();

	List<EnrollmentDTO> enrollments = new LinkedList<EnrollmentDTO>();

	String subjectIdString = request.getParameter("subjectId");
	Integer studentId = Integer.parseInt(request.getParameter("studentId"));

	if (!subjectIdString.isEmpty())
	{
	    Integer subjectId = Integer.parseInt(subjectIdString);
	    request.setAttribute("subject", subjectDAO.getEntity(subjectId));
	    enrollments = enrollmentDAO.getStudentEnrollmentsFromSubject(subjectId, studentId);
	}
	else
	{
	    List<SubjectDTO> subjectsList = new SubjectDAO().getStudentAndLecturerSubjects(studentId,
			    ((LoginBean) request.getSession().getAttribute("loginBean")).getPersonId());

	    for (SubjectDTO subject : subjectsList)
	    {
		enrollments.addAll(new EnrollmentDAO().getStudentEnrollmentsFromSubject(studentId, subject.getId()));
	    }

	    request.setAttribute("subject", subjectsList);
	}

	Collections.sort(enrollments, (x, y) -> y.getIssueDate().compareTo(x.getIssueDate()));
	request.setAttribute("enrollments", enrollments);
	request.setAttribute("student", studentDAO.getEntity(Integer.parseInt(request.getParameter("studentId"))));

	subjectDAO.closeEntityManager();
	studentDAO.closeEntityManager();
	enrollmentDAO.closeEntityManager();

	request.getRequestDispatcher("lecturer/studentenrollments.jsp").forward(request, response);
    }

}

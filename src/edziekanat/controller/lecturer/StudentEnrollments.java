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
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
	doPost(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
	List<EnrollmentDTO> enrollments = new LinkedList<EnrollmentDTO>();
	if (!request.getParameter("subjectId").isEmpty())
	{
	    request.setAttribute("subject",
		    new SubjectDAO().getEntity(Integer.parseInt(request.getParameter("subjectId"))));
	    enrollments = new EnrollmentDAO().getStudentEnrollmentsFromSubject(
		    Integer.parseInt(request.getParameter("subjectId")),
		    Integer.parseInt(request.getParameter("studentId")));
	    Collections.sort(enrollments, (x, y) -> y.getIssueDate().compareTo(x.getIssueDate()));
	    request.setAttribute("enrollments", enrollments);
	}
	else
	{
	    List<SubjectDTO> subjects = new SubjectDAO().getStudentAndLecturerSubjects(
		    Integer.parseInt(request.getParameter("studentId")),
		    ((LoginBean) request.getSession().getAttribute("loginBean")).getPersonId());
	    for (int i = 0; i < subjects.size(); i++)
	    {
		enrollments.addAll(new EnrollmentDAO().getStudentEnrollmentsFromSubject(
			Integer.parseInt(request.getParameter("studentId")), subjects.get(i).getId()));
	    }
	    Collections.sort(enrollments, (x, y) -> y.getIssueDate().compareTo(x.getIssueDate()));
	    request.setAttribute("subject", subjects);
	    request.setAttribute("enrollments", enrollments);
	}
	request.setAttribute("student",
		new StudentDAO().getEntity(Integer.parseInt(request.getParameter("studentId"))));

	request.getRequestDispatcher("lecturer/studentenrollments.jsp").forward(request, response);
    }

}

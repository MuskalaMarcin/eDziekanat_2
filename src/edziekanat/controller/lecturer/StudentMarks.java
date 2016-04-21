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
import edziekanat.databasemodel.dao.PartialMarkDAO;
import edziekanat.databasemodel.dao.StudentDAO;
import edziekanat.databasemodel.dao.SubjectDAO;
import edziekanat.databasemodel.dto.PartialMarkDTO;
import edziekanat.databasemodel.dto.SubjectDTO;

/**
 * Servlet used in showing all marks that student got.
 */
@WebServlet("/studentmarks")
public class StudentMarks extends HttpServlet
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
	PartialMarkDAO partialMarkDAO = new PartialMarkDAO();
	StudentDAO studentDAO = new StudentDAO();

	String subjectIdString = request.getParameter("subjectId");
	Integer studentId = Integer.parseInt(request.getParameter("studentId"));

	List<PartialMarkDTO> partialMarks = new LinkedList<PartialMarkDTO>();
	if (!subjectIdString.isEmpty())
	{
	    Integer subjectId = Integer.parseInt(subjectIdString);
	    request.setAttribute("subject", subjectDAO.getEntity(subjectId));
	    partialMarks = new PartialMarkDAO().getStudentMarksFromSubject(subjectId, studentId);
	}
	else
	{
	    List<SubjectDTO> subjectsList = subjectDAO.getStudentAndLecturerSubjects(studentId,
			    ((LoginBean) request.getSession().getAttribute("loginBean")).getPersonId());

	    for (SubjectDTO subject: subjectsList)
	    {
		partialMarks.addAll(partialMarkDAO.getStudentMarksFromSubject(studentId, subject.getId()));
	    }
	    request.setAttribute("subject", subjectsList);
	}


	Collections.sort(partialMarks, (x, y) -> y.getIssueDate().compareTo(x.getIssueDate()));
	request.setAttribute("partialMarks", partialMarks);
	request.setAttribute("student",studentDAO.getEntity(studentId));

	partialMarkDAO.closeEntityManager();
	subjectDAO.closeEntityManager();
	studentDAO.closeEntityManager();

	request.getRequestDispatcher("lecturer/studentmarks.jsp").forward(request, response);
    }

}

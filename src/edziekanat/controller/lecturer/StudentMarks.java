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
	List<PartialMarkDTO> partialMarks = new LinkedList<PartialMarkDTO>();
	if (!request.getParameter("subjectId").isEmpty())
	{
	    request.setAttribute("subject",
		    new SubjectDAO().getEntity(Integer.parseInt(request.getParameter("subjectId"))));
	    partialMarks = new PartialMarkDAO().getStudentMarksFromSubject(Integer.parseInt(request.getParameter("subjectId")),
		    Integer.parseInt(request.getParameter("studentId")));
	    Collections.sort(partialMarks, (x, y) -> y.getIssueDate().compareTo(x.getIssueDate()));
	    request.setAttribute("partialMarks", partialMarks);
	}
	else
	{
	    List<SubjectDTO> subjects = new SubjectDAO().getStudentAndLecturerSubjects(
		    Integer.parseInt(request.getParameter("studentId")),
		    ((LoginBean) request.getSession().getAttribute("loginBean")).getPersonId());
	    for (int i = 0; i < subjects.size(); i++)
	    {
		partialMarks.addAll(new PartialMarkDAO().getStudentMarksFromSubject(
			Integer.parseInt(request.getParameter("studentId")), subjects.get(i).getId()));
	    }
	    Collections.sort(partialMarks, (x, y) -> y.getIssueDate().compareTo(x.getIssueDate()));
	    request.setAttribute("subject", subjects);
	    request.setAttribute("partialMarks", partialMarks);
	}
	request.setAttribute("student",
		new StudentDAO().getEntity(Integer.parseInt(request.getParameter("studentId"))));

	request.getRequestDispatcher("lecturer/studentmarks.jsp").forward(request, response);
    }

}

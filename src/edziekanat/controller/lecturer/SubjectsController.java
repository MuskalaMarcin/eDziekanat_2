package edziekanat.controller.lecturer;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edziekanat.bean.LoginBean;
import edziekanat.databasemodel.dao.SubjectDAO;
import edziekanat.databasemodel.dto.SubjectDTO;

/**
 * Servlet used in getting all subjects taught by lecturer.
 */
@WebServlet("/lecturersubjects")
public class SubjectsController extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubjectsController()
    {
	super();
    }

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
	List<SubjectDTO> subjects = subjectDAO.getLecturerSubjects(
			((LoginBean) request.getSession().getAttribute("loginBean")).getPersonId());

	if (!subjects.isEmpty())
	{
	    Collections.sort(subjects, (x, y) -> x.getName().compareTo(y.getName()));
	    request.setAttribute("subjects", subjects);
	    request.setAttribute("noSubjects", false);
	}
	else
	{
	    request.setAttribute("noSubjects", true);
	}

	request.getRequestDispatcher("lecturer/subjects").forward(request, response);

	subjectDAO.closeEntityManager();
    }

}

package edziekanat.controller.administrator;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edziekanat.databasemodel.dao.SubjectDAO;

/**
 * Servlet implementation class AdminSubjects
 */
@WebServlet("/adminsubjects")
public class AdminSubjects extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminSubjects()
    {
	super();
    }

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
	if (request.getParameter("lecturerId") == null)
	{
	    request.setAttribute("subjects", new SubjectDAO().getAllEntities());
	}
	else
	{
	    request.setAttribute("subjects",
		    new SubjectDAO().getLecturerSubjects(Integer.parseInt(request.getParameter("lecturerId"))));
	}
	request.getRequestDispatcher("administrator/subjects.jsp").forward(request, response);
    }

}

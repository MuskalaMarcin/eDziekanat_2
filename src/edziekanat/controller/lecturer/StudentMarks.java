package edziekanat.controller.lecturer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edziekanat.databasemodel.dao.StudentDAO;
import edziekanat.databasemodel.dao.SubjectDAO;

/**
 * Servlet implementation class StudentMarks
 */
@WebServlet("/studentmarks")
public class StudentMarks extends HttpServlet
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
	if (!request.getParameter("subjectId").isEmpty())
	{
	    request.setAttribute("subject",
		    new SubjectDAO().getEntity(Integer.parseInt(request.getParameter("subjectId"))));
	}
	request.setAttribute("student",
		new StudentDAO().getEntity(Integer.parseInt(request.getParameter("studentId"))));

	// TODO Finish this servlet

	request.getRequestDispatcher("lecturer/studentmarks.jsp").forward(request, response);
    }

}

package edziekanat.test.database;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edziekanat.databasemodel.dao.FacultyDAO;
import edziekanat.databasemodel.dto.FacultyDTO;

/**
 * Servlet implementation class FacultyDAOTest
 */
@WebServlet("/FacultyDAOTest")
public class FacultyDAOTest extends HttpServlet
{
    private static final long serialVersionUID = 1L;

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

	out.println("ONE Faculty");
	FacultyDTO faculty = new FacultyDAO().getEntity(1);
	out.println("<br>" + faculty.getAddress());
	out.println("<br>" + faculty.getName());
	out.println("<br>" + faculty.getId());
	out.println("<br>" + faculty.getUniversityId());

	out.println("<p>ALL Facultys");
	new FacultyDAO().getAllEntities().forEach(item -> {
	    out.println("<br>" + item.getAddress());
	    out.println("<br>" + item.getName());
	    out.println("<br>" + item.getId());
	    out.println("<br>" + item.getUniversityId());
	    out.println("<br> nastepny");
	});
    }
}

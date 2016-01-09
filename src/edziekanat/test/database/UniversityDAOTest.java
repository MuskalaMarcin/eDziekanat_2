package edziekanat.test.database;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edziekanat.databasemodel.dao.UniversityDAO;
import edziekanat.databasemodel.dto.UniversityDTO;

/**
 * Servlet implementation class UniversityDAOTest
 */
@WebServlet("/UniversityDAOTest")
public class UniversityDAOTest extends HttpServlet
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
    }
}

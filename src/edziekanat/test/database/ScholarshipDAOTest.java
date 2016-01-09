package edziekanat.test.database;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edziekanat.databasemodel.dao.ScholarshipDAO;
import edziekanat.databasemodel.dto.ScholarshipDTO;

/**
 * Servlet implementation class ScholarshipDAOTest
 */
@WebServlet("/ScholarshipDAOTest")
public class ScholarshipDAOTest extends HttpServlet
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

	out.println("ONE Scholarship");
	ScholarshipDTO scholarship = new ScholarshipDAO().getEntity(1);
	out.println("<br>" + scholarship.getScholarshipType());
	out.println("<br>" + scholarship.getAdministratorId());
	out.println("<br>" + scholarship.getId());
	out.println("<br>" + scholarship.getStudentId());
	out.println("<br>" + scholarship.getEndDate());
	out.println("<br>" + scholarship.getGrantDate());

	out.println("<p>ALL Scholarships");
	new ScholarshipDAO().getAllEntities().forEach(item -> {
	    out.println("<br>" + item.getScholarshipType());
	    out.println("<br>" + item.getAdministratorId());
	    out.println("<br>" + item.getId());
	    out.println("<br>" + item.getStudentId());
	    out.println("<br>" + item.getEndDate());
	    out.println("<br>" + item.getGrantDate());
	    out.println("<br> nastepny");
	});
    }
}

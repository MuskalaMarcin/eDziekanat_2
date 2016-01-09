package edziekanat.test.database;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edziekanat.databasemodel.dao.ScholarshipTypeDAO;
import edziekanat.databasemodel.dto.ScholarshipTypeDTO;

@WebServlet("/ScholarshipTypeDAOTest")
public class ScholarshipTypeDAOTest extends HttpServlet
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

	out.println("ONE ScholarshipType");
	ScholarshipTypeDTO scholarshipType = new ScholarshipTypeDAO().getEntity(1);
	out.println("<br>" + scholarshipType.getRequirements());
	out.println("<br>" + scholarshipType.getType());
	out.println("<br>" + scholarshipType.getAmount());

	out.println("<p>ALL ScholarshipTypes");
	new ScholarshipTypeDAO().getAllEntities().forEach(item -> {
	    out.println("<br>" + item.getRequirements());
	    out.println("<br>" + item.getType());
	    out.println("<br>" + item.getAmount());
	    out.println("<br> nastepny");
	});
    }
}

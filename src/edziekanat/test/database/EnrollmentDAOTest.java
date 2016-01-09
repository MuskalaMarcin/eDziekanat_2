package edziekanat.test.database;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edziekanat.databasemodel.dao.EnrollmentDAO;
import edziekanat.databasemodel.dto.EnrollmentDTO;

/**
 * Servlet implementation class EnrollmentDAOTest
 */
@WebServlet("/EnrollmentDAOTest")
public class EnrollmentDAOTest extends HttpServlet
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

	out.println("ONE Enrollment");
	EnrollmentDTO enrollment = new EnrollmentDAO().getEntity(1);
	out.println("<br>" + enrollment.getId());
	out.println("<br>" + enrollment.getMark());
	out.println("<br>" + enrollment.getSubjectId());
	out.println("<br>" + enrollment.getTranscriptId());
	out.println("<br>" + enrollment.getIssueDate());

	out.println("<p>ALL Enrollments");
	new EnrollmentDAO().getAllEntities().forEach(item -> {
	    out.println("<br>" + item.getId());
	    out.println("<br>" + item.getMark());
	    out.println("<br>" + item.getSubjectId());
	    out.println("<br>" + item.getTranscriptId());
	    out.println("<br>" + item.getIssueDate());
	    out.println("<br> nastepny");
	});
    }
}

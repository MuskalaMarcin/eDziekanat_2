package edziekanat.test.database;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edziekanat.databasemodel.dao.TranscriptDAO;
import edziekanat.databasemodel.dto.TranscriptDTO;

/**
 * Servlet implementation class TransciprtDAOTest
 */
@WebServlet("/TranscriptDAOTest")
public class TranscriptDAOTest extends HttpServlet
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

	out.println("ONE Transcript");
	TranscriptDTO transcript = new TranscriptDAO().getEntity(1);
	out.println("<br>" + transcript.getId());
	out.println("<br>" + transcript.getStudent().getName());
	out.println("<br>" + transcript.getStudentsGroup().getId());
	out.println("<br>" + transcript.getIssueDate());

	out.println("<p>ALL Transcripts");
	new TranscriptDAO().getAllEntities().forEach(item -> {
	    out.println("<br>" + item.getId());
	    out.println("<br>" + item.getStudent().getName());
	    out.println("<br>" + item.getStudentsGroup().getId());
	    out.println("<br>" + item.getIssueDate());
	    out.println("<br> nastepny");
	});
    }
}

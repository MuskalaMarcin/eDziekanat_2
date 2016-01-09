package edziekanat.test.database;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edziekanat.databasemodel.dao.PartialMarkDAO;
import edziekanat.databasemodel.dto.PartialMarkDTO;

/**
 * Servlet implementation class PartialMarkDAOTest
 */
@WebServlet("/PartialMarkDAOTest")
public class PartialMarkDAOTest extends HttpServlet
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

	out.println("ONE PartialMark");
	PartialMarkDTO partialMark = new PartialMarkDAO().getEntity(1);
	out.println("<br>" + partialMark.getId());
	out.println("<br>" + partialMark.getMark());
	out.println("<br>" + partialMark.getSubjectId());
	out.println("<br>" + partialMark.getTranscriptId());
	out.println("<br>" + partialMark.getIssueDate());

	out.println("<p>ALL PartialMarks");
	new PartialMarkDAO().getAllEntities().forEach(item -> {
	    out.println("<br>" + item.getId());
	    out.println("<br>" + item.getMark());
	    out.println("<br>" + item.getSubjectId());
	    out.println("<br>" + item.getTranscriptId());
	    out.println("<br>" + item.getIssueDate());
	    out.println("<br> nastepny");
	});
    }
}

package edziekanat.controller.lecturer;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edziekanat.databasemodel.dao.PartialMarkDAO;
import edziekanat.databasemodel.dao.SubjectDAO;
import edziekanat.databasemodel.dao.TranscriptDAO;
import edziekanat.databasemodel.dto.PartialMarkDTO;

/**
 * Servlet used in adding new partial mark.
 */
@WebServlet("/newpartialmark")
public class NewPartialMark extends HttpServlet
{
    private static final long serialVersionUID = 1L;

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
	PartialMarkDAO partialMarkDAO = new PartialMarkDAO();
	SubjectDAO subjectDAO = new SubjectDAO();
	TranscriptDAO transcriptDAO = new TranscriptDAO();

	PartialMarkDTO partialMark = new PartialMarkDTO();
	partialMark.setIssueDate(Calendar.getInstance().getTime());
	partialMark.setMark(Float.parseFloat(request.getParameter("mark")));
	partialMark.setSubject(subjectDAO.getEntity(Integer.parseInt(request.getParameter("subject"))));
	partialMark.setTranscript(transcriptDAO.getEntity(Integer.parseInt(request.getParameter("transcript"))));

	partialMarkDAO.insert(partialMark);

	partialMarkDAO.closeEntityManager();
	subjectDAO.closeEntityManager();
	transcriptDAO.closeEntityManager();

	request.setAttribute("msgshort", "Ocena dodana");
	request.setAttribute("msglong", "Nowa ocena zosta³a dodana");
	request.getRequestDispatcher("common/info.jsp").forward(request, response);
    }

}
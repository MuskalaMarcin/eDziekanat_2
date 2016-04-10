package edziekanat.controller.lecturer;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edziekanat.databasemodel.dao.EnrollmentDAO;
import edziekanat.databasemodel.dao.SubjectDAO;
import edziekanat.databasemodel.dao.TranscriptDAO;
import edziekanat.databasemodel.dto.EnrollmentDTO;

/**
 * Servlet used in adding new enrollment to database.
 */
@WebServlet("/newenrollment")
public class NewEnrollment extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewEnrollment()
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
	EnrollmentDTO enrollment = new EnrollmentDTO();
	enrollment.setIssueDate(Calendar.getInstance().getTime());
	enrollment.setMark(Float.parseFloat(request.getParameter("mark").toString()));
	enrollment.setSubjectId(new SubjectDAO().getEntity(Integer.parseInt(request.getParameter("subject").toString())));
	enrollment.setTranscriptId(new TranscriptDAO().getEntity(Integer.parseInt(request.getParameter("transcript").toString())));
	
	new EnrollmentDAO().insert(enrollment);
	request.setAttribute("msgshort", "Wpis dodana");
	request.setAttribute("msglong", "Nowy wpis zosta³ dodany");
	request.getRequestDispatcher("common/info.jsp").forward(request, response);
    }
    
}
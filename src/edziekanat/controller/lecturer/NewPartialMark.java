package edziekanat.controller.lecturer;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edziekanat.bean.LoginBean;
import edziekanat.databasemodel.dao.AdministratorDAO;
import edziekanat.databasemodel.dao.ApplicationDAO;
import edziekanat.databasemodel.dao.PartialMarkDAO;
import edziekanat.databasemodel.dao.StudentDAO;
import edziekanat.databasemodel.dao.SubjectDAO;
import edziekanat.databasemodel.dao.TranscriptDAO;
import edziekanat.databasemodel.dto.AdministratorDTO;
import edziekanat.databasemodel.dto.ApplicationDTO;
import edziekanat.databasemodel.dto.PartialMarkDTO;
import edziekanat.databasemodel.dto.SubjectDTO;
import edziekanat.databasemodel.dto.TranscriptDTO;

/**
 * Servlet implementation class NewPartialMark
 */
@WebServlet("/newpartialmark")
public class NewPartialMark extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewPartialMark()
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
	PartialMarkDTO partialMark = new PartialMarkDTO();
	partialMark.setIssueDate(Calendar.getInstance().getTime());
	partialMark.setMark(Float.parseFloat(request.getParameter("mark").toString()));
	partialMark.setSubject(new SubjectDAO().getEntity(Integer.parseInt(request.getParameter("subject").toString())));
	partialMark.setTranscript(new TranscriptDAO().getEntity(Integer.parseInt(request.getParameter("transcript").toString())));
	
	new PartialMarkDAO().insert(partialMark);
	request.setAttribute("msgshort", "Ocena dodana");
	request.setAttribute("msglong", "Nowa ocena zosta³a dodana");
	request.getRequestDispatcher("/info.jsp").forward(request, response);
    }
    
}
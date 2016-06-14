package edziekanat.controller.administrator;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edziekanat.databasemodel.dao.PassedSemesterDAO;
import edziekanat.databasemodel.dao.TranscriptDAO;
import edziekanat.databasemodel.dto.PassedSemesterDTO;

/**
 * Servlet implementation class AdminConfirmPassedSemester
 */
@WebServlet("/adminconfirmpassedsemester")
public class AdminConfirmPassedSemester extends HttpServlet
{
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
	PassedSemesterDAO passedSemesterDAO = new PassedSemesterDAO();
	TranscriptDAO transcriptDAO = new TranscriptDAO();
	PassedSemesterDTO passedSemesterDTO = new PassedSemesterDTO();
	passedSemesterDTO.setSemester(Integer.parseInt(request.getParameter("semester")));
	passedSemesterDTO.setDispatchDate(Calendar.getInstance().getTime());
	passedSemesterDTO.setTranscript(transcriptDAO.getEntity(Integer.parseInt(request.getParameter("transcriptId"))));
	passedSemesterDAO.insert(passedSemesterDTO);
	request.setAttribute("msgshort", "Semester zaliczony");
	request.setAttribute("msglong", "Semester zosta³ uznany za zaliczony przez studenta");
	request.setAttribute("previousUrl", request.getHeader("referer"));
	request.getRequestDispatcher("common/info.jsp").forward(request, response);
	passedSemesterDAO.closeEntityManager();
	transcriptDAO.closeEntityManager();
    }
}

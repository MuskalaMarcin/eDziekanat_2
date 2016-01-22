package edziekanat.controller.student;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edziekanat.bean.LoginBean;
import edziekanat.databasemodel.dao.TranscriptDAO;
import edziekanat.databasemodel.dto.CourseDTO;
import edziekanat.databasemodel.dto.StudentsGroupDTO;
import edziekanat.databasemodel.dto.TranscriptDTO;

/**
 * Servlet implementation class TranscriptController
 */
@WebServlet("/studenttranscript")
public class TranscriptController extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    public TranscriptController()
    {
	super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
	doPost(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
	List<TranscriptDTO> transcripts = new TranscriptDAO()
		.getStudentTranscript(((LoginBean) request.getSession().getAttribute("loginBean")).getPersonId());
	request.setAttribute("transcriptList", transcripts);
	List<CourseDTO> courses = new LinkedList<CourseDTO>();
	for (TranscriptDTO transcript : transcripts)
	{
	    StudentsGroupDTO studentGroup = transcript.getStudentsGroup();
	    courses.add(studentGroup.getCourse());
	}
	for (int i = 0; i < transcripts.size(); i++)
	{

	}

	request.getRequestDispatcher("student/transcript").forward(request, response);
    }

}

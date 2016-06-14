package edziekanat.controller.lecturer;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edziekanat.databasemodel.dao.EnrollmentDAO;
import edziekanat.databasemodel.dao.StudentDAO;
import edziekanat.databasemodel.dao.SubjectDAO;
import edziekanat.databasemodel.dao.TranscriptDAO;
import edziekanat.databasemodel.dto.EnrollmentDTO;
import edziekanat.databasemodel.dto.StudentDTO;
import edziekanat.databasemodel.dto.SubjectDTO;
import edziekanat.databasemodel.dto.TranscriptDTO;

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
	EnrollmentDAO enrollmentDAO = new EnrollmentDAO();
	StudentDAO studentDAO = new StudentDAO();
	SubjectDAO subjectDAO = new SubjectDAO();

	StudentDTO student = studentDAO.getEntity(Integer.parseInt(request.getParameter("studentId")));
	SubjectDTO subjectDTO = subjectDAO.getEntity(Integer.parseInt(request.getParameter("subject")));
	TranscriptDTO transcriptDTO = student.getTranscript().stream()
			.filter(t -> t.getStudentsGroup().getSubject().stream()
					.filter(s -> s.getId().equals(subjectDTO.getId())).findAny().isPresent()).findAny().get();

	EnrollmentDTO enrollment = new EnrollmentDTO();
	enrollment.setIssueDate(Calendar.getInstance().getTime());
	enrollment.setMark(Float.parseFloat(request.getParameter("mark")));
	enrollment.setSubjectId(subjectDTO);
	enrollment.setTranscriptId(transcriptDTO);

	enrollmentDAO.insert(enrollment);

	request.setAttribute("msgshort", "Wpis dodana");
	request.setAttribute("msglong", "Nowy wpis zosta³ dodany");
	request.setAttribute("previousUrl", request.getHeader("referer"));
	request.getRequestDispatcher("common/info.jsp").forward(request, response);

	studentDAO.closeEntityManager();
	enrollmentDAO.closeEntityManager();
	subjectDAO.closeEntityManager();
    }
    
}
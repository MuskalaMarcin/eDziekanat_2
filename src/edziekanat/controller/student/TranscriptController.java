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
import edziekanat.databasemodel.dao.EnrollmentDAO;
import edziekanat.databasemodel.dto.EnrollmentDTO;

/**
 * Servlet showing students transcript.
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
	EnrollmentDAO enrollmentDAO = new EnrollmentDAO();
	List<EnrollmentDTO> enrollments = enrollmentDAO.getAllStudentEnrollments(
			((LoginBean) request.getSession().getAttribute("loginBean")).getPersonId());

	if (!enrollments.isEmpty())
	{
	    List<Integer> semesterList = new LinkedList<Integer>();
	    for (EnrollmentDTO enrollment : enrollments)
	    {
		if (!semesterList.contains(enrollment.getSubject().getSemester()))
		{
		    semesterList.add(enrollment.getSubject().getSemester());
		}
	    }

	    if (request.getParameter("rqsemester") == null)
	    {

		for (int i = 0; i < enrollments.size(); i++)
		{
		    if (enrollments.get(i).getSubject().getSemester().compareTo(semesterList.get(0)) != 0)
		    {
			enrollments.remove(i);
			i--;
		    }
		}
		request.setAttribute("selectedSemester", semesterList.get(0));
	    }
	    else
	    {
		int selectedSemester = Integer.valueOf(request.getParameter("rqsemester"));
		for (int i = 0; i < enrollments.size(); i++)
		{
		    if (enrollments.get(i).getSubject().getSemester().compareTo(selectedSemester) != 0)
		    {
			enrollments.remove(i);
			i--;
		    }
		}
		request.setAttribute("selectedSemester", selectedSemester);
	    }
	    request.setAttribute("enrollments", enrollments);
	    request.setAttribute("semesterList", semesterList);
	    request.setAttribute("noEnrollments", false);
	}
	else
	{
	    request.setAttribute("noEnrollments", true);
	}

	enrollmentDAO.closeEntityManager();
	request.getRequestDispatcher("student/transcript").forward(request, response);
    }

}

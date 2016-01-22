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
import edziekanat.databasemodel.dao.SubjectDAO;
import edziekanat.databasemodel.dto.SubjectDTO;

/**
 * Servlet implementation class SubjectsController
 */
@WebServlet("/studentsubjects")
public class SubjectsController extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubjectsController()
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

	List<SubjectDTO> subjects = new SubjectDAO()
		.getStudentSubjects(((LoginBean) request.getSession().getAttribute("loginBean")).getPersonId());
	if (!subjects.isEmpty())
	{
	    List<Integer> semesterList = new LinkedList<Integer>();
	    for (SubjectDTO subject : subjects)
	    {
		if (!semesterList.contains(subject.getSemester()))
		{
		    semesterList.add(subject.getSemester());
		}
	    }
	    if (request.getParameter("rqsemester") == null)
	    {
		for (int i = 0; i < subjects.size(); i++)
		{
		    if (subjects.get(i).getSemester().compareTo(semesterList.get(0)) != 0)
		    {
			subjects.remove(i);
			i--;
		    }
		}
		request.setAttribute("selectedSemester", semesterList.get(0));
	    }
	    else
	    {
		int selectedSemester = Integer.valueOf(request.getParameter("rqsemester"));
		for (int i = 0; i < subjects.size(); i++)
		{
		    if (subjects.get(i).getSemester().compareTo(selectedSemester) != 0)
		    {
			subjects.remove(i);
			i--;
		    }
		}
		request.setAttribute("selectedSemester", selectedSemester);
	    }
	    request.setAttribute("subjects", subjects);
	    request.setAttribute("semesterList", semesterList);
	    request.setAttribute("noSubjects", false);
	}
	else
	{
	    request.setAttribute("noSubjects", true);
	}
	request.getRequestDispatcher("student/subjects").forward(request, response);
    }

}

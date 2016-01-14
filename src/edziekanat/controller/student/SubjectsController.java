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
import edziekanat.databasemodel.dao.StudentDAO;
import edziekanat.databasemodel.dto.StudentDTO;
import edziekanat.databasemodel.dto.StudentsGroupDTO;
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
	LoginBean loginBean = (LoginBean) request.getSession().getAttribute("loginBean");
	StudentDTO student = new StudentDAO().getEntity(loginBean.getPersonId());
	List<StudentsGroupDTO> studentsGroup = new LinkedList<StudentsGroupDTO>();
	studentsGroup = student.getStudentsGroup();
	System.out.println(studentsGroup.get(0).getId());
	List<SubjectDTO> subjects = new LinkedList<SubjectDTO>();
	
	for (int i = 0; i < studentsGroup.size(); i++)
	{
	    subjects.addAll(studentsGroup.get(i).getSubject());
	}
	
	if (!subjects.isEmpty())
	{
	    request.setAttribute("ownsubjects", subjects);
	}
	request.getRequestDispatcher("student/subjects").forward(request, response);
    }

}

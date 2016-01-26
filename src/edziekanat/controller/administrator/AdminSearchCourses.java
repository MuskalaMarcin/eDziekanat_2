package edziekanat.controller.administrator;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edziekanat.databasemodel.dao.FacultyDAO;
import edziekanat.databasemodel.dto.CourseDTO;
import edziekanat.databasemodel.dto.FacultyDTO;

/**
 * Servlet implementation class AdminSearchCourses
 */
@WebServlet("/adminsearchcourses")
public class AdminSearchCourses extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminSearchCourses()
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
	String faculty = request.getParameter("searchedFaculty").toString();
	if (!faculty.isEmpty())
	{
	    List<FacultyDTO> faculties = new FacultyDAO().getFacultyByName(faculty);
	    List<CourseDTO> courses = new LinkedList<CourseDTO>();
	    for (int i = 0; i < faculties.size(); i++)
	    {
		courses.addAll(faculties.get(i).getCourse());
	    }
	    request.setAttribute("courses", courses);
	}
	request.getRequestDispatcher("admin/courses").forward(request, response);
    }

}

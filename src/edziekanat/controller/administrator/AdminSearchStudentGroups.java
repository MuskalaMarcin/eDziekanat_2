package edziekanat.controller.administrator;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edziekanat.databasemodel.dao.CourseDAO;
import edziekanat.databasemodel.dto.CourseDTO;

/**
 * Servlet implementation class AdminSearchStudentGroups
 */
@WebServlet("/adminsearchstudentgroups")
public class AdminSearchStudentGroups extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminSearchStudentGroups()
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
	String course = request.getParameter("searchedCourse");
	if (!course.isEmpty())
	{
	    CourseDAO courseDAO = new CourseDAO();
	    List<CourseDTO> courses = courseDAO.getCourseByName(course);
	    request.setAttribute("courses", courses);
	    courseDAO.closeEntityManager();
	}
	request.getRequestDispatcher("adminstudentgroups").forward(request, response);
    }

}

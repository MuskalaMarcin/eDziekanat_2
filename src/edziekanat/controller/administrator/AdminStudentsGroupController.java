package edziekanat.controller.administrator;

import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edziekanat.databasemodel.dao.CourseDAO;
import edziekanat.databasemodel.dao.StudentsGroupDAO;
import edziekanat.databasemodel.dto.CourseDTO;
import edziekanat.databasemodel.dto.StudentsGroupDTO;

/**
 * Servlet implementation class AdminStudentGroupsController
 */
@WebServlet("/adminstudentgroups")
public class AdminStudentsGroupController extends HttpServlet
{
    private static final long serialVersionUID = 1L;

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
    @SuppressWarnings("unchecked")
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
	List<StudentsGroupDTO> studentsGroupDTOList;
	List<CourseDTO> courses = (List<CourseDTO>) request.getAttribute("courses");

	if (request.getParameter("courseid") == null)
	{
	    if (request.getAttribute("courses") == null || courses.isEmpty())
	    {
		StudentsGroupDAO studentsGroupDAO = new StudentsGroupDAO();

		studentsGroupDTOList = studentsGroupDAO.getAllEntities();

		forwardRequest(request, response, studentsGroupDTOList);

		studentsGroupDAO.closeEntityManager();
	    }
	    else
	    {
		studentsGroupDTOList = new LinkedList<>();
		for (CourseDTO course : courses)
		{
		    studentsGroupDTOList.addAll(course.getStudentsGroup());
		}

		forwardRequest(request, response, studentsGroupDTOList);
	    }
	}
	else
	{
	    CourseDAO courseDAO = new CourseDAO();

	    CourseDTO course = courseDAO.getEntity(Integer.parseInt(request.getParameter("courseid")));
	    request.setAttribute("course", course);
	    studentsGroupDTOList = course.getStudentsGroup();

	    forwardRequest(request, response, studentsGroupDTOList);

	    courseDAO.closeEntityManager();
	}
    }

    private void forwardRequest(HttpServletRequest request, HttpServletResponse response,
		    List<StudentsGroupDTO> studentsGroupDTOList) throws ServletException, IOException
    {
	Collections.sort(studentsGroupDTOList, (x, y) -> x.getCourse().getName().compareTo(y.getCourse().getName()));
	request.setAttribute("studentsgroup", studentsGroupDTOList);
	request.getRequestDispatcher("admin/studentgroups").forward(request, response);
    }

}

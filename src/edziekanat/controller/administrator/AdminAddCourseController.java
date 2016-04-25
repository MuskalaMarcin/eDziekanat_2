package edziekanat.controller.administrator;

import edziekanat.databasemodel.dao.CourseDAO;
import edziekanat.databasemodel.dao.FacultyDAO;
import edziekanat.databasemodel.dto.CourseDTO;
import edziekanat.databasemodel.dto.FacultyDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class AdminAddCourseController
 */
@WebServlet("/adminaddcourse")
public class AdminAddCourseController extends HttpServlet
{
    private static final long serialVersionUID = 1L;

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
	FacultyDAO facultyDAO = new FacultyDAO();
	CourseDAO courseDAO = new CourseDAO();

	CourseDTO course = new CourseDTO();
	@SuppressWarnings("unchecked")
	List<FacultyDTO> faculties = (List<FacultyDTO>) request.getAttribute("faculties");
	request.setAttribute("faculties", faculties);
	course.setName(request.getParameter("name"));
	course.setFaculty(facultyDAO.getEntity(Integer.parseInt(request.getParameter("id"))));
	course.setStationary(Integer.parseInt(request.getParameter("stationary")));

	courseDAO.insert(course);

	request.setAttribute("msgshort", "Kierunek dodany");
	request.setAttribute("msglong", "Nowy kierunek zosta³ dodany");
	request.getRequestDispatcher("common/info.jsp").forward(request, response);

	courseDAO.closeEntityManager();
	facultyDAO.closeEntityManager();
    }

}

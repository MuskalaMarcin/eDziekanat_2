package edziekanat.controller.administrator;

import edziekanat.databasemodel.dao.CourseDAO;
import edziekanat.databasemodel.dao.StudentsGroupDAO;
import edziekanat.databasemodel.dto.CourseDTO;
import edziekanat.databasemodel.dto.StudentsGroupDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class AddNewStudentsGroup
 */
@WebServlet("/adminaddstudentsgroup")
public class AddNewStudentsGroup extends HttpServlet
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
	CourseDAO courseDAO = new CourseDAO();
	StudentsGroupDAO studentsGroupDAO = new StudentsGroupDAO();

	StudentsGroupDTO studentsgroup = new StudentsGroupDTO();
	@SuppressWarnings("unchecked")
	List<CourseDTO> courses = (List<CourseDTO>) request.getAttribute("courses");
	studentsgroup.setSemester(Integer.parseInt(request.getParameter("semester").toString()));
	studentsgroup.setCourse(courseDAO.getEntity(Integer.parseInt(request.getParameter("id").toString())));
	studentsGroupDAO.insert(studentsgroup);
	
	request.setAttribute("msgshort", "Grupa studencka dodana");
	request.setAttribute("msglong", "Nowa grupa studencka zosta³a dodana");
	request.getRequestDispatcher("common/info.jsp").forward(request, response);

	studentsGroupDAO.closeEntityManager();
	courseDAO.closeEntityManager();
    }

}

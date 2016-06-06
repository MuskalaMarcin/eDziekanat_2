package edziekanat.controller.administrator;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edziekanat.databasemodel.dao.ClassroomDAO;
import edziekanat.databasemodel.dto.ClassroomDTO;

/**
 * Servlet implementation class PlanClassesController
 */
@WebServlet("/adminlockclassroom")
public class AdminBlockClassrooms extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    /**
     * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
	doPost(request, response);
    }

    /**
     * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
	ClassroomDAO classroomDAO = new ClassroomDAO();
	String action = request.getParameter("action");
	if (action != null)
	{
	    int classroomid = Integer.parseInt(request.getParameter("classroomid"));
	    ClassroomDTO classroom = classroomDAO.getEntity(classroomid);
	    if (action.equals("Odblokuj"))
	    {
		classroom.setAvailable(true);
	    }
	    else if (action.equals("Zablokuj"))
	    {
		classroom.setAvailable(false);
	    }
	    classroomDAO.update(classroom);
	}

	List<ClassroomDTO> classrooms = classroomDAO.getAllEntities();
	Comparator<ClassroomDTO> byFacultyName = (e1, e2) -> e1.getFaculty().getName()
			.compareTo(e2.getFaculty().getName());
	Comparator<ClassroomDTO> byClassroomNumber = (e1, e2) -> e1.getNumber().compareTo(e2.getNumber());
	classrooms.sort(byFacultyName.thenComparing(byClassroomNumber));
	request.setAttribute("classrooms", classrooms);
	classroomDAO.closeEntityManager();

	request.getRequestDispatcher("administrator/lockclassroom.jsp").forward(request, response);
    }

}

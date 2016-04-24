package edziekanat.controller.administrator;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edziekanat.databasemodel.dao.StudentsGroupDAO;
import edziekanat.databasemodel.dto.StudentsGroupDTO;

/**
 * Servlet implementation class PlanClassesController
 */
@WebServlet("/planclasses")
public class PlanClassesController extends HttpServlet
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
	StudentsGroupDAO studentsGroupDAO = new StudentsGroupDAO();

	StudentsGroupDTO studentsGroup =studentsGroupDAO.getEntity(Integer.parseInt(request.getParameter("studentsGroupId")));
	request.setAttribute("studentsGroup", studentsGroup);
	request.setAttribute("subjects", studentsGroup.getSubject());
	request.setAttribute("classrooms", studentsGroup.getCourse().getFaculty().getClassroom());

	request.getRequestDispatcher("administrator/newclasses.jsp").forward(request, response);

	studentsGroupDAO.closeEntityManager();
    }

}

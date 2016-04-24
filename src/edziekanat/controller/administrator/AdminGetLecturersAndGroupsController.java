package edziekanat.controller.administrator;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edziekanat.databasemodel.dao.LecturerDAO;
import edziekanat.databasemodel.dao.StudentsGroupDAO;

/**
 * Servlet implementation class AdminGetLecturersAndGroupsController
 */
@WebServlet("/admingetlecturersandstudentsgroup")
public class AdminGetLecturersAndGroupsController extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminGetLecturersAndGroupsController()
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
	LecturerDAO lecturerDAO = new LecturerDAO();
	StudentsGroupDAO studentsGroupDAO = new StudentsGroupDAO();

	request.setAttribute("lecturers", lecturerDAO.getAllEntities());
	request.setAttribute("studentsgroup", studentsGroupDAO.getAllEntities());

	request.getRequestDispatcher("admin/newsubject").forward(request, response);

	lecturerDAO.closeEntityManager();
	studentsGroupDAO.closeEntityManager();
    }

}

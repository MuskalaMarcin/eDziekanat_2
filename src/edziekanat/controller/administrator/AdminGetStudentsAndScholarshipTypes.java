package edziekanat.controller.administrator;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edziekanat.databasemodel.dao.ScholarshipTypeDAO;
import edziekanat.databasemodel.dao.StudentDAO;

/**
 * Servlet implementation class AdminGetStudentsAndScholarshipTypes
 */
@WebServlet("/admingetstudentsandscholarshiptypes")
public class AdminGetStudentsAndScholarshipTypes extends HttpServlet
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
	StudentDAO studentDAO = new StudentDAO();
	ScholarshipTypeDAO scholarshipTypeDAO = new ScholarshipTypeDAO();

	request.setAttribute("students", studentDAO.getAllEntities());
	request.setAttribute("scholarships", scholarshipTypeDAO.getAllEntities());

	request.getRequestDispatcher("admin/newscholarship").forward(request, response);

	studentDAO.closeEntityManager();
	scholarshipTypeDAO.closeEntityManager();
    }

}

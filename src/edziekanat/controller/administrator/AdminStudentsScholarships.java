package edziekanat.controller.administrator;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edziekanat.databasemodel.dao.ApplicationDAO;
import edziekanat.databasemodel.dao.ScholarshipDAO;
import edziekanat.databasemodel.dao.StudentDAO;
import edziekanat.databasemodel.dto.ScholarshipDTO;

/**
 * Servlet implementation class AdminStudentsScholarships
 */
@WebServlet("/adminstudentscholarships")
public class AdminStudentsScholarships extends HttpServlet
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
	ScholarshipDAO scholarshipDAO = new ScholarshipDAO();
	StudentDAO studentDAO = new StudentDAO();

	Integer studentId = Integer.parseInt(request.getParameter("studentId"));

	List<ScholarshipDTO> scholarships = scholarshipDAO.getAllStudentsScholarships(studentId);
	Collections.sort(scholarships, (x, y) -> y.getEndDate().compareTo(x.getEndDate()));
	request.setAttribute("scholarships", scholarships);
	request.setAttribute("student", studentDAO.getEntity(studentId));

	scholarshipDAO.closeEntityManager();
	studentDAO.closeEntityManager();

	request.getRequestDispatcher("administrator/studentsscholarships.jsp").forward(request, response);
    }

}

package edziekanat.controller.administrator;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edziekanat.databasemodel.dao.CourseDAO;
import edziekanat.databasemodel.dto.CourseDTO;

/**
 * Servlet implementation class DeleteCourse
 */
@WebServlet("/deletecourse")
public class DeleteCourse extends HttpServlet
{
    private static final long serialVersionUID = 1L;

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
	CourseDAO coursedao = new CourseDAO();
	CourseDTO course = coursedao.getEntity(Integer.parseInt(request.getParameter("courseid")));
	coursedao.remove(course);

	request.setAttribute("msgshort", "Usunięto kierunek");
	request.setAttribute("msglong", "Usunięto kierunek z wydziału: " + course.getFaculty().getName());
	request.getRequestDispatcher("common/info.jsp").forward(request, response);
    }

}

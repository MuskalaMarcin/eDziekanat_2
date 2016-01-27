package edziekanat.controller.administrator;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edziekanat.databasemodel.dao.LecturerDAO;
import edziekanat.databasemodel.dao.SubjectDAO;
import edziekanat.databasemodel.dto.LecturerDTO;

/**
 * Servlet implementation class AdminLecturers
 */
@WebServlet("/adminlecturers")
public class AdminLecturers extends HttpServlet
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
    @SuppressWarnings("unchecked")
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
	List<LecturerDTO> lecturers = new LinkedList<LecturerDTO>();
	if (request.getParameter("lecturers") == null && request.getParameter("subjectId") == null)
	{
	    lecturers = new LecturerDAO().getAllEntities();

	}
	else if (request.getParameter("subjectId") != null)
	{
	    lecturers.add(new SubjectDAO().getEntity(Integer.parseInt(request.getParameter("subjectId"))).getLecturer());
		   
	}
	else
	{
	    lecturers = (List<LecturerDTO>) request.getAttribute("lecturers");
	}
	request.setAttribute("lecturers", lecturers);
	request.getRequestDispatcher("administrator/lecturers.jsp").forward(request, response);
    }

}

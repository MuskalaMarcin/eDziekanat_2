package edziekanat.controller.administrator;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edziekanat.databasemodel.dao.LecturerDAO;
import edziekanat.databasemodel.dto.LecturerDTO;


/**
 * Servlet implementation class AddNewLecturer
 */
@WebServlet("/adminaddlecturer")
public class AddNewLecturer extends HttpServlet
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
	LecturerDTO lecturer = new LecturerDTO();
	lecturer.setName(request.getParameter("name").toString());
	lecturer.setSurname(request.getParameter("surname").toString());
	lecturer.setAddress(request.getParameter("address").toString());
	lecturer.setAcademicDegree(request.getParameter("academicdegree").toString());
	lecturer.setPosition(request.getParameter("position").toString());
	new LecturerDAO().insert(lecturer);
	
	request.setAttribute("msgshort", "Wyk³adowca dodany");
	request.setAttribute("msglong", "Nowy wyk³adowca zosta³ dodany");
	request.getRequestDispatcher("/info.jsp").forward(request, response);
    }

}

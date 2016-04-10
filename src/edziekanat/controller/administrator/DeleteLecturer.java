package edziekanat.controller.administrator;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edziekanat.databasemodel.dao.LecturerDAO;
import edziekanat.databasemodel.dao.UserDAO;
import edziekanat.databasemodel.dto.LecturerDTO;
import edziekanat.databasemodel.dto.UserDTO;

/**
 * Servlet implementation class DeleteLecturer
 */
@WebServlet("/deletelecturer")
public class DeleteLecturer extends HttpServlet
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
	try
	{
	    LecturerDAO lecturerDAO = new LecturerDAO();
	    LecturerDTO lecturer = lecturerDAO.getEntity(Integer.parseInt(request.getParameter("lecturerId")));
	    UserDAO userDAO =  new UserDAO();
	    UserDTO user = userDAO.getLecturerUser(lecturer.getId());
	    userDAO.remove(user);
	    lecturerDAO.remove(lecturer);

	    request.setAttribute("msgshort", "Usunięto wykładowcę");
	    request.setAttribute("msglong",
		    "Usunięto wykładowcę: " + lecturer.getName() + " " + lecturer.getSurname());
	    request.getRequestDispatcher("common/info.jsp").forward(request, response);
	}
	catch (Exception e)
	{
	    request.setAttribute("errorshort", "Błąd");
	    request.setAttribute("errorlong", "Podczas usuwania wykładowcy"
		    + " wystąpił nieznany błąd. Przepraszamy.");
	    request.getRequestDispatcher("common/error.jsp").forward(request, response);
	}
    }

}

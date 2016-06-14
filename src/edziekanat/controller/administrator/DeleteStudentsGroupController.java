package edziekanat.controller.administrator;

import edziekanat.databasemodel.dao.StudentsGroupDAO;
import edziekanat.databasemodel.dto.StudentsGroupDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class DeleteStudentsGroupController
 */
@WebServlet("/deletestudentsgroup")
public class DeleteStudentsGroupController extends HttpServlet
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
	StudentsGroupDAO sgDAO = new StudentsGroupDAO();
	try
	{
	    StudentsGroupDTO studentsGroup = sgDAO.getEntity(Integer.parseInt(request.getParameter("studentsGroupId")));
	    sgDAO.remove(studentsGroup);

	    request.setAttribute("msgshort", "Usuniêto grupê studenck±");
	    request.setAttribute("msglong", "Usuniêto grupê studenck±: " + studentsGroup.getId());
	    request.setAttribute("previousUrl", "http://localhost:8080/edziekanat/adminstudentgroups");
	    request.getRequestDispatcher("common/info.jsp").forward(request, response);
	}
	catch (Exception e)
	{
	    request.setAttribute("msgshort", "B³±d");
	    request.setAttribute("msglong", "Podczas usuwania grupy studenckiej"
		    + " wyst±pi³ nieznany b³±d. Przepraszamy.");
	    request.setAttribute("previousUrl", "http://localhost:8080/edziekanat/adminstudentgroups");
	    request.getRequestDispatcher("common/error.jsp").forward(request, response);
	}
	sgDAO.closeEntityManager();
    }

}

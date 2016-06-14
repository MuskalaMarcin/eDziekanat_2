package edziekanat.controller.administrator;

import edziekanat.databasemodel.dao.EnrollmentDAO;
import edziekanat.databasemodel.dto.EnrollmentDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Marcin Muska�a on 06.06.2016.
 */
@WebServlet("/cancelenrollment")
public class CancelEnrollment extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
	EnrollmentDAO enrollmentDAO = new EnrollmentDAO();

	try
	{
	    Integer enrollmentId = Integer.parseInt(request.getParameter("enrollmentId"));
	    EnrollmentDTO enrollmentDTO = enrollmentDAO.getEntity(enrollmentId);
	    enrollmentDAO.remove(enrollmentDTO);
	    request.setAttribute("msgshort", "Usuni�to wpis");
	    request.setAttribute("msglong", "Wpis zosta� usuni�ty.");
	    request.setAttribute("previousUrl", request.getHeader("referer"));
	    request.getRequestDispatcher("common/info.jsp").forward(request, response);
	}
	catch(NumberFormatException e)
	{
	    request.setAttribute("errorshort", "B��d");
	    request.setAttribute("errorlong", "Podczas przesy�ania danych wyst�pi� b��d.");
	    request.setAttribute("previousUrl", request.getHeader("referer"));
	    request.getRequestDispatcher("common/error.jsp").forward(request, response);
	}
	catch(Exception e)
	{
	    request.setAttribute("errorshort", "B��d");
	    request.setAttribute("errorlong", "Podczas usuwania oceny wyst�pi� nieznany b��d.");
	    request.setAttribute("previousUrl", request.getHeader("referer"));
	    request.getRequestDispatcher("common/error.jsp").forward(request, response);
	}


	enrollmentDAO.closeEntityManager();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
	doPost(request, response);
    }
}

package edziekanat.controller.administrator;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edziekanat.databasemodel.dao.ApplicationDAO;
import edziekanat.databasemodel.dto.ApplicationDTO;

/**
 * Servlet implementation class ManageApplications
 */
@WebServlet("/manageapplications")
public class ManageApplications extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
	doGet(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
	ApplicationDAO appDao = new ApplicationDAO();
	ApplicationDTO application = appDao.getEntity(Integer.parseInt(request.getParameter("applicationId")));
	try
	{
	    if (Integer.parseInt(request.getParameter("action")) == 1)
	    {
		application.setStatus("Odrzucony");
	    }
	    else
	    {
		application.setStatus("Przyjety");

	    }
	    appDao.update(application);

	    request.setAttribute("msgshort", "Zmieniono status wniosku");
	    request.setAttribute("msglong",
		    "Status wniosku " + application.getTitle() + " zostal zmieniony na " + application.getStatus());
	    request.setAttribute("previousUrl", "http://localhost:8080/edziekanat/adminapplications");
	    request.getRequestDispatcher("common/info.jsp").forward(request, response);
	}
	catch (Exception e)
	{
	    request.setAttribute("msgshort", "B³±d");
	    request.setAttribute("msglong",
		    "Podczas zmiany statusu wniosku " + application.getTitle()
			    + " wyst±pi³ nieznany b³±d. Przepraszamy.");
	    request.setAttribute("previousUrl", "http://localhost:8080/edziekanat/adminapplications");
	    request.getRequestDispatcher("common/error.jsp").forward(request, response);
	}
	appDao.closeEntityManager();
    }

}

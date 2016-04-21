package edziekanat.controller.administrator;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edziekanat.bean.LoginBean;
import edziekanat.databasemodel.dao.ApplicationDAO;
import edziekanat.databasemodel.dao.Application_typeDAO;

/**
 * Servlet implementation class ApplicationsHistoryController
 */
@WebServlet("/adminapplicationshistory")
public class ApplicationsHistoryController extends HttpServlet
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
	Application_typeDAO application_typeDAO = new Application_typeDAO();
	ApplicationDAO applicationDAO = new ApplicationDAO();

	request.setAttribute("typeList", application_typeDAO.getApplication_types());
	if (request.getParameter("type") == null || request.getParameter("type").equals("all"))
	{
	    request.setAttribute("historicalApplications", applicationDAO.getAdminHistoricalApplications(
			    ((LoginBean) request.getSession().getAttribute("loginBean")).getPersonId()));
	}
	else
	{
	    Integer type = Integer.parseInt(request.getParameter("type"));
	    request.setAttribute("historicalApplications", applicationDAO.getAdminHistoricalApplications(
			    ((LoginBean) request.getSession().getAttribute("loginBean")).getPersonId(), type));
	}

	application_typeDAO.closeEntityManager();
	applicationDAO.closeEntityManager();

	request.getRequestDispatcher("administrator/applicationshistory.jsp").forward(request, response);
    }

}

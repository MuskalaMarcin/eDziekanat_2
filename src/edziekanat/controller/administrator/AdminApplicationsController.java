package edziekanat.controller.administrator;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edziekanat.bean.LoginBean;
import edziekanat.databasemodel.dao.ApplicationDAO;
import edziekanat.databasemodel.dao.Application_typeDAO;
import edziekanat.databasemodel.dto.ApplicationDTO;

/**
 * Servlet implementation class AdminApplicationsController
 */
@WebServlet("/adminapplications")
public class AdminApplicationsController extends HttpServlet
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
	ApplicationDAO applicationDAO = new ApplicationDAO();
	Application_typeDAO application_typeDAO = new Application_typeDAO();

	Integer personId = ((LoginBean) request.getSession().getAttribute("loginBean")).getPersonId();
	request.setAttribute("typeList", application_typeDAO.getApplication_types());
	if (request.getParameter("type") == null || request.getParameter("type").equals("all"))
	{
	    request.setAttribute("waitingApplications", applicationDAO.getAdminWaitingApplications(personId));
	}
	else
	{
	    Integer type = Integer.parseInt(request.getParameter("type"));
	    request.setAttribute("waitingApplications", applicationDAO.getAdminWaitingApplications(personId, type));
	}

	request.getRequestDispatcher("administrator/waitingapplications.jsp").forward(request, response);

	application_typeDAO.closeEntityManager();
	applicationDAO.closeEntityManager();
    }

}

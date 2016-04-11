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
        request.setAttribute("typeList", new Application_typeDAO().getApplication_types());
        if(request.getParameter("type")== null || request.getParameter("type").equals("all"))
        {
            request.setAttribute("historicalApplications", new ApplicationDAO().getAdminHistoricalApplications(
                    ((LoginBean) request.getSession().getAttribute("loginBean")).getPersonId()));
        }
        else
        {
            Integer type = Integer.parseInt(request.getParameter("type"));
            request.setAttribute("historicalApplications", new ApplicationDAO().getAdminHistoricalApplications(
                    ((LoginBean) request.getSession().getAttribute("loginBean")).getPersonId(),type));
        }
	    request.getRequestDispatcher("administrator/applicationshistory.jsp").forward(request, response);
    }

}

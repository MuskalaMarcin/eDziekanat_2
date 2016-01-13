package edziekanat.controller.student;

import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edziekanat.bean.LoginBean;
import edziekanat.databasemodel.dao.ApplicationDAO;
import edziekanat.databasemodel.dao.ScholarshipDAO;
import edziekanat.databasemodel.dao.UserDAO;
import edziekanat.databasemodel.dto.AdministratorDTO;
import edziekanat.databasemodel.dto.ApplicationDTO;
import edziekanat.databasemodel.dto.ScholarshipDTO;
import edziekanat.databasemodel.dto.UserDTO;

/**
 * Servlet implementation class ApplicationsController
 */
@WebServlet("/studentapplications")
public class ApplicationsController extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApplicationsController()
    {
	super();
    }

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
	LoginBean loginBean = (LoginBean) request.getSession().getAttribute("loginBean");

	List<ApplicationDTO> applications = new ApplicationDAO()
		.getMultipleEntities("student_id = '" + loginBean.getPersonId() + "'");
	Collections.sort(applications, (x, y) -> y.getDispatchDate().compareTo(x.getDispatchDate()));

	if (!applications.isEmpty())
	{
	    request.setAttribute("ownapplications", applications);
	}
	request.getRequestDispatcher("student/applications").forward(request, response);
    }

}

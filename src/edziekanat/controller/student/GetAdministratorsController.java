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
import edziekanat.databasemodel.dao.Application_typeDAO;
import edziekanat.databasemodel.dao.StudentDAO;
import edziekanat.databasemodel.dto.AdministratorDTO;
import edziekanat.databasemodel.dto.Application_typeDTO;
import edziekanat.databasemodel.dto.StudentsGroupDTO;

/**
 * Servlet used in sending new application to get all administrators from the database.
 */
@WebServlet("/studentgetadministartors")
public class GetAdministratorsController extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAdministratorsController()
    {
	super();
    }

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
	Application_typeDAO application_typeDAO = new Application_typeDAO();
	StudentDAO studentDAO = new StudentDAO();

	List<AdministratorDTO> admins = new LinkedList<>();

	for (StudentsGroupDTO group : studentDAO.getEntity(((LoginBean) request.getSession().getAttribute("loginBean"))
			.getPersonId()).getStudentsGroup())
	{
	    admins.addAll(group.getCourse().getFaculty().getUniversity().getAdministrator());
	}

	List<Application_typeDTO> appTypes = application_typeDAO.getApplication_types();

	request.setAttribute("adminList", removeDuplicates(admins));
	request.setAttribute("typeList", appTypes);
	request.getRequestDispatcher("student/newapplication").forward(request, response);

	studentDAO.closeEntityManager();
	application_typeDAO.closeEntityManager();
    }

    /**
     * Removes duplicated administrators, then sorts them by surname.
     *
     * @param admins
     * @return
     */
    private List<AdministratorDTO> removeDuplicates(List<AdministratorDTO> admins)
    {
	Collections.sort(admins, (x, y) -> x.getUser().getLogin().compareTo(y.getUser().getLogin()));
	for (int i = 1; i < admins.size(); i++)
	{
	    AdministratorDTO previous = admins.get(i - 1);
	    AdministratorDTO next = admins.get(i);
	    if (previous.getUser().getLogin().equals(next.getUser().getLogin()))
	    {
		admins.remove(previous);
		i--;
	    }
	}
	Collections.sort(admins, (x, y) -> x.getSurname().compareTo(y.getSurname()));
	return admins;
    }
}

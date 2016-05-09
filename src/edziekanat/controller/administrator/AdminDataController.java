package edziekanat.controller.administrator;

import edziekanat.bean.LoginBean;
import edziekanat.databasemodel.dao.AdministratorDAO;
import edziekanat.databasemodel.dao.StudentDAO;
import edziekanat.databasemodel.dto.AdministratorDTO;
import edziekanat.databasemodel.dto.StudentDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet providing applications send by student.
 */
@WebServlet("/adminmydata")
public class AdminDataController extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    /**
     * @see javax.servlet.http.HttpServlet#HttpServlet()
     */
    public AdminDataController()
    {
	super();
    }

    /**
     * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse
     * response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
	doPost(request, response);
    }

    /**
     * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
		Object save = request.getParameter("save");
		Object edit = request.getParameter("edit");
		AdministratorDAO administratorDAO = new AdministratorDAO();
		AdministratorDTO admin = administratorDAO.getEntity(((LoginBean) request.getSession().getAttribute("loginBean")).getPersonId());
		if (admin != null)
		{
			request.setAttribute("adminData", admin);

			request.setAttribute("editing","false");
		}
		if(save!=null)
		{
			admin.setName(request.getParameter("name"));
			admin.setSurname(request.getParameter("surname"));
			admin.setAddress(request.getParameter("address"));
			admin.getUser().seteMail(request.getParameter("email"));
			administratorDAO.update(admin);
			LoginBean newBean = (LoginBean) request.getSession().getAttribute("loginBean");
			newBean.setName(request.getParameter("name"));
			newBean.setSurname(request.getParameter("surname"));
			newBean.setAddress(request.getParameter("address"));
			newBean.seteMail(request.getParameter("email"));
			request.getSession().setAttribute("loginBean",newBean);
			request.setAttribute("editing","false");
		}
		else if(edit!=null)
		{
			request.setAttribute("editing","true");
		}
		administratorDAO.closeEntityManager();
		request.getRequestDispatcher("administrator/admin_my_data").forward(request, response);
    }

}

package edziekanat.controller.student;

import edziekanat.bean.LoginBean;
import edziekanat.databasemodel.dao.ApplicationDAO;
import edziekanat.databasemodel.dao.StudentDAO;
import edziekanat.databasemodel.dto.ApplicationDTO;
import edziekanat.databasemodel.dto.StudentDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Servlet providing applications send by student.
 */
@WebServlet("/studentmydata")
public class MyDataController extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    /**
     * @see javax.servlet.http.HttpServlet#HttpServlet()
     */
    public MyDataController()
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
		StudentDAO studentDAO = new StudentDAO();
		StudentDTO student = studentDAO.getEntity(((LoginBean) request.getSession().getAttribute("loginBean")).getPersonId());
		if (student != null)
		{
			request.setAttribute("studentData", student);
			request.setAttribute("editing","false");
		}
		if(save!=null)
		{
			student.setName(request.getParameter("name"));
			student.setSurname(request.getParameter("surname"));
			student.setAddress(request.getParameter("address"));
			student.getUser().seteMail(request.getParameter("email"));
			studentDAO.update(student);
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
		studentDAO.closeEntityManager();
		request.getRequestDispatcher("student/my_data").forward(request, response);
    }

}

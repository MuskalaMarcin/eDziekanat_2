package edziekanat.controller;

import edziekanat.bean.LoginBean;
import edziekanat.databasemodel.dao.NewsDAO;
import edziekanat.databasemodel.dao.UserDAO;
import edziekanat.databasemodel.dto.AdministratorDTO;
import edziekanat.databasemodel.dto.LecturerDTO;
import edziekanat.databasemodel.dto.NewsDTO;
import edziekanat.databasemodel.dto.StudentDTO;
import edziekanat.databasemodel.dto.UserDTO;
import edziekanat.utilities.PasswordUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Servlet maintaing logging in to application.
 */
@WebServlet("/loginaction")
public class LoginController extends HttpServlet
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
	request.getSession().setMaxInactiveInterval(3600);
	UserDAO userDAO = new UserDAO();
	try
	{
	    String username = request.getParameter("username");
	    String password = request.getParameter("password");
	    UserDTO user = userDAO.getEntity(username);
	    if (user == null)
		throw new ServletException();
	    else
	    {
		request.login(username, PasswordUtils.getSHA512PasswordHash(password, user.getSalt()));
	    }
	    List<NewsDTO> news = getNews();
	    System.out.println(news.size());
	    request.getSession().setAttribute("news", news);
	    request.getSession().setAttribute("senderNames", getUserNames(news));
	    request.getSession().setAttribute("loginBean", getLoginBean(request, userDAO));
	}
	catch (ServletException e)
	{
	    request.getSession().setAttribute("loginError", "true");
	}
	response.sendRedirect((String) request.getSession().getAttribute("backURL"));
	userDAO.closeEntityManager();
    }

    private LoginBean getLoginBean(HttpServletRequest request, UserDAO userDAO)
    {
	UserDTO user = userDAO.getEntity(request.getUserPrincipal().getName());
	switch (user.getUserRole())
	{
	case "admin":
	    AdministratorDTO admin = user.getAdministrator();
	    return new LoginBean(user.getLogin(), user.geteMail(), user.isActive(), user.getUserRole(),
			    admin.getId(), admin.getName(), admin.getSurname(), admin.getAddress(),
			    admin.getAcademicDegree());
	case "student":
	    StudentDTO student = user.getStudent();
	    return new LoginBean(user.getLogin(), user.geteMail(), user.isActive(), user.getUserRole(),
			    student.getId(), student.getName(), student.getSurname(), student.getAddress(),
			    student.getAcademicDegree());
	case "lecturer":
	    LecturerDTO lecturer = user.getLecturer();
	    return new LoginBean(user.getLogin(), user.geteMail(), user.isActive(), user.getUserRole(),
			    lecturer.getId(), lecturer.getName(), lecturer.getSurname(), lecturer.getAddress(),
			    lecturer.getAcademicDegree());
	default:
	    return null;
	}
    }

    private List<NewsDTO> getNews()
    {
	NewsDAO newsdao = new NewsDAO();
	List<NewsDTO> news = newsdao.getAllEntities();

	if (!news.isEmpty())
	{
	    Collections.sort(news, (x, y) -> y.getDispatchDate().compareTo(x.getDispatchDate()));
	}
	else {
	    System.out.println("PUSTO PUSTO PUSTO");
	}
	return news;
    }

    private List<String> getUserNames(List<NewsDTO> allNews)
    {
	List<String> userNames = new LinkedList<>();
	allNews.forEach(news -> {
	    UserDTO user = null;
	    user = news.getSender();
	    userNames.add(user.getAdministrator().getName() + " " + user.getAdministrator().getSurname());
	});
	return userNames;
    }
}

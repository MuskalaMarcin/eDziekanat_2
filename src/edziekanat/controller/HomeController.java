package edziekanat.controller;

import edziekanat.databasemodel.dao.NewsDAO;
import edziekanat.databasemodel.dto.NewsDTO;
import edziekanat.databasemodel.dto.UserDTO;

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
 * Servlet redirecting users visiting homepage to login page if they're not
 * logged in or specified for their role homepage.
 */
@WebServlet("/home")
public class HomeController extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    /**
     * Not used GET method redirecting to POST.
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
	doPost(request, response);
    }

    /**
     * POST method redirecting user to selected homepage
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
	NewsDAO newsdao = new NewsDAO();
	List<NewsDTO> news = getNews(newsdao);
	request.getSession().setAttribute("news", news);
	request.getSession().setAttribute("senderNames", getUserNames(news));
	if (request.isUserInRole("admin")) response.sendRedirect("admin");
	else if (request.isUserInRole("student")) response.sendRedirect("student");
	else if (request.isUserInRole("lecturer")) response.sendRedirect("lecturer");
	newsdao.closeEntityManager();
    }

    private List<NewsDTO> getNews(NewsDAO newsdao)
    {
	List<NewsDTO> news = newsdao.getAllEntities();
	if (!news.isEmpty())
	{
	    Collections.sort(news, (x, y) -> y.getDispatchDate().compareTo(x.getDispatchDate()));
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

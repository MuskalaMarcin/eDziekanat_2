package edziekanat.controller.common;

import edziekanat.bean.LoginBean;
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
 * Servlet implementation class AdminNews
 */
@WebServlet("/news")
public class News extends HttpServlet
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
	LoginBean loginBean = (LoginBean) request.getSession().getAttribute("loginBean");
	String messagesURL = "/" + loginBean.getUserRole() + "/news";

	NewsDAO newsdao = new NewsDAO();
	List<NewsDTO> news = newsdao.getAllEntities();

	if (!news.isEmpty())
	{
	    Collections.sort(news, (x, y) -> y.getDispatchDate().compareTo(x.getDispatchDate()));
	    List<String> senderNames = getUserNames(news);
	    request.setAttribute("senderNames", senderNames);
	    request.setAttribute("news", news);
	}
	getServletContext().getRequestDispatcher(messagesURL).forward(request, response);
	newsdao.closeEntityManager();
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

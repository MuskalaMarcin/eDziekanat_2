package edziekanat.controller.administrator;

import edziekanat.bean.LoginBean;
import edziekanat.databasemodel.dao.NewsDAO;
import edziekanat.databasemodel.dao.UserDAO;
import edziekanat.databasemodel.dto.NewsDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Calendar;

/**
 * Servlet implementation class AddNewNews
 */
@WebServlet("/adminaddnews")
public class AddNewNews extends HttpServlet
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
	NewsDTO news = new NewsDTO();
	NewsDAO newsdao = new NewsDAO();
	UserDAO userdao = new UserDAO();
	news.setTitle(request.getParameter("title"));
	news.setContent(request.getParameter("content"));
	news.setDispatchDate(Calendar.getInstance().getTime());
	news.setSender(userdao.getEntity(((LoginBean) request.getSession().getAttribute("loginBean")).getLogin()));
	newsdao.insert(news);

	request.setAttribute("msgshort", "Dodano og³oszenie.");
	request.setAttribute("msglong", "Og³oszenie zosta³o dodane do tablicy og³oszeñ.");
	request.getRequestDispatcher("common/info.jsp").forward(request, response);

	newsdao.closeEntityManager();
	userdao.closeEntityManager();
    }
}

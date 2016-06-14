package edziekanat.controller.administrator;

import edziekanat.databasemodel.dao.NewsDAO;
import edziekanat.databasemodel.dto.NewsDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class DeleteLecturer
 */
@WebServlet("/deletenews")
public class DeleteNews extends HttpServlet
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
	NewsDAO newsdao =  new NewsDAO();

	try
	{
	    NewsDTO news = newsdao.getEntity(Integer.parseInt(request.getParameter("newsid")));
	    newsdao.remove(news);

	    request.setAttribute("msgshort", "Usuniêto news");
	    request.setAttribute("msglong",
			    "Usuniêto news o tytule: " + news.getTitle());
	    request.setAttribute("previousUrl", "http://localhost:8080/edziekanat/news");
	    request.getRequestDispatcher("common/info.jsp").forward(request, response);
	}
	catch (Exception e)
	{
	    request.setAttribute("errorshort", "B³±d");
	    request.setAttribute("errorlong", "Podczas usuwania newsu"
			    + " wyst±pi³ nieznany b³±d. Przepraszamy.");
	    request.setAttribute("previousUrl", "http://localhost:8080/edziekanat/news");
	    request.getRequestDispatcher("common/error.jsp").forward(request, response);
	}

	newsdao.closeEntityManager();
    }
}

package edziekanat.controller.common;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edziekanat.bean.LoginBean;
import edziekanat.databasemodel.dao.MessageDAO;
import edziekanat.databasemodel.dao.UserDAO;
import edziekanat.databasemodel.dto.MessageDTO;

/**
 * Servlet implementation class SendMessageController
 */
@WebServlet("/sendmessage")
public class SendMessageController extends HttpServlet
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
	UserDAO userDAO = new UserDAO();
	MessageDTO newMessage = new MessageDTO();

	newMessage.setContent(request.getParameter("content"));
	newMessage.setDispatchDate(Calendar.getInstance().getTime());
	newMessage.setReceiver(userDAO.getEntity(request.getParameter("msgreceiver")));
	newMessage
		.setSender(userDAO.getEntity(((LoginBean) request.getSession().getAttribute("loginBean")).getLogin()));
	newMessage.setTitle(request.getParameter("msgtitle"));

	new MessageDAO().insert(newMessage);

	request.setAttribute("msgshort", "Wys³ano wiadomo¶æ");
	request.setAttribute("msglong", "Twoja wiadomo¶æ zosta³a wys³ana.");
	request.getRequestDispatcher("common/info.jsp").forward(request, response);
    }

}

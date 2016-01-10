package edziekanat.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edziekanat.bean.LoginBean;
import edziekanat.databasemodel.dao.MessageDAO;

/**
 * Servlet implementation class MessageController
 */
@WebServlet("/messageController")
public class MessageController extends HttpServlet
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
	String messagesURL = "/" + loginBean.getUserRole() + "messages";

	RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(messagesURL);
	request.setAttribute("sentMessages",
		new MessageDAO().getUserMessages(loginBean.getLogin()));
	request.setAttribute("receivedMessages",
		new MessageDAO().getMultipleEntities("receiver = '" + loginBean.getLogin() + "'"));

	dispatcher.forward(request, response);
    }

}

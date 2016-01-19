package edziekanat.controller.common;

import java.io.IOException;
import java.util.Calendar;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edziekanat.bean.LoginBean;
import edziekanat.databasemodel.dao.MessageDAO;
import edziekanat.databasemodel.dto.MessageDTO;
import edziekanat.databasemodel.dto.UserDTO;

/**
 * Servlet implementation class MessageController
 */
@WebServlet("/receivedmessages")
public class ReceivedMessagesController extends HttpServlet
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
	String messagesURL = "/" + loginBean.getUserRole() + "/receivedmessages";

	List<MessageDTO> receivedMsg = new MessageDAO()
		.getMultipleEntities("receiver_id = '" + loginBean.getLogin() + "'");

	if (!receivedMsg.isEmpty())
	{
	    Collections.sort(receivedMsg, (x, y) -> y.getDispatchDate().compareTo(x.getDispatchDate()));
	    setReceivedDate(receivedMsg);
	    List<String> senderNames = getUserNames(receivedMsg, true);
	    request.setAttribute("senderNames", senderNames);
	    request.setAttribute("receivedMessages", receivedMsg);
	}
	getServletContext().getRequestDispatcher(messagesURL).forward(request, response);
    }

    private void setReceivedDate(List<MessageDTO> receivedMsg)
    {
	Calendar calendar = Calendar.getInstance();
	MessageDAO messageDAO = new MessageDAO();
	receivedMsg.forEach(msg -> {
	    if (msg.getReceiveDate() == null)
	    {	
		msg.setReceiveDate(calendar.getTime());
		messageDAO.update(msg);
	    }
	});
    }

    private List<String> getUserNames(List<MessageDTO> allMessage, boolean isSender)
    {
	List<String> userNames = new LinkedList<String>();
	allMessage.forEach(message -> {
	    UserDTO user = null;
	    user = isSender ? message.getSender() : message.getReceiver();
	    switch (user.getUserRole())
	    {
	    case "admin":
		userNames.add(user.getAdministrator().getName() + " " + user.getAdministrator().getSurname());
		break;
	    case "student":
		userNames.add(user.getStudent().getName() + " " + user.getStudent().getSurname());
		break;
	    case "lecturer":
		userNames.add(user.getLecturer().getName() + " " + user.getLecturer().getSurname());
		break;
	    }
	});
	return userNames;
    }

}

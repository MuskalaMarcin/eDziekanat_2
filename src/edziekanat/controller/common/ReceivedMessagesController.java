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
public class ReceivedMessagesController extends ParentMessagesController
{

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
	LoginBean loginBean = (LoginBean) request.getSession().getAttribute("loginBean");
	String messagesURL = "/" + loginBean.getUserRole() + "/receivedmessages";

	MessageDAO messageDAO = new MessageDAO();
	List<MessageDTO> receivedMsg = getMessages(request, messageDAO, loginBean.getLogin(), false);

	if (!receivedMsg.isEmpty())
	{
	    setReceivedDate(receivedMsg);
	    List<String> senderNames = getUserNames(receivedMsg, true);
	    request.setAttribute("senderNames", senderNames);
	    request.setAttribute("receivedMessages", receivedMsg);
	}

	getServletContext().getRequestDispatcher(messagesURL).forward(request, response);
	messageDAO.closeEntityManager();
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
}

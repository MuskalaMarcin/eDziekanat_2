package edziekanat.controller.common;

import java.io.IOException;
import java.util.ArrayList;
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
 * Servlet implementation class SentMessagesController
 */
@WebServlet("/sentmessages")
public class SentMessagesController extends ParentMessagesController
{
    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
	LoginBean loginBean = (LoginBean) request.getSession().getAttribute("loginBean");
	String messagesURL = "/" + loginBean.getUserRole() + "/sentmessages";

	MessageDAO messageDAO = new MessageDAO();
	List<MessageDTO> sentMsg = getMessages(request, messageDAO, loginBean.getLogin(), true);

	if (!sentMsg.isEmpty())
	{
		List<MessageDTO> sentMsgToSend = new ArrayList<>();
		List<String> receiverNames = new ArrayList<>();
		String lasttitle = "";
		String lastcontent = "";
		for(MessageDTO message:sentMsg)
		{
			if(message.getGroup()== null)
			{
				sentMsgToSend.add(message);
				receiverNames.add(getUserName(message,false));
			}
			else
			{
				if(!message.getTitle().equals(lasttitle) && !message.getContent().equals(lastcontent))
				{
					lasttitle = message.getTitle();
					lastcontent = message.getContent();
					sentMsgToSend.add(message);
					receiverNames.add("Grupa "+message.getGroup().getId().toString());
				}
			}
		}
	    request.setAttribute("receiverNames", receiverNames);
	    request.setAttribute("sentMessages", sentMsgToSend);
	}

	getServletContext().getRequestDispatcher(messagesURL).forward(request, response);

	messageDAO.closeEntityManager();
    }
}

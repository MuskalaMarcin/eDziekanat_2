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
	    List<List<String>> receiverNames = new ArrayList<>();
	    List<String> name;
	    String lasttitle = "";
	    String lastcontent = "";
	    int messageCounter = 0;
		if(sentMsg.size() == 1)
		{
			name = new ArrayList<>();
			name.add(getUserName(sentMsg.get(messageCounter), false));
			receiverNames.add(name);
			sentMsgToSend.add(sentMsg.get(messageCounter));
		}
		if(sentMsg.size() > 1) {
			while (messageCounter < sentMsg.size()) {
				if (sentMsg.get(messageCounter).getGroup() == null) {
					name = new ArrayList<>();
					name.add(getUserName(sentMsg.get(messageCounter), false));
					receiverNames.add(name);
					sentMsgToSend.add(sentMsg.get(messageCounter));
					messageCounter++;
				} else {
					lasttitle = sentMsg.get(messageCounter).getTitle();
					lastcontent = sentMsg.get(messageCounter).getContent();
					name = new ArrayList<>();
					name.add("Grupa " + sentMsg.get(messageCounter).getGroup().getId().toString());
					sentMsgToSend.add(sentMsg.get(messageCounter));
					while (messageCounter < sentMsg.size() && sentMsg.get(messageCounter).getTitle().equals(lasttitle) && sentMsg.get(messageCounter)
							.getContent().equals(lastcontent)) {
						String recStatus;
						if (sentMsg.get(messageCounter).getReceiveDate() == null) {
							recStatus = "nie";
						} else {
							recStatus = sentMsg.get(messageCounter).getReceiveDate().toString();
						}
						name.add(getUserName(sentMsg.get(messageCounter).getReceiver()) + " - otrzymano: " + recStatus);
						messageCounter++;
					}
					receiverNames.add(name);
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

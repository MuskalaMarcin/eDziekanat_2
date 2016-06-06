package edziekanat.controller.common;

import edziekanat.bean.LoginBean;
import edziekanat.databasemodel.dao.MessageDAO;
import edziekanat.databasemodel.dto.MessageDTO;
import edziekanat.databasemodel.dto.StudentsGroupDTO;
import edziekanat.databasemodel.dto.UserDTO;
import org.apache.commons.lang3.ObjectUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Marcin Muskala on 25.04.2016.
 */
public abstract class ParentMessagesController extends HttpServlet
{
    private static final long serialVersionUID = 1L;
    private static final int msgPerPages = 10;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
	doPost(request, response);
    }

    protected List<MessageDTO> getMessages(HttpServletRequest request, MessageDAO messageDAO, String login,
		    Boolean isSender) throws ServletException, IOException
    {
	String query;
	if (isSender)
	{
	    query = "sender_id = '" + login + "'";
	}
	else
	{
	    query = "receiver_id = '" + login + "'";
	}

	List<MessageDTO> msg = messageDAO.getMultipleEntities(query);
	List<MessageDTO> messageDTOs = new LinkedList<>();
	if (!msg.isEmpty())
	{
	    Collections.sort(msg, (x, y) -> y.getId().compareTo(x.getId()));
	    Collections.sort(msg, (x, y) -> y.getDispatchDate().compareTo(x.getDispatchDate()));
	    int msgSize = 0;
	    String previousTitle = "";
	    String previousContent = "";
	    StudentsGroupDTO previousGroup = null;
	    for (MessageDTO message : msg)
	    {
			if (!(message.getTitle().equals(previousTitle) && ObjectUtils
					.equals(message.getGroup(), previousGroup) && message.getContent()
					.equals(previousContent)))
			{
				msgSize++;
			}
			previousGroup = message.getGroup();
			previousTitle = message.getTitle();
			previousContent = message.getContent();
	    }
	    int pagesNumber = msgSize / msgPerPages + ((msgSize % msgPerPages > 0) ? 1 : 0);

	    String requestPageString = request.getParameter("getPage");
	    Integer requestPage;
	    if (requestPageString == null)
	    {
			requestPage = 0;
	    }
	    else
	    {
			requestPage = Integer.parseInt(requestPageString);
	    }
	    int lastMsgIndex = (requestPage * msgPerPages) + msgPerPages;

	    int msgCounter = 0;
	    previousGroup = null;
	    previousTitle = "";
	    previousContent = "";
	    for (MessageDTO message : msg)
	    {
			if (msgCounter >= requestPage * msgPerPages && msgCounter <= lastMsgIndex)
			{
				messageDTOs.add(message);
			}
			if (!(message.getTitle().equals(previousTitle) && ObjectUtils
					.equals(message.getGroup(), previousGroup) && message.getContent()
					.equals(previousContent)))
			{
				msgCounter++;
			}
			previousGroup = message.getGroup();
			previousTitle = message.getTitle();
			previousContent = message.getContent();
	    }
	    request.setAttribute("currentPage", requestPage);
	    request.setAttribute("pagesNumber", pagesNumber);
	}

	return messageDTOs;
    }

    protected List<String> getUserNames(List<MessageDTO> allMessage, boolean isSender)
    {
	return allMessage.stream().map(message -> getUserName(message, isSender)).collect(Collectors.toList());
    }

    protected String getUserName(MessageDTO message, boolean isSender)
    {
	UserDTO user = isSender ? message.getSender() : message.getReceiver();

	return getUserName(user);
    }

    protected String getUserName(UserDTO user)
    {
	switch (user.getUserRole())
	{
	case "admin":
	    return user.getAdministrator().getName() + " " + user.getAdministrator().getSurname();
	case "student":
	    return user.getStudent().getName() + " " + user.getStudent().getSurname();
	case "lecturer":
	    return user.getLecturer().getName() + " " + user.getLecturer().getSurname();
	}
	return null;
    }
}

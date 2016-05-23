package edziekanat.controller.common;

		import edziekanat.bean.LoginBean;
		import edziekanat.databasemodel.dao.MessageDAO;
		import edziekanat.databasemodel.dto.MessageDTO;
		import edziekanat.databasemodel.dto.UserDTO;

		import javax.servlet.ServletException;
		import javax.servlet.http.HttpServlet;
		import javax.servlet.http.HttpServletRequest;
		import javax.servlet.http.HttpServletResponse;
		import java.io.IOException;
		import java.util.Collections;
		import java.util.LinkedList;
		import java.util.List;

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
										   Boolean isSender)
			throws ServletException, IOException
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
		if (!msg.isEmpty())
		{
			Collections.sort(msg, (x, y) -> y.getId().compareTo(x.getId()));
			Collections.sort(msg, (x, y) -> y.getDispatchDate().compareTo(x.getDispatchDate()));
			int pagesNumber = msg.size() / msgPerPages + ((msg.size() % msgPerPages > 0) ? 1 : 0);
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
			msg = msg.subList(requestPage * msgPerPages,
					((lastMsgIndex) > msg.size()) ? msg.size() : lastMsgIndex);
			request.setAttribute("currentPage", requestPage);
			request.setAttribute("pagesNumber", pagesNumber);
		}

		return msg;
	}

	protected List<String> getUserNames(List<MessageDTO> allMessage, boolean isSender)
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

	protected String getUserName(MessageDTO message, boolean isSender)
	{
		String userName = "";

		UserDTO user = null;
		user = isSender ? message.getSender() : message.getReceiver();
		switch (user.getUserRole())
		{
			case "admin":
				userName = user.getAdministrator().getName() + " " + user.getAdministrator().getSurname();
				break;
			case "student":
				userName = user.getStudent().getName() + " " + user.getStudent().getSurname();
				break;
			case "lecturer":
				userName = user.getLecturer().getName() + " " + user.getLecturer().getSurname();
				break;
		}

		return userName;
	}

	protected String getUserName(UserDTO _user)
	{
		String userName = "";

		UserDTO user = _user;

		switch (user.getUserRole())
		{
			case "admin":
				userName = user.getAdministrator().getName() + " " + user.getAdministrator().getSurname();
				break;
			case "student":
				userName = user.getStudent().getName() + " " + user.getStudent().getSurname();
				break;
			case "lecturer":
				userName = user.getLecturer().getName() + " " + user.getLecturer().getSurname();
				break;
		}

		return userName;
	}
}

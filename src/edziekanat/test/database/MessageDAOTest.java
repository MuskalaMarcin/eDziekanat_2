package edziekanat.test.database;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edziekanat.databasemodel.dao.MessageDAO;
import edziekanat.databasemodel.dto.MessageDTO;

@WebServlet("/MessageDAOTest")
public class MessageDAOTest extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
	doPost(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
	response.setContentType("text/html");
	PrintWriter out = response.getWriter();

	out.println("ONE Message");
	MessageDTO message = new MessageDAO().getEntity(1);
	out.println("<br>" + message.getContent());
	out.println("<br>" + message.getTitle());
	out.println("<br>" + message.getReceiver().getLogin());
	out.println("<br>" + message.getId());
	out.println("<br>" + message.getSender().getLogin());
	out.println("<br>" + message.getDispatchDate());
	out.println("<br>" + message.getReceiveDate());

	out.println("<p>ALL Messages");
	new MessageDAO().getAllEntities().forEach(item -> {
	    out.println("<br>" + item.getContent());
	    out.println("<br>" + item.getTitle());
	    out.println("<br>" + item.getReceiver().getLogin());
	    out.println("<br>" + item.getId());
	    out.println("<br>" + item.getSender().getLogin());
	    out.println("<br>" + item.getDispatchDate());
	    out.println("<br>" + item.getReceiveDate());
	    out.println("<br> nastepny");
	});
    }
}

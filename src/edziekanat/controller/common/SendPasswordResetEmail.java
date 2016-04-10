package edziekanat.controller.common;

import edziekanat.databasemodel.dao.UserDAO;
import edziekanat.databasemodel.dto.UserDTO;
import edziekanat.utilities.MailUtils;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.NoSuchElementException;

/**
 * Created by Marcin on 10.04.2016.
 */
@WebServlet("/sendresetemailaction")
public class SendPasswordResetEmail extends HttpServlet
{

    private static String RECIPIENT = "marcin.muskala@gmail.com";

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
	UserDTO user = getUser(request.getParameter("login-email"));
	if (user == null)
	{
	    request.setAttribute("resetError", "true");
	    request.getRequestDispatcher("common/passwordresetform.jsp").forward(request, response);
	}
	else
	{
	    String[] to = { user.geteMail() };
	    String subject = "eDziekanat - reset has�a";
	    String body = "eDziekanat - reset has�a!";
	    try
	    {
		MailUtils.sendFromGMail(to, subject, body);

		request.setAttribute("msgshort", "Resetowanie has�a");
		request.setAttribute("msglong", "Procedura resetowania has�a zosta�a rozpocz�ta,"
				+ " post�puj zgodnie z instrukcjami z otrzymanej wiadomo�ci e-mail.");
		request.getRequestDispatcher("common/info.jsp").forward(request, response);
	    }
	    catch (MessagingException me)
	    {
		request.setAttribute("msgshort", "B��d");
		request.setAttribute("msglong",
				"Podczas resetowania has�a wyst�pi� nieznany b��d, spr�buj ponownie po�niej.");
		request.getRequestDispatcher("common/error.jsp").forward(request, response);
	    }
	}
    }

    private UserDTO getUser(String loginEMail)
    {
	UserDAO userDAO = new UserDAO();
	UserDTO user = userDAO.getEntity(loginEMail);
	if (user == null)
	{
	    try
	    {
		user = userDAO.getAllEntities().stream().filter(userDTO -> userDTO.geteMail().equals(loginEMail))
				.findAny().get();
	    }
	    catch (NoSuchElementException e)
	    {
		return null;
	    }
	}
	return user;
    }
}

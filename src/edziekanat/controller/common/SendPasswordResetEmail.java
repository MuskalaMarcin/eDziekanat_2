package edziekanat.controller.common;

import edziekanat.databasemodel.dao.PasswordResetDAO;
import edziekanat.databasemodel.dao.UserDAO;
import edziekanat.databasemodel.dto.PasswordResetDTO;
import edziekanat.databasemodel.dto.UserDTO;
import edziekanat.utilities.MailUtils;
import edziekanat.utilities.PasswordUtils;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.NoSuchElementException;

import static j2html.TagCreator.*;

/**
 * Created by Marcin on 10.04.2016.
 */
@WebServlet("/sendresetemailaction")
public class SendPasswordResetEmail extends HttpServlet
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
	UserDTO user = getUser(request.getParameter("login-email"));
	if (user == null)
	{
	    request.setAttribute("resetError", "true");
	    request.getRequestDispatcher("common/passwordresetform.jsp").forward(request, response);
	}
	else
	{
	    PasswordResetDTO passwordResetDTO = addResetRequest(user);

	    String[] to = { user.geteMail() };
	    String subject = "eDziekanat - reset has³a";
	    String resetUrl = "http://localhost:8080/edziekanat/resetpassword?resetid=" + passwordResetDTO.getId();
	    String body = constructEmailBody(resetUrl);

	    try
	    {
		MailUtils.sendFromGMail(to, subject, body);

		request.setAttribute("msgshort", "Resetowanie has³a");
		request.setAttribute("msglong", "Procedura resetowania has³a zosta³a rozpoczêta,"
				+ " postêpuj zgodnie z instrukcjami w otrzymanej wiadomo¶ci e-mail.");
		request.getRequestDispatcher("common/info.jsp").forward(request, response);
	    }
	    catch (MessagingException me)
	    {
		new PasswordResetDAO().remove(passwordResetDTO);
		request.setAttribute("msgshort", "B³±d");
		request.setAttribute("msglong",
				"Podczas resetowania has³a wyst±pi³ nieznany b³±d, spróbuj ponownie po¼niej.");
		request.getRequestDispatcher("common/error.jsp").forward(request, response);
	    }
	}
    }

    private String constructEmailBody(String resetUrl)
    {
	return body().attr("style", "text-align: center")
			.with(h1("eDziekanat").attr("style",
					"color: #333; font-size: 3em; font-weight: 300; font-family: sans-serif;"),
					h2("Twój wirtualny dziekanat.").attr("style", "color: #ccc; font-size: 1.5em;"
							+ " font-weight: 300; font-family: sans-serif;"),
					hr().attr("style", "color: #eee; width:100%; height: 1px"),
					p("Rozpocz±³e¶ procedurê resetowania has³a, aby przej¶æ dalej kliknij w link: "
							+ resetUrl
							+ " i postêpuj zgodnie z instrukcjami na ekranie. Link jest "
							+ "wa¿ny 24 godziny.").attr("style", "color: #888; font-size:"
							+ " 1em; font-weight: 300; font-family: sans-serif;"),
					p("Je¿eli nie oczekiwa³e¶ tego maila skontaktuj siê"
							+ " z administracj± systemu eDziekanat.").attr("style",
							"color: #888; font-size: 1em; font-weight: 300; font-family: sans-serif;"))
			.render();
    }

    private PasswordResetDTO addResetRequest(UserDTO user)
    {
	PasswordResetDAO passwordResetDAO = new PasswordResetDAO();

	try
	{
	    PasswordResetDTO previousReset = user.getPasswordResets().stream()
			    .filter(passwordResetDTO -> passwordResetDTO.getIsActive().equals(1)).findAny().get();
	    previousReset.setIsActive(0);
	    passwordResetDAO.update(previousReset);
	}
	catch (NoSuchElementException e)
	{
	}

	String hash = PasswordUtils.generateSalt();
	if (passwordResetDAO.getAllEntities().stream().filter(passwordReset -> passwordReset.getId().equals(hash))
			.findAny().isPresent())
	{
	    return addResetRequest(user);
	}

	PasswordResetDTO passwordResetDTO = new PasswordResetDTO();
	passwordResetDTO.setId(hash);
	passwordResetDTO.setIsActive(1);
	passwordResetDTO.setRequestDate(new Date());
	passwordResetDTO.setUser(user);
	passwordResetDAO.insert(passwordResetDTO);

	return passwordResetDTO;
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

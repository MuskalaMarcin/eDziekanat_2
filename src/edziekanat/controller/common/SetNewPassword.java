package edziekanat.controller.common;

import edziekanat.databasemodel.dao.PasswordResetDAO;
import edziekanat.databasemodel.dao.UserDAO;
import edziekanat.databasemodel.dto.PasswordResetDTO;
import edziekanat.databasemodel.dto.UserDTO;
import edziekanat.utilities.PasswordUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Marcin Muskala on 10.04.2016.
 */
@WebServlet("/setnewpassword")
public class SetNewPassword extends HttpServlet
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
	String resetId = request.getParameter("resetid");
	String password = request.getParameter("password");
	String passwordRepeat = request.getParameter("passwordrepeat");

	if (password.equals(passwordRepeat))
	{
	    if (password.length() >= 5)
	    {
		PasswordResetDAO passwordResetDAO = new PasswordResetDAO();
		UserDAO userDAO = new UserDAO();

		PasswordResetDTO passwordResetDTO = passwordResetDAO.getEntity(resetId);
		passwordResetDTO.setIsActive(0);
		passwordResetDAO.update(passwordResetDTO);

		UserDTO user = passwordResetDTO.getUser();
		String salt = PasswordUtils.generateSalt();
		String hash = PasswordUtils.getSHA512PasswordHash(password, salt);
		user.setPassword(hash);
		user.setSalt(salt);
		userDAO.update(user);

		userDAO.closeEntityManager();
		passwordResetDAO.closeEntityManager();

		request.setAttribute("msgshort", "Zmieniono has³o");
		request.setAttribute("msglong", "Has³o zosta³o zmienione. Mo¿esz zalogowaæ siê do systemu.");
		request.getRequestDispatcher("common/info.jsp").forward(request, response);
	    }
	    else
	    {
		request.setAttribute("errorshort", "B³±d");
		request.setAttribute("errorlong", "Minimalna d³ugo¶æ has³a to 5 znaków.");
		request.getRequestDispatcher("common/error.jsp").forward(request, response);
	    }
	}
	else
	{
	    request.setAttribute("errorshort", "B³±d");
	    request.setAttribute("errorlong", "Podano ró¿ne has³a.");
	    request.getRequestDispatcher("common/error.jsp").forward(request, response);
	}
    }
}

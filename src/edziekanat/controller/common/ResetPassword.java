package edziekanat.controller.common;

import edziekanat.databasemodel.dao.PasswordResetDAO;
import edziekanat.databasemodel.dto.PasswordResetDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * Created by Marcin Muskala on 10.04.2016.
 */
@WebServlet("/resetpassword")
public class ResetPassword extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
	String resetId = request.getParameter("resetid");
	PasswordResetDAO passwordResetDAO = new PasswordResetDAO();
	PasswordResetDTO passwordResetDTO = passwordResetDAO.getEntity(resetId);
	if (passwordResetDTO == null || passwordResetDTO.getIsActive().equals(0))
	{
	    request.setAttribute("errorshort", "B³±d");
	    request.setAttribute("errorlong", "Podany link jest b³êdny, lub zosta³ wcze¶niej wykorzystany.");
	    request.getRequestDispatcher("common/error.jsp").forward(request, response);
	}
	else if (((int) ((passwordResetDTO.getRequestDate().getTime() - new Date().getTime()) / (1000 * 60 * 60 * 24)))
			> 1)
	{
	    passwordResetDTO.setIsActive(0);
	    passwordResetDAO.update(passwordResetDTO);

	    request.setAttribute("errorshort", "B³±d");
	    request.setAttribute("errorlong", "Przekroczono maksymalny czas wa¿no¶ci linku resetuj±cego (24h).");
	    request.getRequestDispatcher("common/error.jsp").forward(request, response);
	}
	else
	{
	    request.setAttribute("resetid", resetId);
	    request.getRequestDispatcher("common/newpasswordform.jsp").forward(request, response);
	}
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
	doGet(request, response);
    }
}

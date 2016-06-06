package edziekanat.controller.administrator;

import edziekanat.databasemodel.dao.PartialMarkDAO;
import edziekanat.databasemodel.dto.PartialMarkDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Marcin Muska�a on 06.06.2016.
 */
@WebServlet("/cancelpartialmark")
public class CancelPartialMark extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        PartialMarkDAO partialMarkDAO = new PartialMarkDAO();

        try
        {
            Integer partialMarkId = Integer.parseInt(request.getParameter("partialMarkId"));
            PartialMarkDTO partialMarkDTO = partialMarkDAO.getEntity(partialMarkId);
            partialMarkDAO.remove(partialMarkDTO);
            request.setAttribute("msgshort", "Usuni�to ocen�");
            request.setAttribute("msglong", "Ocena zosta�a usuni�ta.");
            request.getRequestDispatcher("common/info.jsp").forward(request, response);
        }
        catch (NumberFormatException e)
        {
            request.setAttribute("errorshort", "B��d");
            request.setAttribute("errorlong", "Podczas przesy�ania danych wyst�pi� b��d.");
            request.getRequestDispatcher("common/error.jsp").forward(request, response);
        }
        catch (Exception e)
        {
            request.setAttribute("errorshort", "B��d");
            request.setAttribute("errorlong", "Podczas usuwania oceny wyst�pi� nieznany b��d.");
            request.getRequestDispatcher("common/error.jsp").forward(request, response);
        }

        partialMarkDAO.closeEntityManager();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
	doPost(request, response);
    }
}

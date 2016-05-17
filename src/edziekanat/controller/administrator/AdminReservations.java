package edziekanat.controller.administrator;

import edziekanat.databasemodel.dao.ReservationRequestDAO;
import edziekanat.databasemodel.dto.ReservationRequestDTO;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Marcin Muska³a on 17.05.2016.
 */
@WebServlet("/adminreservations")
public class AdminReservations extends HttpServlet
{
    private static final int resPerPages = 10;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
	String action = request.getParameter("action");
	RequestDispatcher rd;
	List<ReservationRequestDTO> reservationRequestsList;
	ReservationRequestDAO reservationRequestDAO = new ReservationRequestDAO();

	if (StringUtils.equals(action, "history"))
	{
	    rd = request.getRequestDispatcher("/administrator/historyreservations.jsp");
	    reservationRequestsList = reservationRequestDAO.getHistoryOfReservations();
	}
	else
	{
	    action = "waiting";
	    rd = request.getRequestDispatcher("/administrator/currentreservations.jsp");
	    reservationRequestsList = reservationRequestDAO.getWaitingReservations();
	    String successMsg = request.getParameter("successMsg");
	    if (successMsg != null)
	    {
		request.setAttribute("successMsg", successMsg);
	    }
	    String errorMsg = request.getParameter("errorMsg");
	    if (errorMsg != null)
	    {
		request.setAttribute("errorMsg", errorMsg);
	    }
	}

	int pagesNumber = reservationRequestsList.size() / resPerPages + ((reservationRequestsList.size() % resPerPages
			> 0) ? 1 : 0);
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
	int lastResIndex = (requestPage * resPerPages) + resPerPages;
	reservationRequestsList = reservationRequestsList.subList(requestPage * resPerPages,
			((lastResIndex) > reservationRequestsList.size()) ? reservationRequestsList.size() :
					lastResIndex);
	request.setAttribute("currentPage", requestPage);
	request.setAttribute("pagesNumber", pagesNumber);
	request.setAttribute("reservationsList", reservationRequestsList);

	request.setAttribute("action", action);
	rd.forward(request, response);
	reservationRequestDAO.closeEntityManager();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
	doPost(request, response);
    }
}

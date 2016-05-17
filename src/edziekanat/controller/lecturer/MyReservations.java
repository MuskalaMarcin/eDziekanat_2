package edziekanat.controller.lecturer;

import edziekanat.bean.LoginBean;
import edziekanat.databasemodel.dao.ReservationRequestDAO;
import edziekanat.databasemodel.dto.ReservationRequestDTO;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

/**
 * Created by Marcin Muskala on 16.05.2016.
 */
@WebServlet("/myreservations")
public class MyReservations extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
	ReservationRequestDAO reservationRequestDAO = new ReservationRequestDAO();
	LoginBean loginBean = (LoginBean) request.getSession().getAttribute("loginBean");
	List<ReservationRequestDTO> reservationRequestDTOList = reservationRequestDAO
			.getLecturersReservations(loginBean.getPersonId());

	removeIfAsked(reservationRequestDAO, request, reservationRequestDTOList);

	request.setAttribute("reservationsList", reservationRequestDTOList);
	request.getRequestDispatcher("/lecturer/myreservations.jsp").forward(request, response);
	reservationRequestDAO.closeEntityManager();
    }

    private void removeIfAsked(ReservationRequestDAO reservationRequestDAO, HttpServletRequest request,
		    List<ReservationRequestDTO> reservationRequestDTOList)
    {
	String action = request.getParameter("action");
	if (StringUtils.equals(action, "delete"))
	{
	    try
	    {
		Integer reservationId = Integer.parseInt(request.getParameter("reservationId"));
		ReservationRequestDTO reservation = reservationRequestDTOList.stream()
				.filter(r -> r.getId().equals(reservationId)).findFirst().get();
		reservationRequestDAO.remove(reservation);
		reservationRequestDTOList.remove(reservation);

		request.setAttribute("deletedReservation", true);
		request.setAttribute("warningMsg", "Twoja rezerwacja o id: " + reservationId + " zosta³a usuniêta.");
	    }
	    catch (Exception e)
	    {
		request.setAttribute("errorMsg", "Podczas usuwania rezerwacji wyst±pi³ bl±d.");
	    }
	}
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
	doPost(request, response);
    }
}

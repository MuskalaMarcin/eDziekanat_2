package edziekanat.controller.administrator;

import edziekanat.databasemodel.dao.ReservationRequestDAO;
import edziekanat.databasemodel.dao.ScheduledClassesDAO;
import edziekanat.databasemodel.dto.ReservationRequestDTO;
import edziekanat.databasemodel.dto.ScheduledClassesDTO;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Marcin Muska³a on 17.05.2016.
 */
@WebServlet("/managereservations")
public class ManageReservations extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
	ReservationRequestDAO reservationRequestDAO = new ReservationRequestDAO();
	ScheduledClassesDAO scheduledClassesDAO = new ScheduledClassesDAO();
	try
	{
	    String action = request.getParameter("action");
	    Integer reservationId = Integer.parseInt(request.getParameter("reservationId"));
	    ReservationRequestDTO reservation = reservationRequestDAO.getEntity(reservationId);
	    List<ScheduledClassesDTO> scheduledClassesDTOList = scheduledClassesDAO.getAllEntities();

	    if (StringUtils.equals(action, "accepted"))
	    {
		int repeatClasses = reservation.getRepeatClasses();
		if (repeatClasses == 0)
		{
		    if (manageSingleReservation(scheduledClassesDTOList, scheduledClassesDAO, reservation))
		    {
			request.setAttribute("successMsg", "Zaakceptowano wybrany wniosek o rezerwacje sali.");
		    }
		    else
		    {
			request.setAttribute("errorMsg", "Sala jest ju¿ zarezerwowana w wybranym terminie.");
		    }
		}
		else
		{
		    if (manageRepeatedReservation(scheduledClassesDTOList, scheduledClassesDAO,
				    reservation))
		    {
			request.setAttribute("successMsg", "Zaakceptowano wybrany wniosek o rezerwacje sali.");
		    }
		    else
		    {
			request.setAttribute("errorMsg", "Sala jest ju¿ zarezerwowana w wybranym terminie.");
		    }
		}
	    }
	    else if (StringUtils.equals(action, "rejected"))
	    {
		reservation.setStatus("rejected");
		request.setAttribute("warningMsg", "Odrzucono wybrany wniosek.");
	    }

	    reservationRequestDAO.update(reservation);
	}
	catch (Exception e)
	{
	    e.printStackTrace();
	    request.setAttribute("errorMsg", "Podczas przetwarzania zadania wyst±pi³ b³±d.");
	}

	request.setAttribute("getPage", request.getParameter("getPage"));
	request.getRequestDispatcher("/adminreservations").forward(request, response);
	reservationRequestDAO.closeEntityManager();
	scheduledClassesDAO.closeEntityManager();
    }

    private boolean manageRepeatedReservation(List<ScheduledClassesDTO> scheduledClassesDTOList,
		    ScheduledClassesDAO scheduledClassesDAO, ReservationRequestDTO reservation)
    {
	Calendar calendar = Calendar.getInstance();
	calendar.setFirstDayOfWeek(Calendar.MONDAY);
	calendar.setTime(reservation.getClassesDate());
	do
	{
	    if (scheduledClassesDTOList.stream().filter(f -> f.getDate().compareTo(calendar.getTime()) == 0)
			    .findAny().isPresent())
	    {
		reservation.setStatus("rejected");
		return false;
	    }
	    calendar.add(Calendar.DAY_OF_YEAR, 7 * reservation.getRepeatClasses());
	}
	while (calendar.getTime().compareTo(reservation.getClassesEndDate()) <= 0);

	calendar.setTime(reservation.getClassesDate());
	do
	{
	    ScheduledClassesDTO newClasses = new ScheduledClassesDTO();
	    newClasses.setClassroom(reservation.getClassroom());
	    newClasses.setSubject(reservation.getSubject());
	    newClasses.setDate(calendar.getTime());
	    newClasses.setDuration(90);
	    scheduledClassesDAO.insert(newClasses);
	    calendar.add(Calendar.DAY_OF_YEAR, 7 * reservation.getRepeatClasses());
	}
	while (calendar.getTime().compareTo(reservation.getClassesEndDate()) <= 0);
	reservation.setStatus("accepted");
	return true;
    }

    private boolean manageSingleReservation(List<ScheduledClassesDTO> scheduledClassesDTOList,
		    ScheduledClassesDAO scheduledClassesDAO, ReservationRequestDTO reservation)
    {
	if (scheduledClassesDTOList.stream().filter(f -> f.getDate().compareTo(reservation.getClassesDate()) == 0)
			.findAny().isPresent())
	{
	    reservation.setStatus("rejected");
	    return false;
	}
	else
	{
	    ScheduledClassesDTO newClasses = new ScheduledClassesDTO();
	    newClasses.setClassroom(reservation.getClassroom());
	    newClasses.setSubject(reservation.getSubject());
	    newClasses.setDate(reservation.getClassesDate());
	    newClasses.setDuration(90);
	    scheduledClassesDAO.insert(newClasses);
	    reservation.setStatus("accepted");
	    return true;
	}
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
	doPost(request, response);
    }
}

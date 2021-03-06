package edziekanat.controller.common;

import java.io.IOException;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edziekanat.bean.LoginBean;
import edziekanat.databasemodel.dao.ClassroomDAO;
import edziekanat.databasemodel.dao.LecturerDAO;
import edziekanat.databasemodel.dao.ScheduledClassesDAO;
import edziekanat.databasemodel.dto.ClassroomDTO;
import edziekanat.databasemodel.dto.LecturerDTO;
import edziekanat.databasemodel.dto.ReservationRequestDTO;
import edziekanat.databasemodel.dto.ScheduledClassesDTO;

/**
 * Created by Marcin Muskala on 21.04.2016.
 */
@WebServlet("/classrooms")
public class ClassroomsController extends ParentTimetableController
{
    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    @SuppressWarnings("deprecation")
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
	ClassroomDAO classroomDAO = new ClassroomDAO();

	Integer selectedClassroomId = Integer.parseInt(
			request.getParameter("classroomId") == null ? "-1" : request.getParameter("classroomId"));
	LoginBean loginBean = ((LoginBean) request.getSession().getAttribute("loginBean"));

	if (selectedClassroomId == -1)
	{
	    request.setAttribute("noClassroom", true);
	}
	else
	{
	    ClassroomDTO selectedClassroom = classroomDAO.getEntity(selectedClassroomId);
	    if (selectedClassroom.getAvailable())
	    {
		List<ScheduledClassesDTO> scheduledClassesList = selectedClassroom.getScheduledClasses();
		List<ReservationRequestDTO> reservationRequestList = selectedClassroom.getReservation_request();

		int selectedWeek = getClassesAndDates(request, scheduledClassesList);
		filterReservations(reservationRequestList, selectedWeek);
		setReservations(reservationRequestList, request, selectedWeek);

		request.setAttribute("selectedClassroom", selectedClassroom);
		request.setAttribute("noClassroom", false);
		request.setAttribute("available", true);
	    }
	    else
	    {
		request.setAttribute("selectedClassroom", selectedClassroom);
		request.setAttribute("noClassroom", false);
		request.setAttribute("available", false);
	    }
	}

	if (request.isUserInRole("lecturer"))
	{
	    List<ClassroomDTO> classroomsToSend = classroomDAO.getLecturerClassrooms(loginBean.getPersonId());
	    Collections.sort(classroomsToSend);
	    request.setAttribute("classroomsList", classroomsToSend);

	    LecturerDAO lecturerDAO = new LecturerDAO();
	    LecturerDTO lecturerDTO = lecturerDAO.getEntity(loginBean.getPersonId());
	    request.setAttribute("subjects", lecturerDTO.getSubject());
	    request.getRequestDispatcher("lecturer/classrooms.jsp").forward(request, response);

	    lecturerDAO.closeEntityManager();
	}
	else if (request.isUserInRole("admin"))
	{
	    List<ClassroomDTO> classroomsToSend = classroomDAO.getAllEntities();
	    Collections.sort(classroomsToSend, (x, y) -> y.getFaculty().getName().compareTo(x.getFaculty().getName()));
	    request.setAttribute("classroomsList", classroomsToSend);

	    request.getRequestDispatcher("administrator/classrooms.jsp").forward(request, response);
	}

	classroomDAO.closeEntityManager();
    }

    private void filterReservations(List<ReservationRequestDTO> reservationRequestList, int selectedWeek)
    {
	Calendar calendar = Calendar.getInstance();
	calendar.setFirstDayOfWeek(Calendar.MONDAY);
	Date currentDate = calendar.getTime();
	long maxTimeDiff = 180 * 24 * 60 * 60 * 1000L; // 180 days
	for (ListIterator<ReservationRequestDTO> it = reservationRequestList.listIterator(); it.hasNext(); )
	{
	    ReservationRequestDTO reservationRequestDTO = it.next();
	    Date startDate = reservationRequestDTO.getClassesDate();
	    calendar.setTime(startDate);
	    if (reservationRequestDTO.getStatus().equals("rejected") || reservationRequestDTO.getStatus()
			    .equals("accepted"))
	    {
		it.remove();
	    }
	    else if ((Math.abs(currentDate.getTime() - startDate.getTime())) > maxTimeDiff
			    || calendar.get(Calendar.WEEK_OF_YEAR) != selectedWeek)
	    {
		if (reservationRequestDTO.getRepeatClasses().equals(0))
		{
		    it.remove();
		}
		else
		{
		    while (calendar.getTime().compareTo(reservationRequestDTO.getClassesEndDate()) < 0
				    && calendar.get(Calendar.WEEK_OF_YEAR) != selectedWeek)
		    {
			calendar.add(Calendar.DAY_OF_YEAR, 7 * reservationRequestDTO.getRepeatClasses());
		    }
		    if ((Math.abs(currentDate.getTime() - startDate.getTime())) > maxTimeDiff
				    || calendar.get(Calendar.WEEK_OF_YEAR) != selectedWeek
				    || calendar.getTime().compareTo(reservationRequestDTO.getClassesEndDate()) > 0)
		    {
			it.remove();
		    }
		}
	    }
	}
	Collections.sort(reservationRequestList, (y, x) -> x.getClassesDate().compareTo(y.getClassesDate()));
    }

    private void setReservations(List<ReservationRequestDTO> reservationRequestList, HttpServletRequest request
		    , int selectedWeek)
    {
	if (!reservationRequestList.isEmpty())
	{
	    Calendar calendar = Calendar.getInstance();
	    calendar.setFirstDayOfWeek(Calendar.MONDAY);
	    calendar.setTime(reservationRequestList.get(reservationRequestList.size() - 1).getClassesDate());
	    calendar.set(Calendar.WEEK_OF_YEAR, selectedWeek);

	    ReservationRequestDTO[][] reservations = new ReservationRequestDTO[5][8];
	    for (int i = 2; i < 7 && !reservationRequestList.isEmpty(); i++)
	    {
		calendar.set(Calendar.DAY_OF_WEEK, i);
		for (int j = 0; j < ScheduledClassesDAO.hours.size() && !reservationRequestList.isEmpty(); j++)
		{
		    calendar.set(Calendar.HOUR_OF_DAY, ScheduledClassesDAO.hours.get(j));
		    calendar.set(Calendar.MINUTE, ScheduledClassesDAO.minutes.get(j));
		    calendar.set(Calendar.SECOND, 0);

		    for (ListIterator<ReservationRequestDTO> it = reservationRequestList.listIterator(); it
				    .hasNext(); )
		    {
			ReservationRequestDTO current = it.next();
			if (current.getClassesDate().compareTo(calendar.getTime()) == 0)
			{
			    reservations[i - 2][j] = current;
			    it.remove();
			}
			else if (current.getRepeatClasses() > 0)
			{
			    Calendar calendar2 = Calendar.getInstance();
			    calendar2.setFirstDayOfWeek(Calendar.MONDAY);
			    calendar2.setTime(current.getClassesDate());

			    while (calendar2.getTime().compareTo(current.getClassesEndDate()) < 0
					    && calendar2.get(Calendar.WEEK_OF_YEAR) != selectedWeek)
			    {
				calendar2.add(Calendar.DAY_OF_YEAR, 7 * current.getRepeatClasses());
			    }
			    if (calendar2.compareTo(calendar) == 0
					    && calendar2.getTime().compareTo(current.getClassesEndDate()) <= 0)
			    {
				reservations[i - 2][j] = current;
				it.remove();
			    }
			}
		    }
		}
	    }
	    request.setAttribute("reservations", reservations);
	}
    }
}

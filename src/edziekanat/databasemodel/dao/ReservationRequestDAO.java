package edziekanat.databasemodel.dao;

import edziekanat.databasemodel.TableNames;
import edziekanat.databasemodel.dto.ClassroomDTO;
import edziekanat.databasemodel.dto.ReservationRequestDTO;
import edziekanat.databasemodel.dto.ScheduledClassesDTO;
import edziekanat.databasemodel.dto.SubjectDTO;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Marcin Muska³a on 09.05.2016.
 */
public class ReservationRequestDAO extends DAOParentClass<ReservationRequestDTO>
{
    public ReservationRequestDAO()
    {
	super(ReservationRequestDTO.class, TableNames.RESERVATION_REQUEST);
    }

    public ReservationRequestDTO getEntity(Integer id)
    {
	return entityManager.find(ReservationRequestDTO.class, id);
    }

    public List<ReservationRequestDTO> getReservationsFromSubject(Integer subjectId)
    {
	return getAllEntities().stream().filter(p -> p.getSubject().getId().equals(subjectId))
			.sorted((x, y) -> y.getRequestDate().compareTo(x.getRequestDate()))
			.collect(Collectors.toList());
    }

    public List<ReservationRequestDTO> getReservationsFromClassroom(Integer classroomId)
    {
	return getAllEntities().stream().filter(p -> p.getClassroom().getId().equals(classroomId))
			.sorted((x, y) -> y.getRequestDate().compareTo(x.getRequestDate()))
			.collect(Collectors.toList());
    }

    public List<ReservationRequestDTO> getLecturersReservations(Integer lecturerId)
    {
	return getAllEntities().stream().filter(p -> p.getSubject().getLecturer().getId().equals(lecturerId))
			.sorted((x, y) -> y.getRequestDate().compareTo(x.getRequestDate()))
			.collect(Collectors.toList());
    }

    public boolean insertNewReservation(SubjectDTO subject, ClassroomDTO classroom, Date startDate, Date endDate,
		    Integer repeat, Integer startTime)
    {
	startDate.setHours(ScheduledClassesDAO.hours.get(startTime));
	startDate.setMinutes(ScheduledClassesDAO.minutes.get(startTime));
	startDate.setSeconds(0);
	if (endDate != null && repeat > 0)
	{
	    endDate.setHours(ScheduledClassesDAO.hours.get(startTime));
	    endDate.setMinutes(ScheduledClassesDAO.minutes.get(startTime));
	    endDate.setSeconds(0);
	}

	List<ScheduledClassesDTO> scheduledClasses = classroom.getScheduledClasses();
	List<ReservationRequestDTO> reservations = classroom.getReservation_request();

	if (repeat == 0)
	{
	    if (scheduledClasses.stream().filter(s -> s.getDate().compareTo(startDate) == 0).findAny().isPresent())
	    {
		return false;
	    }
	    if (reservations.stream().filter(s -> s.getClassesDate().compareTo(startDate) == 0).findAny().isPresent())
	    {
		return false;
	    }
	}
	else
	{
	    Calendar calendar = Calendar.getInstance();
	    calendar.setFirstDayOfWeek(Calendar.MONDAY);
	    calendar.setTime(startDate);

	    do
	    {
		if (scheduledClasses.stream().filter(s -> s.getDate().compareTo(calendar.getTime()) == 0).findAny()
				.isPresent())
		{
		    return false;
		}
		if (reservations.stream().filter(s -> s.getClassesDate().compareTo(calendar.getTime()) == 0).findAny()
				.isPresent())
		{
		    return false;
		}
		calendar.add(Calendar.DAY_OF_YEAR, 7 * repeat);
	    }
	    while (calendar.getTime().compareTo(endDate) < 0);
	}

	ReservationRequestDTO newReservation = new ReservationRequestDTO();
	newReservation.setRequestDate(new Date());
	newReservation.setClassesDate(startDate);
	newReservation.setClassroom(classroom);
	newReservation.setClassesEndDate(endDate);
	newReservation.setRepeatClasses(repeat);
	newReservation.setStatus("sent");
	newReservation.setSubject(subject);
	insert(newReservation);

	return true;
    }
}

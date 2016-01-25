package edziekanat.databasemodel.dao;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import edziekanat.databasemodel.TableNames;
import edziekanat.databasemodel.dto.ClassroomDTO;
import edziekanat.databasemodel.dto.ScheduledClassesDTO;
import edziekanat.databasemodel.dto.SubjectDTO;

/**
 * Data access class used to perform operations on scheduled_classes entities.
 */
@SuppressWarnings("deprecation")
public class ScheduledClassesDAO extends DAOParentClass<ScheduledClassesDTO>
{
    final List<Integer> hours = Arrays.asList(7, 9, 11, 12, 14, 16, 18, 19);
    final List<Integer> minutes = Arrays.asList(30, 15, 0, 45, 30, 15, 0, 45);

    public ScheduledClassesDAO()
    {
	super(ScheduledClassesDTO.class, TableNames.SCHEDULED_CLASSES);
    }

    /**
     * Method getting one object of ScheduledClasses entity.
     * 
     * @param id Integer id value
     * @return ScheduledClassesDTO object
     */
    public ScheduledClassesDTO getEntity(Integer id)
    {
	return entityManager.find(ScheduledClassesDTO.class, id);
    }

    public List<ScheduledClassesDTO> getStudentsClasses(Integer studentId)
    {
	List<ScheduledClassesDTO> scheduledClasses = new LinkedList<ScheduledClassesDTO>();

	for (SubjectDTO subject : new SubjectDAO().getStudentSubjects(studentId))
	{
	    scheduledClasses.addAll(subject.getScheduledClasses());
	}

	return scheduledClasses;
    }

    public List<ScheduledClassesDTO> getLecturersClasses(Integer lecturerId)
    {
	List<ScheduledClassesDTO> scheduledClasses = new LinkedList<ScheduledClassesDTO>();

	for (SubjectDTO subject : new LecturerDAO().getEntity(lecturerId).getSubject())
	{
	    scheduledClasses.addAll(subject.getScheduledClasses());
	}

	return scheduledClasses;
    }

    public List<ScheduledClassesDTO> getStudentsGroupClasses(Integer studentsGroupId)
    {
	List<ScheduledClassesDTO> scheduledClasses = new LinkedList<ScheduledClassesDTO>();

	for (SubjectDTO subject : new StudentsGroupDAO().getEntity(studentsGroupId).getSubject())
	{
	    scheduledClasses.addAll(subject.getScheduledClasses());
	}

	return scheduledClasses;
    }

    public boolean insertNewClasses(SubjectDTO subject, ClassroomDTO classroom, Date startDate, Integer startTime)
    {
	startDate.setHours(hours.get(startTime));
	startDate.setMinutes(minutes.get(startTime));
	startDate.setSeconds(0);
	for (ScheduledClassesDTO sclasses : getAllEntities())
	{
	    if (sclasses.getDate().equals(startDate) && sclasses.getClassroom().equals(classroom))
	    {
		return false;
	    }
	}
	ScheduledClassesDTO classes = new ScheduledClassesDTO();
	classes.setClassroom(classroom);
	classes.setDate(startDate);
	classes.setDuration(90);
	classes.setSubject(subject);
	insert(classes);
	return true;
    }

    public boolean insertNewRepeatedClasses(SubjectDTO subject, ClassroomDTO classroom, Integer repeat, Date startDate,
	    Date endDate, Integer startTime)
    {
	Date newClassesDate = startDate;
	newClassesDate.setHours(hours.get(startTime));
	newClassesDate.setMinutes(minutes.get(startTime));
	newClassesDate.setSeconds(0);
	Calendar calendar = Calendar.getInstance();
	calendar.setTime(newClassesDate);

	List<ScheduledClassesDTO> allEntities = getAllEntities();
	List<ScheduledClassesDTO> newClasses = new LinkedList<ScheduledClassesDTO>();
	do
	{
	    for (ScheduledClassesDTO sclasses : allEntities)
	    {
		if (sclasses.getDate().equals(newClassesDate) && sclasses.getClassroom().equals(classroom))
		{
		    return false;
		}
	    }
	    ScheduledClassesDTO classes = new ScheduledClassesDTO();
	    classes.setClassroom(classroom);
	    classes.setDate(calendar.getTime());
	    classes.setDuration(90);
	    classes.setSubject(subject);
	    newClasses.add(classes);
	    calendar.add(Calendar.DAY_OF_MONTH, repeat * 7);
	}
	while (calendar.getTime().before(endDate));

	for (ScheduledClassesDTO sc : newClasses)
	{
	    insert(sc);
	}

	return true;
    }
}

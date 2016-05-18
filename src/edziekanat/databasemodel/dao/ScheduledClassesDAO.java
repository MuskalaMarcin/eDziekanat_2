package edziekanat.databasemodel.dao;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

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
    public static final List<Integer> hours = Arrays.asList(7, 9, 11, 12, 14, 16, 18, 19);
    public static final List<Integer> minutes = Arrays.asList(30, 15, 0, 45, 30, 15, 0, 45);

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

    /**
     * Method getting student's schedules classes
     *
     * @param studentId
     * @return
     */
    public List<ScheduledClassesDTO> getStudentsClasses(Integer studentId)
    {
	return new SubjectDAO().getStudentSubjects(studentId).stream()
			.map(subjectDTO -> subjectDTO.getScheduledClasses()).flatMap(p -> p.stream())
			.collect(Collectors.toList());
    }

    /**
     * Method getting lecturer's schedules classes
     *
     * @param lecturerId
     * @return
     */
    public List<ScheduledClassesDTO> getLecturersClasses(Integer lecturerId)
    {
	return new LecturerDAO().getEntity(lecturerId).getSubject().stream()
			.map(subjectDTO -> subjectDTO.getScheduledClasses()).flatMap(p -> p.stream())
			.collect(Collectors.toList());
    }

    /**
     * Method getting studentsgroup's schedules classes
     *
     * @param studentsGroupId
     * @return
     */
    public List<ScheduledClassesDTO> getStudentsGroupClasses(Integer studentsGroupId)
    {
	return new StudentsGroupDAO().getEntity(studentsGroupId).getSubject().stream()
			.map(subjectDTO -> subjectDTO.getScheduledClasses()).flatMap(p -> p.stream())
			.collect(Collectors.toList());
    }

    /**
     * Method inserts new schedules classes
     *
     * @param subject
     * @param classroom
     * @param startDate
     * @param startTime
     * @return
     */
    public boolean insertNewClasses(SubjectDTO subject, ClassroomDTO classroom, Date startDate, Integer startTime)
    {
	startDate.setHours(hours.get(startTime));
	startDate.setMinutes(minutes.get(startTime));
	startDate.setSeconds(0);
	for (ScheduledClassesDTO sclasses : getAllEntities())
	{
	    if (sclasses.getDate().getTime() == startDate.getTime() && sclasses.getClassroom().getId()
			    .equals(classroom.getId()))
	    {
		return false;
	    }
	}
	for (ScheduledClassesDTO sclasses : subject.getStudents_group().stream().map(s -> s.getSubject())
			.flatMap(s -> s.stream()).map(s -> s.getScheduledClasses()).flatMap(s -> s.stream())
			.collect(Collectors.toList()))
	{
	    if (sclasses.getDate().getTime() == startDate.getTime())
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

    /**
     * Method inserts repeated schedules classes
     *
     * @param subject
     * @param classroom
     * @param repeat
     * @param startDate
     * @param endDate
     * @param startTime
     * @return
     */
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
		if (sclasses.getDate().getTime() == newClassesDate.getTime() && sclasses.getClassroom().getId()
				.equals(classroom.getId()))
		{
		    return false;
		}
	    }
	    for (ScheduledClassesDTO sclasses : subject.getStudents_group().stream().map(s -> s.getSubject())
			    .flatMap(s -> s.stream()).map(s -> s.getScheduledClasses()).flatMap(s -> s.stream())
			    .collect(Collectors.toList()))
	    {
		if (sclasses.getDate().getTime() == newClassesDate.getTime())
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

	newClasses.forEach(sc -> insert(sc));

	return true;
    }
}

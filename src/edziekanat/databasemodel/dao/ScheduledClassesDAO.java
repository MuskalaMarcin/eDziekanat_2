package edziekanat.databasemodel.dao;

import java.util.LinkedList;
import java.util.List;

import edziekanat.databasemodel.TableNames;
import edziekanat.databasemodel.dto.ScheduledClassesDTO;
import edziekanat.databasemodel.dto.SubjectDTO;

/**
 * Data access class used to perform operations on scheduled_classes entities.
 */
public class ScheduledClassesDAO extends DAOParentClass<ScheduledClassesDTO>
{
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
}

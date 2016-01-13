package edziekanat.databasemodel.dao;

import edziekanat.databasemodel.TableNames;
import edziekanat.databasemodel.dto.StudentsGroupStudentDTO;

/**
 * Data access class used to perform operations on students_group_student entities.
 */
public class StudentsGroupStudentDAO extends DAOParentClass<StudentsGroupStudentDTO>
{
    public StudentsGroupStudentDAO()
    {
	super(StudentsGroupStudentDTO.class, TableNames.STUDENTS_GROUP_STUDENT);
    }

    /**
     * Method getting one object of StudentsGroupStudent entity.
     * 
     * @param id Integer id value
     * @return StudentsGroupStudentDTO object
     */
    public StudentsGroupStudentDTO getEntity(Integer id)
    {
	return entityManager.find(StudentsGroupStudentDTO.class, id);
    }
}

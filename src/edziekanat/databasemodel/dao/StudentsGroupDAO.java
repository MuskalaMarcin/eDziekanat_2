package edziekanat.databasemodel.dao;

import edziekanat.databasemodel.TableNames;
import edziekanat.databasemodel.dto.StudentsGroupDTO;

/**
 * Data access class used to perform operations on student_group entities.
 */
public class StudentsGroupDAO extends DAOParentClass<StudentsGroupDTO>
{
    public StudentsGroupDAO()
    {
	super(StudentsGroupDTO.class, TableNames.STUDENTS_GROUP);
    }

    /**
     * Method getting one object of StudentsGroup entity.
     * 
     * @param id Integer id value
     * @return StudentsGroupDTO object
     */
    public StudentsGroupDTO getEntity(Integer id)
    {
	return entityManager.find(StudentsGroupDTO.class, id);
    }
}

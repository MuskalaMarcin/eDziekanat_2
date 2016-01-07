package edziekanat.databasemodel.dao;

import edziekanat.databasemodel.dto.StudentDTO;

/**
 * Data access class used to perform operations on student entities.
 */
public class StudentDAO extends DAOParentClass<StudentDTO>
{
    /**
     * Method getting one object of student entity.
     * 
     * @param id Integer id value
     * @return StudentDTO object
     */
    public StudentDTO getEntity(Integer id)
    {
	return entityManager.find(StudentDTO.class, id);
    }
}

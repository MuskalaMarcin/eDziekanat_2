package edziekanat.databasemodel.dao;

import edziekanat.databasemodel.dto.CourseDTO;

/**
 * Data access class used to perform operations on course entities.
 */
public class CourseDAO extends DAOParentClass<CourseDTO>
{
    /**
     * Method getting one object of Course entity.
     * 
     * @param id Integer id value
     * @return CourseDTO object
     */
    public CourseDTO getEntity(Integer id)
    {
	return entityManager.find(CourseDTO.class, id);
    }
}

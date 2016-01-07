package edziekanat.databasemodel.dao;

import edziekanat.databasemodel.dto.EnrollmentDTO;

/**
 * Data access class used to perform operations on enrollment entities.
 */
public class EnrollmentDAO extends DAOParentClass<EnrollmentDTO>
{
    /**
     * Method getting one object of Enrollment entity.
     * 
     * @param id Integer id value
     * @return EnrollmentDTO object
     */
    public EnrollmentDTO getEntity(Integer id)
    {
	return entityManager.find(EnrollmentDTO.class, id);
    }
}

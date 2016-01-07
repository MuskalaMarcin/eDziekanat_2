package edziekanat.databasemodel.dao;

import edziekanat.databasemodel.dto.ApplicationDTO;

/**
 * Data access class used to perform operations on application entities.
 */
public class ApplicationDAO extends DAOParentClass<ApplicationDTO>
{
    /**
     * Method getting one object of Application entity.
     * 
     * @param id Integer id value
     * @return ApplicationDTO object
     */
    public ApplicationDTO getEntity(Integer id)
    {
	return entityManager.find(ApplicationDTO.class, id);
    }
}

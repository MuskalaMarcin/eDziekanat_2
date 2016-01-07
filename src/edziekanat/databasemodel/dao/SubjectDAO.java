package edziekanat.databasemodel.dao;

import edziekanat.databasemodel.dto.SubjectDTO;

/**
 * Data access class used to perform operations on subject entities.
 */
public class SubjectDAO extends DAOParentClass<SubjectDTO>
{
    /**
     * Method getting one object of Subject entity.
     * 
     * @param id Integer id value
     * @return SubjectDTO object
     */
    public SubjectDTO getEntity(Integer id)
    {
	return entityManager.find(SubjectDTO.class, id);
    }
}

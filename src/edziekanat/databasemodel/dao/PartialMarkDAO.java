package edziekanat.databasemodel.dao;

import edziekanat.databasemodel.dto.PartialMarkDTO;

/**
 * Data access class used to perform operations on partial_mark entities.
 */
public class PartialMarkDAO extends DAOParentClass<PartialMarkDTO>
{
    /**
     * Method getting one object of PartialMark entity.
     * 
     * @param id Integer id value
     * @return PartialMarkDTO object
     */
    public PartialMarkDTO getEntity(Integer id)
    {
	return entityManager.find(PartialMarkDTO.class, id);
    }
}

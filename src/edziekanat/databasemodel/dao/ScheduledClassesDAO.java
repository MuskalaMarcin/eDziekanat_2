package edziekanat.databasemodel.dao;

import edziekanat.databasemodel.dto.ScheduledClassesDTO;

/**
 * Data access class used to perform operations on scheduled_classes entities.
 */
public class ScheduledClassesDAO extends DAOParentClass<ScheduledClassesDTO>
{
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
}

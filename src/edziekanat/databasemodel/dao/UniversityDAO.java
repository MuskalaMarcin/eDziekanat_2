package edziekanat.databasemodel.dao;

import edziekanat.databasemodel.TableNames;
import edziekanat.databasemodel.dto.UniversityDTO;

/**
 * Data access object used to perform operations on universities.
 */
public class UniversityDAO extends DAOParentClass<UniversityDTO>
{
    public UniversityDAO()
    {
	super(UniversityDTO.class, TableNames.UNIVERSITY);
    }

    /**
     * Method getting one object of University entity.
     * 
     * @param id Integer id value
     * @return UniversityDTO object
     */
    public UniversityDTO getEntity(Integer id)
    {
	return entityManager.find(UniversityDTO.class, id);
    }
}

package edziekanat.databasemodel.dao;

import edziekanat.databasemodel.TableNames;
import edziekanat.databasemodel.dto.ScholarshipDTO;

/**
 * Data access class used to perform operations on scholarship entities.
 */
public class ScholarshipDAO extends DAOParentClass<ScholarshipDTO>
{
    public ScholarshipDAO()
    {
	super(ScholarshipDTO.class, TableNames.SCHOLARSHIP);
    }

    /**
     * Method getting one object of Scholarship entity.
     * 
     * @param id Integer id value
     * @return ScholarshipDTO object
     */
    public ScholarshipDTO getEntity(Integer id)
    {
	return entityManager.find(ScholarshipDTO.class, id);
    }
}

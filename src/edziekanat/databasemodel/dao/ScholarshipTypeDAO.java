package edziekanat.databasemodel.dao;

import edziekanat.databasemodel.TableNames;
import edziekanat.databasemodel.dto.ScholarshipTypeDTO;

/**
 * Data access class used to perform operations on scholarship_type entities.
 */
public class ScholarshipTypeDAO extends DAOParentClass<ScholarshipTypeDTO>
{
    public ScholarshipTypeDAO()
    {
	super(ScholarshipTypeDTO.class, TableNames.SCHOLARSHIP_TYPE);
    }

    /**
     * Method getting one object of ScholarshipType entity.
     * 
     * @param id Integer id value
     * @return ScholarshipTypeDTO object
     */
    public ScholarshipTypeDTO getEntity(Integer id)
    {
	return entityManager.find(ScholarshipTypeDTO.class, id);
    }
}

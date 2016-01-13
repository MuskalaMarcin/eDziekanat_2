package edziekanat.databasemodel.dao;

import edziekanat.databasemodel.TableNames;
import edziekanat.databasemodel.dto.AdministratorDTO;

/**
 * Data access class used to perform operations on administrator entities.
 */
public class AdministratorDAO extends DAOParentClass<AdministratorDTO>
{
    public AdministratorDAO()
    {
	super(AdministratorDTO.class, TableNames.ADMINISTRATOR);
    }
    
    /**
     * Method getting one object of administrator entity.
     * 
     * @param id Integer id value
     * @return AdministratorDTO object
     */
    public AdministratorDTO getEntity(Integer id)
    {
	return entityManager.find(AdministratorDTO.class, id);
    }
}

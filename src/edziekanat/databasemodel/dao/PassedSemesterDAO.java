package edziekanat.databasemodel.dao;

import edziekanat.databasemodel.TableNames;
import edziekanat.databasemodel.dto.PassedSemesterDTO;

public class PassedSemesterDAO extends DAOParentClass<PassedSemesterDTO>
{
    public PassedSemesterDAO()
    {
	super(PassedSemesterDTO.class, TableNames.PASSED_SEMESTER);
    }

    /**
     * Method getting one object of PassedSemester entity.
     *
     * @param id Integer id value
     * @return PassedSemesterDTO object
     */
    public PassedSemesterDTO getEntity(Integer id)
    {
	return entityManager.find(PassedSemesterDTO.class, id);
    }
}

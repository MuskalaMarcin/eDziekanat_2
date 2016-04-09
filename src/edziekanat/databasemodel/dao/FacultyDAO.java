package edziekanat.databasemodel.dao;

import java.util.LinkedList;
import java.util.List;

import edziekanat.databasemodel.TableNames;
import edziekanat.databasemodel.dto.FacultyDTO;

/**
 * Data access class used to perform operations on faculty entities.
 */
public class FacultyDAO extends DAOParentClass<FacultyDTO>
{
    public FacultyDAO()
    {
	super(FacultyDTO.class, TableNames.FACULTY);
    }

    /**
     * Method getting one object of Faculty entity.
     * 
     * @param id
     *            Integer id value
     * @return FacultyDTO object
     */
    public FacultyDTO getEntity(Integer id)
    {
	return entityManager.find(FacultyDTO.class, id);
    }

    /**
     * Method getting faculties by name
     * @param facultyname
     * @return
     */
    public List<FacultyDTO> getFacultyByName(String facultyname)
    {
	return getMultipleEntities("UPPER(name) LIKE '%" + facultyname.toUpperCase() + "%'");
    }
}

package edziekanat.databasemodel.dao;

import java.util.List;

import edziekanat.databasemodel.TableNames;
import edziekanat.databasemodel.dto.LecturerDTO;

/**
 * Data access class used to perform operations on lecturer entities.
 */
@SuppressWarnings("unchecked")
public class LecturerDAO extends DAOParentClass<LecturerDTO>
{
    public LecturerDAO()
    {
	super(LecturerDTO.class, TableNames.LECTURER);
    }

    /**
     * Method getting one object of Lecturer entity.
     * 
     * @param id Integer id value
     * @return LecturerDTO object
     */
    public LecturerDTO getEntity(Integer id)
    {
	return entityManager.find(LecturerDTO.class, id);
    }

    public List<LecturerDTO> getLecturersByStudentId(Integer studentId)
    {
	return entityManager.createNativeQuery("", LecturerDTO.class).getResultList();
    }
}

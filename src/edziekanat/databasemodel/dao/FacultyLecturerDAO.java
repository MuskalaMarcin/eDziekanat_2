package edziekanat.databasemodel.dao;

import edziekanat.databasemodel.dto.FacultyLecturerDTO;

/**
 * Data access class used to perform operations on faculty_lecturer entities.
 */
public class FacultyLecturerDAO extends DAOParentClass<FacultyLecturerDTO>
{
    /**
     * Method getting one object of FacultyLecturer entity.
     * 
     * @param id Integer id value
     * @return FacultyLecturerDTO object
     */
    public FacultyLecturerDTO getEntity(Integer id)
    {
	return entityManager.find(FacultyLecturerDTO.class, id);
    }
}

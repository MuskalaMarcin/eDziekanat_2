package edziekanat.databasemodel.dao;

import java.util.List;

import edziekanat.databasemodel.dto.LecturerDTO;

public class LecturerDAO extends DAOParentClass
{
    public LecturerDTO getLecturer(Integer id)
    {
	return entityManager.find(LecturerDTO.class, id);
    }

    public List<LecturerDTO> getMultipleLecturers(String whereStmnt)
    {
	return executeMultiResultQuery("SELECT l FROM LecturerDTO l WHERE l." + whereStmnt);
    }

    public List<LecturerDTO> getAllLecturers()
    {
	return executeMultiResultQuery("SELECT l FROM LecturerDTO l");
    }
}

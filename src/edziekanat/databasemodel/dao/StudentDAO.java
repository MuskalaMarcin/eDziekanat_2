package edziekanat.databasemodel.dao;

import java.util.List;

import edziekanat.databasemodel.dto.StudentDTO;

public class StudentDAO extends DAOParentClass
{
    public StudentDTO getStudent(Integer id)
    {
	return entityManager.find(StudentDTO.class, id);
    }

    public List<StudentDTO> getMultipleStudents(String whereStmnt)
    {
	return executeMultiResultQuery("SELECT s FROM StudentDTO s WHERE s." + whereStmnt);
    }

    public List<StudentDTO> getAllStudents()
    {
	return executeMultiResultQuery("SELECT s FROM StudentDTO s");
    }
}

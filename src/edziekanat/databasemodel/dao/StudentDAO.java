package edziekanat.databasemodel.dao;

import java.util.LinkedList;
import java.util.List;

import edziekanat.databasemodel.TableNames;
import edziekanat.databasemodel.dto.LecturerDTO;
import edziekanat.databasemodel.dto.StudentDTO;

/**
 * Data access class used to perform operations on student entities.
 */
public class StudentDAO extends DAOParentClass<StudentDTO>
{
    public StudentDAO()
    {
	super(StudentDTO.class, TableNames.STUDENT);
    }

    /**
     * Method getting one object of student entity.
     * 
     * @param id Integer id value
     * @return StudentDTO object
     */
    public StudentDTO getEntity(Integer id)
    {
	return entityManager.find(StudentDTO.class, id);
    }

    public List<StudentDTO> getStudentsByNameAndSurname(String name, String surname)
    {
	List<StudentDTO> students = new LinkedList<StudentDTO>();
	name = name.substring(0, 1).toUpperCase() + name.substring(1);
	surname = surname.substring(0, 1).toUpperCase() + surname.substring(1);
	students.addAll(getMultipleEntities("name = '" + name + "' and surname = '" + surname + "'"));
	return students;
    }

    public List<StudentDTO> getStudentsBySurname(String surname)
    {
	List<StudentDTO> students = new LinkedList<StudentDTO>();
	surname = surname.substring(0, 1).toUpperCase() + surname.substring(1);
	students.addAll(getMultipleEntities("surname = '" + surname + "'"));
	return students;
    }
}

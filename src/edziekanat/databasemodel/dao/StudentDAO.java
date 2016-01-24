package edziekanat.databasemodel.dao;

import java.util.LinkedList;
import java.util.List;

import edziekanat.databasemodel.TableNames;
import edziekanat.databasemodel.dto.StudentDTO;
import edziekanat.databasemodel.dto.StudentsGroupDTO;

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

    public List<StudentDTO> searchStudentsInSubject(String surname, Integer subjectId)
    {
	List<StudentDTO> students = new LinkedList<StudentDTO>();
	for (StudentsGroupDTO sg : new SubjectDAO().getEntity(subjectId).getStudents_group())
	{
	    for (StudentDTO student : sg.getStudent())
	    {
		if (student.getSurname().toLowerCase().contains(surname.toLowerCase()))
		{
		    students.add(student);
		}
	    }
	}
	return students;
    }

    public List<StudentDTO> searchStudentsInSubject(String name, String surname, Integer subjectId)
    {
	List<StudentDTO> students = new LinkedList<StudentDTO>();
	for (StudentsGroupDTO sg : new SubjectDAO().getEntity(subjectId).getStudents_group())
	{
	    for (StudentDTO student : sg.getStudent())
	    {
		if (student.getSurname().toLowerCase().contains(surname.toLowerCase())
			&& student.getName().toLowerCase().contains(name.toLowerCase()))
		{
		    students.add(student);
		}
	    }
	}
	return students;
    }
}

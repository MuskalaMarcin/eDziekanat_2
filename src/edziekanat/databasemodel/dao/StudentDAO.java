package edziekanat.databasemodel.dao;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

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

    /**
     * Method getting students by name and surname
     *
     * @param name
     * @param surname
     * @return
     */
    public List<StudentDTO> getStudentsByNameAndSurname(String name, String surname)
    {
	return getMultipleEntities("UPPER(name) like '%" + name.toUpperCase() + "%' and UPPER(surname) like '%"
			+ surname.toUpperCase() + "%'");
    }

    /**
     * Method getting students by surname
     *
     * @param surname
     * @return
     */
    public List<StudentDTO> getStudentsBySurname(String surname)
    {
	return getMultipleEntities("UPPER(surname) LIKE '%" + surname.toUpperCase() + "%'");
    }

    /**
     * Method getting students in specific students group by student's surname
     *
     * @param surname
     * @param studentGroupId
     * @return
     */
    public List<StudentDTO> searchStudentsInStudentsGroup(String surname, Integer studentGroupId)
    {
	return new StudentsGroupDAO().getEntity(studentGroupId).getStudent().stream()
			.filter(student -> student.getSurname().toLowerCase().contains(surname.toLowerCase())).collect(
					Collectors.toList());
    }

    /**
     * Method getting students in specific students group by student's name and surname
     *
     * @param name
     * @param surname
     * @param studentGroupId
     * @return
     */
    public List<StudentDTO> searchStudentsInStudentsGroup(String name, String surname, Integer studentGroupId)
    {
	return new StudentsGroupDAO().getEntity(studentGroupId).getStudent().stream()
			.filter(student -> student.getSurname().toLowerCase().contains(surname.toLowerCase())
					&& student.getName().toLowerCase().contains(name.toLowerCase()))
			.collect(Collectors.toList());
    }

    /**
     * Method getting students with specific subject by student's surname
     *
     * @param surname
     * @param subjectId
     * @return
     */
    public List<StudentDTO> searchStudentsInSubject(String surname, Integer subjectId)
    {
	return new SubjectDAO().getEntity(subjectId).getStudents_group().stream()
			.map(studentsGroupDTO -> studentsGroupDTO.getStudent()).flatMap(p -> p.stream())
			.filter(student -> student.getSurname().toLowerCase().contains(surname.toLowerCase())).collect(
					Collectors.toList());
    }

    /**
     * Method getting students in specific subject by student's name and surname
     *
     * @param name
     * @param surname
     * @param subjectId
     * @return
     */
    public List<StudentDTO> searchStudentsInSubject(String name, String surname, Integer subjectId)
    {
	return new SubjectDAO().getEntity(subjectId).getStudents_group().stream()
			.map(studentsGroupDTO -> studentsGroupDTO.getStudent()).flatMap(p -> p.stream())
			.filter(student -> student.getSurname().toLowerCase().contains(surname.toLowerCase())
					&& student.getName().toLowerCase().contains(name.toLowerCase())).collect(
					Collectors.toList());
    }
}

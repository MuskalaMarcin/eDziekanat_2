package edziekanat.databasemodel.dao;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import edziekanat.databasemodel.TableNames;
import edziekanat.databasemodel.dto.StudentsGroupDTO;
import edziekanat.databasemodel.dto.SubjectDTO;

/**
 * Data access class used to perform operations on subject entities.
 */
public class SubjectDAO extends DAOParentClass<SubjectDTO>
{
    public SubjectDAO()
    {
	super(SubjectDTO.class, TableNames.SUBJECT);
    }

    /**
     * Method getting one object of Subject entity.
     *
     * @param id Integer id value
     * @return SubjectDTO object
     */
    public SubjectDTO getEntity(Integer id)
    {
	return entityManager.find(SubjectDTO.class, id);
    }

    /**
     * Method getting all student's subjects
     *
     * @param studentId
     * @return
     */
    public List<SubjectDTO> getStudentSubjects(Integer studentId)
    {
	return new StudentDAO().getEntity(studentId).getStudentsGroup().stream()
			.map(studentsGroupDTO -> studentsGroupDTO.getSubject()).flatMap(p -> p.stream())
			.sorted((x, y) -> y.getSemester().compareTo(x.getSemester())).collect(
					Collectors.toList());
    }

    public List<SubjectDTO> getStudentsSubjectsFromSemester(Integer studentId, Integer semester)
    {
	return getStudentSubjects(studentId).stream().filter(subjectDTO -> subjectDTO.getSemester().equals(semester))
			.sorted((x, y) -> x.getName().compareTo(y.getName())).collect(
					Collectors.toList());
    }

    public List<SubjectDTO> getLecturerSubjects(Integer lecturerId)
    {
	return new LecturerDAO().getEntity(lecturerId).getSubject();
    }

    public List<SubjectDTO> getStudentAndLecturerSubjects(Integer studentId, Integer lecturerId)
    {
	return new StudentDAO().getEntity(studentId).getStudentsGroup().stream()
			.map(studentsGroupDTO -> studentsGroupDTO.getSubject()).flatMap(p -> p.stream())
			.filter(p -> p.getLecturer().getId().equals(lecturerId))
			.sorted((x, y) -> y.getSemester().compareTo(x.getSemester())).collect(
					Collectors.toList());
    }
}

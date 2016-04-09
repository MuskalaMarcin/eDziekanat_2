package edziekanat.databasemodel.dao;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import edziekanat.databasemodel.TableNames;
import edziekanat.databasemodel.dto.ClassroomDTO;
import edziekanat.databasemodel.dto.FacultyDTO;

/**
 * Data access class used to perform operations on classroom entities.
 */
public class ClassroomDAO extends DAOParentClass<ClassroomDTO>
{

    public ClassroomDAO()
    {
	super(ClassroomDTO.class, TableNames.CLASSROOM);
    }

    /**
     * Method getting one object of Classroom entity.
     *
     * @param id Integer id value
     * @return ClassroomDTO object
     */
    public ClassroomDTO getEntity(Integer id)
    {
	return entityManager.find(ClassroomDTO.class, id);
    }

    /**
     * Method getting list of classrooms by lecturerid
     *
     * @param lecturerId
     * @return
     */
    public List<ClassroomDTO> getLecturerClassrooms(Integer lecturerId)
    {
	return new LecturerDAO().getEntity(lecturerId).getFaculty().stream()
			.map(facultyDTO -> facultyDTO.getClassroom()).flatMap(classroomDTOs -> classroomDTOs.stream())
			.collect(Collectors.toList());
    }
}

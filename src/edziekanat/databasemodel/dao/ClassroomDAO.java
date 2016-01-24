package edziekanat.databasemodel.dao;

import java.util.LinkedList;
import java.util.List;

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

    public List<ClassroomDTO> getLecturerClassrooms(Integer lecturerId)
    {
	List<ClassroomDTO> classrooms = new LinkedList<ClassroomDTO>();
	for (FacultyDTO faculty : new LecturerDAO().getEntity(lecturerId).getFaculty())
	{
	    classrooms.addAll(faculty.getClassroom());
	}
	return classrooms;
    }
}

package edziekanat.databasemodel.dao;

import java.util.LinkedList;
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
     * @param id
     *            Integer id value
     * @return LecturerDTO object
     */
    public LecturerDTO getEntity(Integer id)
    {
	return entityManager.find(LecturerDTO.class, id);
    }

    /**
     * Method getting list of student's lecturers
     * @param studentId
     * @return
     */
    public List<LecturerDTO> getLecturersByStudentId(Integer studentId)
    {
	return entityManager.createNativeQuery("", LecturerDTO.class).getResultList();
    }

    /**
     * Method getting list of lecturers by surname
     * @param surname
     * @return
     */
    public List<LecturerDTO> getLecturersBySurname(String surname)
    {
	List<LecturerDTO> lecturers = new LinkedList<LecturerDTO>();
	surname = surname.toUpperCase();
	lecturers.addAll(getMultipleEntities("UPPER(surname) like '%" + surname + "%'"));
	return lecturers;
    }

    /**
     * Method getting list of lecturers by name and surname
     * @param name
     * @param surname
     * @return
     */
    public List<LecturerDTO> getLecturersByNameAndSurname(String name, String surname)
    {
	List<LecturerDTO> lecturers = new LinkedList<LecturerDTO>();
	name = name.toUpperCase();
	surname = surname.toUpperCase();
	lecturers.addAll(getMultipleEntities("UPPER(name) like '%" + name + "%' and UPPER(surname)  '%" + surname + "%'"));
	return lecturers;
    }
}

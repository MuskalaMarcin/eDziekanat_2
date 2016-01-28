package edziekanat.databasemodel.dao;

import java.util.LinkedList;
import java.util.List;

import edziekanat.databasemodel.TableNames;
import edziekanat.databasemodel.dto.CourseDTO;

/**
 * Data access class used to perform operations on course entities.
 */
public class CourseDAO extends DAOParentClass<CourseDTO>
{
    public CourseDAO()
    {
	super(CourseDTO.class, TableNames.COURSE);
    }

    /**
     * Method getting one object of Course entity.
     * 
     * @param id Integer id value
     * @return CourseDTO object
     */
    public CourseDTO getEntity(Integer id)
    {
	return entityManager.find(CourseDTO.class, id);
    }
    
    /**
     * Method getting courses by name
     * @param coursename
     * @return
     */
    public List<CourseDTO> getCourseByName(String coursename)
    {
	List<CourseDTO> courses = new LinkedList<CourseDTO>();
	coursename = coursename.toUpperCase();
	courses = getMultipleEntities("UPPER(name) LIKE '%" + coursename + "%'");
	return courses;
    }

}

package edziekanat.databasemodel.dao;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import edziekanat.databasemodel.TableNames;
import edziekanat.databasemodel.dto.CourseDTO;
import org.apache.commons.lang3.StringUtils;

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
     *
     * @param courseName
     * @return
     */
    public List<CourseDTO> getCourseByName(String courseName)
    {
	return getAllEntities().stream()
			.filter(courseDTO -> StringUtils.equalsIgnoreCase(courseDTO.getName(), courseName))
			.collect(Collectors.toList());
    }

}

package edziekanat.databasemodel.dao;

import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import edziekanat.databasemodel.TableNames;
import edziekanat.databasemodel.dto.ScholarshipDTO;

/**
 * Data access class used to perform operations on scholarship entities.
 */
public class ScholarshipDAO extends DAOParentClass<ScholarshipDTO>
{
    public ScholarshipDAO()
    {
	super(ScholarshipDTO.class, TableNames.SCHOLARSHIP);
    }

    /**
     * Method getting one object of Scholarship entity.
     * 
     * @param id Integer id value
     * @return ScholarshipDTO object
     */
    public ScholarshipDTO getEntity(Integer id)
    {
	return entityManager.find(ScholarshipDTO.class, id);
    }

    /**
     * Method getting all active student's scholarships
     * @param studentId
     * @return
     */
    public List<ScholarshipDTO> getActiveStudentScholarships(Integer studentId)
    {
	List<ScholarshipDTO> scholarships = getMultipleEntities("student_id = '" + studentId + "'");
	Date currentDate = Calendar.getInstance().getTime();
	for (int i = 0; i < scholarships.size(); i++)
	{
	    if (scholarships.get(i).getEndDate().before(currentDate))
	    {
		scholarships.remove(i);
		i--;
	    }
	}
	Collections.sort(scholarships, (x, y) -> y.getEndDate().compareTo(x.getEndDate()));
	return scholarships;
    }

    /**
     * Method getting all active scholarships by adminid
     * @param adminId
     * @return
     */
    public List<ScholarshipDTO> getAllActiveAdminScholarships(Integer adminId)
    {
	List<ScholarshipDTO> scholarships = new AdministratorDAO().getEntity(adminId).getScholarship();
	Date currentDate = Calendar.getInstance().getTime();
	for (int i = 0; i < scholarships.size(); i++)
	{
	    if (scholarships.get(i).getEndDate().before(currentDate))
	    {
		scholarships.remove(i);
		i--;
	    }
	}
	Collections.sort(scholarships, (x, y) -> y.getEndDate().compareTo(x.getEndDate()));
	return scholarships;
    }
    
    /**
     * Method getting all student's scholarships
     * @param studentId
     * @return
     */
    public List<ScholarshipDTO> getAllStudentsScholarships(Integer studentId)
    {
	return new StudentDAO().getEntity(studentId).getScholarship();
    }
}

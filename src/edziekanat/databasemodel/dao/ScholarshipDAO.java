package edziekanat.databasemodel.dao;

import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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
     *
     * @param studentId
     * @return
     */
    public List<ScholarshipDTO> getActiveStudentScholarships(Integer studentId)
    {
	Date currentDate = Calendar.getInstance().getTime();

	return new StudentDAO().getEntity(studentId).getScholarship().stream()
			.filter(scholarship -> scholarship.getEndDate().after(currentDate))
			.sorted((x, y) -> y.getEndDate().compareTo(x.getEndDate())).collect(
					Collectors.toList());
    }

    /**
     * Method getting all active scholarships by adminid
     *
     * @param adminId
     * @return
     */
    public List<ScholarshipDTO> getAllActiveAdminScholarships(Integer adminId)
    {
	Date currentDate = Calendar.getInstance().getTime();

	return new AdministratorDAO().getEntity(adminId).getScholarship().stream()
			.filter(scholarship -> scholarship.getEndDate().after(currentDate))
			.sorted((x, y) -> y.getEndDate().compareTo(x.getEndDate())).collect(
					Collectors.toList());
    }

    /**
     * Method getting all student's scholarships
     *
     * @param studentId
     * @return
     */
    public List<ScholarshipDTO> getAllStudentsScholarships(Integer studentId)
    {
	return new StudentDAO().getEntity(studentId).getScholarship();
    }
}

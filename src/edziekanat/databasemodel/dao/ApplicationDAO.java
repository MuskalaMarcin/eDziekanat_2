package edziekanat.databasemodel.dao;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import edziekanat.databasemodel.TableNames;
import edziekanat.databasemodel.dto.ApplicationDTO;

/**
 * Data access class used to perform operations on application entities.
 */
public class ApplicationDAO extends DAOParentClass<ApplicationDTO>
{
    public ApplicationDAO()
    {
	super(ApplicationDTO.class, TableNames.APPLICATION);
    }

    /**
     * Method getting one object of Application entity.
     *
     * @param id Integer id value
     * @return ApplicationDTO object
     */
    public ApplicationDTO getEntity(Integer id)
    {
	return entityManager.find(ApplicationDTO.class, id);
    }

    /**
     * Method getting waiting students applications by studentid
     *
     * @param studentId
     * @return
     */
    public List<ApplicationDTO> getWaitingApplications(Integer studentId)
    {
	return getMultipleEntities("student_id = '" + studentId + "' and status = 'Nierozpatrzony'").stream()
			.sorted((x, y) -> y.getDispatchDate().compareTo(x.getDispatchDate())).collect(
					Collectors.toList());
    }

    /**
     * Method getting all students applications
     *
     * @param studentId
     * @return
     */
    public List<ApplicationDTO> getApplications(Integer studentId)
    {
	return getMultipleEntities("student_id = '" + studentId + "' and status != 'Nierozpatrzony'").stream()
			.sorted((x, y) -> y.getDispatchDate().compareTo(x.getDispatchDate()))
			.collect(Collectors.toList());
    }

    /**
     * Method getting waiting students applications by studentid
     *
     * @param studentId
     * @return
     */
    public List<ApplicationDTO> getWaitingStudentApplications(Integer studentId)
    {
	return getMultipleEntities("student_id = '" + studentId + "' and status = 'Nierozpatrzony'").stream()
			.sorted((x, y) -> y.getDispatchDate().compareTo(x.getDispatchDate())).collect(
					Collectors.toList());
    }

    /**
     * Method getting all waiting admin applications by adminid
     *
     * @param adminId
     * @return
     */
    public List<ApplicationDTO> getAdminWaitingApplications(Integer adminId)
    {
	return getMultipleEntities("administrator_id = '" + adminId + "' and status = 'Nierozpatrzony'").stream()
			.sorted((x, y) -> y.getDispatchDate().compareTo(x.getDispatchDate())).collect(
					Collectors.toList());
    }

    /**
     * Method getting list of historial applications by adminid
     *
     * @param adminId
     * @return
     */
    public List<ApplicationDTO> getAdminHistoricalApplications(Integer adminId)
    {
	return getMultipleEntities("administrator_id = '" + adminId + "' and status != 'Nierozpatrzony'").stream()
			.sorted((x, y) -> y.getDispatchDate().compareTo(x.getDispatchDate()))
			.collect(Collectors.toList());
    }
}

package edziekanat.databasemodel.dao;

import java.util.Collections;
import java.util.List;

import edziekanat.databasemodel.TableNames;
import edziekanat.databasemodel.dto.ApplicationDTO;
import edziekanat.databasemodel.dto.PaymentDTO;

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
    
    public List<ApplicationDTO> getWaitingApplications(Integer studentId)
    {
	List<ApplicationDTO> waitingApplications = getMultipleEntities(
		"student_id = '" + studentId + "' and status = 'Nierozpatrzony'");
	Collections.sort(waitingApplications, (x, y) -> y.getDispatchDate().compareTo(x.getDispatchDate()));
	return waitingApplications;
    }
    
    public List<ApplicationDTO> getApplications(Integer studentId)
    {
	List<ApplicationDTO> getApplications = getMultipleEntities(
		"student_id = '" + studentId + "' and status = 'Odrzucony' or "
			+ "student_id = '" + studentId + "' and status = 'Przyjêty'");
	Collections.sort(getApplications, (x, y) -> y.getDispatchDate().compareTo(x.getDispatchDate()));
	return getApplications;
    }
}

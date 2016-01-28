package edziekanat.databasemodel.dao;

import edziekanat.databasemodel.TableNames;
import edziekanat.databasemodel.dto.UserDTO;

/**
 * Data access class used to perform operations on user entities.
 */
public class UserDAO extends DAOParentClass<UserDTO>
{
    public UserDAO()
    {
	super(UserDTO.class, TableNames.USER);
    }

    /**
     * Method getting one object of user entity.
     * 
     * @param login String login value
     * @return UserDTO object
     */
    public UserDTO getEntity(String login)
    {
	return entityManager.find(UserDTO.class, login);
    }
    
    /**
     * Method getting admin's user
     * @param id
     * @return
     */
    public UserDTO getAdminUser(Integer id)
    {
	return getSingleEntity("administrator_id = '" + id +"'");
    }
    
    /**
     * Method getting student's user
     * @param id
     * @return
     */
    public UserDTO getStudentUser(Integer id)
    {
	return getSingleEntity("student_id = '" + id +"'");
    }
    
    /**
     * Method getting lecturer's user
     * @param id
     * @return
     */
    public UserDTO getLecturerUser(Integer id)
    {
	return getSingleEntity("lecturer_id = '" + id +"'");
    }
}

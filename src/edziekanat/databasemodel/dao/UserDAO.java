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
    
    public UserDTO getAdminUser(Integer id)
    {
	return getSingleEntity("administrator_id = '" + id +"'");
    }
    
    public UserDTO getStudentUser(Integer id)
    {
	return getSingleEntity("student_id = '" + id +"'");
    }
    
    public UserDTO getLecturerUser(Integer id)
    {
	return getSingleEntity("lecturer_id = '" + id +"'");
    }
}

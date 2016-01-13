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

    public UserDTO getUserByLecturerId(int id)
    {
	return (UserDTO) entityManager
		.createNativeQuery("SELECT * FROM " + tableName + "WHERE lecturer_id=" + id, entityClass)
		.getSingleResult();
    }

    public UserDTO getUserByAdministratorId(int id)
    {
	return (UserDTO) entityManager
		.createNativeQuery("SELECT * FROM " + tableName + "WHERE administrator_id=" + id, entityClass)
		.getSingleResult();
    }

    public UserDTO getUserByStudentId(int id)
    {
	return (UserDTO) entityManager
		.createNativeQuery("SELECT * FROM " + tableName + "WHERE student_id=" + id, entityClass)
		.getSingleResult();
    }
}

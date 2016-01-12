package edziekanat.databasemodel.dao;

import edziekanat.databasemodel.TableNames;
import edziekanat.databasemodel.dto.UserDTO;

/**
 * Data access class used to perform operations on user entities.
 */
public class UserDAO extends DAOParentClass<UserDTO>
{
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
		.createNativeQuery("SELECT * FROM " + TableNames.USER + "WHERE lecturer_id=" + id, UserDTO.class)
		.getSingleResult();
    }

    public UserDTO getUserByAdministratorId(int id)
    {
	return (UserDTO) entityManager
		.createNativeQuery("SELECT * FROM " + TableNames.USER + "WHERE administrator_id=" + id, UserDTO.class)
		.getSingleResult();
    }

    public UserDTO getUserByStudentId(int id)
    {
	return (UserDTO) entityManager
		.createNativeQuery("SELECT * FROM " + TableNames.USER + "WHERE student_id=" + id, UserDTO.class)
		.getSingleResult();
    }
}

package edziekanat.databasemodel.dao;

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
}

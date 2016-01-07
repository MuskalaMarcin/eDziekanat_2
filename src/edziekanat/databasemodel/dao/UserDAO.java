package edziekanat.databasemodel.dao;

import java.util.List;

import edziekanat.databasemodel.dto.UserDTO;

/**
 * Data access object used to perform operations on users.
 */
public class UserDAO extends DAOParentClass
{
    public UserDTO getUser(String login)
    {
	return entityManager.find(UserDTO.class, login);
    }

    public List<UserDTO> getMultipleUsers(String whereStmnt)
    {
	return executeMultiResultQuery("SELECT u FROM UserDTO u WHERE u." + whereStmnt);
    }

    public List<UserDTO> getAllUsers()
    {
	return executeMultiResultQuery("SELECT u FROM UserDTO u");
    }

    public long getNumberOfAllUsers()
    {
	return getNumberOfEntities("users");
    }
}

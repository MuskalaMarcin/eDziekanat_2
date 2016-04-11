package edziekanat.databasemodel.dao;

import edziekanat.databasemodel.TableNames;
import edziekanat.databasemodel.dto.UserDTO;

import java.util.NoSuchElementException;

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
     *
     * @param id
     * @return
     */
    public UserDTO getAdminUser(Integer id)
    {
	return getSingleEntity("administrator_id = '" + id + "'");
    }

    /**
     * Method getting student's user
     *
     * @param id
     * @return
     */
    public UserDTO getStudentUser(Integer id)
    {
	return getSingleEntity("student_id = '" + id + "'");
    }

    /**
     * Method getting lecturer's user
     *
     * @param id
     * @return
     */
    public UserDTO getLecturerUser(Integer id)
    {
	return getSingleEntity("lecturer_id = '" + id + "'");
    }

    /**
     * Method returning user searched by login or if not found by email adress
     *
     * @param loginEMail user's login or email
     * @return UserDTO object
     */
    public UserDTO getUserByLoginOrEmail(String loginEMail)
    {
	UserDTO user = getEntity(loginEMail);
	if (user == null)
	{
	    try
	    {
		user = getAllEntities().stream().filter(userDTO -> userDTO.geteMail().equals(loginEMail)).findAny()
				.get();
	    }
	    catch (NoSuchElementException e)
	    {
		return null;
	    }
	}
	return user;
    }
}

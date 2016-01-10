package edziekanat.databasemodel.dao;

import java.util.List;

import edziekanat.databasemodel.TableNames;
import edziekanat.databasemodel.dto.MessageDTO;

/**
 * Data access class used to perform operations on message entities.
 */
@SuppressWarnings("unchecked")
public class MessageDAO extends DAOParentClass<MessageDTO>
{
    /**
     * Method getting one object of Message entity.
     * 
     * @param id Integer id value
     * @return MessageDTO object
     */
    public MessageDTO getEntity(Integer id)
    {
	return entityManager.find(MessageDTO.class, id);
    }

    public List<MessageDTO> getUserMessages(String login)
    {
	return entityManager.createNativeQuery("SELECT * FROM " + TableNames.MESSAGE +
		" WHERE login = " + login, MessageDTO.class).getResultList();
    }
}

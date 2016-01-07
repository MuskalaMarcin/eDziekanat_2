package edziekanat.databasemodel.dao;

import edziekanat.databasemodel.dto.MessageDTO;

/**
 * Data access class used to perform operations on message entities.
 */
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
}

package edziekanat.databasemodel.dao;

import edziekanat.databasemodel.TableNames;
import edziekanat.databasemodel.dto.MessageDTO;

import java.util.List;

/**
 * Data access class used to perform operations on message entities.
 */
public class MessageDAO extends DAOParentClass<MessageDTO>
{
    public MessageDAO()
    {
	super(MessageDTO.class, TableNames.MESSAGE);
    }

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

    @Override
    public List<MessageDTO> getMultipleEntities(String whereStmnt)
    {
        return executeMultiResultQuery("SELECT * FROM " + tableName + " WHERE " + whereStmnt +" ORDER BY id ASC");
    }
}

package edziekanat.databasemodel.dao;

import edziekanat.databasemodel.TableNames;
import edziekanat.databasemodel.dto.PartialMarkDTO;
import edziekanat.databasemodel.dto.PasswordResetDTO;

/**
 * Created by mumar on 10.04.2016.
 */
public class PasswordResetDAO extends DAOParentClass<PasswordResetDTO>
{
    public PasswordResetDAO()
    {
	super(PasswordResetDTO.class, TableNames.PASSWORD_RESET);
    }

    /**
     * Method getting one object of Password reset entity.
     *
     * @param id String id value
     * @return PasswordResetDTO object
     */
    public PasswordResetDTO getEntity(String id)
    {
	return entityManager.find(PasswordResetDTO.class, id);
    }
}

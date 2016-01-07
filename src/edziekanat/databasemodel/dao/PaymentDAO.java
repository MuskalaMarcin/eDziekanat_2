package edziekanat.databasemodel.dao;

import edziekanat.databasemodel.dto.PaymentDTO;

/**
 * Data access class used to perform operations on payment entities.
 */
public class PaymentDAO extends DAOParentClass<PaymentDTO>
{
    /**
     * Method getting one object of Payment entity.
     * 
     * @param id Integer id value
     * @return PaymentDTO object
     */
    public PaymentDTO getEntity(Integer id)
    {
	return entityManager.find(PaymentDTO.class, id);
    }
}

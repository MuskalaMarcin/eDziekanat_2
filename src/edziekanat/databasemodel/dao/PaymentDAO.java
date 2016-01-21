package edziekanat.databasemodel.dao;

import java.util.Collections;
import java.util.List;

import edziekanat.databasemodel.TableNames;
import edziekanat.databasemodel.dto.PaymentDTO;

/**
 * Data access class used to perform operations on payment entities.
 */
public class PaymentDAO extends DAOParentClass<PaymentDTO>
{
    public PaymentDAO()
    {
	super(PaymentDTO.class, TableNames.PAYMENT);
    }

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

    public List<PaymentDTO> getAllStudentPayments(Integer studentId)
    {
	return getMultipleEntities("student_id = '" + studentId + "'");
    }

    public List<PaymentDTO> getWaitingPayments(Integer studentId)
    {
	List<PaymentDTO> waitingPayments = getMultipleEntities(
		"student_id = '" + studentId + "' and payment_date is null");
	Collections.sort(waitingPayments, (x, y) -> y.getIssueDate().compareTo(x.getIssueDate()));
	return waitingPayments;
    }

    public List<PaymentDTO> getPaymentsHistory(Integer studentId)
    {
	List<PaymentDTO> historyPayments = getMultipleEntities(
		"student_id = '" + studentId + "' and payment_date is not null");
	Collections.sort(historyPayments, (x, y) -> y.getPaymentDate().compareTo(x.getPaymentDate()));
	return historyPayments;
    }
}

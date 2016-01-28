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

    /**
     * Method getting all student's payments
     * @param studentId
     * @return
     */
    public List<PaymentDTO> getAllStudentPayments(Integer studentId)
    {
	return getMultipleEntities("student_id = '" + studentId + "'");
    }

    /**
     * Method getting all waiting student's payments
     * @param studentId
     * @return
     */
    public List<PaymentDTO> getWaitingPayments(Integer studentId)
    {
	List<PaymentDTO> waitingPayments = getMultipleEntities(
		"student_id = '" + studentId + "' and payment_date is null");
	Collections.sort(waitingPayments, (x, y) -> y.getIssueDate().compareTo(x.getIssueDate()));
	return waitingPayments;
    }

    /**
     * Method getting student's payment history
     * @param studentId
     * @return
     */
    public List<PaymentDTO> getPaymentsHistory(Integer studentId)
    {
	List<PaymentDTO> historyPayments = getMultipleEntities(
		"student_id = '" + studentId + "' and payment_date is not null");
	Collections.sort(historyPayments, (x, y) -> y.getPaymentDate().compareTo(x.getPaymentDate()));
	return historyPayments;
    }

    /**
     * Method getting admin's waiting payments
     * @param adminId
     * @return
     */
    public List<PaymentDTO> getWaitingAdminPayments(Integer adminId)
    {
	List<PaymentDTO> waitingPayments = getMultipleEntities(
		"administrator_id = '" + adminId + "' and payment_date is null");
	Collections.sort(waitingPayments, (x, y) -> y.getIssueDate().compareTo(x.getIssueDate()));
	return waitingPayments;
    }

    /**
     * Method getting payments history by adminid
     * @param adminId
     * @return
     */
    public List<PaymentDTO> getAdminPaymentsHistory(Integer adminId)
    {
	List<PaymentDTO> historyPayments = getMultipleEntities(
		"administrator_id = '" + adminId + "' and payment_date is not null");
	Collections.sort(historyPayments, (x, y) -> y.getPaymentDate().compareTo(x.getPaymentDate()));
	return historyPayments;
    }
}

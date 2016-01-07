package edziekanat.databasemodel.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import edziekanat.databasemodel.TableNames;

@Entity
@Table(name = TableNames.PAYMENT)
public class PaymentDTO implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "amount")
    private float amount;
    @Temporal(TemporalType.DATE)
    @Column(name = "issue_date")
    private Date issueDate;
    @Temporal(TemporalType.DATE)
    @Column(name = "payment_date")
    private Date paymentDate;
    @Column(name = "student_id")
    private Integer studentId;
    @Column(name = "administrator_id")
    private Integer administratorId;

    public Integer getId()
    {
	return id;
    }

    public void setId(Integer id)
    {
	this.id = id;
    }

    public String getTitle()
    {
	return title;
    }

    public void setTitle(String title)
    {
	this.title = title;
    }

    public String getDescription()
    {
	return description;
    }

    public void setDescription(String description)
    {
	this.description = description;
    }

    public float getAmount()
    {
	return amount;
    }

    public void setAmount(float amount)
    {
	this.amount = amount;
    }

    public Date getIssueDate()
    {
	return issueDate;
    }

    public void setIssueDate(Date issueDate)
    {
	this.issueDate = issueDate;
    }

    public Date getPaymentDate()
    {
	return paymentDate;
    }

    public void setPaymentDate(Date paymentDate)
    {
	this.paymentDate = paymentDate;
    }

    public Integer getStudentId()
    {
	return studentId;
    }

    public void setStudentId(Integer studentId)
    {
	this.studentId = studentId;
    }

    public Integer getAdministratorId()
    {
	return administratorId;
    }

    public void setAdministratorId(Integer administratorId)
    {
	this.administratorId = administratorId;
    }
}

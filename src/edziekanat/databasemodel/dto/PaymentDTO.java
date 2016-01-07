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

    public Date getIssue_date()
    {
	return issueDate;
    }

    public void setIssue_date(Date issue_date)
    {
	this.issueDate = issue_date;
    }

    public Date getPayment_date()
    {
	return paymentDate;
    }

    public void setPayment_date(Date payment_date)
    {
	this.paymentDate = payment_date;
    }

    public Integer getStudent_id()
    {
	return studentId;
    }

    public void setStudent_id(Integer student_id)
    {
	this.studentId = student_id;
    }

    public Integer getAdministrator_id()
    {
	return administratorId;
    }

    public void setAdministrator_id(Integer administrator_id)
    {
	this.administratorId = administrator_id;
    }
}

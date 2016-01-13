package edziekanat.databasemodel.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="payment_id_seq")
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
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private StudentDTO student;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "administrator_id")
    private AdministratorDTO administrator;

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

    public StudentDTO getStudent()
    {
        return student;
    }

    public void setStudent(StudentDTO student)
    {
        this.student = student;
    }

    public AdministratorDTO getAdministrator()
    {
        return administrator;
    }

    public void setAdministrator(AdministratorDTO administrator)
    {
        this.administrator = administrator;
    }
}

package edziekanat.databasemodel.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "payment")
public class PaymentDTO
{
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
    private Date issue_date;
    @Temporal(TemporalType.DATE)
    @Column(name = "payment_date")
    private Date payment_date;
    @Column(name = "student_id")
    private Integer student_id;
    @Column(name = "administrator_id")
    private Integer administrator_id;
    
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
        return issue_date;
    }
    public void setIssue_date(Date issue_date)
    {
        this.issue_date = issue_date;
    }
    public Date getPayment_date()
    {
        return payment_date;
    }
    public void setPayment_date(Date payment_date)
    {
        this.payment_date = payment_date;
    }
    public Integer getStudent_id()
    {
        return student_id;
    }
    public void setStudent_id(Integer student_id)
    {
        this.student_id = student_id;
    }
    public Integer getAdministrator_id()
    {
        return administrator_id;
    }
    public void setAdministrator_id(Integer administrator_id)
    {
        this.administrator_id = administrator_id;
    }
}

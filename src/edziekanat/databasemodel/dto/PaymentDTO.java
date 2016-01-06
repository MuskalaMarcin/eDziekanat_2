package edziekanat.databasemodel.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="payment")
public class PaymentDTO {
	@Id
    @Column(name="id")
	private Integer id;
	@Column(name="title")
	private String title;
	@Column(name="description")
	private String description;
	@Column(name="amount")
	private float amount;
	@Column(name="issue_date")
	private Date issue_date;
	@Column(name="payment_date")
	private Date payment_date;
	@Column(name="student_id")
	private Integer student_id;
	@Column(name="administrator_id")
	private Integer administrator_id;
	
	public PaymentDTO(Integer id, String title, String description, float amount, Date issue_date, Date payment_date,
			Integer student_id, Integer administrator_id) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.amount = amount;
		this.issue_date = issue_date;
		this.payment_date = payment_date;
		this.student_id = student_id;
		this.administrator_id = administrator_id;
	}

}

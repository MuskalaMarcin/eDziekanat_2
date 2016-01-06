package edziekanat.databasemodel.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="schollarship_type")
public class Scholarship_TypeDTO {
	@Id
    @Column(name="id")
	private String type;
	@Column(name="requirements")
	private String requirements;
	@Column(name="amount")
	private Float amount;
	
	public Scholarship_TypeDTO(String type, String requirements, Float amount) {
		this.type = type;
		this.requirements = requirements;
		this.amount = amount;
	}

}

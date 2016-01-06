package edziekanat.databasemodel.dto;

import java.io.File;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="learning_materials")
public class Learning_MaterialsDTO {
	@Id
    @Column(name="id")
	private Integer id;
	@Column(name="name")
	private String name;
	@Column(name="description")
	private String description;
	@Column(name="file")
	private File file;
	@Column(name="subject_id")
	private Integer subject_id;
	
	public Learning_MaterialsDTO(Integer id, String name, String description, File file, Integer subject_id) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.file = file;
		this.subject_id = subject_id;
	}

}

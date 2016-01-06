package edziekanat.databasemodel.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="message")
public class MessageDTO {
	@Id
    @Column(name="id")
	private Integer id;
    @Column(name="title")
	private String title;
    @Column(name="content")
	private String content;
    @Column(name="dispatch_date")
    private Date dispatch_date;
    @Column(name="receive_date")
    private Date receive_date;
    @Column(name="sender_id")
    private String sender_id;
    @Column(name="receiver_id")
    private String receiver_id;
	
	public MessageDTO(Integer id, String title, String content, Date dispatch_date, Date receive_date, String sender_id,
			String receiver_id) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.dispatch_date = dispatch_date;
		this.receive_date = receive_date;
		this.sender_id = sender_id;
		this.receiver_id = receiver_id;
	}

}

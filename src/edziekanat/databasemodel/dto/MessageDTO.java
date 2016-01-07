package edziekanat.databasemodel.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "message")
public class MessageDTO
{
    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "title")
    private String title;
    @Column(name = "content")
    private String content;
    @Temporal(TemporalType.DATE)
    @Column(name = "dispatch_date")
    private Date dispatch_date;
    @Temporal(TemporalType.DATE)
    @Column(name = "receive_date")
    private Date receive_date;
    @Column(name = "sender_id")
    private String sender_id;
    @Column(name = "receiver_id")
    private String receiver_id;

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

    public String getContent()
    {
	return content;
    }

    public void setContent(String content)
    {
	this.content = content;
    }

    public Date getDispatch_date()
    {
	return dispatch_date;
    }

    public void setDispatch_date(Date dispatch_date)
    {
	this.dispatch_date = dispatch_date;
    }

    public Date getReceive_date()
    {
	return receive_date;
    }

    public void setReceive_date(Date receive_date)
    {
	this.receive_date = receive_date;
    }

    public String getSender_id()
    {
	return sender_id;
    }

    public void setSender_id(String sender_id)
    {
	this.sender_id = sender_id;
    }

    public String getReceiver_id()
    {
	return receiver_id;
    }

    public void setReceiver_id(String receiver_id)
    {
	this.receiver_id = receiver_id;
    }
}

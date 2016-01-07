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
@Table(name = TableNames.MESSAGE)
public class MessageDTO implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "title")
    private String title;
    @Column(name = "content")
    private String content;
    @Temporal(TemporalType.DATE)
    @Column(name = "dispatch_date")
    private Date dispatchDate;
    @Temporal(TemporalType.DATE)
    @Column(name = "receive_date")
    private Date receiveDate;
    @Column(name = "sender_id")
    private String senderId;
    @Column(name = "receiver_id")
    private String receiverId;

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
	return dispatchDate;
    }

    public void setDispatch_date(Date dispatch_date)
    {
	this.dispatchDate = dispatch_date;
    }

    public Date getReceive_date()
    {
	return receiveDate;
    }

    public void setReceive_date(Date receive_date)
    {
	this.receiveDate = receive_date;
    }

    public String getSender_id()
    {
	return senderId;
    }

    public void setSender_id(String sender_id)
    {
	this.senderId = sender_id;
    }

    public String getReceiver_id()
    {
	return receiverId;
    }

    public void setReceiver_id(String receiver_id)
    {
	this.receiverId = receiver_id;
    }
}

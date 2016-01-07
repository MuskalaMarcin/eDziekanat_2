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

    public Date getDispatchDate()
    {
	return dispatchDate;
    }

    public void setDispatchDate(Date dispatchDate)
    {
	this.dispatchDate = dispatchDate;
    }

    public Date getReceiveDate()
    {
	return receiveDate;
    }

    public void setReceiveDate(Date receiveDate)
    {
	this.receiveDate = receiveDate;
    }

    public String getSenderId()
    {
	return senderId;
    }

    public void setSenderId(String senderId)
    {
	this.senderId = senderId;
    }

    public String getReceiverId()
    {
	return receiverId;
    }

    public void setReceiverId(String receiverId)
    {
	this.receiverId = receiverId;
    }
}

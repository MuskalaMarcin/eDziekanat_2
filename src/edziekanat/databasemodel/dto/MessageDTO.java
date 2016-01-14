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
import javax.persistence.SequenceGenerator;
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
    @SequenceGenerator(name="MESSAGESEQ",sequenceName="message_id_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.AUTO, generator="MESSAGESEQ")
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
    @ManyToOne(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @JoinColumn(name = "sender_id")
    private UserDTO sender;
    @ManyToOne(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @JoinColumn(name = "receiver_id")
    private UserDTO receiver;

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

    public UserDTO getSender()
    {
        return sender;
    }

    public void setSender(UserDTO sender)
    {
        this.sender = sender;
    }

    public UserDTO getReceiver()
    {
        return receiver;
    }

    public void setReceiver(UserDTO receiver)
    {
        this.receiver = receiver;
    }
}

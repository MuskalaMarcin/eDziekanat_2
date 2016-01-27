package test.java.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import edziekanat.databasemodel.dto.MessageDTO;
import edziekanat.databasemodel.dto.UserDTO;

public class MessageDTOTest
{
    MessageDTO mess;

    @Before
    public void setUp()
    {
	this.mess = new MessageDTO();
    }

    @Test
    public void testGetId()
    {
	mess.setId(1);
	final int id = mess.getId();
	assertEquals("Z³e ID!", 1, id);
    }

    @Test
    public void testSetId()
    {
	mess.setId(1);
	final int id = mess.getId();
	assertEquals("Z³e ID!", 1, id);
    }

    @Test
    public void testGetTitle()
    {
	mess.setTitle("foo");
	final String title = mess.getTitle();
	assertEquals("foo", title);
    }

    @Test
    public void testSetTitle()
    {
	mess.setTitle("foo");
	final String title = mess.getTitle();
	assertEquals("foo", title);
    }

    @Test
    public void testGetContent()
    {
	mess.setContent("foo");
	final String content = mess.getContent();
	assertEquals("foo", content);
    }

    @Test
    public void testSetContent()
    {
	mess.setContent("foo");
	final String content = mess.getContent();
	assertEquals("foo", content);
    }

    @Test
    public void testGetDispatchDate()
    {
	Date date = new Date();
	mess.setDispatchDate(date);
	final Date datetested = mess.getDispatchDate();
	assertEquals(date, datetested);
    }

    @Test
    public void testSetDispatchDate()
    {
	Date date = new Date();
	mess.setDispatchDate(date);
	final Date datetested = mess.getDispatchDate();
	assertEquals(date, datetested);
    }

    @Test
    public void testGetReceiveDate()
    {
	Date date = new Date();
	mess.setReceiveDate(date);
	final Date datetested = mess.getReceiveDate();
	assertEquals(date, datetested);
    }

    @Test
    public void testSetReceiveDate()
    {
	Date date = new Date();
	mess.setReceiveDate(date);
	final Date datetested = mess.getReceiveDate();
	assertEquals(date, datetested);
    }

    @Test
    public void testGetSender()
    {
	UserDTO us = new UserDTO();
	mess.setSender(us);
	UserDTO tested = mess.getSender();
	assertEquals(us, tested);
    }

    @Test
    public void testSetSender()
    {
	UserDTO us = new UserDTO();
	mess.setSender(us);
	UserDTO tested = mess.getSender();
	assertEquals(us, tested);
    }

    @Test
    public void testGetReceiver()
    {
	UserDTO us = new UserDTO();
	mess.setReceiver(us);
	UserDTO tested = mess.getReceiver();
	assertEquals(us, tested);
    }

    @Test
    public void testSetReceiver()
    {
	UserDTO us = new UserDTO();
	mess.setReceiver(us);
	UserDTO tested = mess.getReceiver();
	assertEquals(us, tested);
    }

}

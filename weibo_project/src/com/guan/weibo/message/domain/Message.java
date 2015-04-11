package com.guan.weibo.message.domain;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.guan.weibo.user.domain.User;

@Entity(name="message")
public class Message {
	
	@Id
	@Column(name="m_id",length=32)
	private String m_id;
	
	@Column(name="m_title",length=50)
	private String m_title;
	
	@Column(name="m_content",length=5000)
	private String m_content;
	
	@Column(name="m_http",length=150)
	private String	m_http;
	
	@Column(name="m_fav",length=11)
	private Integer m_fav;
	
	@Column(name="m_reply",length=11)
	private Integer m_reply;
	
	@Column(name="m_copy",length=11)
	private Integer m_copy;
	
	@Column(name="m_datetime")
	private Timestamp m_datetime;

	@ManyToOne(cascade={CascadeType.ALL},fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User user;
	
	@ManyToOne(cascade={CascadeType.ALL},fetch=FetchType.LAZY)
	@JoinColumn(name="t_id")
	private MessageTitle messageTitle;
	
	@OneToOne(mappedBy="message")
	private Copy copy;
	
	
	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	
	
	public String getM_title() {
		return m_title;
	}

	public void setM_title(String m_title) {
		this.m_title = m_title;
	}
	
	
	public String getM_content() {
		return m_content;
	}

	public void setM_content(String m_content) {
		this.m_content = m_content;
	}


	public String getM_http() {
		return m_http;
	}

	public void setM_http(String m_http) {
		this.m_http = m_http;
	}

	public Integer getM_fav() {
		return m_fav;
	}

	public void setM_fav(Integer m_fav) {
		this.m_fav = m_fav;
	}

	public Integer getM_reply() {
		return m_reply;
	}

	public void setM_reply(Integer m_reply) {
		this.m_reply = m_reply;
	}

	
	public Integer getM_copy() {
		return m_copy;
	}

	public void setM_copy(Integer m_copy) {
		this.m_copy = m_copy;
	}

	
	public Timestamp getM_datetime() {
		return m_datetime;
	}

	public void setM_datetime(Timestamp m_datetime) {
		this.m_datetime = m_datetime;
	}

	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
	public MessageTitle getMessageTitle() {
		return messageTitle;
	}

	public void setMessageTitle(MessageTitle messageTitle) {
		this.messageTitle = messageTitle;
	}

	public Copy getCopy() {
		return copy;
	}

	public void setCopy(Copy copy) {
		this.copy = copy;
	}

	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}

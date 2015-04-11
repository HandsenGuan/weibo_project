package com.guan.weibo.message.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.guan.weibo.user.domain.User;

@Entity(name="copy")
public class Copy {
	
	@Id
	@Column(name="c_id",length=32)
	private String c_id;
	
	@OneToOne
	private Message message;
	
	@OneToOne
	private User user;
	
	public String getC_id() {
		return c_id;
	}

	public void setC_id(String c_id) {
		this.c_id = c_id;
	}
	
	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Copy() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	
	
	
	
}

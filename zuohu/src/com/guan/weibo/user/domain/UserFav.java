package com.guan.weibo.user.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

import com.guan.weibo.message.domain.Message;

@Entity(name="user_fav")
public class UserFav implements Serializable{

	private static final long serialVersionUID = -421436187695802752L;

	public UserFav() {
		super();
	}

	//用户关注消息表
	@Id
	@GeneratedValue(generator = "ud")
	@GenericGenerator(name = "ud", strategy = "uuid")
	private String fav_id;
	
	//用户
	@ManyToOne
	@JoinColumn(name="u_id")
	private User user;
	
	//用户关注的消息
	@ManyToOne
	@JoinColumn(name="m_id")
	private Message message;
	

	public String getFav_id() {
		return fav_id;
	}

	public void setFav_id(String fav_id) {
		this.fav_id = fav_id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "UserFav [fav_id=" + fav_id + ", user=" + user + ", message="
				+ message + "]";
	}

}

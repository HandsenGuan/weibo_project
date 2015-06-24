package com.guan.weibo.user.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity(name="user_follow")
public class UserFollow implements Serializable{
	
	private static final long serialVersionUID = 5541554046996965639L;

	public UserFollow() {
		super();
	}

	//用户关注表主键
	@Id
	@GeneratedValue(generator = "ud")
	@GenericGenerator(name = "ud", strategy = "uuid")
	private String f_id;
	
	//用户
	@ManyToOne()
	@JoinColumn(name="u_id")
	private User user;
	
	//用户关注对象
	@ManyToOne
	@JoinColumn(name="fu_id")
	private User fuser;

	public String getF_id() {
		return f_id;
	}

	public void setF_id(String f_id) {
		this.f_id = f_id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getFuser() {
		return fuser;
	}

	public void setFuser(User fuser) {
		this.fuser = fuser;
	}

	@Override
	public String toString() {
		return "UserFollow [f_id=" + f_id + ", user=" + user + ", fuser="
				+ fuser + "]";
	}
	
}

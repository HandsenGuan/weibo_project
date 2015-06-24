package com.guan.weibo.user.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

@Entity(name="group_user")
public class GroupUser implements Serializable{

	private static final long serialVersionUID = 9186795208699318541L;

	public GroupUser() {
		super();
	}
	
	//群-用户表的主键
	@Id
	@GeneratedValue(generator = "ud")
	@GenericGenerator(name = "ud", strategy = "uuid")
	private String gu_id;
	
	@ManyToOne
	@JoinColumn(name="u_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="g_id")
	private Group group;
	
	@Column(name="level")
	private int level;

	public String getGu_id() {
		return gu_id;
	}

	public void setGu_id(String gu_id) {
		this.gu_id = gu_id;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	@Override
	public String toString() {
		return "GroupUser [gu_id=" + gu_id + ", user=" + user + ", group="
				+ group + ", level=" + level + "]";
	}
	
}

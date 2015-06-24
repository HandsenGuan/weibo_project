package com.guan.weibo.user.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

@Entity(name="groups")
public class Group implements Serializable{
	
	private static final long serialVersionUID = 6176061879440300783L;

	public Group() {
		super();
	}

	//群表主键
	@Id
	@GeneratedValue(generator = "ud")
	@GenericGenerator(name = "ud", strategy = "uuid")
	private String g_id;
	
	//群名
	@Column(name="g_name")
	private String g_name;

	//群描述
	@Column(name="g_desc")
	private String g_desc;
	
	//group-user表
	@OneToMany(fetch=FetchType.EAGER,mappedBy="group")
	private Set<GroupUser> users;
	
	
	public String getG_name() {
		return g_name;
	}

	public void setG_name(String g_name) {
		this.g_name = g_name;
	}

	public String getG_desc() {
		return g_desc;
	}

	public void setG_desc(String g_desc) {
		this.g_desc = g_desc;
	}

	public String getG_id() {
		return g_id;
	}

	public void setG_id(String g_id) {
		this.g_id = g_id;
	}

	public Set<GroupUser> getUsers() {
		return users;
	}

	public void setUsers(Set<GroupUser> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "Group [g_id=" + g_id + ", g_name=" + g_name + ", g_desc="
				+ g_desc + "]";
	}

}

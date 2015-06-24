package com.guan.weibo.message.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

import com.guan.weibo.user.domain.UserFav;

@Entity(name = "label")
public class Label implements Serializable{

	private static final long serialVersionUID = 9073804931646226376L;

	// 标签表主键（uuid）
	@Id
	@GeneratedValue(generator = "ud")
	@GenericGenerator(name = "ud", strategy = "uuid")
	private String l_id;
	
	//标签名
	@Column(name="name")
	private String name;
	
	//使用该标签的次数
	@Column(name="num")
	private int num;
	
	//使用该标签的多个状态
	@OneToMany(mappedBy="label")
	private Set<MessageLabel> messages;

	public String getL_id() {
		return l_id;
	}

	public void setL_id(String l_id) {
		this.l_id = l_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public Set<MessageLabel> getMessages() {
		return messages;
	}

	public void setMessages(Set<MessageLabel> messages) {
		this.messages = messages;
	}

	public Label() {
		super();
	}
	
}

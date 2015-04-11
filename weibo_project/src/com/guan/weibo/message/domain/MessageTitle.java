package com.guan.weibo.message.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity(name = "message_title")
public class MessageTitle {

	@Id
	@Column(name = "t_id", length = 32)
	private String t_id;

	@Column(name = "t_num", length = 11)
	private Integer t_num;

	@Column(name = "t_name", length = 20)
	private String t_name;

	@Column(name = "t_content", length = 1000)
	private String t_content;

	// 消息
	@OneToMany(mappedBy = "user")
	@LazyCollection(LazyCollectionOption.EXTRA)
	private Set<Message> messages;

	
	public Set<Message> getMessages() {
		return messages;
	}

	public void setMessages(Set<Message> messages) {
		this.messages = messages;
	}

	public String getT_id() {
		return t_id;
	}

	public void setT_id(String t_id) {
		this.t_id = t_id;
	}

	public Integer getT_num() {
		return t_num;
	}

	public void setT_num(Integer t_num) {
		this.t_num = t_num;
	}

	public String getT_name() {
		return t_name;
	}

	public void setT_name(String t_name) {
		this.t_name = t_name;
	}

	public String getT_content() {
		return t_content;
	}

	public void setT_content(String t_content) {
		this.t_content = t_content;
	}

}

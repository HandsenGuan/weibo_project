package com.guan.weibo.message.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity(name = "message_label")
public class MessageLabel implements Serializable{

	private static final long serialVersionUID = 7611563777144316246L;

	// 消息-标签表主键（uuid）
	@Id
	@GeneratedValue(generator = "ud")
	@GenericGenerator(name = "ud", strategy = "uuid")
	private String ml_id;
	
	@ManyToOne
	@JoinColumn(name="m_id")
	private Message message;

	@ManyToOne
	@JoinColumn(name="l_id")
	private Label label;

	public String getMl_id() {
		return ml_id;
	}

	public void setMl_id(String ml_id) {
		this.ml_id = ml_id;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public Label getLabel() {
		return label;
	}

	public void setLabel(Label label) {
		this.label = label;
	}

	public MessageLabel() {
		super();
	}
	
}

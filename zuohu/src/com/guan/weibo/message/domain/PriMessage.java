package com.guan.weibo.message.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

import com.guan.weibo.user.domain.User;

@Entity(name="pri_message")
public class PriMessage implements Serializable{

	private static final long serialVersionUID = 7448097704591231746L;

	public PriMessage() {
		super();
	}
	
	//私信表主键
	@Id
	@GeneratedValue(generator = "ud")
	@GenericGenerator(name = "ud", strategy = "uuid")
	private String pm_id;
	
	@ManyToOne
	@JoinColumn(name="from_id")
	private User from;
	
	@ManyToOne
	@JoinColumn(name="to_id")
	private User to;
	
	//内容
	@Column(name="content",length=500)
	private String content;
	
	//发送时间
	@Column(name="time")
	private Timestamp time;
	
	//消息状态
	@Column(name="state")
	private int state;

	public String getPm_id() {
		return pm_id;
	}

	public void setPm_id(String pm_id) {
		this.pm_id = pm_id;
	}

	public User getFrom() {
		return from;
	}

	public void setFrom(User from) {
		this.from = from;
	}

	public User getTo() {
		return to;
	}

	public void setTo(User to) {
		this.to = to;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getTime() {
		return time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}
	
}

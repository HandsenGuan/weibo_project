package com.guan.weibo.message.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

import com.guan.weibo.user.domain.User;

@Entity(name="reply")
public class Reply implements Serializable{

	
	private static final long serialVersionUID = 1L;

	public Reply() {
		super();
	}
	
	//回复表主键（uuid）
	@Id
	@GeneratedValue(generator = "ud")
	@GenericGenerator(name = "ud", strategy = "uuid")
	private  String r_id;
	
	//评论的消息
	@ManyToOne
	@JoinColumn(name="m_id")
	private Message message;
	
	//父评论id
	@ManyToOne
	@JoinColumn(name="p_id")
	private Reply parent;
	
	//消息体
	@Column(name="content")
	private String content;
	
	//时间
	@Column(name="time")
	private Timestamp time;
	
	//评论的用户
	@ManyToOne
	@JoinColumn(name="u_id")
	private User user;
	
	//用户关注消息表(关注此消息的多个用户)
	@OneToMany(fetch=FetchType.EAGER,mappedBy="parent")
	private Set<Reply> children;

	public String getR_id() {
		return r_id;
	}

	public void setR_id(String r_id) {
		this.r_id = r_id;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Reply getParent() {
		return parent;
	}

	public void setParent(Reply parent) {
		this.parent = parent;
	}

	public Set<Reply> getChildren() {
		return children;
	}

	public void setChildren(Set<Reply> children) {
		this.children = children;
	}

	@Override
	public String toString() {
		return "Reply [r_id=" + r_id + ", message=" + message +", content=" + content + ", time=" + time + "]";
	}
	
}

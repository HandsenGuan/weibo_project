package com.guan.weibo.user.domain;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.guan.weibo.message.domain.Copy;
import com.guan.weibo.message.domain.Message;

@Entity(name="user")
public class User {
	
	@Id
	@Column(name="user_id",length=11)
	private String user_id;
	
	@Column(name="user_nickname",length=20)
	private String user_nickname;
	
	@Column(name="user_image",length=5000)
	private  Byte[] user_image;
	
	@Column(name="user_email",length=30)
	private String user_email;
	
	@Column(name="user_password",length=20)
	private String user_password;
	
	@Column(name="user_sex",length=1)
	private String user_sex;
	
	@Column(name="user_name",length=20)
	private String user_name;
	
	@Column(name="user_skin",length=11)
	private String user_skin;
	
	@Column(name="user_qq",length=20)
	private String user_qq;
	
	@Column(name="user_school",length=11)
	private String user_school;
	
	@Column(name="user_work",length=20)
	private String user_work;
	
	@Column(name="user_tel",length=11)
	private String user_tel;
	
	@Column(name="user_info",length=100)
	private String user_info;
	
	@Column(name="user_datetime")
	private Timestamp user_datetime;
	
	@Column(name="user_blog",length=50)
	private String user_blog;

	@Column(name="user_status",length=1)
	private boolean user_status;
	
	@Column(name="activationCode",length=64)
	private String activationCode;
	
	//消息 user-message
	@OneToMany(mappedBy="user")
	@LazyCollection(LazyCollectionOption.EXTRA)
	private Set<Message> messages;
	
	//转发消息 copy-user
	@OneToOne(mappedBy="user")
	private Copy copy;

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_nickname() {
		return user_nickname;
	}

	public void setUser_nickname(String user_nickname) {
		this.user_nickname = user_nickname;
	}

	public Byte[] getUser_image() {
		return user_image;
	}

	public void setUser_image(Byte[] user_image) {
		this.user_image = user_image;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	public String getUser_sex() {
		return user_sex;
	}

	public void setUser_sex(String user_sex) {
		this.user_sex = user_sex;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_skin() {
		return user_skin;
	}

	public void setUser_skin(String user_skin) {
		this.user_skin = user_skin;
	}

	public String getUser_qq() {
		return user_qq;
	}

	public void setUser_qq(String user_qq) {
		this.user_qq = user_qq;
	}

	public String getUser_school() {
		return user_school;
	}

	public void setUser_school(String user_school) {
		this.user_school = user_school;
	}

	public String getUser_work() {
		return user_work;
	}

	public void setUser_work(String user_work) {
		this.user_work = user_work;
	}

	public String getUser_tel() {
		return user_tel;
	}

	public void setUser_tel(String user_tel) {
		this.user_tel = user_tel;
	}

	public String getUser_info() {
		return user_info;
	}

	public void setUser_info(String user_info) {
		this.user_info = user_info;
	}

	public Timestamp getUser_datetime() {
		return user_datetime;
	}

	public void setUser_datetime(Timestamp user_datetime) {
		this.user_datetime = user_datetime;
	}

	public String getUser_blog() {
		return user_blog;
	}

	public void setUser_blog(String user_blog) {
		this.user_blog = user_blog;
	}

	public boolean isUser_status() {
		return user_status;
	}

	public void setUser_status(boolean user_status) {
		this.user_status = user_status;
	}

	public String getActivationCode() {
		return activationCode;
	}

	public void setActivationCode(String activationCode) {
		this.activationCode = activationCode;
	}

	public Set<Message> getMessages() {
		return messages;
	}

	public void setMessages(Set<Message> messages) {
		this.messages = messages;
	}

	public Copy getCopy() {
		return copy;
	}

	public void setCopy(Copy copy) {
		this.copy = copy;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}

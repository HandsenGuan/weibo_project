package com.guan.weibo.user.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OrderBy;

import com.guan.weibo.message.domain.Message;
import com.guan.weibo.message.domain.PriMessage;
import com.guan.weibo.message.domain.Reply;

@Entity(name = "user")
public class User implements Serializable {

	private static final long serialVersionUID = -75774699051182286L;

	public User() {
		super();
	}

	/**
	 * 构造函数
	 * 
	 * @param nickname
	 * @param password
	 */
	public User(String nickname, String password) {
		this.nickname = nickname;
		this.password = password;
		this.status = false;
		this.message_num = this.follow_num = 0;
		this.datetime = new Timestamp(System.currentTimeMillis());
	}

	// 用户表主键id
	@Id
	@GeneratedValue(generator = "ud")
	@GenericGenerator(name = "ud", strategy = "uuid")
	private String u_id;

	// 昵称
	@Column(name = "nickname", length = 50)
	private String nickname;

	// 密码
	@Column(name = "password", length = 50)
	private String password;

	// 注册码
	@Column(name = "activationCode", length = 64)
	private String activationCode;

	// 用户激活状态
	@Column(name = "status", length = 1)
	private boolean status;

	// 用户邮箱
	@Column(name = "email", length = 50)
	private String email;

	// 用户发布状态数
	@Column(name = "message_num")
	private int message_num;

	// 用户关注数
	@Column(name = "follow_num")
	private int follow_num;

	// 用户收藏数
	@Column(name = "fav_num")
	private int fav_num;

	// 用户注册时间
	@Column(name = "datetime")
	private Timestamp datetime;

	// 用户注册时间
	@Column(name = "user_desc")
	private String user_desc;

	// 用户头像
	@Column(name = "user_img")
	private String user_img;

	// 用户关注表
	// 用户关注的人
	@OneToMany(mappedBy = "user")
	private Set<UserFollow> follows;

	// 关注此用户的人
	@OneToMany(mappedBy = "fuser")
	private Set<UserFollow> followeds;

	// 用户喜爱消息表(用户关注的多个消息)
	@OneToMany(mappedBy = "user")
	private Set<UserFav> favs;

	// 用户消息表
	@OneToMany(fetch = FetchType.EAGER,mappedBy = "user")
	@OrderBy(clause = "time desc")
	private Set<Message> messages;

	// group-user表
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
	private Set<GroupUser> groups;

	// 私信表
	@OneToMany(mappedBy = "from")
	@OrderBy(clause = "time desc")
	private Set<PriMessage> send_primessages;

	@OneToMany(mappedBy = "to")
	@OrderBy(clause = "time desc")
	private Set<PriMessage> receive_primessages;
	
	
	//评论表
	@OneToMany(mappedBy = "user")
	@OrderBy(clause = "time desc")
	private Set<Reply> replys;

	public String getU_id() {
		return u_id;
	}

	public void setU_id(String u_id) {
		this.u_id = u_id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getActivationCode() {
		return activationCode;
	}

	public void setActivationCode(String activationCode) {
		this.activationCode = activationCode;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getMessage_num() {
		return message_num;
	}

	public void setMessage_num(int message_num) {
		this.message_num = message_num;
	}

	public int getFollow_num() {
		return follow_num;
	}

	public void setFollow_num(int follow_num) {
		this.follow_num = follow_num;
	}

	public Timestamp getDatetime() {
		return datetime;
	}

	public void setDatetime(Timestamp datetime) {
		this.datetime = datetime;
	}

	public Set<UserFollow> getFollows() {
		return follows;
	}

	public void setFollows(Set<UserFollow> follows) {
		this.follows = follows;
	}

	public Set<UserFollow> getFolloweds() {
		return followeds;
	}

	public void setFolloweds(Set<UserFollow> followeds) {
		this.followeds = followeds;
	}

	public Set<UserFav> getFavs() {
		return favs;
	}

	public void setFavs(Set<UserFav> favs) {
		this.favs = favs;
	}

	public Set<Message> getMessages() {
		return messages;
	}

	public void setMessages(Set<Message> messages) {
		this.messages = messages;
	}

	public Set<GroupUser> getGroups() {
		return groups;
	}

	public void setGroups(Set<GroupUser> groups) {
		this.groups = groups;
	}

	public int getFav_num() {
		return fav_num;
	}

	public void setFav_num(int fav_num) {
		this.fav_num = fav_num;
	}

	public Set<PriMessage> getSend_primessages() {
		return send_primessages;
	}

	public void setSend_primessages(Set<PriMessage> send_primessages) {
		this.send_primessages = send_primessages;
	}

	public Set<PriMessage> getReceive_primessages() {
		return receive_primessages;
	}

	public void setReceive_primessages(Set<PriMessage> receive_primessages) {
		this.receive_primessages = receive_primessages;
	}

	public String getUser_desc() {
		return user_desc;
	}

	public void setUser_desc(String user_desc) {
		this.user_desc = user_desc;
	}

	
	public String getUser_img() {
		return user_img;
	}

	public void setUser_img(String user_img) {
		this.user_img = user_img;
	}

	public Set<Reply> getReplys() {
		return replys;
	}

	public void setReplys(Set<Reply> replys) {
		this.replys = replys;
	}

	@Override
	public String toString() {
		return "User [u_id=" + u_id + ", nickname=" + nickname + ", password=" + password + ", activationCode=" + activationCode + ", status="
				+ status + ", email=" + email + ", message_num=" + message_num + ", follow_num=" + follow_num + ", fav_num=" + fav_num
				+ ", datetime=" + datetime + "]";
	}

}

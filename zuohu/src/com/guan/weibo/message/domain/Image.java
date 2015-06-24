package com.guan.weibo.message.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity(name="image")
public class Image implements Serializable{

	private static final long serialVersionUID = 5984543537903192398L;

	public Image() {
		super();
	}

	//图片表主键
	@Id
	@GeneratedValue(generator = "ud")
	@GenericGenerator(name = "ud", strategy = "uuid")
	private String img_id;
	
	//消息
	@ManyToOne
	@JoinColumn(name="m_id")
	private Message message;
	
	//图片地址
	@Column(name="url",length=200)
	private String url;
	
	//图片描述
	@Column(name="img_desc",length=200)
	private String desc;

	public String getImg_id() {
		return img_id;
	}

	public void setImg_id(String img_id) {
		this.img_id = img_id;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "Image [img_id=" + img_id + ", url=" + url + ", desc=" + desc
				+ "]";
	}
	
	
}

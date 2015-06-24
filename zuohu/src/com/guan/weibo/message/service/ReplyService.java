package com.guan.weibo.message.service;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.guan.weibo.message.dao.ReplyDao;
import com.guan.weibo.message.domain.Reply;

public class ReplyService {
	
	private ReplyDao replyDao;

	public ReplyDao getReplyDao() {
		return replyDao;
	}

	public void setReplyDao(ReplyDao replyDao) {
		this.replyDao = replyDao;
	}

	public ReplyService() {
		super();
	}
	
	/**
	 * 添加评论
	 */
	public void add(Reply reply) {
		replyDao.add(reply);
	}

	/**
	 * 删除评论
	 */
	public void delete(String r_id) {
		replyDao.delete(r_id);
	}
	
	/**
	 * 根据id查找评论
	 */
	public Reply queryByRid(String r_id){
		return replyDao.queryByRid(r_id);
	}
	
}

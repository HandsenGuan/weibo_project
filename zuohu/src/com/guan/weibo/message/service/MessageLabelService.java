package com.guan.weibo.message.service;

import java.util.List;

import com.guan.weibo.message.dao.MessageLabelDao;
import com.guan.weibo.message.domain.MessageLabel;

public class MessageLabelService {

	public MessageLabelService() {
		super();
	}
	
	private MessageLabelDao messageLabelDao;

	public MessageLabelDao getMessageLabelDao() {
		return messageLabelDao;
	}

	public void setMessageLabelDao(MessageLabelDao messageLabelDao) {
		this.messageLabelDao = messageLabelDao;
	}
	
	/**
	 * 添加消息-标签关系
	 * @param messageLabel
	 */
	public void add(MessageLabel messageLabel) {
		try {
			messageLabelDao.add(messageLabel);
		} catch (Exception e) {
			throw new RuntimeException("发布消息失败！");
		}
	}
	
	/**
	 * 根据消息id查询标签
	 * @param m_id
	 * @return
	 */
	public List<MessageLabel> queryByMid(String m_id) {
		List<MessageLabel> messageLabel =null;
		try {
			messageLabel = messageLabelDao.queryByMid(m_id);
		} catch (Exception e) {
			throw new RuntimeException("发布消息失败！");
		}
		return messageLabel;
	}
	
	/**
	 * 根据标签查询消息
	 * @param l_id
	 * @return
	 */
	public List<MessageLabel> queryByLid(String l_id) {
		List<MessageLabel> messageLabel =null;
		try {
			messageLabel = messageLabelDao.queryByLid(l_id);
		} catch (Exception e) {
			throw new RuntimeException("发布消息失败！");
		}
		return messageLabel;
	}
	

}

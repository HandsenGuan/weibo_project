package com.guan.weibo.message.dao;

import java.util.List;

import com.guan.weibo.message.domain.MessageLabel;

public interface MessageLabelDao {

	/**
	 * 添加消息-标签关系
	 * @param messageLabel
	 */
	public void add(MessageLabel messageLabel);
	
	/**
	 * 根据消息id查询标签
	 * @param m_id
	 * @return
	 */
	public List<MessageLabel> queryByMid(String m_id);
	
	/**
	 * 根据标签查询消息
	 * @param l_id
	 * @return
	 */
	public List<MessageLabel> queryByLid(String l_id);
	
}

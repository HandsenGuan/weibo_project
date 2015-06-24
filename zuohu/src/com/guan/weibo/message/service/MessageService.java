package com.guan.weibo.message.service;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.guan.weibo.message.dao.MessageDao;
import com.guan.weibo.message.domain.Message;

public class MessageService {
	
	private MessageDao messageDao;
	
	public MessageService() {
		super();
	}

	public MessageDao getMessageDao() {
		return messageDao;
	}

	public void setMessageDao(MessageDao messageDao) {
		this.messageDao = messageDao;
	}

	/**
	 * 发布消息
	 */
	public void publishMessage(Message message ){
		messageDao.save(message);
	}
	
	/**
	 * 删除消息
	 * @param m_id
	 */
	public void deleteMessageById(String m_id){
			messageDao.deleteById(m_id);
	}
	
	
	/**
	 * 根据消息id修改消息
	 * @param m_id
	 * @param message
	 */
	public void update(Message message){
			messageDao.update(message);
	}
	
	/**
	 * 查询用户发布的所有消息
	 * @return
	 */
	public List<Message> queryMessagesByUid(String user_id){
		return messageDao.queryMessagesByUid(user_id);
	}
	
	
	/**
	 * 根据消息id查询消息
	 * @param m_id
	 * @return
	 */
	public Message queryMessageByMid(String m_id) {
			return messageDao.queryMessageByMid(m_id);
	}
	
	/**
	 * 根据时间查询状态id
	 * @param time
	 * @return
	 */
	public Message queryMessageByTime(Timestamp time) {
			return messageDao.queryMessageByTime(time);
	}
	
	
	/**
	 * 查询指定uid的所有消息数量
	 * @return
	 */
	public long queryCountByUid(String user_id) {
			return messageDao.queryCountByUid(user_id);
	}
	
	
	/**
	 * 查询消息相关信息（收藏数,评论数,转载数,发布时间）
	 */
	public Map<String,Object> queryMessageInfo(String m_id){
		Map<String,Object> messageInfo = new HashMap<>();
			//查询浏览数
			int scanNum = messageDao.queryScanNum(m_id);
			//查询评论数
			int replyNum = messageDao.queryReplyNum(m_id);
			//查询发布时间
			Timestamp datetime = messageDao.queryTime(m_id);
			
			messageInfo.put("scanNum", scanNum);
			messageInfo.put("replyNum", replyNum);
			messageInfo.put("datetime", datetime);
		return messageInfo;
	}
	
	/**
	 * 查询指定消息的类型
	 * @param m_id
	 * @return
	 */
	public int queryTypeByMid(String m_id){
			return messageDao.queryTypeByUid(m_id);
	}
	
	/**
	 * 分页查询一页消息
	 * @return
	 */
	public List<Message> queryByPageAndUid(String user_id, int pageNum, int pageSize) {
			return messageDao.queryByPageAndUid(user_id, pageNum, pageSize);
	}
	
	
	/**
	 * 根据用户id查询用户关注及自己发的消息的总数
	 * @param user_id
	 * @return
	 */
	public long queryTotalCountByUid(String user_id) {
			return messageDao.queryTotalCountByUid(user_id);
	}
	
	
}

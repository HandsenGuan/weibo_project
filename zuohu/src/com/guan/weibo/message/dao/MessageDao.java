package com.guan.weibo.message.dao;

import java.sql.Timestamp;
import java.util.List;

import com.guan.weibo.message.domain.Message;

public interface MessageDao {

	
	/**
	 * 添加消息
	 */
	public void save(Message message);
	
	
	/**
	 * 根据id删除消息
	 * @param id
	 */
	public void deleteById(String id);
	
	
	/**
	 * 根据消息id修改消息
	 * @param message
	 */
	public void update(Message message);
	
	
	/**
	 * 分页查询一页消息
	 * @return
	 */
	public List<Message> queryByPageAndUid(String user_id,int pageNum,int pageSize);	
	
	/**
	 * 根据用户id查询用户关注及自己发的消息的总数
	 * @param user_id
	 * @return
	 */
	public long queryTotalCountByUid(String user_id);
	
	/**
	 * 查询指定uid的所有消息
	 * @return
	 */
	public List<Message> queryMessagesByUid(String user_id);
	
	/**
	 * 查询指定mid的消息
	 * @return
	 */
	public Message queryMessageByMid(String m_id);
	
	/**
	 * 查询指定uid的所有消息数量
	 * @param user_id
	 * @return
	 */
	public long queryCountByUid(String user_id);
	
	/**
	 * 查询指定uid的消息类型
	 * @param user_id
	 * @return
	 */
	public int queryTypeByUid(String m_id);
	
	
	/**
	 * 根据时间查询状态id
	 * @param time
	 * @return
	 */
	public Message queryMessageByTime(Timestamp time);
	
	
	/**
	 * 根据消息id查询评论次数
	 * @param m_id
	 * @return
	 */
	public int queryReplyNum(String m_id);
	
	
	/**
	 * 根据消息id查询浏览次数
	 * @param m_id
	 * @return
	 */
	public int queryScanNum(String m_id);
	
	/**
	 * 查询发布时间
	 * @param m_id
	 * @return
	 */
	public Timestamp queryTime(String m_id);

}

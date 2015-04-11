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
	 * 查询指定uid的所有消息
	 * @return
	 */
	public List<Message> queryByUid(String user_id);
	
	
	/**
	 * 查询指定uid的所有消息数量
	 * @param user_id
	 * @return
	 */
	public int queryCountByUid(String user_id);
	
	
	/**
	 * 查询指定话题的消息
	 * @param t_id
	 * @return
	 */
	public List<Message> queryByTid(String t_id);
	
	/**
	 * 查询指定话题的消息数量
	 * @param t_id
	 * @return
	 */
	public int queryCountByTid(String t_id);
	
	
	/**
	 * 查询收藏次数
	 * @param m_id
	 * @return
	 */
	public int queryFavNum(String m_id);
	
	/**
	 * 查询评论次数
	 * @param m_id
	 * @return
	 */
	public int queryReplyNum(String m_id);
	
	/**
	 * 查询转载次数
	 * @param m_id
	 * @return
	 */
	public int queryCopyNum(String m_id);
	
	/**
	 * 查询发布时间
	 * @param m_id
	 * @return
	 */
	public Timestamp queryTimeNum(String m_id);

	
	
}

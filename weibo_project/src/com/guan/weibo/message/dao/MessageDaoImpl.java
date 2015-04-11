package com.guan.weibo.message.dao;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.guan.weibo.message.domain.Message;

public class MessageDaoImpl implements MessageDao {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * 添加消息
	 */
	@Override
	public void save(Message message) {
		Session session = null; // 定义Session
		Transaction tx = null; // 定义事务
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.save(message);
			tx.commit(); // 提交
		} catch (Exception e) {
			tx.rollback(); // 出现异常回滚
		}

	}

	/**
	 * 根据id删除消息
	 * 
	 * @param id
	 */
	@Override
	public void deleteById(String id) {
		// 拼装sql语句
		String hsql = "delete from message where m_id=:m_id";
		Session session = null; // 定义Session
		Transaction tx = null; // 定义事务
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			
			Query query = session.createQuery(hsql);
			query.setParameter("m_id", id);
			query.executeUpdate();
			
			tx.commit(); // 提交
		} catch (Exception e) {
			tx.rollback(); // 出现异常回滚
		}
		

	}

	/**
	 * 查询指定user_id的所有消息
	 * 
	 * @return
	 */
	@Override
	public List<Message> queryByUid(String user_id) {
		List list = null;
		String hsql = "from messgae where user_id=:user_id";
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(hsql);
		query.setParameter("user_id", user_id);
		list = query.list();
		return list;
	}

	/**
	 * 查询指定uid的所有消息数量
	 * 
	 * @param user_id
	 * @return
	 */
	@Override
	public int queryCountByUid(String user_id) {
		String hsql = "select count(*) from messgae where user_id=:uid";
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(hsql);
		query.setParameter("uid", user_id);
		
		return (int) query.uniqueResult();
	}

	/**
	 * 查询指定话题的消息
	 * 
	 * @param t_id
	 * @return
	 */
	@Override
	public List<Message> queryByTid(String t_id) {
		List list = null;
		String hsql = "from messgae where t_id=:t_id";
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(hsql);
		query.setParameter("t_id", t_id);
		list = query.list();
		return list;
	}

	/**
	 * 查询指定话题的消息数量
	 * 
	 * @param t_id
	 * @return
	 */
	@Override
	public int queryCountByTid(String t_id) {
		String hsql = "select count(*) from messgae where t_id=:t_id";
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(hsql);
		query.setParameter("t_id", t_id);
		
		return (int) query.uniqueResult();
	}

	/**
	 * 查询收藏次数
	 * 
	 * @param m_id
	 * @return
	 */
	@Override
	public int queryFavNum(String m_id) {
		String hsql = "select m_fav from messgae where m_id=:m_id";
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(hsql);
		query.setParameter("m_id", m_id);
		return (int)query.uniqueResult();
	}

	/**
	 * 查询评论次数
	 * 
	 * @param m_id
	 * @return
	 */
	@Override
	public int queryReplyNum(String m_id) {
		String hsql = "select m_reply from messgae where m_id=:m_id";
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(hsql);
		query.setParameter("m_id", m_id);
		return (int)query.uniqueResult();
	}

	/**
	 * 查询转载次数
	 * 
	 * @param m_id
	 * @return
	 */
	@Override
	public int queryCopyNum(String m_id) {
		String hsql = "select m_copy from messgae where m_id=:m_id";
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(hsql);
		query.setParameter("m_id", m_id);
		return (int)query.uniqueResult();
	}

	/**
	 * 查询发布时间
	 * 
	 * @param m_id
	 * @return
	 */
	@Override
	public Timestamp queryTimeNum(String m_id) {
		String hsql = "select m_datetime from messgae where m_id=:m_id";
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(hsql);
		query.setParameter("m_id", m_id);
		return (Timestamp)query.uniqueResult();
	}

}

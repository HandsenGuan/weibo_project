package com.guan.weibo.message.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.guan.weibo.message.domain.MessageLabel;

public class MessageLabelDaoImpl implements MessageLabelDao{

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	/**
	 * 添加消息-标签关系
	 * @param messageLabel
	 */
	@Override
	public void add(MessageLabel messageLabel) {
		Session session = null; // 定义Session
		Transaction tx = null; // 定义事务
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.save(messageLabel);
			tx.commit(); // 提交
			session.close();
		} catch (Exception e) {
			tx.rollback(); // 出现异常回滚
		}
	}

	/**
	 * 根据消息id查询标签
	 * @param m_id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<MessageLabel> queryByMid(String m_id) {
		List<MessageLabel> list = null;
		String hsql = "from message_label where m_id=:m_id";
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(hsql);
		query.setParameter("m_id", m_id);
		list = query.list();
		session.close();
		return list;
	}

	/**
	 * 根据标签查询消息
	 * @param l_id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<MessageLabel> queryByLid(String l_id) {
		List<MessageLabel> list = null;
		String hsql = "from message_label where l_id=:l_id";
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(hsql);
		query.setParameter("l_id", l_id);
		list = query.list();
		session.close();
		return list;
	}
	

}

package com.guan.weibo.message.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.guan.weibo.message.domain.Message;
import com.guan.weibo.message.domain.Reply;

public class ReplyDaoImpl implements ReplyDao {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * 添加评论
	 */
	@Override
	public void add(Reply reply) {
		Session session = null; // 定义Session
		Transaction tx = null; // 定义事务
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.save(reply);
			tx.commit(); // 提交
			session.close();
		} catch (Exception e) {
			tx.rollback(); // 出现异常回滚
		}
	}

	/**
	 * 删除评论
	 */
	@Override
	public void delete(String r_id) {
		// 拼装sql语句
		String hsql = "delete from reply where r_id=:r_id";
		Session session = null; // 定义Session
		Transaction tx = null; // 定义事务
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();

			Query query = session.createQuery(hsql);
			query.setParameter("r_id", r_id);
			query.executeUpdate();

			tx.commit(); // 提交
			session.close();
		} catch (Exception e) {
			tx.rollback(); // 出现异常回滚
		}

	}
	
	/**
	 * 根据id查找评论
	 */
	public Reply queryByRid(String r_id){
		String hsql = "from reply where r_id=:r_id";
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(hsql);
		query.setParameter("r_id", r_id);
		
		Reply reply = (Reply)query.uniqueResult();
		
		session.close();
		return reply;
	}

}

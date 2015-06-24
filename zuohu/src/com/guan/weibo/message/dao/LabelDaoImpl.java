package com.guan.weibo.message.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.guan.weibo.message.domain.Label;

public class LabelDaoImpl implements LabelDao{

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	/**
	 * 添加标签
	 * @param label
	 */
	@Override
	public void add(Label label) {
		Session session = null; // 定义Session
		Transaction tx = null; // 定义事务
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.save(label);
			tx.commit(); // 提交
			session.close();
		} catch (Exception e) {
			tx.rollback(); // 出现异常回滚
		}
		
	}

	/**
	 * 查询前三十标签
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Label> queryTop30Labels() {
		List<Label> list = null;
		String hsql = "from label order by num desc limit 0,5";
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(hsql);
		list = query.list();
		session.close();
		return list;
		
	}

	/**
	 * 根据标签id查询id
	 * @param l_id
	 * @return
	 */
	@Override
	public Label queryByLid(String l_id) {
		String hsql = "from label where l_id=:l_id";
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(hsql);
		query.setParameter("l_id", l_id);
		Label label = (Label)query.uniqueResult();
		session.close();
		return label;
	}

}

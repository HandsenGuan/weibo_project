package com.guan.weibo.message.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.guan.weibo.message.domain.PriMessage;

public class PrimessageDaoImpl implements PrimessageDao {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * 添加私信
	 * 
	 * @param primessage
	 */
	@Override
	public void add(PriMessage primessage) {

		Session session = null; // 定义Session
		Transaction tx = null; // 定义事务
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.save(primessage);
			tx.commit(); // 提交
			session.close();
		} catch (Exception e) {
			tx.rollback(); // 出现异常回滚
		}

	}

	/**
	 * 根据id删除私信
	 * 
	 * @param pm_id
	 */
	@Override
	public void deleteByPMid(String pm_id) {
		// 拼装sql语句
		String hsql = "delete from pri_message where pm_id=:pm_id";
		Session session = null; // 定义Session
		Transaction tx = null; // 定义事务
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();

			Query query = session.createQuery(hsql);
			query.setParameter("pm_id", pm_id);
			query.executeUpdate();

			tx.commit(); // 提交
			session.close();
		} catch (Exception e) {
			tx.rollback(); // 出现异常回滚
		}
	}

	/**
	 * 根据id更新私信状态
	 * 
	 * @param pm_id
	 * @param state
	 */
	@Override
	public void updatePrimessageStateByPMid(String pm_id) {
		
		String hsql = "update pri_message set state=:state where pm_id=:pm_id";

		Session session = null; // 定义Session
		Transaction tx = null; // 定义事务
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			Query query = session.createQuery(hsql);
			query.setParameter("state", 1);
			query.setParameter("pm_id", pm_id);
			query.executeUpdate();
			tx.commit(); // 提交
			session.close();
		} catch (Exception e) {
			tx.rollback(); // 出现异常回滚
		}

	}

	/**
	 * 根据state更新私信状态
	 * @param pm_id
	 * @param state
	 */
	public void updatePrimessageStateByToAndState(String u_id){
		String hsql = "update pri_message set state=:readstate where to_id=:u_id and state=:state";

		Session session = null; // 定义Session
		Transaction tx = null; // 定义事务
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			Query query = session.createQuery(hsql);
			query.setParameter("readstate", 1);
			query.setParameter("u_id", u_id);
			query.setParameter("state", 0);
			query.executeUpdate();
			tx.commit(); // 提交
			session.close();
		} catch (Exception e) {
			tx.rollback(); // 出现异常回滚
		}
	}
	
	/**
	 * 根据收信人id查询所有私信
	 * @param id
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<PriMessage> queryPrimessagesByTo(String u_id) {
		List<PriMessage> list = null;
		String hsql = "from pri_message where to_id=:u_id or from_id=:u_id";
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(hsql);
		query.setParameter("u_id", u_id);
		list = query.list();
		session.close();
		return list;
	}

	/**
	 * 根据收信人id与发信人id查询所有的私信
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<PriMessage> queryPrimessagesByUids(String u_id1, String u_id2) {
		List<PriMessage> list = null;
		String hsql = "from pri_message where from_id=:u_id1 and to_id=:u_id2 or from_id=:u_id2 and to_id=:u_id1";
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(hsql);
		query.setParameter("u_id1", u_id1);
		query.setParameter("u_id2", u_id2);
		list = query.list();
		session.close();
		return list;
	}
	
	/**
	 * 根据收信用户id和私信状态查询所有的私信
	 * @param to
	 * @param state
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<PriMessage> queryPrimessagesByToAndState(String to,int state){
		List<PriMessage> list = null;
		String hsql = "from pri_message where state=:state and to_id=:to";
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(hsql);
		query.setParameter("to", to);
		query.setParameter("state", state);
		list = query.list();
		session.close();
		return list;
	}

}

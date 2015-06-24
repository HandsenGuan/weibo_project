package com.guan.weibo.user.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.guan.weibo.user.domain.Group;
import com.guan.weibo.user.domain.User;

public class GroupDaoImpl implements GroupDao {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * 添加群
	 */
	@Override
	public void add(Group group) {
		Session session = null; // 定义Session
		Transaction tx = null; // 定义事务
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.save(group);
			tx.commit(); // 提交
			session.close();
		} catch (Exception e) {
			tx.rollback(); // 出现异常回滚
		}
	}

	/**
	 * 删除群
	 */
	@Override
	public void delete(String g_id) {
		// 拼装sql语句
		String hsql = "delete from groups where g_id=:g_id";
		Session session = null; // 定义Session
		Transaction tx = null; // 定义事务
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();

			Query query = session.createQuery(hsql);
			query.setParameter("g_id", g_id);
			query.executeUpdate();

			tx.commit(); // 提交
			session.close();
		} catch (Exception e) {
			tx.rollback(); // 出现异常回滚
		}
	}

	/**
	 * 更新群信息
	 */
	@Override
	public void updateGroup(Group group) {

		Session session = null; // 定义Session
		Transaction tx = null; // 定义事务
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.update(group);
			tx.commit(); // 提交
			session.close();
		} catch (Exception e) {
			tx.rollback(); // 出现异常回滚
		}
	}

	/**
	 * 更新指定id的群名
	 * 
	 * @param g_id
	 * @param name
	 */
	@Override
	public void updateGroupName(String g_id, String name) {

		String hsql = "update groups set g_name=:name where g_id=:g_id";

		Session session = null; // 定义Session
		Transaction tx = null; // 定义事务
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			Query query = session.createQuery(hsql);
			query.setParameter("name", name);
			query.setParameter("g_id", g_id);
			query.executeUpdate();
			tx.commit(); // 提交
			session.close();
		} catch (Exception e) {

			tx.rollback(); // 出现异常回滚
		}

	}

	/**
	 * 根据id查询群信息
	 */
	@Override
	public Group queryGroupById(String g_id) {
		String hsql = "from groups where g_id=:g_id";
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(hsql);
		query.setParameter("g_id", g_id);
		Group group = (Group) query.uniqueResult();
		session.close();
		return group;
	}

}

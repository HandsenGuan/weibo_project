package com.guan.weibo.user.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.guan.weibo.user.domain.GroupUser;

public class GroupUserDaoImpl implements GroupUserDao {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * 添加群用户对象
	 * 
	 * @param group_user
	 */
	@Override
	public void add(GroupUser group_user) {
		Session session = null; // 定义Session
		Transaction tx = null; // 定义事务
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.save(group_user);
			tx.commit(); // 提交
			session.close();
		} catch (Exception e) {
			tx.rollback(); // 出现异常回滚
		}

	}

	/**
	 * 删除指定id群中的用户id
	 * 
	 * @param u_id
	 * @param g_id
	 */
	@Override
	public void delete(String u_id, String g_id) {
		// 拼装sql语句
		String hsql = "delete from group_user where u_id=:u_id and g_id=:g_id";
		Session session = null; // 定义Session
		Transaction tx = null; // 定义事务
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			Query query = session.createQuery(hsql);
			query.setParameter("u_id", u_id);
			query.setParameter("g_id", g_id);
			query.executeUpdate();
			tx.commit(); // 提交
			session.close();
		} catch (Exception e) {
			tx.rollback(); // 出现异常回滚
		}

	}

	/**
	 * 根据用户id修改用户等级
	 * 
	 * @param u_id
	 * @param level
	 */
	@Override
	public void updateLevelByUidAndGid(String g_id , String u_id, int level) {
		String hsql = "update group_user set level=:level where u_id=:u_id and g_id=:g_id";
		Session session = null; // 定义Session
		Transaction tx = null; // 定义事务
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			Query query = session.createQuery(hsql);
			query.setParameter("level", level);
			query.setParameter("u_id", u_id);
			query.setParameter("g_id", g_id);
			query.executeUpdate();
			tx.commit(); // 提交
			session.close();
		} catch (Exception e) {

			tx.rollback(); // 出现异常回滚
		}


	}

	/**
	 * 根据群id查询该群下所有的用户id
	 * 
	 * @param g_id
	 */
	@Override
	public List<GroupUser> queryUsersByGid(String g_id) {
		String hsql = "from group_user where g_id=:g_id";
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(hsql);
		query.setParameter("g_id", g_id);
		List<GroupUser> group_users = query.list();
		session.close();
		return group_users;
	}

	/**
	 * 根据用户id查询用户所在的所有的群
	 * 
	 * @param u_id
	 */
	@Override
	public List<GroupUser> queryGroupsByUid(String u_id) {
		String hsql = "from group_user where u_id=:u_id";
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(hsql);
		query.setParameter("u_id", u_id);
		List<GroupUser> group_users = query.list();
		session.close();
		return group_users;

	}

}

package com.guan.weibo.user.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.guan.weibo.user.domain.UserFav;
import com.guan.weibo.user.domain.UserFollow;

public class UserFollowDaoImpl implements UserFollowDao {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * 添加关注用户记录
	 * 
	 * @param userFollow
	 */
	@Override
	public void add(UserFollow userFollow) {
		Session session = null; // 定义Session
		Transaction tx = null; // 定义事务
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.save(userFollow);
			tx.commit(); // 提交
			session.close();
		} catch (Exception e) {
			tx.rollback(); // 出现异常回滚
		}

	}
	
	/**
	 * 删除关注用户的记录
	 * @param f_id
	 */
	@Override
	public void delete(String f_id) {
		// 拼装sql语句
		String hsql = "delete from user_follow where f_id=:f_id";
		Session session = null; // 定义Session
		Transaction tx = null; // 定义事务
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();

			Query query = session.createQuery(hsql);
			query.setParameter("f_id", f_id);
			query.executeUpdate();

			tx.commit(); // 提交
			session.close();
		} catch (Exception e) {
			tx.rollback(); // 出现异常回滚
		}

	}

	/**
	 * 根据用户id查询关注记录
	 * @param u_id
	 * @return
	 */
	@Override
	public List<UserFollow> queryByUid(String u_id) {
		String hsql = "from user_follow where u_id=:u_id";
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(hsql);
		query.setParameter("u_id", u_id);
		List<UserFollow> userFollows = query.list();
		session.close();
		return userFollows;
	}

	/**
	 * 根据用户id与被关注用户id查询是否关注
	 * @param u_id
	 * @param fu_id
	 * @return
	 */
	@Override
	public boolean queryByUidAndFuid(String u_id, String fu_id) {
		String hsql = "select count(*) from user_follow where u_id=:u_id and fu_id=:fu_id";
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(hsql);
		query.setParameter("u_id", u_id);
		query.setParameter("fu_id", fu_id);
		long i = (long)query.uniqueResult();
		session.close();
		return  i>=1?true:false;
	}

}

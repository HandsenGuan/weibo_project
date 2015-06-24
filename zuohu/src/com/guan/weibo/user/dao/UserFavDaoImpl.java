package com.guan.weibo.user.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.guan.weibo.user.domain.Group;
import com.guan.weibo.user.domain.UserFav;

public class UserFavDaoImpl implements UserFavDao {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * 添加一个用户关注信息
	 * 
	 * @param userFav
	 */
	@Override
	public void add(UserFav userFav) {
		Session session = null; // 定义Session
		Transaction tx = null; // 定义事务
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.save(userFav);
			tx.commit(); // 提交
			session.close();
		} catch (Exception e) {
			tx.rollback(); // 出现异常回滚
		}

	}

	/**
	 * 删除一个用户关注信息
	 * 
	 * @param userFav
	 */
	@Override
	public void delete(String fav_id) {
		// 拼装sql语句
		String hsql = "delete from user_fav where fav_id=:fav_id";
		Session session = null; // 定义Session
		Transaction tx = null; // 定义事务
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();

			Query query = session.createQuery(hsql);
			query.setParameter("fav_id", fav_id);
			query.executeUpdate();

			tx.commit(); // 提交
			session.close();
		} catch (Exception e) {
			tx.rollback(); // 出现异常回滚
		}

	}

	/**
	 * 根据用户id查询关注信息
	 * 
	 * @param u_id
	 * @return 
	 */
	@Override
	public List<UserFav> queryByUid(String u_id) {
		String hsql = "from user_fav where u_id=:u_id";
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(hsql);
		query.setParameter("u_id", u_id);
		List<UserFav> userFavs = query.list();
		session.close();
		return userFavs;
		
	}

	/**
	 * 根据用户id与消息id查询关注记录
	 */
	@Override
	public boolean queryByUidAndMid(String u_id, String m_id) {
		String hsql = "select count(*) from user_fav where u_id=:u_id and m_id=:m_id";
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(hsql);
		query.setParameter("u_id", u_id);
		query.setParameter("m_id", m_id);
		long i = (long)query.uniqueResult();
		session.close();
		return  i==1?true:false;
	}
	
	
	
	

}

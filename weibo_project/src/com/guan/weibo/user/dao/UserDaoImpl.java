package com.guan.weibo.user.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.guan.weibo.user.domain.User;

public class UserDaoImpl implements UserDao {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * 添加用户
	 */
	@Override
	public void save(User user) {

		Session session = null; // 定义Session
		Transaction tx = null; // 定义事务
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.save(user);
			tx.commit(); // 提交
		} catch (Exception e) {
			tx.rollback(); // 出现异常回滚
		}
	}

	/**
	 * 根据id删除用户
	 */
	@Override
	public void deleteById(String id) {

	}

	/**
	 * 查找所有
	 */
	@Override
	public List<User> queryList() {
		String hsql = "from user";
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(hsql);

		@SuppressWarnings("unchecked")
		List<User> user_list = query.list();

		return user_list;
	}

	/**
	 * 根据账号和密码查询
	 */
	@Override
	public User queryByLoginnameAndLoginpass(String loginname, String loginpass) {

		String hsql = "from user where user_nickname=:loginname and user_password=:loginpass";
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(hsql);
		query.setParameter("loginname", loginname);
		query.setParameter("loginpass", loginpass);
		User user = (User) query.uniqueResult();
		return user;
	}
	
	/**
	 * 根据id和密码查询
	 */
	@Override
	public boolean queryByUidAndPassword(String uid, String password) {
		String hsql = "select count(*) from user where user_id=:uid and user_password=:password";
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(hsql);
		query.setParameter("uid", uid);
		query.setParameter("password", password);
		return (int) query.uniqueResult() > 1?true:false;
	}

	
	/**
	 * 根据id查找用户
	 */
	@Override
	public User queryByUid(String uid) {
		String hsql = "from user where user_id=:uid";
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(hsql);
		query.setParameter("uid", uid);
		User user = (User) query.uniqueResult();
		return user;
	}

	/**
	 * 检验用户名是否注册
	 */
	public boolean ajaxValidateLoginname(String loginname) {

		String hsql = "select count(*) from user where user_nickname=:loginname";
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(hsql);
		query.setParameter("loginname", loginname);

		return (int) query.uniqueResult() == 1;
	}

	

	/**
	 * 校验email是否注册
	 */
	@Override
	public boolean ajaxValidateEmail(String email) {

		String hsql = "select count(*) from user where user_email=:email";
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(hsql);
		query.setParameter("email", email);

		return (int) query.uniqueResult() == 1;
	}

	/**
	 * 修改用户状态
	 */
	@Override
	public void updateStatus(String uid, boolean status) {

		String hsql = "update user set user_status=:status where user_id=:uid";
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery(hsql);
		query.setParameter(0, status);
		query.setParameter(1, uid);
		query.executeUpdate();
		tx.commit();

	}

	/**
	 * 修改密码
	 */
	@Override
	public void updatePassword(String uid, String password) {
		
		String hsql = "update user set user_password=:password where user_id=:uid";
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery(hsql);
		query.setParameter(0, password);
		query.setParameter(1, uid);
		query.executeUpdate();
		tx.commit();

	}

	

	/**
	 * 修改用户信息
	 * 
	 * @param user
	 */

	@Override
	public void updateUser(User user) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(user);
		tx.commit();
	}

}

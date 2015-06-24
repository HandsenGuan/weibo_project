package com.guan.weibo.user.dao;

import java.util.List;

import javax.annotation.Resource;

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
			session.close();
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
	 * 修改用户信息
	 * 
	 * @param user
	 */
	@Override
	public void updateUser(User user) {
		
		Session session = null; // 定义Session
		Transaction tx = null; // 定义事务
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.update(user);
			tx.commit(); // 提交
			session.close();
		} catch (Exception e) {
			tx.rollback(); // 出现异常回滚
		}
		
	}
	
	
	/**
	 * 修改密码
	 */
	@Override
	public void updatePassword(String uid, String password) {
		
		String hsql = "update user set password=:password where u_id=:uid";
		
		Session session = null; // 定义Session
		Transaction tx = null; // 定义事务
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			Query query = session.createQuery(hsql);
			query.setParameter("password", password);
			query.setParameter("uid", uid);
			query.executeUpdate();
			tx.commit(); // 提交
			session.close();
		} catch (Exception e) {
			tx.rollback(); // 出现异常回滚
		}

	}
	
	
	/**
	 * 修改用户状态
	 */
	@Override
	public void updateStatus(String uid, boolean status) {

		String hsql = "update user set status=:status where u_id=:uid";
	
		Session session = null; // 定义Session
		Transaction tx = null; // 定义事务
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			Query query = session.createQuery(hsql);
			query.setParameter("status", status);
			query.setParameter("uid", uid);
			query.executeUpdate();
			tx.commit(); // 提交
			session.close();
		} catch (Exception e) {
			tx.rollback(); // 出现异常回滚
		}
		
	}
	
	/**
	 * 修改邮箱
	 */
	@Override
	public void updateEmail(String uid, String email) {
		
		String hsql = "update user set email=:email where u_id=:uid";
		
		Session session = null; // 定义Session
		Transaction tx = null; // 定义事务
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			Query query = session.createQuery(hsql);
			query.setParameter("email", email);
			query.setParameter("uid", uid);
			query.executeUpdate();
			tx.commit(); // 提交
			session.close();
		} catch (Exception e) {
			tx.rollback(); // 出现异常回滚
		}
		
	}
	
	/**
	 * 修改头像
	 */
	@Override
	public void updateUserImg(String uid, String img_url) {
		
		String hsql = "update user set user_img=:img_url where u_id=:uid";
		
		Session session = null; // 定义Session
		Transaction tx = null; // 定义事务
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			Query query = session.createQuery(hsql);
			query.setParameter("img_url", img_url);
			query.setParameter("uid", uid);
			query.executeUpdate();
			tx.commit(); // 提交
			session.close();
		} catch (Exception e) {
			tx.rollback(); // 出现异常回滚
		}
		
	}
	
	/**
	 * 修改发布消息数
	 */
	@Override
	public void updateUserMessageNum(String uid,boolean isAdd){
		String hsql;
		if(isAdd){
			hsql = "update user set message_num=message_num+1 where u_id=:uid";
		}else{
			hsql = "update user set message_num=message_num-1 where u_id=:uid";
		}
		
		Session session = null; // 定义Session
		Transaction tx = null; // 定义事务
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			Query query = session.createQuery(hsql);
			query.setParameter("uid", uid);
			query.executeUpdate();
			tx.commit(); // 提交
			session.close();
		} catch (Exception e) {
			tx.rollback(); // 出现异常回滚
		}
		
	}
	
	/**
	 * 修改关注数
	 */
	@Override
	public void updateUserFollowNum(String uid,boolean isAdd){
		String hsql;
		if(isAdd){
			hsql = "update user set follow_num=follow_num+1 where u_id=:uid";
		}else{
			hsql = "update user set follow_num=follow_num-1 where u_id=:uid";
		}
		
		Session session = null; // 定义Session
		Transaction tx = null; // 定义事务
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			Query query = session.createQuery(hsql);
			query.setParameter("uid", uid);
			query.executeUpdate();
			tx.commit(); // 提交
			session.close();
		} catch (Exception e) {
			tx.rollback(); // 出现异常回滚
		}
		
	}
	
	/**
	 * 修改被关注数
	 */
	@Override
	public void updateUserFollowedNum(String uid,boolean isAdd){
		String hsql;
		if(isAdd){
			hsql = "update user set followed_num=followed_num+1 where u_id=:uid";
		}else{
			hsql = "update user set followed_num=followed_num-1 where u_id=:uid";
		}
		
		Session session = null; // 定义Session
		Transaction tx = null; // 定义事务
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			Query query = session.createQuery(hsql);
			query.setParameter("uid", uid);
			query.executeUpdate();
			tx.commit(); // 提交
			session.close();
		} catch (Exception e) {
			tx.rollback(); // 出现异常回滚
		}
		
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
		session.close();
		return user_list;
	}

	/**
	 * 根据账号和密码查询
	 */
	@Override
	public User queryByLoginnameAndLoginpass(String loginname, String loginpass) {

		String hsql = "from user where nickname=:loginname and password=:loginpass";
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(hsql);
		query.setParameter("loginname", loginname);
		query.setParameter("loginpass", loginpass);
		User user = (User) query.uniqueResult();
		session.close();
		return user;
	}
	
	/**
	 * 根据id和密码查询
	 */
	@Override
	public boolean queryByUidAndPassword(String uid, String password) {
		String hsql = "select count(*) from user where u_id=:uid and password=:password";
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(hsql);
		query.setParameter("uid", uid);
		query.setParameter("password", password);
		long i = (long)query.uniqueResult();
		session.close();
		return  i==1?true:false;
	}

	
	/**
	 * 根据id查找用户
	 */
	@Override
	public User queryByUid(String uid) {
		String hsql = "from user where u_id=:uid";
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(hsql);
		query.setParameter("uid", uid);
		User user = (User) query.uniqueResult();
		session.close();
		return user;
	}
	
	
	/**
	 * 通过激活码查找用户
	 */
	@Override
	public User queryByActivationCode(String code){
		String hsql = "from user where activationCode=:code";
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(hsql);
		query.setParameter("code", code);
		User user = (User) query.uniqueResult();
		session.close();
		return user;
	}
	

	/**
	 * 检验用户名是否注册
	 */
	public boolean ajaxValidateLoginname(String loginname) {

		String hsql = "select count(*) from user where nickname=:loginname";
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(hsql);
		query.setParameter("loginname", loginname);
		long i =  (long) query.uniqueResult();
		session.close();
		return i == 1;
	}

	

	/**
	 * 校验email是否注册
	 */
	@Override
	public boolean ajaxValidateEmail(String email) {

		String hsql = "select count(*) from user where email=:email";
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(hsql);
		query.setParameter("email", email);
		long i = (long) query.uniqueResult();
		session.close();
		return  i == 1;
	}
	
	/**
	 * 校验password是否正确
	 */
	@Override
	public boolean ajaxValidatePassword(String u_id,String password) {
		
		String hsql = "select count(*) from user where password=:password and u_id=:u_id";
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(hsql);
		query.setParameter("password", password);
		query.setParameter("u_id", u_id);
		long i = (long) query.uniqueResult();
		session.close();
		return  i == 1;
	}

		

}

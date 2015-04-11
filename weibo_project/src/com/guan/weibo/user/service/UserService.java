package com.guan.weibo.user.service;

import java.sql.Timestamp;
import java.util.List;

import com.guan.weibo.user.dao.UserDao;
import com.guan.weibo.user.domain.User;

public class UserService {

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	private UserDao userDao;

	/**
	 * 查询所有用户
	 * 
	 * @return
	 */
	public List<User> queryAll() {
		return userDao.queryList();
	}

	/**
	 * 异步验证用户名是否已注册
	 * @param loginname
	 * @return
	 */
	public boolean ajaxValidateLoginname(String loginname) {
		try {
			return userDao.ajaxValidateLoginname(loginname);
		} catch (Exception e) {
			throw new RuntimeException("查询邮箱失败！");
		}
	}

	/**
	 * 异步验证邮箱是否已注册
	 * @param email
	 * @return
	 */
	public boolean ajaxValidateEmail(String email) {
		try {
			return userDao.ajaxValidateEmail(email);
		} catch (Exception e) {
			throw new RuntimeException("查询邮箱失败！");
		}
	}

	/**
	 * 注册功能
	 * @param user
	 */
	public void regist(User user) {
		try {
			user.setUser_datetime(new Timestamp(System.currentTimeMillis()));
			userDao.save(user);
		} catch (Exception e) {
			throw new RuntimeException("注册失败！");
		}

		/**
		 * 发邮件
		 */
		
		

	}

	/**
	 * 登录功能
	 * 
	 * @param user
	 * @return
	 */
	public User login(String loginname, String loginpass) {
		User user = null;
		try {
			user = userDao.queryByLoginnameAndLoginpass(loginname, loginpass);
		} catch (Exception e) {
			throw new RuntimeException("登录失败！");
		}
		return user;
	}

	
	/**
	 * 修改密码
	 * @param uid
	 * @param newPass
	 * @param oldPass
	 */
	public void updatePassword(String uid,String newPass,String oldPass){
		try {
			//1、校验老密码
			boolean bool = userDao.queryByUidAndPassword(uid, oldPass);
			if(!bool){
//				throw new UserException("原密码错误！");
			}
			
			//2、修改新密码
			userDao.updatePassword(uid, newPass);
			
		} catch (Exception e) {
			throw new RuntimeException("修改密码失败！");
		}
	}
	
	
	/**
	 *根据id查找用户信息 
	 * @param uid
	 * @return
	 */
	public User findByUid(String uid){
		User user = null;
		try {
			user = userDao.queryByUid(uid);
		} catch (Exception e) {
			throw new RuntimeException("根据id查找用户信息");
		}
		return user;
	}
	
	
	/**
	 * 修改用户信息
	 * @param user
	 */
	public void updateUserInfo(User user){
		try {
			userDao.updateUser(user);
		} catch (Exception e) {
			throw new RuntimeException("修改用户信息失败！");
		}
		
	}

	public UserService() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	
	
}

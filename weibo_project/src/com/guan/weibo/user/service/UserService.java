package com.guan.weibo.user.service;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.List;
import java.util.Properties;

import javax.mail.Session;

import com.guan.weibo.mail.Mail;
import com.guan.weibo.user.dao.UserDao;
import com.guan.weibo.user.domain.User;
import com.guan.weibo.utils.CommonUtils;
import com.guan.weibo.utils.MailUtils;

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
		try {
			return userDao.queryList();
		} catch (Exception e) {
			throw new RuntimeException("查询所有用户失败！");
		}
	}

	/**
	 * 异步验证用户名是否已注册
	 * 
	 * @param loginname
	 * @return
	 */
	public boolean ajaxValidateLoginname(String loginname) {
		try {
			return userDao.ajaxValidateLoginname(loginname);
		} catch (Exception e) {
			throw new RuntimeException("异步验证用户名失败！");
		}
	}

	/**
	 * 异步验证邮箱是否已注册
	 * 
	 * @param email
	 * @return
	 */
	public boolean ajaxValidateEmail(String email) {
		try {
			return userDao.ajaxValidateEmail(email);
		} catch (Exception e) {
			throw new RuntimeException("异步验证邮箱失败！");
		}
	}

	/**
	 * 校验password是否正确
	 */
	public boolean ajaxValidatePassword(String u_id, String password) {
		return userDao.ajaxValidatePassword(u_id, password);
	}

	/**
	 * 注册功能
	 * 
	 * @param user
	 */
	public void regist(User user) {
		
		user.setActivationCode(CommonUtils.uuid()+CommonUtils.uuid());
		
		userDao.save(user);

		/**
		 * 发邮件
		 */
		// 3、发邮件

		// 把配置文件加载到prop中
		Properties prop = new Properties();
		try {
			prop.load(this.getClass().getClassLoader().getResourceAsStream("email_template.properties"));
		} catch (IOException e1) {
			throw new RuntimeException(e1);
		}

		// 登录邮件服务器得到session
		String host = prop.getProperty("host");// 服务器主机名
		String name = prop.getProperty("username");// 登录名
		String pass = prop.getProperty("password");// 登录密码
		Session session = MailUtils.createSession(host, name, pass);

		// 创建mail对象
		String from = prop.getProperty("from");
		String to = user.getEmail();
		String subject = prop.getProperty("subject");
		// Message .format方法会把第一个参数中的{0}，使用第二个参数来替换。
		// 例如Message.format("你好{0}，{1}"，"张三"，"拜拜");返回“你好张三，拜拜”
		String content = MessageFormat.format(prop.getProperty("content"), user.getActivationCode());
		Mail mail = new Mail(from, to, subject, content);

		// 发送邮件
		try {
			MailUtils.send(session, mail);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	
	/**
	 * 激活功能
	 * @param code
	 */
	public void activation(String code){
		/**
		 * 1、通过激活码查询用户
		 * 2、如果User是null，说明是无效激活码，抛出异常，发出异常信息。(无效激活码)
		 * 3、查看用户激活状态是否为true，如果为true，抛出异常，发出异常信息。(二次激活)
		 * 4、修改用户状态为true
		 */
		try {
			User user = userDao.queryByActivationCode(code);
			if(user==null) throw new RuntimeException("无效的激活码！");
			if(user.getStatus())throw  new RuntimeException("您已激活，不要二次激活！");
		
			userDao.updateStatus(user.getU_id(), true);
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
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
	 * 
	 * @param uid
	 * @param newPass
	 * @param oldPass
	 */
	public void updatePassword(String uid, String newPass, String oldPass) {
		try {
			// 1、校验老密码
			boolean bool = userDao.queryByUidAndPassword(uid, oldPass);
			if (!bool) {
				System.out.println("原密码：" + bool);
				return;
			}
			// 2、修改新密码
			userDao.updatePassword(uid, newPass);
		} catch (Exception e) {
			throw new RuntimeException("修改密码失败！");
		}
	}

	/**
	 * 修改邮箱
	 */
	public void updateEmail(String uid, String email) {
		userDao.updateEmail(uid, email);
	}

	/**
	 * 修改头像
	 */
	public void updateUserImg(String uid, String img_url) {
		userDao.updateUserImg(uid, img_url);
	}

	/**
	 * 根据id查找用户信息
	 * 
	 * @param uid
	 * @return
	 */
	public User queryByUid(String uid) {
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
	 * 
	 * @param user
	 */
	public void updateUserInfo(User user) {
		try {
			userDao.updateUser(user);
		} catch (Exception e) {
			throw new RuntimeException("修改用户信息失败！");
		}

	}
	
	/**
	 * 修改发布消息数
	 */
	public void updateUserMessageNum(String uid,boolean isAdd){
		
		userDao.updateUserMessageNum(uid, isAdd);
		
	}
	
	/**
	 * 修改关注数
	 */
	public void updateUserFollowNum(String uid,boolean isAdd){
		userDao.updateUserFollowNum(uid, isAdd);
	}
	
	/**
	 * 修改被关注数
	 */
	public void updateUserFollowedNum(String uid,boolean isAdd){
		userDao.updateUserFollowedNum(uid, isAdd);
	}
	
	

	public UserService() {
		super();
	}

}

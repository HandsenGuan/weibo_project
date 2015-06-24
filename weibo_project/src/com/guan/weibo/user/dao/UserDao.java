package com.guan.weibo.user.dao;

import java.util.List;

import com.guan.weibo.user.domain.User;

public interface UserDao {

	/**
	 * 添加用户
	 */
	public void save(User user);

	/**
	 * 删除用户
	 */
	public void deleteById(String id);

	/**
	 * 查询所有
	 */
	public List<User> queryList();

	/**
	 * 通过用户名和密码查询
	 */
	public User queryByLoginnameAndLoginpass(String loginname, String loginpass);

	/**
	 * 通过id和密码查询
	 */
	public boolean queryByUidAndPassword(String uid, String password);

	/**
	 * 通过激活码查找用户
	 */
	public User queryByActivationCode(String code);
	
	/**
	 * 通过激活码查找用户
	 */
	public User queryByUid(String uid);

	/**
	 * 检验用户名是否注册
	 */
	public boolean ajaxValidateLoginname(String loginname);

	/**
	 * 校验email是否注册
	 */
	public boolean ajaxValidateEmail(String email);

	/**
	 * 校验用户密码
	 * 
	 * @param u_id
	 * @param email
	 * @return
	 */
	public boolean ajaxValidatePassword(String u_id, String password);

	/**
	 * 修改用户状态
	 */
	public void updateStatus(String uid, boolean status);

	/**
	 * 修改密码
	 */
	public void updatePassword(String uid, String password);
	
	/**
	 * 修改密码
	 */
	public void updateEmail(String uid, String email);

	/**
	 * 修改用户头像
	 * @param uid
	 * @param img_url
	 */
	public void updateUserImg(String uid, String img_url);
	/**
	 * 修改用户信息
	 * 
	 * @param user
	 */
	public void updateUser(User user);
	
	/**
	 * 修改发布消息数
	 */
	public void updateUserMessageNum(String uid,boolean isAdd);
	
	/**
	 * 修改关注数
	 */
	public void updateUserFollowNum(String uid,boolean isAdd);
	
	/**
	 * 修改被关注数
	 */
	public void updateUserFollowedNum(String uid,boolean isAdd);

}
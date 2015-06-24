package com.guan.weibo.user.dao;

import java.util.List;

import com.guan.weibo.user.domain.GroupUser;

public interface GroupUserDao {

	/**
	 * 添加群用户对象
	 * @param group_user
	 */
	public void add(GroupUser group_user);
	
	/**
	 * 删除指定id群中的用户id
	 * @param u_id
	 * @param g_id
	 */
	public void delete(String u_id,String g_id);
	
	/**
	 * 根据用户id修改用户等级
	 * @param u_id
	 * @param level
	 */
	public void updateLevelByUidAndGid(String g_id,String u_id,int level);
	
	/**
	 * 根据群id查询该群下所有的用户id
	 * @param g_id
	 */
	public List<GroupUser> queryUsersByGid(String g_id);
	
	
	/**
	 * 根据用户id查询用户所在的所有的群
	 * @param u_id
	 */
	public List<GroupUser> queryGroupsByUid(String u_id);
	
}

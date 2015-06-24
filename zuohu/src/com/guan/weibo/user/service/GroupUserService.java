package com.guan.weibo.user.service;

import java.util.List;

import com.guan.weibo.user.dao.GroupUserDao;
import com.guan.weibo.user.domain.GroupUser;

public class GroupUserService {
	
	private GroupUserDao groupUserDao;

	public GroupUserDao getGroupUserDao() {
		return groupUserDao;
	}

	public void setGroupUserDao(GroupUserDao groupUserDao) {
		this.groupUserDao = groupUserDao;
	}
	
	/**
	 * 添加群用户对象
	 * 
	 * @param group_user
	 */
	public void add(GroupUser group_user) {
		
		try {
			groupUserDao.add(group_user);
		} catch (Exception e) {
			throw new RuntimeException("添加群用户对象失败！");
		}
		
	}
	
	
	/**
	 * 删除指定id群中的用户id
	 * 
	 * @param u_id
	 * @param g_id
	 */
	public void delete(String u_id, String g_id) {
		try {
			groupUserDao.delete(u_id, g_id);
		} catch (Exception e) {
			throw new RuntimeException("删除指定id群中的用户id失败！");
		}
	}
	
	/**
	 * 根据用户id修改用户等级
	 * 
	 * @param u_id
	 * @param level
	 */
	public void updateLevelByUidAndGid(String g_id , String u_id, int level) {
		try {
			groupUserDao.updateLevelByUidAndGid(g_id , u_id , level);
		} catch (Exception e) {
			throw new RuntimeException("根据用户id修改用户等级失败！");
		}
	}
	
	/**
	 * 根据群id查询该群下所有的用户id
	 * 
	 * @param g_id
	 */
	public List<GroupUser> queryUsersByGid(String g_id) {
		List<GroupUser> group_users = null;
		try {
			group_users =  groupUserDao.queryUsersByGid(g_id);
		} catch (Exception e) {
			throw new RuntimeException("根据群id查询该群下所有的用户id失败！");
		}
		return group_users;
	}
	
	/**
	 * 根据用户id查询用户所在的所有的群
	 * 
	 * @param u_id
	 */
	public List<GroupUser> queryGroupsByUid(String u_id) {
		List<GroupUser> group_users = null;
		try {
			group_users =  groupUserDao.queryGroupsByUid(u_id);
		} catch (Exception e) {
			throw new RuntimeException("根据用户id查询用户所在的所有的群失败！");
		}
		return group_users;
	}
	
	
}

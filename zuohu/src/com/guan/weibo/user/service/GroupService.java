package com.guan.weibo.user.service;

import com.guan.weibo.user.dao.GroupDao;
import com.guan.weibo.user.domain.Group;

public class GroupService {
	
	private GroupDao groupDao;

	public GroupDao getGroupDao() {
		return groupDao;
	}

	public void setGroupDao(GroupDao groupDao) {
		this.groupDao = groupDao;
	}


	/**
	 * 新建群
	 * @param group
	 */
	public void add(Group group){
		try {
			groupDao.add(group);
		} catch (Exception e) {
			throw new RuntimeException("新建群失败！");
		}
		
	}
	
	/**
	 * 删除指定id群
	 * @param g_id
	 */
	public void delete(String g_id){
		
		try {
			groupDao.delete(g_id);
		} catch (Exception e) {
			throw new RuntimeException("删除指定id群失败！");
		}
		
	}
	
	
	/**
	 * 修改群信息
	 * @param group
	 */
	public void updateGroup(Group group){
		
		try {
			groupDao.updateGroup(group);
		} catch (Exception e) {
			throw new RuntimeException("修改群信息失败！");
		}
		
	}
	
	/**
	 * 更新指定id的群名
	 * 
	 * @param g_id
	 * @param name
	 */
	public void updateGroupName(String g_id, String name) {
		
		try {
			groupDao.updateGroupName(g_id, name);
		} catch (Exception e) {
			throw new RuntimeException("更新指定id的群名失败！");
		}
		
	}
	
	/**
	 * 根据id查询群信息
	 */
	public Group queryGroupById(String g_id) {
		Group group = null;
		
		try {
			group = groupDao.queryGroupById(g_id);
		} catch (Exception e) {
			throw new RuntimeException("根据id查询群信息失败！");
		}
		
		return group;
	}
	

}

package com.guan.weibo.user.dao;

import com.guan.weibo.user.domain.Group;

public interface GroupDao {

	/**
	 * 添加群
	 * @param group
	 */
	public void add(Group group);
	
	/**
	 * 根据id删除群
	 * @param g_id
	 */
	public void delete(String g_id);
	
	/**
	 * 根据id修改群信息
	 * @param g_id
	 * @param group
	 */
	public void updateGroup(Group group );
	
	/**
	 * 更新指定id的群名
	 * @param g_id
	 * @param name
	 */
	public void updateGroupName(String g_id,String name);
	
	
	/**
	 * 根据id查询群信息
	 * @param g_id
	 * @return
	 */
	public Group queryGroupById(String g_id);
	
}

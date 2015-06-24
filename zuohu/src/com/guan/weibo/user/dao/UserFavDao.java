package com.guan.weibo.user.dao;

import java.util.List;

import com.guan.weibo.user.domain.UserFav;

public interface UserFavDao {

	/**
	 * 添加一个用户关注信息
	 * @param userFav
	 */
	public void add(UserFav userFav);
	
	/**
	 * 删除一个用户关注信息
	 * @param userFav
	 */
	public void delete(String fav_id);
	
	
	/**
	 * 根据用户id查询关注信息
	 * @param u_id
	 */
	public List<UserFav> queryByUid(String u_id);
	
	
	/**
	 * 根据用户id与消息id查询关注消息
	 * @param u_id
	 * @param m_id
	 */
	public boolean queryByUidAndMid(String u_id,String m_id);
	
}

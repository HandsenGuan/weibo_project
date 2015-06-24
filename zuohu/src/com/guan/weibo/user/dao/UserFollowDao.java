package com.guan.weibo.user.dao;

import java.util.List;

import com.guan.weibo.user.domain.UserFollow;

public interface UserFollowDao {
	
	/**
	 * 添加关注用户记录
	 * @param userFollow
	 */
	public void add(UserFollow userFollow);
	
	/**
	 * 删除关注用户的记录
	 * @param f_id
	 */
	public void delete(String f_id);
	
	/**
	 * 根据用户id查询关注记录
	 * @param u_id
	 * @return
	 */
	public List<UserFollow> queryByUid(String u_id);
	
	/**
	 * 根据用户id与被关注用户id查询是否关注
	 * @param u_id
	 * @param fu_id
	 * @return
	 */
	public boolean queryByUidAndFuid(String u_id,String fu_id);

}

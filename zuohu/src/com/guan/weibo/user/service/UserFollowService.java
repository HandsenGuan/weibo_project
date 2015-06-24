package com.guan.weibo.user.service;

import java.util.List;

import com.guan.weibo.user.dao.UserFollowDao;
import com.guan.weibo.user.domain.UserFollow;

public class UserFollowService {
	
	private UserFollowDao userFollowDao;

	public UserFollowDao getUserFollowDao() {
		return userFollowDao;
	}

	public void setUserFollowDao(UserFollowDao userFollowDao) {
		this.userFollowDao = userFollowDao;
	}
	
	/**
	 * 添加关注用户记录
	 * 
	 * @param userFollow
	 */
	public void add(UserFollow userFollow) {
		
		try {
			userFollowDao.add(userFollow);
		} catch (Exception e) {
			throw new RuntimeException("添加关注用户记录 失败！");
		}
		
	}
	
	/**
	 * 删除关注用户的记录
	 * @param f_id
	 */
	public void delete(String f_id) {
		
		try {
			userFollowDao.delete(f_id);
		} catch (Exception e) {
			throw new RuntimeException("删除关注用户的记录 失败！");
		}
		
	}
	
	/**
	 * 根据用户id查询关注记录
	 * @param u_id
	 * @return
	 */
	public List<UserFollow> queryByUid(String u_id) {
		List<UserFollow> userFollows = null;;
		
		try {
			userFollows = userFollowDao.queryByUid(u_id);
		} catch (Exception e) {
			throw new RuntimeException("根据用户id查询关注记录 失败！");
		}
		
		return userFollows;
	}
	
	/**
	 * 根据用户id与被关注用户id查询是否关注
	 * @param u_id
	 * @param fu_id
	 * @return
	 */
	public boolean queryByUidAndFuid(String u_id, String fu_id) {
		
		try {
			return userFollowDao.queryByUidAndFuid(u_id, fu_id);
		} catch (Exception e) {
			throw new RuntimeException("根据用户id与被关注用户id查询是否关注失败！");
		}
		
	}
	
	
	
	
	
	

}

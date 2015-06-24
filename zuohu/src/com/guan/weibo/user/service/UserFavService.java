package com.guan.weibo.user.service;

import java.util.List;

import com.guan.weibo.user.dao.UserDao;
import com.guan.weibo.user.dao.UserFavDao;
import com.guan.weibo.user.domain.UserFav;

public class UserFavService {

	private UserFavDao userFavDao;

	public UserFavDao getUserFavDao() {
		return userFavDao;
	}

	public void setUserFavDao(UserFavDao userFavDao) {
		this.userFavDao = userFavDao;
	}

	public UserFavService() {
		super();
	}

	/**
	 * 添加一个用户关注信息
	 * 
	 * @param userFav
	 */
	public void add(UserFav userFav) {
		try {
			userFavDao.add(userFav);
		} catch (Exception e) {
			throw new RuntimeException("添加一个用户关注信息失败！");
		}
	}
	
	
	/**
	 * 删除一个用户关注信息
	 * 
	 * @param userFav
	 */
	public void delete(String fav_id) {
		
		try {
			userFavDao.delete(fav_id);
		} catch (Exception e) {
			throw new RuntimeException("删除一个用户关注信息失败！");
		}
		
	}
	
	
	/**
	 * 根据用户id查询关注信息
	 * 
	 * @param u_id
	 * @return 
	 */
	public List<UserFav> queryByUid(String u_id) {
		
		List<UserFav> userFavs = null;
		try {
			userFavs =  userFavDao.queryByUid(u_id);
		} catch (Exception e) {
			throw new RuntimeException("根据用户id查询关注信息失败！");
		}
		
		return userFavs;
	}
	
	/**
	 * 根据用户id与消息id查询关注记录
	 */
	public boolean queryByUidAndMid(String u_id, String m_id) {
		
		try {
			return userFavDao.queryByUidAndMid(u_id, m_id);
		} catch (Exception e) {
			throw new RuntimeException("根据用户id与消息id查询关注记录失败！");
		}
		
	}
	
	
	
}

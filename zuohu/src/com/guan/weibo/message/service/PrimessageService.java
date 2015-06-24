package com.guan.weibo.message.service;

import java.util.List;

import com.guan.weibo.message.dao.PrimessageDao;
import com.guan.weibo.message.domain.PriMessage;

public class PrimessageService {

	private PrimessageDao primessageDao;

	public PrimessageDao getPrimessageDao() {
		return primessageDao;
	}

	public void setPrimessageDao(PrimessageDao primessageDao) {
		this.primessageDao = primessageDao;
	}

	public PrimessageService() {
		super();
	}
	
	/**
	 * 添加私信
	 * @param primessage
	 */
	public void add(PriMessage primessage){
		
		try {
			primessageDao.add(primessage);
		} catch (Exception e) {
			throw new RuntimeException("添加私信失败！");
		}
		
	}
	
	/**
	 * 根据id删除私信
	 * @param pm_id
	 */
	public void deleteByPMid(String pm_id){
		
		try {
			primessageDao.deleteByPMid(pm_id);
		} catch (Exception e) {
			throw new RuntimeException("根据id删除私信失败！");
		}
		
	}
	
	/**
	 * 根据id更新私信状态
	 * @param pm_id
	 * @param state
	 */
	public void updatePrimessageStateByPMid(String pm_id){
		
		try {
			primessageDao.updatePrimessageStateByPMid(pm_id);
		} catch (Exception e) {
			throw new RuntimeException("根据id更新私信状态失败！");
		}
		
	}
	
	/**
	 * 根据state更新私信状态
	 * @param pm_id
	 * @param state
	 */
	public void updatePrimessageStateByToAndState(String u_id){
		
		try {
			primessageDao.updatePrimessageStateByToAndState(u_id);
		} catch (Exception e) {
			throw new RuntimeException(" 根据state更新私信状态失败！");
		}
		
	}
	
	
	/**
	 * 根据收信人id查询所有私信
	 * @param id
	 */
	public List<PriMessage> queryPrimessagesByTo(String u_id){
		List<PriMessage> primessages = null;
		
		try {
			primessages = primessageDao.queryPrimessagesByTo(u_id);
		} catch (Exception e) {
			throw new RuntimeException("根据收信人id查询所有私信失败!");
		}
		
		return primessages;
	}
	
	/**
	 * 根据收信人id与发信人id查询所有的私信
	 * @return
	 */
	public List<PriMessage> queryPrimessagesByFromAndTo(String u_id1, String u_id2){
		List<PriMessage> primessages = null;
		
		try {
			primessages = primessageDao.queryPrimessagesByUids(u_id1, u_id2);
		} catch (Exception e) {
			throw new RuntimeException("根据收信人id与发信人id查询所有的私信失败!");
		}
		
		return primessages;
	}
	
	/**
	 * 根据收信用户id和私信状态查询所有的私信
	 * @param to
	 * @param state
	 * @return
	 */
	public List<PriMessage> queryPrimessagesByToAndState(String to,int state){
List<PriMessage> primessages = null;
		
		try {
			primessages = primessageDao.queryPrimessagesByToAndState(to, state);
		} catch (Exception e) {
			throw new RuntimeException("根据收信人id与发信人id查询所有的私信失败!");
		}
		
		return primessages;
	}
	
}

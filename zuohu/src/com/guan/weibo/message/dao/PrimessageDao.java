package com.guan.weibo.message.dao;

import java.util.List;

import com.guan.weibo.message.domain.PriMessage;

public interface PrimessageDao {
	
	/**
	 * 添加私信
	 * @param primessage
	 */
	public void add(PriMessage primessage);
	
	/**
	 * 根据id删除私信
	 * @param pm_id
	 */
	public void deleteByPMid(String pm_id);
	
	/**
	 * 根据id更新私信状态
	 * @param pm_id
	 * @param state
	 */
	public void updatePrimessageStateByPMid(String pm_id);
	
	/**
	 * 根据state更新私信状态
	 * @param pm_id
	 * @param state
	 */
	public void updatePrimessageStateByToAndState(String u_id);
	
	/**
	 * 根据收信人id查询所有私信
	 * @param id
	 */
	public List<PriMessage> queryPrimessagesByTo(String u_id);
	
	/**
	 * 根据收信人id与发信人id查询所有的私信
	 * @return
	 */
	public List<PriMessage> queryPrimessagesByUids(String u_id1,String u_id2);
	
	/**
	 * 根据收信用户id和私信状态查询所有的私信
	 * @param to
	 * @param state
	 * @return
	 */
	public List<PriMessage> queryPrimessagesByToAndState(String to,int state);
	
}

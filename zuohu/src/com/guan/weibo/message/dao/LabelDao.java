package com.guan.weibo.message.dao;

import java.util.List;

import com.guan.weibo.message.domain.Label;

public interface LabelDao {
	
	/**
	 * 添加标签
	 * @param label
	 */
	public void add(Label label);

	/**
	 * 查询前十标签
	 */
	public List<Label> queryTop30Labels();
	
	/**
	 * 根据标签id查询id
	 * @param l_id
	 * @return
	 */
	public Label queryByLid(String l_id);

}

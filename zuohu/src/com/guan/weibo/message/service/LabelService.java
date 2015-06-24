package com.guan.weibo.message.service;

import java.util.List;

import com.guan.weibo.message.dao.LabelDao;
import com.guan.weibo.message.domain.Label;

public class LabelService {

	public LabelService() {
		super();
	}

	private LabelDao labelDao;

	public LabelDao getLabelDao() {
		return labelDao;
	}

	public void setLabelDao(LabelDao labelDao) {
		this.labelDao = labelDao;
	}
	
	/**
	 * 添加标签
	 * @param label
	 */
	public void add(Label label) {
		try {
			labelDao.add(label);
		} catch (Exception e) {
			throw new RuntimeException("发布消息失败！");
		}
	}
	
	/**
	 * 查询前十标签
	 */
	public List<Label> queryTop30Labels() {
		List<Label> labels = null;
		try {
			labels = labelDao.queryTop30Labels();
		} catch (Exception e) {
			throw new RuntimeException("发布消息失败！");
		}
    
		return labels;
		
	}
	
	
	/**
	 * 根据标签id查询id
	 * @param l_id
	 * @return
	 */
	public Label queryByLid(String l_id) {
		try {
			return labelDao.queryByLid(l_id);
		} catch (Exception e) {
			throw new RuntimeException("发布消息失败！");
		}
		
	}
	
	
}

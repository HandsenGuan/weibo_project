package com.guan.weibo.message.dao;

import java.util.List;

import com.guan.weibo.message.domain.Image;

public interface ImageDao {

	/**
	 * 添加图片
	 * @param image
	 */
	public void add(Image image);

	/**
	 * 删除指定id的图片
	 * @param img_id
	 */
	public void deleteByImgid(String img_id);
	
	/**
	 * 删除指定状态id的所有图片
	 * @param m_id
	 */
	public void deleteByMid(String m_id);
	
	
	/**
	 * 修改图片信息
	 * @param image
	 */
	public void update(Image image);

	
	/**
	 * 根据状态id查询所有的图片
	 * @param m_id
	 * @return
	 */
	public List<Image> queryImagesByMid(String m_id);
	
	/**
	 * 根据id查询照片
	 * @param img_id
	 * @return
	 */
	public Image queryImageByImgid(String img_id);
	
}

package com.guan.weibo.message.service;

import java.util.List;

import com.guan.weibo.message.dao.ImageDao;
import com.guan.weibo.message.domain.Image;

public class ImageService {

	private ImageDao imageDao;

	public ImageDao getImageDao() {
		return imageDao;
	}

	public void setImageDao(ImageDao imageDao) {
		this.imageDao = imageDao;
	}
	
	
	/**
	 * 添加图片
	 * @param image
	 */
	public void add(Image image) {
		try {
			imageDao.add(image);
		} catch (Exception e) {
			throw new RuntimeException("添加图片失败！");
		}
	}
	
	/**
	 * 删除指定id的图片
	 * 
	 * @param img_id
	 */
	public void deleteByImgid(String img_id) {
		try {
			imageDao.deleteByImgid(img_id);
		} catch (Exception e) {
			throw new RuntimeException("删除指定id的图片失败！");
		}
	}
	
	
	/**
	 * 删除指定状态id的所有图片
	 * @param m_id
	 */
	public void deleteByMid(String m_id) {
		try {
			imageDao.deleteByMid(m_id);
		} catch (Exception e) {
			throw new RuntimeException("删除指定状态id的所有图片失败！");
		}
	}
	
	/**
	 * 修改图片信息
	 * @param image
	 */
	public void update(Image image) {
		try {
			imageDao.update(image);
		} catch (Exception e) {
			throw new RuntimeException("修改图片信息失败！");
		}
	}
	
	/**
	 * 根据状态id查询所有的图片
	 * @param m_id
	 * @return
	 */
	public List<Image> queryImagesByMid(String m_id) {
		List<Image> images = null;
		try {
			images = imageDao.queryImagesByMid(m_id);
		} catch (Exception e) {
			throw new RuntimeException("根据状态id查询所有的图片失败！");
		}
		
		return images;
		
	}
	
	/**
	 * 根据id查询照片
	 * @param img_id
	 * @return
	 */
	public Image queryImageByImgid(String img_id) {
		try {
			return imageDao.queryImageByImgid(img_id);
		} catch (Exception e) {
			throw new RuntimeException("根据状态id查询所有的图片失败！");
		}
		
	}
	
}

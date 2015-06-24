package com.guan.weibo.message.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.guan.weibo.message.domain.Image;

public class ImageDaoImpl implements ImageDao {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * 添加图片
	 * 
	 * @param image
	 */
	@Override
	public void add(Image image) {
		Session session = null; // 定义Session
		Transaction tx = null; // 定义事务
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.save(image);
			tx.commit(); // 提交
			session.close();
		} catch (Exception e) {
			tx.rollback(); // 出现异常回滚
		}

	}

	/**
	 * 删除指定id的图片
	 * 
	 * @param img_id
	 */
	@Override
	public void deleteByImgid(String img_id) {
		// 拼装sql语句
		String hsql = "delete from image where img_id=:img_id";
		Session session = null; // 定义Session
		Transaction tx = null; // 定义事务
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();

			Query query = session.createQuery(hsql);
			query.setParameter("img_id", img_id);
			query.executeUpdate();

			tx.commit(); // 提交
			session.close();
		} catch (Exception e) {
			tx.rollback(); // 出现异常回滚
		}
	}

	/**
	 * 删除指定状态id的所有图片
	 * 
	 * @param m_id
	 */
	@Override
	public void deleteByMid(String m_id) {
		// 拼装sql语句
		String hsql = "delete from image where m_id=:m_id";
		Session session = null; // 定义Session
		Transaction tx = null; // 定义事务
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();

			Query query = session.createQuery(hsql);
			query.setParameter("m_id", m_id);
			query.executeUpdate();

			tx.commit(); // 提交
			session.close();
		} catch (Exception e) {
			tx.rollback(); // 出现异常回滚
		}

	}

	/**
	 * 修改图片信息
	 * 
	 * @param image
	 */
	@Override
	public void update(Image image) {
		Session session = null; // 定义Session
		Transaction tx = null; // 定义事务
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.flush();
			session.update(image);
			tx.commit(); // 提交
			session.close();
		} catch (Exception e) {
			tx.rollback(); // 出现异常回滚
		}

	}

	/**
	 * 根据状态id查询所有的图片
	 * 
	 * @param m_id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Image> queryImagesByMid(String m_id) {
		List<Image> list = null;
		String hsql = "from image where m_id=:m_id";
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(hsql);
		query.setParameter("m_id", m_id);
		list = query.list();
		session.close();
		return list;
	}

	/**
	 * 根据id查询照片
	 * 
	 * @param img_id
	 * @return
	 */
	@Override
	public Image queryImageByImgid(String img_id) {
		String hsql = "from image where img_id=:img_id";
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(hsql);
		query.setParameter("img_id", img_id);
		Image image = (Image)query.uniqueResult();
		session.close();
		return image;
	}

}

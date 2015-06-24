package com.guan.weibo.message.dao;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.guan.weibo.message.domain.Message;
import com.guan.weibo.user.domain.UserFollow;
import com.guan.weibo.user.service.UserFollowService;

public class MessageDaoImpl implements MessageDao {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private UserFollowService userFollowService;

	public UserFollowService getUserFollowService() {
		return userFollowService;
	}

	public void setUserFollowService(UserFollowService userFollowService) {
		this.userFollowService = userFollowService;
	}

	/**
	 * 添加消息
	 */
	@Override
	public void save(Message message) {
		Session session = null; // 定义Session
		Transaction tx = null; // 定义事务
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.save(message);
			tx.commit(); // 提交
			session.close();
		} catch (Exception e) {
			tx.rollback(); // 出现异常回滚
		}

	}

	/**
	 * 根据id删除消息
	 * 
	 * @param id
	 */
	@Override
	public void deleteById(String id) {
		// 拼装sql语句
		String hsql = "delete from message where m_id=:m_id";
		Session session = null; // 定义Session
		Transaction tx = null; // 定义事务
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			
			Query query = session.createQuery(hsql);
			query.setParameter("m_id", id);
			query.executeUpdate();
			
			tx.commit(); // 提交
			session.close();
		} catch (Exception e) {
			tx.rollback(); // 出现异常回滚
		}
		

	}
	
	
	/**
	 * 根据id修改消息
	 */
	@Override
	public void update(Message message) {
		
		Session session = null; // 定义Session
		Transaction tx = null; // 定义事务
		
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.update(message);
			tx.commit(); // 提交
			session.close();
		} catch (Exception e) {
			tx.rollback(); // 出现异常回滚
		}
		
	}
	

	/**
	 * 查询指定user_id的所有消息
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Message> queryMessagesByUid(String user_id) {
		List<Message> list = null;
		String hsql = "from message where u_id=:user_id";
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(hsql);
		query.setParameter("user_id", user_id);
		list = query.list();
		session.close();
		return list;
	}

	/**
	 * 查询指定uid的所有消息数量
	 * 
	 * @param user_id
	 * @return
	 */
	@Override
	public long queryCountByUid(String user_id) {
		String hsql = "select count(*) from message where u_id=:uid";
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(hsql);
		query.setParameter("uid", user_id);
		long count = (long) query.uniqueResult();
		session.close();
		return count;
	}




	/**
	 * 查询评论次数
	 * 
	 * @param m_id
	 * @return
	 */
	@Override
	public int queryReplyNum(String m_id) {
		String hsql = "select reply_num from message where m_id=:m_id";
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(hsql);
		query.setParameter("m_id", m_id);
		int replyNum = (int)query.uniqueResult();
		session.close();
		return replyNum;
	}

	/**
	 * 查询发布时间
	 * 
	 * @param m_id
	 * @return
	 */
	@Override
	public Timestamp queryTime(String m_id) {
		String hsql = "select time from message where m_id=:m_id";
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(hsql);
		query.setParameter("m_id", m_id);
		Timestamp time = (Timestamp)query.uniqueResult();
		session.close();
		return time;
	}

	
	
	
	/**
	 * 根据id查询浏览次数
	 */
	@Override
	public int queryScanNum(String m_id) {
		String hsql = "select scan_num from message where m_id=:m_id";
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(hsql);
		query.setParameter("m_id", m_id);
		int scanNum = (int)query.uniqueResult();
		session.close();
		return scanNum;
	}

	/**
	 *根据消息id查询消息类型
	 */
	@Override
	public int queryTypeByUid(String m_id) {
		String hsql = "select type from message where m_id=:m_id";
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(hsql);
		query.setParameter("m_id", m_id);
		int type = (int)query.uniqueResult();
		session.close();
		
		return type;
	}

	/**
	 * 根据消息id查询消息
	 */
	@Override
	public Message queryMessageByMid(String m_id) {
		String hsql = "from message where m_id=:m_id";
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(hsql);
		query.setParameter("m_id", m_id);
		
		Message message = (Message)query.uniqueResult();
		
		session.close();
		
		return message;
	}

	/**
	 * 根据时间查询状态id
	 * @param time
	 * @return
	 */
	@Override
	public Message queryMessageByTime(Timestamp time) {
		String hsql = "from message where time=:time";
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(hsql);
		query.setParameter("time", time);
		
		Message message = (Message)query.uniqueResult();
		
		session.close();
		
		return message;
	}
	
	
	/**
	 * 分页查询一页消息
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Message> queryByPageAndUid(String user_id, int pageNum, int pageSize) {
		//查询用户关注表
		List<UserFollow> userfollows =  userFollowService.queryByUid(user_id);
		List<String> ids = new ArrayList<String>();
		if(userfollows!=null){
			for(int i=0;i<userfollows.size();i++){
				ids.add(userfollows.get(i).getFuser().getU_id());
			}
		}
		
		StringBuffer hsql = new StringBuffer("from message where u_id in (");
		//拼装hsql
		for(String id :ids){
			hsql.append("'"+id+"',");
		}
		
		hsql.append("'"+user_id + "') order by time desc");
			
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(hsql.toString());
		query.setFirstResult((pageNum-1)*pageSize);
		query.setMaxResults(pageSize);
		
		List<Message> messages =  (List<Message>)query.list();
		session.close();
		return messages;
	}
	/**
	 * 根据用户id查询用户关注及自己发的消息的总数
	 * @param user_id
	 * @return
	 */
	@Override
	public long queryTotalCountByUid(String user_id) {
		
		List<UserFollow> userfollows =  userFollowService.queryByUid(user_id);
		
		List<String> ids = new ArrayList<String>();
		if(userfollows!=null){
			for(int i=0;i<userfollows.size();i++){
				ids.add(userfollows.get(i).getFuser().getU_id());
			}
		}
		
		StringBuffer hsql = new StringBuffer("select count(*) from message where u_id in (");
		
		for(String id :ids){
			hsql.append("'"+id+"',");
		}
		
		hsql.append("'"+user_id + "')");
			
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(hsql.toString());
		long count = (long) query.uniqueResult();
		session.close();
		return count;
	}
	
	

}

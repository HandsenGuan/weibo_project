package com.guan.weibo.message.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.hibernate.Query;
import org.hibernate.Session;

import com.guan.weibo.message.dao.MessageDao;
import com.guan.weibo.message.domain.Message;

public class MessageService {
	
	private MessageDao messageDao;
	
	public MessageService() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MessageDao getMessageDao() {
		return messageDao;
	}

	public void setMessageDao(MessageDao messageDao) {
		this.messageDao = messageDao;
	}

	/**
	 * 发布消息
	 */
	public void publishMessage(Message message ){
		try {
			messageDao.save(message);
		} catch (Exception e) {
			throw new RuntimeException("发布消息失败！");
		}
	}
	
	/**
	 * 删除消息
	 * @param m_id
	 */
	public void deleteMessageById(String m_id){
		try {
			messageDao.deleteById(m_id);
		} catch (Exception e) {
			throw new RuntimeException("删除消息失败！");
		}
		
	}
	
	
	/**
	 * 查询用户发布的所有消息
	 * @return
	 */
	public List<Message> queryByUid(String user_id){
		List list = null;
		try {
			list = messageDao.queryByUid(user_id);
		} catch (Exception e) {
			throw new RuntimeException("删除消息失败！");
		}
		return list;
	}
	
	/**
	 * 查询指定话题下发布的所有消息
	 * @return
	 */
	public List<Message> queryByTid(String t_id){
		List list = null;
		try {
			list = messageDao.queryByTid(t_id);
		} catch (Exception e) {
			throw new RuntimeException("删除消息失败！");
		}
		return list;
	}
	
	/**
	 * 查询指定uid的所有消息数量
	 * @return
	 */
	public int queryCountByUid(String user_id) {
		try {
			return messageDao.queryCountByUid(user_id);
		} catch (Exception e) {
			throw new RuntimeException("删除消息失败！");
		}
	}
	
	/**
	 * 查询指定话题的消息数量
	 * 
	 * @param t_id
	 * @return
	 */
	public int queryCountByTid(String t_id) {
		try {
			return messageDao.queryCountByTid(t_id);
		} catch (Exception e) {
			throw new RuntimeException("删除消息失败！");
		}
	}
	
	/**
	 * 查询消息相关信息（收藏数,评论数,转载数,发布时间）
	 */
	
	public Map<String,Object> queryMessageInfo(String m_id){
		Map<String,Object> messageInfo = new HashMap<>();
		//查询收藏数
		int favNum = messageDao.queryFavNum(m_id);
		//查询评论数
		int replyNum = messageDao.queryReplyNum(m_id);
		//查询转载数
		int copyNum = messageDao.queryCopyNum(m_id);
		//查询发布时间
		Timestamp datetime = messageDao.queryTimeNum(m_id);
		
		messageInfo.put("m_fav", favNum);
		messageInfo.put("m_reply", replyNum);
		messageInfo.put("m_copy", copyNum);
		messageInfo.put("datetime", datetime);
		
		return messageInfo;
	}
	
	
	
	
}

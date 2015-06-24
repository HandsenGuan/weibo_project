package com.guan.weibo.message.dao;

import com.guan.weibo.message.domain.Reply;

public interface ReplyDao {

	public void add(Reply reply);
	
	public void delete(String r_id);
	
	public Reply queryByRid(String r_id);
	
}

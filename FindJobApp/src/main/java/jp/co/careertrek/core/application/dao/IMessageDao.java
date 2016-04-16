package jp.co.careertrek.core.application.dao;

import jp.co.careertrek.core.application.po.Message;

public interface IMessageDao {

	Long create(Message message);
	
}

package jp.co.careertrek.core.application.po;

import lombok.Data;

@Data
public class Message {

	private Long messageId;
	
	private Long candidateId;
	
	private Long companyId;
	
	private String messageText;
}

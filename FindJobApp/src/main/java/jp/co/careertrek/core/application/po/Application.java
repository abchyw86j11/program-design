package jp.co.careertrek.core.application.po;

import java.util.Date;

import lombok.Data;

@Data
public class Application {
	
	private Long applicationId;
	
	private Long candidateId;
	
	private Long jobId;
	
	private Date applyDate;

}

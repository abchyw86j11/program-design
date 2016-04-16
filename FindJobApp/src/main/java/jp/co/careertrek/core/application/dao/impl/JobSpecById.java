package jp.co.careertrek.core.application.dao.impl;

import jp.co.careertrek.core.application.dao.IJobSpecification;
import lombok.Setter;

public class JobSpecById implements IJobSpecification{
	
	@Setter
	private Long jobId;

}

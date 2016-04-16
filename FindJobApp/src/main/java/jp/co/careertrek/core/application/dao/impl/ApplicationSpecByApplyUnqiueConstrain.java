package jp.co.careertrek.core.application.dao.impl;

import jp.co.careertrek.core.application.dao.ApplicationSpecification;
import lombok.Setter;

public class ApplicationSpecByApplyUnqiueConstrain implements ApplicationSpecification {
	@Setter
	private Long candidateId;
	@Setter
	private Long jobId;
}

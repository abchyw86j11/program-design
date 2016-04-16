package jp.co.careertrek.core.application.dao.impl;

import jp.co.careertrek.core.application.dao.ApplicationSpecification;

public class AppicationSpecById implements ApplicationSpecification{
	
	private Long candidateId;

	public Long getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(Long candidateId) {
		this.candidateId = candidateId;
	}
	

}

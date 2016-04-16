package jp.co.careertrek.candidate.application.service;

import java.util.List;

import jp.co.careertrek.core.application.exception.DuplicateApplicationException;
import jp.co.careertrek.core.application.po.Application;

public interface IApplicationService {
	
	List<Application> getList(Long caniddateId);
	
	Application apply(Long candidateId, Long jobId, String message) throws DuplicateApplicationException;

}

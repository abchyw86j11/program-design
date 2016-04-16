package jp.co.careertrek.core.application.dao;

import jp.co.careertrek.core.application.po.Job;

public interface IJobDao {
	Job get(Long jobId);
	Job select(IJobSpecification spec);
}

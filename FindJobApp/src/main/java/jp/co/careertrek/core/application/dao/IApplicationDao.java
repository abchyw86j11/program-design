package jp.co.careertrek.core.application.dao;

import java.util.List;

import jp.co.careertrek.core.application.po.Application;

public interface IApplicationDao {
	
	Long create(Application application);
	
	Application get(Long applicationId);
	
	List<Application> selectPage(ApplicationSpecification spec);
	
	Application select(ApplicationSpecification spec);

	Long selectCount(ApplicationSpecification spec);
}

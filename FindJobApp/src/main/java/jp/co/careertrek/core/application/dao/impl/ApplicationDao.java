package jp.co.careertrek.core.application.dao.impl;

import java.util.List;

import jp.co.careertrek.core.application.dao.ApplicationSpecification;
import jp.co.careertrek.core.application.dao.IApplicationDao;
import jp.co.careertrek.core.application.po.Application;

public class ApplicationDao implements IApplicationDao {
	
	// ApplicationBhv bhv;

	@Override
	public Long create(Application application) {
		// bhv.create()
		return null;
	}

	@Override
	public Application get(Long applicationId) {
		// bhv.selectById()
		return null;
	}

	@Override
	public List<Application> selectPage(ApplicationSpecification spec) {
		// bhv.selectPage(spec.toConditionBean)
		return null;
	}

	@Override
	public Application select(ApplicationSpecification spec) {
		// bhv.selectEntity(spec.toConditionBean)
		return null;
	}

	@Override
	public Long selectCount(ApplicationSpecification spec) {
		// bhv.selectCount(spec.toConditionBean)
		return null;
	}

}

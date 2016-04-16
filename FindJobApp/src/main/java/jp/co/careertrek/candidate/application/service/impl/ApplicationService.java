package jp.co.careertrek.candidate.application.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.careertrek.candidate.application.service.IApplicationService;
import jp.co.careertrek.core.application.dao.IApplicationDao;
import jp.co.careertrek.core.application.dao.IJobDao;
import jp.co.careertrek.core.application.dao.IMessageDao;
import jp.co.careertrek.core.application.dao.impl.AppicationSpecById;
import jp.co.careertrek.core.application.dao.impl.ApplicationSpecByApplyUnqiueConstrain;
import jp.co.careertrek.core.application.dao.impl.JobSpecById;
import jp.co.careertrek.core.application.exception.DuplicateApplicationException;
import jp.co.careertrek.core.application.po.Application;
import jp.co.careertrek.core.application.po.Job;
import jp.co.careertrek.core.application.po.Message;
import jp.co.careertrek.core.notification.INotificationManager;
import jp.co.careertrek.core.notification.application.ApplicationNotification;

@Service("applicationService")
public class ApplicationService implements IApplicationService {

	@Autowired
	private IApplicationDao applicationDao;
	@Autowired
	private IMessageDao messageDao;
	@Autowired
	private IJobDao jobDao;
	@Autowired
	private INotificationManager notificationManager;

	@Override
	public List<Application> getList(Long candidateId) {
		AppicationSpecById spec = new AppicationSpecById();
		spec.setCandidateId(candidateId);

		return applicationDao.selectPage(spec);
	}

	@Transactional
	@Override
	public Application apply(Long candidateId, Long jobId, String messageText) throws DuplicateApplicationException {
		// 重複チェック
		checkExistingApplication(candidateId, jobId);
		// 応募を保存する
		Application application = saveApplication(candidateId, jobId, messageText);
		// 通知処理
		notifyNewApplication(application);

		return application;
	}

	private void checkExistingApplication(Long candidateId, Long jobId) throws DuplicateApplicationException {
		ApplicationSpecByApplyUnqiueConstrain spec = new ApplicationSpecByApplyUnqiueConstrain();
		spec.setCandidateId(candidateId);
		spec.setJobId(jobId);
		if (applicationDao.selectCount(spec) > 0L) {
			throw new DuplicateApplicationException();
		}
	}

	private Application saveApplication(Long candidateId, Long jobId, String messageText) {
		Application application = new Application();
		application.setCandidateId(candidateId);
		application.setApplyDate(new Date());
		application.setJobId(jobId);
		applicationDao.create(application);

		JobSpecById spec = new JobSpecById();
		spec.setJobId(jobId);
		Job job = jobDao.select(spec);

		Message message = new Message();
		message.setCandidateId(candidateId);
		message.setCompanyId(job.getRecruiterCompanyId());
		message.setMessageText(messageText);
		messageDao.create(message);

		return application;
	}

	private void notifyNewApplication(Application application) {
		ApplicationNotification notification = new ApplicationNotification(application);
		notificationManager.sendNotification(notification);
	}

}

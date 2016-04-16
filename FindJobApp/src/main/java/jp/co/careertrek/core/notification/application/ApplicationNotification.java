package jp.co.careertrek.core.notification.application;

import jp.co.careertrek.core.application.po.Application;
import jp.co.careertrek.core.notification.INotification;

public class ApplicationNotification implements INotification{
	
	private Application application;

	public ApplicationNotification(Application application) {
		super();
		this.application = application;
	}

	@Override
	public void send() {
		// send mail
	}

}

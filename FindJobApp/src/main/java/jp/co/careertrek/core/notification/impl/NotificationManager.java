package jp.co.careertrek.core.notification.impl;

import jp.co.careertrek.core.notification.INotification;
import jp.co.careertrek.core.notification.INotificationManager;

public class NotificationManager implements INotificationManager {

	@Override
	public void sendNotification(INotification notification) {
		notification.send();
	}

}

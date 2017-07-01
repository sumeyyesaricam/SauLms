package sau.lms.helper;

import sau.lms.R;
import sau.lms.SplashScreen;
import android.app.IntentService;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.WakefulBroadcastReceiver;


public class GcmIntentService extends IntentService {

	public static final int NOTIFICATION_ID = 1;
	private static final String USER_ID = "userid";
	private NotificationManager mNotificationManager;
	NotificationCompat.Builder builder;

	public GcmIntentService() {
		super("GcmIntentService");
	}

	@Override
	protected void onHandleIntent(Intent intent) {
		Bundle extras = intent.getExtras();

		if (!extras.isEmpty()) {
			sendNotification(intent.getExtras());
		}
		WakefulBroadcastReceiver.completeWakefulIntent(intent);
	}

	private void sendNotification(Bundle msg) {
		mNotificationManager = (NotificationManager) this
				.getSystemService(Context.NOTIFICATION_SERVICE);

		PendingIntent contentIntent = PendingIntent.getActivity(this, 0,
				new Intent(this, SplashScreen.class), 0);
			//contentIntent.putExtra(USER_ID,studentid);
		NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(
				this)
				.setSmallIcon(R.drawable.saulms)
				.setContentTitle(msg.getString("contentTitle"))
				
				.setStyle(
						new NotificationCompat.BigTextStyle().bigText(msg
								.getString("message"))).setAutoCancel(true)
				.setContentText(msg.getString("message"));
				
		mBuilder.setContentIntent(contentIntent);
		mNotificationManager.notify(NOTIFICATION_ID, mBuilder.build());
	}
}

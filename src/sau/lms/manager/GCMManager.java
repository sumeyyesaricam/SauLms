package sau.lms.manager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import sau.lms.LoginActivity;
import sau.lms.service.ServiceGetCaller;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.AsyncTask;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.gcm.GoogleCloudMessaging;

public class GCMManager  {
	public static final String EXTRA_MESSAGE = "message";
	public static final String PROPERTY_REG_ID = "registration_id";
	private static final String PROPERTY_APP_VERSION = "appVersion";
	private final static int PLAY_SERVICES_RESOLUTION_REQUEST = 9000;

	String SENDER_ID = "347130374579";
	
	SharedPreferences pref;
	GoogleCloudMessaging gcm;
	AtomicInteger msgId = new AtomicInteger();
	SharedPreferences prefs;
	int PRIVATE_MODE = 0;
	String regid = "";
	Context ctx;
	Activity actvty=null;
	public GCMManager(Activity a,Context ctx) {
		this.ctx = ctx;
		this.actvty=a;
	}
	
	public String GetRegID(String userid) {
		if (checkPlayServices()) {
			regid = getRegistrationId(ctx);
			if (regid.isEmpty()) {
				registerInBackground(userid);
			}
		}
		return regid;
	}
	private void registerInBackground(final String userid) {
		Thread asd = new Thread() {
			@Override
			public void run() {
				try {
					if (gcm == null) {
						gcm = GoogleCloudMessaging.getInstance(ctx);
					}
					regid = gcm.register(SENDER_ID);
					sendRegistrationIdToBackend(userid,regid);
					storeRegistrationId(ctx, regid);
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		};

		asd.start();
	}
	private void sendRegistrationIdToBackend(String userid,String regid) {
		String versiyon=String.valueOf(getAppVersion(ctx));
		List<NameValuePair> prmdvc = new ArrayList<NameValuePair>();
		prmdvc.add(new BasicNameValuePair("UserId",userid));
		prmdvc.add(new BasicNameValuePair("Device", "1"));
		prmdvc.add(new BasicNameValuePair("DeviceKey",regid));
		prmdvc.add(new BasicNameValuePair("Version",versiyon));
		try {
			String control = new ServiceGetCaller(prmdvc).execute("DeviceSet").get();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}			
	}
	public boolean checkPlayServices() {
		int resultCode = GooglePlayServicesUtil
				.isGooglePlayServicesAvailable(this.ctx);
		if (resultCode != ConnectionResult.SUCCESS) {
			if (GooglePlayServicesUtil.isUserRecoverableError(resultCode)) {
				GooglePlayServicesUtil.getErrorDialog(resultCode,
						(Activity) this.ctx, PLAY_SERVICES_RESOLUTION_REQUEST)
						.show();
			} else {
			}
			return false;
		}
		return true;
	}

	public String getRegistrationId(Context context) {
		final SharedPreferences prefs = getGCMPreferences(context);
		String registrationId = prefs.getString(PROPERTY_REG_ID, "");
		if (registrationId.isEmpty()) {
			return "";
		}
		int registeredVersion = prefs.getInt(PROPERTY_APP_VERSION,
				Integer.MIN_VALUE);
		int currentVersion = getAppVersion(context);
		if (registeredVersion != currentVersion) {
			return "";
		}
		return registrationId;
	}

	public SharedPreferences getGCMPreferences(Context context) {
		return ctx.getSharedPreferences("WheFile", PRIVATE_MODE);
	}

	public static int getAppVersion(Context context) {
		try {
			PackageInfo packageInfo = context.getPackageManager()
					.getPackageInfo(context.getPackageName(), 0);
			return packageInfo.versionCode;
		} catch (NameNotFoundException e) {
			// should never happen
			throw new RuntimeException("Could not get package name: " + e);
		}
	}

	
	private void storeRegistrationId(Context context, String regId) {
		final SharedPreferences prefs = getGCMPreferences(context);
		int appVersion = getAppVersion(context);
		SharedPreferences.Editor editor = prefs.edit();
		editor.putString(PROPERTY_REG_ID, regId);
		editor.putInt(PROPERTY_APP_VERSION, appVersion);
		editor.commit();
	}

	
}

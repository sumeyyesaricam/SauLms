package sau.lms;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.google.android.gms.gcm.GoogleCloudMessaging;

import sau.lms.helper.JsonParser;
import sau.lms.manager.GCMManager;
import sau.lms.model.User;
import sau.lms.service.ServiceGetCaller;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

public class SplashScreen extends Activity {

	String regid;
	private static final String TAG_ID = "id";
	private static final String PHOTO_URL = "photo";
	private static final String LOGIN_CHECK = "logcheck";

	// String userid = intent.getStringExtra(USER_ID);
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash_screen);
		Intent intent = getIntent();
		GCMManager gcm = new GCMManager(SplashScreen.this,this);
		SharedPreferences prefs = gcm.getGCMPreferences(SplashScreen.this);
		boolean log_check = prefs.getBoolean(LOGIN_CHECK, false);

		if (log_check == true) {
			if (gcm.checkPlayServices()) {// GOOGLE PLAY SERVÝCE APK YÜKLÜMÜ
				String regid = gcm.getRegistrationId(this);
				if (!regid.isEmpty()) {
					String version = String.valueOf(gcm.getAppVersion(this));
					String jsonStr;
					try {
						jsonStr = new ServiceGetCaller(SplashScreen.this)
								.execute(
										"LoginDeviceGet?Version=" + version
												+ "&DeviceKey=" + regid).get();
						if (jsonStr != null) {
							User user;
							try {
								user = JsonParser.getUserObject(jsonStr);
								String studentid = String.valueOf(user
										.getStudentId());
								Toast.makeText(getApplicationContext(),
										"Bu cihaz önceden kaydedilmiþ",
										Toast.LENGTH_SHORT).show();
								Intent intent1 = new Intent(
										getApplicationContext(),
										CourseActivity.class);
								intent1.putExtra(TAG_ID, studentid);
								intent1.putExtra(PHOTO_URL, user.getPhoto());
								startActivity(intent1);
								finish();
							} catch (ClassNotFoundException e) {
								e.printStackTrace();
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					} catch (ExecutionException e1) {
						e1.printStackTrace();
					}
				} else {
					Intent loginIntent = new Intent(getApplicationContext(),
							LoginActivity.class);
					startActivity(loginIntent);
				}
			}
		} else {
			Intent loginIntent = new Intent(getApplicationContext(),
					LoginActivity.class);
			startActivity(loginIntent);
		}
	}
}

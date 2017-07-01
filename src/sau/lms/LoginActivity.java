package sau.lms;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import sau.lms.helper.JsonParser;
import sau.lms.manager.GCMManager;
import sau.lms.manager.SettingManager;
import sau.lms.model.User;
import sau.lms.service.ServiceGetCaller;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity {
	
	private static final String TAG_ID = "id";
	private static final String PHOTO_URL = "photo";
	private static final String NAME = "name";
	private static final String SURNAME = "surname";
	private static final String LOGIN_CHECK = "logcheck";
	
	Button btnLogin;
	CheckBox login_check;
	String control;
		GCMManager gcm=new GCMManager(LoginActivity.this,this);
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		btnLogin = (Button) findViewById(R.id.btnLogin);
		login_check = (CheckBox) findViewById(R.id.login_check);
		login_check.setOnCheckedChangeListener(new OnCheckedChangeListener() {

        	SharedPreferences prefs = gcm.getGCMPreferences(LoginActivity.this);
        	SharedPreferences.Editor editor = prefs.edit();
            public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
                if (login_check.isChecked()) {
            		editor.putBoolean(LOGIN_CHECK, true);
            		editor.commit();
                } else {
                	editor.putBoolean(LOGIN_CHECK, false);
            		editor.commit();
                }
 
            }
        });
		btnLogin.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Login();
			}
		});
	}

	public void Login() {
		String username = ((EditText) findViewById(R.id.etUsername)).getText()
				.toString();
		String password = ((EditText) findViewById(R.id.etPassword)).getText()
				.toString();
		String pass;
		try {
			pass = SettingManager.Encrypt(password);
			List<NameValuePair> prm = new ArrayList<NameValuePair>();
			prm.add(new BasicNameValuePair("UserName", username));
			prm.add(new BasicNameValuePair("PasswordHash", pass));
			try {
				String jsonStr = new ServiceGetCaller(LoginActivity.this, prm).execute("Login").get();
				 //String jsonStr = new ServiceGetCaller(LoginActivity.this,prm).execute("LoginTest").get();
				if (jsonStr != null ) {
					try {
						// user = (User) getApplicationContext();
						User user = JsonParser.getUserObject(jsonStr);
						String userid = String.valueOf(user.getUserId());
						if (user != null && user.getStudentId()!=0) {
							GCMManager gcm=new GCMManager(LoginActivity.this,this);
							String reg=gcm.GetRegID(userid);
							
							Intent intent = new Intent(LoginActivity.this,
									CourseActivity.class);
							String studentid = String.valueOf(user
									.getStudentId());
							intent.putExtra(TAG_ID, studentid);
							intent.putExtra(PHOTO_URL, user.getPhoto());
							intent.putExtra(NAME, user.getName());
							intent.putExtra(SURNAME, user.getSurname());
							startActivity(intent);
						}
						else{
							Toast.makeText(getApplicationContext(),user.getMessage(),
									Toast.LENGTH_LONG).show();
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else {
					Log.e("ServiceHandler",
							"Couldn't get any data from the url");
				}
			} catch (Exception e) {
				e.printStackTrace();
				Toast.makeText(getApplicationContext(),
						"Sunucuya baðlanýlamadý.Lütfen tekrar deneyin.",
						Toast.LENGTH_LONG).show();
			}
		} catch (Exception ePassword) {
			ePassword.printStackTrace();
			Toast.makeText(getApplicationContext(),
					"Sunucuya baðlanýlamadý.Lütfen tekrar deneyin.",
					Toast.LENGTH_LONG).show();
		}
	}
}

package sau.lms;

import java.util.List;
import java.util.concurrent.ExecutionException;

import sau.lms.adapter.CourseAdapter;
import sau.lms.helper.DownloadImage;
import sau.lms.helper.JsonParser;
import sau.lms.manager.GCMManager;
import sau.lms.model.Course;
import sau.lms.model.User;
import sau.lms.service.ServiceGetCaller;
import sau.lms.R;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class CourseActivity extends Activity {

	private static final String TAG_ID = "id";
	private static final String PHOTO_URL = "photo";
	private static final String NAME = "name";
	private static final String SURNAME = "surname";
	private static final String LOGIN_CHECK = "logcheck";
	
	ImageView img_user, img_popup;
	List<Course> _Courses;
	static String photo = null;
	
	GCMManager gcm = new GCMManager(CourseActivity.this, this);
	String usename=null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_course);
		Intent intent = getIntent();
		String id = intent.getStringExtra(TAG_ID);
		usename=intent.getStringExtra(NAME)+" "+intent.getStringExtra(SURNAME);
		photo = intent.getStringExtra(PHOTO_URL);
		img_user = (ImageView) findViewById(R.id.img_user);
		img_popup = (ImageView) findViewById(R.id.image_popup);
		img_popup.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				PopupMenu popup = new PopupMenu(CourseActivity.this, img_popup);
				popup.getMenuInflater().inflate(R.menu.popup_menu,
						popup.getMenu());
				popup.getMenu().add(usename);
				popup.getMenu().add(1, 1, 1, "ÇIKIÞ");
				popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
					public boolean onMenuItemClick(MenuItem item) {
						if (item.getItemId() == 1) {
							SharedPreferences prefs = gcm
									.getGCMPreferences(CourseActivity.this);
							SharedPreferences.Editor editor = prefs.edit();
							editor.putBoolean(LOGIN_CHECK, false);
							editor.commit();
							Intent intent = new Intent(CourseActivity.this,
									LoginActivity.class);
							startActivity(intent);
						}
						return true;
					}
				});
				popup.show();
			}
		});
		try {
			img_user.setImageBitmap(new DownloadImage(
					(ImageView) findViewById(R.id.img_user)).execute(photo)
					.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		GetCourse(id);

	}

	public static String PhotoUrl() {
		return photo;
	}

	public void GetCourse(String studentid) {
		try {
			String jsonStr = new ServiceGetCaller(CourseActivity.this).execute(
					"groups/" + studentid).get();
			if (jsonStr != null) {
				try {
					List<Course> courses = JsonParser.getCourseObject(jsonStr);

					final ListView courseList = (ListView) findViewById(R.id.listCourse);
					if (courses != null) {

						CourseAdapter courseAdapter = new CourseAdapter(
								CourseActivity.this, courses, photo,usename);
						courseList.setAdapter(courseAdapter);
					} else {
						Toast.makeText(getApplicationContext(),
								"Lütfen bir kullanýcý adý giriniz.",
								Toast.LENGTH_LONG).show();

					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				Log.e("ServiceHandler", "Couldn't get any data from the url");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

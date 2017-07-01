package sau.lms;

import java.util.List;
import java.util.concurrent.ExecutionException;

import sau.lms.adapter.ExamAdapter;
import sau.lms.helper.DownloadImage;
import sau.lms.helper.JsonParser;
import sau.lms.manager.GCMManager;
import sau.lms.model.Exam;
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
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class ExamActivity extends Activity {

	private static String url = "http://apilms.sabis.sakarya.edu.tr/api/student/vclasslist2/482640?sid=247587";
	List<Exam> _Exams; 
	private static final String TAG_CID = "cid";
    private static final String TAG_SID = "sid";
    private static final String PHOTO_URL="photo";
    private static final String NAME_SURNAME="nameSurname";;
	private static final String LOGIN_CHECK = "logcheck";
	
    String cid =null,sid=null,photo=null;
    ImageView img_euser,img_popup;
    GCMManager gcm = new GCMManager(ExamActivity.this, this); 
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_exam);
		Intent intent = getIntent();
		 cid = intent.getStringExtra(TAG_CID);
		 sid = intent.getStringExtra(TAG_SID);
		 photo = intent.getStringExtra(PHOTO_URL);
		 final String usename=intent.getStringExtra(NAME_SURNAME);
		 img_euser = (ImageView) findViewById(R.id.img_euser);	
		 img_popup = (ImageView) findViewById(R.id.imageEpopup);
			img_popup.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					PopupMenu popup = new PopupMenu(ExamActivity.this, img_popup);
					popup.getMenuInflater().inflate(R.menu.popup_menu,
							popup.getMenu());
					popup.getMenu().add(usename);
					popup.getMenu().add(1, 1, 1, "ÇIKIÞ");
					popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
						public boolean onMenuItemClick(MenuItem item) {
							if (item.getItemId() == 1) {
								SharedPreferences prefs = gcm
										.getGCMPreferences(ExamActivity.this);
								SharedPreferences.Editor editor = prefs.edit();
								editor.putBoolean(LOGIN_CHECK, false);
								editor.commit();
								Intent intent = new Intent(ExamActivity.this,
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
				img_euser.setImageBitmap(new DownloadImage((ImageView) findViewById(R.id.img_euser)).execute(photo).get());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		GetExam();
	}
	
	public void GetExam(){
		 try {
			 String jsonStr = new ServiceGetCaller(ExamActivity.this).execute(url).get();
	            if (jsonStr != null) {
	                try {
	                    final List<Exam> exams = JsonParser.getExamObject(jsonStr);
	                	
	                    final ListView examList = (ListView) findViewById(R.id.listVClass);
	                    if (exams != null) {
	                        
	                    	ExamAdapter examAdapter = new ExamAdapter(ExamActivity.this, exams);
	                    	examList.setAdapter(examAdapter);
	                    	examList.setOnItemClickListener(new OnItemClickListener(){
	                        	
								@Override
								public void onItemClick(AdapterView<?> parent,
										View view, int position, long id) {
									Exam exam = exams.get(position);	
									 /*long day=DateFormatter.Extraction(exam.getStartDate());
									if(day>=0){
					                Intent i = new Intent(Intent.ACTION_VIEW);
					                i.setData(Uri.parse(exam.getUrl()));
					                startActivity(i);
					                }			*/					
							}
	                        });
	                    } else {
	                    	 Toast.makeText(getApplicationContext(),"Lütfen bir kullanýcý adý giriniz.", Toast.LENGTH_LONG).show();	             			
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



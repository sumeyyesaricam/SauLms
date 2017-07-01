package sau.lms;

import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;

import java.util.List;
import java.util.concurrent.ExecutionException;

import sau.lms.adapter.AssigmentAdapter;
import sau.lms.helper.DownloadImage;
import sau.lms.helper.JsonParser;
import sau.lms.manager.GCMManager;
import sau.lms.model.Assigment;
import sau.lms.service.ServiceGetCaller;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class AssigmentActivity extends Activity {

	private static final String TAG_CID = "cid";
    private static final String TAG_SID = "sid";
    private static final String PHOTO_URL="photo";
    private static final String NAME_SURNAME="nameSurname";
	private static final String LOGIN_CHECK = "logcheck";
	
    List<Assigment> _Assigments;
    String cid =null,sid=null,photo=null;
    ImageView img_auser, img_popup;
    GCMManager gcm = new GCMManager(AssigmentActivity.this, this);
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_assigment);
		Intent intent = getIntent();
	    cid = intent.getStringExtra(TAG_CID);
		 sid = intent.getStringExtra(TAG_SID);
		 photo = intent.getStringExtra(PHOTO_URL);
			final String usename=intent.getStringExtra(NAME_SURNAME);
		 img_auser = (ImageView) findViewById(R.id.img_auser);	
		 img_popup = (ImageView) findViewById(R.id.imageApopup);
			img_popup.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					PopupMenu popup = new PopupMenu(AssigmentActivity.this, img_popup);
					popup.getMenuInflater().inflate(R.menu.popup_menu,
							popup.getMenu());
					popup.getMenu().add(usename);
					popup.getMenu().add(1, 1, 1, "ÇIKIÞ");
					popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
						public boolean onMenuItemClick(MenuItem item) {
							if (item.getItemId() == 1) {
								SharedPreferences prefs = gcm
										.getGCMPreferences(AssigmentActivity.this);
								SharedPreferences.Editor editor = prefs.edit();
								editor.putBoolean(LOGIN_CHECK, false);
								editor.commit();
								Intent intent = new Intent(AssigmentActivity.this,
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
				img_auser.setImageBitmap(new DownloadImage((ImageView) findViewById(R.id.img_auser)).execute(photo).get());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		GetAssigment();
	}
	public void GetAssigment(){
		 try {
			 String jsonStr = new ServiceGetCaller(AssigmentActivity.this).execute("AssignmentList2/"+cid+"?sid="+sid).get();
	            if (jsonStr != null) {
	                try {
	                    final List<Assigment> assigments = JsonParser.getAssigmentObject(jsonStr);
	                	
	                    final ListView assigmentList = (ListView) findViewById(R.id.listAssigment);
	                    if (assigments != null) {	                      
	                    	AssigmentAdapter assigmentAdapter = new AssigmentAdapter(AssigmentActivity.this, assigments);
	                    	assigmentList.setAdapter(assigmentAdapter);
	                    	assigmentList.setOnItemClickListener(new OnItemClickListener(){
	                        	
								@Override
								public void onItemClick(AdapterView<?> parent,
										View view, int position, long id) {
									Assigment assigment = assigments.get(position);	
									// long day=DateFormatter.Extraction(assigment.getEndDate());
									//if(day<=0){
									if(assigment.getFileUrl()!=null)
					                {Intent i = new Intent(Intent.ACTION_VIEW);
					                i.setData(Uri.parse(assigment.getFileUrl()));
					                startActivity(i);
					                }
					                //}								
							}
	                        });
	                    } 
	                    else {
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


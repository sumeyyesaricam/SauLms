package sau.lms;

import java.util.List;
import java.util.concurrent.ExecutionException;

import sau.lms.adapter.ContentAdapter;
import sau.lms.helper.DownloadImage;
import sau.lms.helper.JsonParser;
import sau.lms.manager.GCMManager;
import sau.lms.model.Content;
import sau.lms.service.ServiceGetCaller;
import sau.lms.ContentActivity;
import sau.lms.R;
import sau.lms.VideoActivity;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class ContentActivity extends Activity {
	
	private static final String TAG_URL = "url";	
	private static final String TAG_NAME = "name";
	private static final String TAG_CID = "cid";
    private static final String TAG_SID = "sid";
	private static final String PHOTO_URL="photo";
    private static final String NAME_SURNAME="nameSurname";
	private static final String LOGIN_CHECK = "logcheck";
	private static final String CONTENT_COUNT="contentCount";
	
    String cid =null,sid=null,photo=null,contentCount=null;
	List<Content> _Contents;
	Context con=this;
	ImageView img_cuser,img_popup;
	 ProgressDialog mProgressDialog;
	 TextView txtiscontent;
	 GCMManager gcm = new GCMManager(ContentActivity.this, this);
	 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_content);

		 txtiscontent = (TextView) findViewById(R.id.txtiscontent);
		Intent intent = getIntent();
		 cid = intent.getStringExtra(TAG_CID);
		 sid = intent.getStringExtra(TAG_SID);
		 photo = intent.getStringExtra(PHOTO_URL);
		 img_cuser = (ImageView) findViewById(R.id.img_cuser);	
		 contentCount=intent.getStringExtra(CONTENT_COUNT);
		 final String usename=intent.getStringExtra(NAME_SURNAME);
		 if(contentCount=="0" || contentCount==null )			 
		 {
			 txtiscontent.setText("Bu derse ait içeriðiniz bulunmamaktadýr.");
		 }		
		 img_popup = (ImageView) findViewById(R.id.imageCpopup);
			img_popup.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					PopupMenu popup = new PopupMenu(ContentActivity.this, img_popup);
					popup.getMenuInflater().inflate(R.menu.popup_menu,
							popup.getMenu());
					popup.getMenu().add(usename);
					popup.getMenu().add(1, 1, 1, "ÇIKIÞ");
					popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
						public boolean onMenuItemClick(MenuItem item) {
							if (item.getItemId() == 1) {
								SharedPreferences prefs = gcm
										.getGCMPreferences(ContentActivity.this);
								SharedPreferences.Editor editor = prefs.edit();
								editor.putBoolean(LOGIN_CHECK, false);
								editor.commit();
								Intent intent = new Intent(ContentActivity.this,
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
				img_cuser.setImageBitmap(new DownloadImage((ImageView) findViewById(R.id.img_cuser)).execute(photo).get());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		GetContent();
	}
	public void GetContent(){
		 try {
			 String jsonStr = new ServiceGetCaller(ContentActivity.this).execute("contentlist2/"+cid+"?sid="+sid).get();
	            if (jsonStr != null) {
	                try {
	                    final List<Content> contents = JsonParser.getContentObject(jsonStr);
	                	
	                    final ListView contentList = (ListView) findViewById(R.id.listContent);
	                    if (contents != null) {
	                        
	                    	ContentAdapter contentAdapter = new ContentAdapter(ContentActivity.this, contents);
	                        contentList.setAdapter(contentAdapter);
	                        contentList.setOnItemClickListener(new OnItemClickListener(){
	                        	
								@Override
								public void onItemClick(AdapterView<?> parent,
										View view, int position, long id) {
									Content content = contents.get(position);
									if(content.getType()==1){
										Intent intent=new Intent(ContentActivity.this,VideoActivity.class);
										intent.putExtra(TAG_URL,content.getUrl());
										intent.putExtra(TAG_NAME,content.getName());
										startActivity(intent); 
									}
									else{							
					                Intent i = new Intent(Intent.ACTION_VIEW);
					                i.setData(Uri.parse(content.getUrl()));
					                startActivity(i);
								}
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


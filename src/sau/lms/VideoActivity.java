package sau.lms;

import sau.lms.R;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Bundle;
import android.util.Log;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoActivity extends Activity {

	 private VideoView myVideoView;	
	 private int position = 0;
	 private ProgressDialog progressDialog;
	 private MediaController mediaControls;
	 private static final String TAG_URL = "url";
	 private static final String TAG_NAME = "name";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_video);
		Intent in = getIntent();
        String url = in.getStringExtra(TAG_URL);
        String name = in.getStringExtra(TAG_NAME);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		if (mediaControls == null) {			
		 mediaControls = new MediaController(VideoActivity.this);
		}
		
		myVideoView=(VideoView)findViewById(R.id.videoView1);
		
		progressDialog = new ProgressDialog(VideoActivity.this);
		progressDialog.setTitle(name);
		progressDialog.setMessage("Yükleniyor...");
		progressDialog.setCancelable(false);
		progressDialog.show();
		
		try{
		 myVideoView.setMediaController(mediaControls);
		 myVideoView.setVideoPath(url);
		}
		catch(Exception  e) {
			 Log.e("Error", e.getMessage());
			 e.printStackTrace();
		}
		 myVideoView.requestFocus();
		 myVideoView.setOnPreparedListener(new OnPreparedListener() {
			             public void onPrepared(MediaPlayer mediaPlayer) {
		                 progressDialog.dismiss();
		                 myVideoView.seekTo(position);			 
			                 if (position == 0) {
			                	 myVideoView.start();			 
			                 } else {
		                     myVideoView.pause();			
			                 }			
			             }
		   });

	}
	 @Override
	
	     public void onSaveInstanceState(Bundle savedInstanceState) {
	     super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("Position", myVideoView.getCurrentPosition());
         myVideoView.pause();
     }
	   @Override
	    public void onRestoreInstanceState(Bundle savedInstanceState) {
	      super.onRestoreInstanceState(savedInstanceState);
         position = savedInstanceState.getInt("Position");
         myVideoView.seekTo(position);
     }

}



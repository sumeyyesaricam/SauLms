package sau.lms.helper;

import android.app.ProgressDialog;
import android.view.View;

public class ProgressBar {

	   
	 public static void download(View view){
		  final ProgressDialog progress;
	      progress=new ProgressDialog(view.getContext());
	      progress.setMessage("Sayfa Yükleniyor.");
	      progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
	      progress.setIndeterminate(true);
	      progress.setProgress(0);
	      progress.show();
	      
	      final int totalProgressTime = 100;
	      final Thread t = new Thread() {
	         @Override
	         public void run() {
	            int jumpTime = 0;
	            
	            while(jumpTime < totalProgressTime) {
	               try {
	                  sleep(200);
	                  jumpTime += 5;
	                  progress.setProgress(jumpTime);
	               }
	               catch (InterruptedException e) {
	                  e.printStackTrace();
	               }
	            }
	         }
	      };
	      t.start();
	   }
}

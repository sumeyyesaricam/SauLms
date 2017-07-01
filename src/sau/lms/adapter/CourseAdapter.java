package sau.lms.adapter;


import java.util.List;

import sau.lms.helper.ProgressBar;
import sau.lms.model.Course;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import sau.lms.AssigmentActivity;
import sau.lms.ContentActivity;
import sau.lms.ExamActivity;
import sau.lms.VClassActivity;
import sau.lms.R;

public class CourseAdapter  extends ListAdapter<Course> {
		private String data=null;
		private String usrnm=null;
	     public CourseAdapter(Context c, List<Course> items,String photo,String usename) {
		super(c, items);
		data=photo;
		usrnm=usename;
	}
	    ImageView img_vclass,img_content,img_assigment,img_exam,img_user;
	    private static final String TAG_CID = "cid";
	    private static final String TAG_SID = "sid";
	    private static final String PHOTO_URL="photo";
	    private static final String NAME_SURNAME="nameSurname";
	    private static final String CONTENT_COUNT="contentCount";
	    public static class ViewHolder{

	        public TextView txtGroupName,txtCourseName,txtVcount,txtCcount,txtAcount,txtEcount;
	        public ImageView img_vclass,img_content,img_assigment,img_exam;

	    }
		@Override
	    public View getView(int position, View convertView, ViewGroup parent) {

	        ViewHolder holder=new ViewHolder();
	        final Course course = items.get(position);
	        
            View vi=convertView;
	        if(convertView==null){ 
	        	try{
	        		vi = inflater.inflate(R.layout.course_list, null); 
	        
	            holder.txtGroupName=(TextView)vi.findViewById(R.id.txtGroupName);
	            holder.txtCourseName=(TextView)vi.findViewById(R.id.txtCourseName);
	            holder.txtVcount=(TextView)vi.findViewById(R.id.txtVcount);
	            holder.txtCcount=(TextView)vi.findViewById(R.id.txtCcount);
	            holder.txtAcount=(TextView)vi.findViewById(R.id.txtAcount);
	            holder.txtEcount=(TextView)vi.findViewById(R.id.txtEcount);
	            holder.img_vclass=(ImageView)vi.findViewById(R.id.img_vclass);
	            holder.img_content=(ImageView)vi.findViewById(R.id.img_content);
	            holder.img_assigment=(ImageView)vi.findViewById(R.id.img_assigment);
	            holder.img_exam=(ImageView)vi.findViewById(R.id.img_exam);
	            vi.setTag(holder);
	            }catch(Exception e){
	            	e.printStackTrace();
	            }
	        }
	        else  
	         holder=(ViewHolder)convertView.getTag();
	        
	        holder.txtGroupName.setText(course.getGroupName());
	        holder.txtCourseName.setText(course.getCourseName());
	        RelativeLayout.LayoutParams aspar = (RelativeLayout.LayoutParams)holder.img_assigment.getLayoutParams();
	        RelativeLayout.LayoutParams expar = (RelativeLayout.LayoutParams)holder.img_exam.getLayoutParams();
	        RelativeLayout.LayoutParams conpar = (RelativeLayout.LayoutParams)holder.img_content.getLayoutParams();
	        if(course.getVClassCount()==0){
	        	holder.txtVcount.setVisibility(View.INVISIBLE);
	        	holder.img_vclass.setVisibility(View.INVISIBLE);
	        	if(course.getContentCount()!=0)
	        	{	        	
	        	conpar.leftMargin = 36;
	        	holder.img_content.setLayoutParams(conpar);
	        	if(course.getExamCount()!=0){	        		
	        		expar.leftMargin = 150;
		        	holder.img_exam.setLayoutParams(expar);
	        	}
	        	else if(course.getAssignmentCount()!=0){	        		
	        		aspar.leftMargin = 150;
		        	holder.img_assigment.setLayoutParams(aspar);
	        	}
	        	}
	        	else if(course.getAssignmentCount()!=0)
	        	{        
	        	aspar.leftMargin = 36;
	        	holder.img_assigment.setLayoutParams(aspar);
	        	if(course.getExamCount()!=0)
	        	{
	        	expar.leftMargin = 150;
	        	holder.img_exam.setLayoutParams(expar);
	        	}
	        	}
	        	if(course.getExamCount()!=0)
	        	{
	        		expar.leftMargin = 36;
	        	holder.img_exam.setLayoutParams(expar);
	        	}
	        }else
	        {
	        	holder.txtVcount.setText(String.valueOf(course.getVClassCount()));
	        	
	        	holder.img_vclass.setOnClickListener(new OnClickListener() {
	    	        
		            @Override
		            public void onClick(View view) {
		            	//ProgressBar.download(view);
		            	Intent intent=new Intent(context,VClassActivity.class);
		            	String ci=String.valueOf(course.getGroupId());
		            	String si=String.valueOf(course.getStudentId());
						intent.putExtra(TAG_CID,ci);
						intent.putExtra(TAG_SID,si);
						intent.putExtra(PHOTO_URL,data);
						intent.putExtra(NAME_SURNAME,usrnm);
		            	context.startActivity(intent);
		            }
		        });
	        }
	        if(course.getContentCount()==0){
	        	holder.txtCcount.setVisibility(View.INVISIBLE);
	        	holder.img_content.setVisibility(View.INVISIBLE);
	        	if(course.getVClassCount()!=0 && course.getExamCount()!=0 ){	        		
		        	expar.leftMargin = 150;
		        	holder.img_exam.setLayoutParams(expar);
	        	}
	        	else if(course.getAssignmentCount()==0){	
	        		expar.leftMargin = 36;
		        	holder.img_exam.setLayoutParams(expar);
	        	}
	        	else{
	        		aspar.leftMargin = 36;
		        	holder.img_assigment.setLayoutParams(aspar);
		        	expar.leftMargin = 150;
		        	holder.img_exam.setLayoutParams(expar);
	        	}
	        }
	        else
	        {
	        	 holder.txtCcount.setText(String.valueOf(course.getContentCount()));
	        	 holder.img_content.setOnClickListener(new OnClickListener() {

	 	            @Override
	 	            public void onClick(View view) {
	 	            	//ProgressBar.download(view);
	 	            	Intent intent=new Intent(context,ContentActivity.class);
		            	String ci=String.valueOf(course.getGroupId());
		            	String si=String.valueOf(course.getStudentId());
		            	String contentCount=String.valueOf(course.getContentCount());
						intent.putExtra(TAG_CID,ci);
						intent.putExtra(TAG_SID,si);
						intent.putExtra(PHOTO_URL,data);
						intent.putExtra(NAME_SURNAME,usrnm);
						intent.putExtra(CONTENT_COUNT,contentCount);
	 	            	context.startActivity(intent);
	 	            }
	 	        });
	        }
	        if(course.getAssignmentCount()==0){
	        	holder.txtAcount.setVisibility(View.INVISIBLE);
	        	holder.img_assigment.setVisibility(View.INVISIBLE);
	        	if(course.getVClassCount()!=0 && course.getContentCount()!=0 && course.getExamCount()!=0){
		        	expar.leftMargin = 250;
		        	holder.img_exam.setLayoutParams(expar);
	        	}
	        }else
	        {
	        	 holder.txtAcount.setText(String.valueOf(course.getAssignmentCount()));
	        	 holder.img_assigment.setOnClickListener(new OnClickListener() {

	 	            @Override
	 	            public void onClick(View view) {
	 	            	//ProgressBar.download(view);
	 	            	Intent intent=new Intent(context,AssigmentActivity.class);
		            	String ci=String.valueOf(course.getGroupId());
		            	String si=String.valueOf(course.getStudentId());
						intent.putExtra(TAG_CID,ci);
						intent.putExtra(TAG_SID,si); 
						intent.putExtra(NAME_SURNAME,usrnm);
						intent.putExtra(PHOTO_URL,data);
		            	context.startActivity(intent);
	 	            }
	 	        });
	        }
	        if(course.getExamCount()==0){
	        	holder.txtEcount.setVisibility(View.INVISIBLE);
	        	holder.img_exam.setVisibility(View.INVISIBLE);
	        }else
	        {
	        	holder.txtEcount.setText(String.valueOf(course.getExamCount()));
	        	 holder.img_exam.setOnClickListener(new OnClickListener() {

	 	            @Override
	 	            public void onClick(View view) {
	 	            	//ProgressBar.download(view);
	 	            	Intent intent=new Intent(context,ExamActivity.class);
		            	String ci=String.valueOf(course.getGroupId());
		            	String si=String.valueOf(course.getStudentId());
						intent.putExtra(TAG_CID,ci);
						intent.putExtra(TAG_SID,si); 
						intent.putExtra(NAME_SURNAME,usrnm);
						intent.putExtra(PHOTO_URL,data);
		            	context.startActivity(intent);  
	 	            }
	 	        });
	        }
	        holder.txtCourseName.setOnClickListener(new OnClickListener(){
	        	 @Override
	 	            public void onClick(View view) {
	        		 String cntnt=String.valueOf(course.getContentCount());
	        		 if(course.getContentCount()==0)
	        			 cntnt=null;
	        		 //ProgressBar.download(view);
	 	            	Intent intent=new Intent(context,ContentActivity.class);
		            	String ci=String.valueOf(course.getGroupId());
		            	String si=String.valueOf(course.getStudentId());
						intent.putExtra(TAG_CID,ci);
						intent.putExtra(TAG_SID,si);
						intent.putExtra(PHOTO_URL,data);
						intent.putExtra(NAME_SURNAME,usrnm);
						intent.putExtra(CONTENT_COUNT,cntnt);
	 	            	context.startActivity(intent);
	 	            }
        	});
	        return vi;
	    }
}



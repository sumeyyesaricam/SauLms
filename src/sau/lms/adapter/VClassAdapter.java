package sau.lms.adapter;
import java.util.List;

import sau.lms.helper.DateFormatter;
import sau.lms.model.VClass;
import sau.lms.R;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class VClassAdapter extends ListAdapter<VClass> {
	
    
   public VClassAdapter(Context c, List<VClass> items) {
		super(c, items);
	}

   public static class ViewHolder{
       public TextView txtVClassName,txtStartDate,txtDuration;
   }
   
   @Override
   public View getView(int position, View convertView, ViewGroup parent) {
      
       ViewHolder holder=new ViewHolder();
       VClass vclass = items.get(position);
       View vi=convertView;
       if(convertView==null){ 
       	try{
       		vi = inflater.inflate(R.layout.vclass_list, null);          
           holder.txtVClassName=(TextView)vi.findViewById(R.id.txtVClassName); 
           holder.txtStartDate=(TextView)vi.findViewById(R.id.txtStartDate);
           holder.txtDuration=(TextView)vi.findViewById(R.id.txtDuration);
           vi.setTag(holder);         
           }
       	catch(Exception e){
           	e.printStackTrace();
           }
       }
       else  
        holder=(ViewHolder)convertView.getTag();
       holder.txtVClassName.setText(vclass.getName());
       String date=DateFormatter.Show(vclass.getStartDate());
       long day=DateFormatter.Extraction(vclass.getStartDate());
		if(day>0)
	      {
			holder.txtStartDate.setText(date);
	      }
	      else if(day==0){
	    	  holder.txtStartDate.setText("Katýlabilirsiniz.");
	      }else{
	    	  holder.txtStartDate.setText(date);
			  holder.txtDuration.setText(vclass.getDuration()+" dk");
	      }
       return vi;
   }
}

package sau.lms.adapter;

import java.util.List;

import sau.lms.helper.DateFormatter;
import sau.lms.model.Assigment;
import sau.lms.R;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class AssigmentAdapter extends ListAdapter<Assigment> {
	
 
   public AssigmentAdapter(Context c, List<Assigment> items) {
		super(c, items);
	}
   public static class ViewHolder{

       public TextView txtAssigmentName,txtEnroll;

   }
   @Override
   public View getView(int position, View convertView, ViewGroup parent) {
      
       ViewHolder holder=new ViewHolder();
       Assigment assigment = items.get(position);
       View vi=convertView;
       if(convertView==null){ 
       	try{
       		vi = inflater.inflate(R.layout.assigment_list, null);          
           holder.txtAssigmentName=(TextView)vi.findViewById(R.id.txtAssigmentName);
           holder.txtEnroll=(TextView)vi.findViewById(R.id.txtEnroll);
           vi.setTag(holder);         
           }
       	catch(Exception e){
           	e.printStackTrace();
           }
       }
       else  
        holder=(ViewHolder)convertView.getTag();
       holder.txtAssigmentName.setText(assigment.getName());
       String date=DateFormatter.Show(assigment.getEndDate());
       long day=DateFormatter.Extraction(assigment.getEndDate());
       
       if(assigment.getEnrollStatus()==0)
       {
    	   if(day>0)
    	   {   holder.txtEnroll.setText("Ödevi Yüklemediniz.");  
    	   holder.txtEnroll.setTextColor(Color.RED);}
    	   else
    		   holder.txtEnroll.setText(date);
       }
       else if(assigment.getEnrollStatus()==1 || assigment.getEnrollStatus()==2 )
    	   holder.txtEnroll.setText("Ýnceleniyor.");
       else if(assigment.getEnrollStatus()==3)
    	   holder.txtEnroll.setText("Yeniden yükleyebilirsiniz.");
       else if(assigment.getEnrollStatus()==4)
    	   holder.txtEnroll.setText(String.valueOf(assigment.getScore()));
       return vi;
   }
}

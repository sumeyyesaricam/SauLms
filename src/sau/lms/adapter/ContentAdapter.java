package sau.lms.adapter;

import java.util.List;

import sau.lms.model.Content;
import sau.lms.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ContentAdapter extends ListAdapter<Content> {
   
   public ContentAdapter(Context c, List<Content> items) {
		super(c, items);
	}
   public static class ViewHolder{

       public TextView txtContentName;
       public ImageView img_folder;

   }
   @Override
   public View getView(int position, View convertView, ViewGroup parent) {
      
       ViewHolder holder=new ViewHolder();
       Content content = items.get(position);
       View vi=convertView;
       if(convertView==null){ 
       	try{
       		vi = inflater.inflate(R.layout.content_list, null);          
           holder.txtContentName=(TextView)vi.findViewById(R.id.txtContentName);             
           holder.img_folder=(ImageView)vi.findViewById(R.id.img_folder);
           vi.setTag(holder);         
           }
       	catch(Exception e){
           	e.printStackTrace();
           }
       }
       else  
       holder=(ViewHolder)convertView.getTag();
       holder.txtContentName.setText(content.getName());  
     
       if (content.getType()==4) {
    	   holder.img_folder.setImageResource(R.drawable.icon_image);
		} else if (content.getType()==8){
			holder.img_folder.setImageResource(R.drawable.icon_pdf);
		} else if (content.getType()==3) {
			holder.img_folder.setImageResource(R.drawable.icon_audio);
		} else if (content.getType()==9){
			holder.img_folder.setImageResource(R.drawable.icon_zip);
		}else if (content.getType()==6){
			holder.img_folder.setImageResource(R.drawable.icon_excel);
		}else if (content.getType()==5){
			holder.img_folder.setImageResource(R.drawable.icon_word);
		}else if (content.getType()==7){
			holder.img_folder.setImageResource(R.drawable.icon_power);
		}else if (content.getType()==1){
			holder.img_folder.setImageResource(R.drawable.icon_video);
		}else if (content.getType()==2){
			holder.img_folder.setImageResource(R.drawable.icon_link);
		}
       return vi;
   }
}

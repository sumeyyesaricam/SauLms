package sau.lms.helper;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateFormatter {

	public static long Extraction(String data)
	{
		Date now=new Date();
		long frk=0;				
	       SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
	       Date date;
	     try {
			date = simpleDateFormat.parse(data);
			long fark=now.getTime()-date.getTime();
		    frk=fark/(1000*60*60*24);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
	     return frk;
	}
	
	
	public static String Show(String data){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		Date date=null;
		try {
			 date = simpleDateFormat.parse(data);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		SimpleDateFormat sss = new SimpleDateFormat("yyyy");
		String dat = sss.format(date); 
		 Calendar now = Calendar.getInstance();
		 int year=Integer.valueOf(dat);
		  String format=null;
		   
		 if(now.get(Calendar.YEAR)==year)
		 {
			 if(0<Extraction(data) && Extraction(data)<7)
			 {
				 format="EEEE";
			 }
			 else{
				 format="dd MMMM";
			 }
		 }
		 else
			 format="dd MMMM yyyy";
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		String datee = sdf.format(date); 
		return datee;
	}

}



package sau.lms.helper;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import sau.lms.model.Assigment;
import sau.lms.model.Content;
import sau.lms.model.Course;
import sau.lms.model.Exam;
import sau.lms.model.User;
import sau.lms.model.VClass;

import com.google.gson.Gson;
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;
import com.google.gson.reflect.TypeToken;

public class JsonParser {
	public static <T> List<T> getObject(String result) throws IOException, ClassNotFoundException {
        Type type = new TypeToken<List<T>>() {}.getType();
        Gson gson = new Gson();
        List<T> _res = gson.fromJson(result, type);
        return _res;
    }
	
    public static List<Course> getCourseObject(String result) throws IOException, ClassNotFoundException {
        Type type = new TypeToken<List<Course>>(){}.getType();
        Gson gson = new Gson();
        List<Course> _res = gson.fromJson(result, type);
        return _res;
    }
    public static List<VClass> getVClassObject(String result) throws IOException, ClassNotFoundException {
        Type type = new TypeToken<List<VClass>>(){}.getType();
        Gson gson = new Gson();
        List<VClass> _res = gson.fromJson(result, type);
        return _res;
    }
    public static List<Content> getContentObject(String result) throws IOException, ClassNotFoundException {
        Type type = new TypeToken<List<Content>>(){}.getType();
        Gson gson = new Gson();
        List<Content> _res = gson.fromJson(result, type);
        return _res;
    }
    public static List<Assigment> getAssigmentObject(String result) throws IOException, ClassNotFoundException {
        Type type = new TypeToken<List<Assigment>>(){}.getType();
        Gson gson = new Gson();
        List<Assigment> _res = gson.fromJson(result, type);
        return _res;
    }
    public static List<Exam> getExamObject(String result) throws IOException, ClassNotFoundException {
        Type type = new TypeToken<List<Exam>>(){}.getType();
        Gson gson = new Gson();
        List<Exam> _res = gson.fromJson(result, type);
        return _res;
    }
    public static User getUserObject(String result) throws IOException, ClassNotFoundException {
        Type type = new TypeToken<User>(){}.getType();
        Gson gson = new Gson();
        User _res = gson.fromJson(result,type);
        return _res;
    }
    public static String getStringObject(String result) throws IOException, ClassNotFoundException {
        Type type = new TypeToken<String>() {}.getType();
        Gson gson = new Gson();
        String _res = gson.fromJson(result, type);
        return _res;
    }
}

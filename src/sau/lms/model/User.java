package sau.lms.model;

import java.io.Serializable;
import java.util.List;

import android.app.Application;

import com.google.gson.annotations.SerializedName;

public class User   implements Serializable{

	@SerializedName("UserId")
    private  int UserId ;  
	
	@SerializedName("Name")
    private  String Name ; 
	
	@SerializedName("Surname")
    private  String Surname ; 
	
	@SerializedName("StudentId")
    private  int StudentId ; 

    @SerializedName("LoginId")
    private  String LoginId ;
    
    @SerializedName("SessionId")
    private  int SessionId ;
    
    @SerializedName("UserName")
    private  String UserName ;

    @SerializedName("PasswordHash")
    private  String PasswordHash ;
    
    @SerializedName("UserIP")
    private  String UserIP ;
    
    @SerializedName("AttemptDate")
    private  String AttemptDate ;
    
    @SerializedName("Code")
    private  int Code ;

    @SerializedName("Message")
    private  String Message ;

    @SerializedName("Devices")
    private  List<UserDevice> Devices ;
    
    @SerializedName("Photo")
    private String Photo;

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userid) {
    	UserId = userid;
    }
    public String getName() {
        return Name;
    }

    public void setName(String name) {
    	Name = name;
    }
    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
    	Surname = surname;
    }
    
    public String getPhoto() {
        return Photo;
    }

    public void setPhoto(String photo) {
    	Photo = photo;
    }
    
    public int getStudentId() {
        return StudentId;
    }

    public void setStudentId(int studentid) {
    	StudentId = studentid;
    }

    public String getLoginId() {
        return LoginId;
    }

    public void setLoginId(String loginid) {
    	LoginId = loginid;
    }

    public int getSessionId() {
        return SessionId;
    }

    public void setSessionId(int sessionid) {
    	SessionId = sessionid;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String username) {
    	UserName = username;
    }

    public String getPasswordHash() {
        return PasswordHash;
    }

    public void setPasswordHash(String passwordhash) {
    	PasswordHash = passwordhash;
    }

    public String getUserIP() {
        return UserIP;
    }

    public void setUserIP(String userip) {
    	UserIP = userip;
    }

    public String getAttemptDate() {
        return AttemptDate;
    }

    public void setAttemptDate(String attemptdate) {
    	AttemptDate = attemptdate;
    }

    public int getCode() {
        return Code;
    }

    public void setCode(int code) {
    	Code = code;
    }

    public List<UserDevice> getDevices() {
        return Devices;
    }

    public void setDevices(List<UserDevice> devices) {
    	Devices = devices;
    }
    
    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
    	Message = message;
    }
}


package sau.lms.model;

import java.io.Serializable;
import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Exam implements Serializable {

	@SerializedName("Icon")
    private  String Icon ;
	
	@SerializedName("Description")
    private  String Description ;
	
	@SerializedName("ActivityKey")
    private  String ActivityKey ;
	
	@SerializedName("ActivityType")
    private  String ActivityType ;
	
	@SerializedName("ContentType")
    private  String ContentType ;
    
    @SerializedName("Status")
    private  byte Status ;

    @SerializedName("AttCount")
    private  int AttCount ;
    
    @SerializedName("Week")
    private  int Week ;
    
    @SerializedName("AttFirst")
    private  String AttFirst ;
    
    @SerializedName("AttLast")
    private  String AttLast ;
    
    @SerializedName("Score")
    private  int Score ;
    
    @SerializedName("TemplateId")
    private  int TemplateId ;
    
    @SerializedName("ScoreDesc")
    private  String ScoreDesc ;
    
    @SerializedName("EStatus")
    private  int EStatus ;
    
    @SerializedName("Url")
    private  String Url ;
    
    @SerializedName("EStatusText")
    private  String EStatusText ;
    
    @SerializedName("FileSize")
    private  int FileSize ;
    
    @SerializedName("Name")
    private  String Name ;

    @SerializedName("GroupId")
    private  int GroupId ;
    
    @SerializedName("ActivityId")
    private  int ActivityId ;
    
    @SerializedName("StartDate")
    private  String StartDate;
    
    @SerializedName("EndDate")
    private  String EndDate ; 
 
    @SerializedName("Publish")
    private  byte  Publish;
    
    @SerializedName("FileId")
    private  int FileId ;

    @SerializedName("UId")
    private  int UId;
    
    @SerializedName("UName")
    private  String UName;
    
    public String getIcon() {
        return Icon;
    }

    public void setIcon(String icon) {
    	Icon = icon;
    }
    
    public int getWeek() {
        return Week;
    }

    public void setWeek(int week) {
    	Week = week;
    }
    
    public String getActivityKey() {
        return ActivityKey;
    }

    public void setActivityKey(String activityKey) {
    	ActivityKey = activityKey;
    }
    public String getActivityType() {
        return ActivityType;
    }

    public void setActivityType(String activityType) {
    	ActivityType = activityType;
    }
    public String getContentType() {
        return ContentType;
    }

    public void setContentType(String contentType) {
    	ContentType = contentType;
    }

    public byte getStatus() {
        return Status;
    }

    public void setStatus(byte status) {
    	Status = status;
    }

    public int getAttCount() {
        return AttCount;
    }

    public void setAttCount(int attcount) {
    	AttCount = attcount;
    }

    public String getAttFirst() {
        return AttFirst;
    }

    public void setAttFirst(String attfirst) {
    	AttFirst = attfirst;
    }

    public String getAttLast() {
        return AttLast;
    }

    public void setAttLast(String attlast) {
    	AttLast = attlast;
    }

    public int getScore() {
        return Score;
    }

    public void setScore(int score) {
    	Score = score;
    }

    public String getScoreDesc() {
        return ScoreDesc;
    }

    public void setScoreDesc(String scoredesc) {
    	ScoreDesc = scoredesc;
    }

    public int getEStatus() {
        return EStatus;
    }

    public void setEStatus(int eStatus) {
    	EStatus = eStatus;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
    	Url = url;
    }
    
    public int getFileSize() {
        return FileSize;
    }

    public void setFileSize(int filesize) {
    	FileSize = filesize;
    }
    
    public int getGroupId() {
        return GroupId;
    }

    public void setGroupId(int groupid) {
    	GroupId = groupid;
    }
    public int getTemplateId() {
        return TemplateId;
    }

    public void setTemplateId(int templateId) {
    	TemplateId = templateId;
    }
    
    public int getActivityId() {
        return ActivityId;
    }

    public void setActivityId(int activityId) {
    	ActivityId = activityId;
    }
    
    public String getName() {
        return Name;
    }

    public void setName(String name) {
    	Name = name;
    }
    
    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
    	Description = description;
    }
    
    public int getFileId() {
        return FileId;
    }

    public void setFileId(int fileid) {
    	FileId = fileid;
    }
    
    public String getEStatusText() {
        return EStatusText;
    }

    public void setEStatusText(String eStatusText) {
    	EStatusText = eStatusText;
    }
    
    public String getEndDate() {
        return EndDate;
    }

    public void setEndDate(String endDate) {
    	EndDate = endDate;
    }
    
    public String getStartDate() {
        return StartDate;
    }

    public void setStartDate(String startDate) {
    	StartDate = startDate;
    }
    
    public byte getPublish() {
        return Publish;
    }

    public void setPublish(byte publish) {
    	Publish = publish;
    }
    
    public int getUId() {
        return UId;
    }

    public void setUId(int uid) {
    	UId = uid;
    }
    
    public String getUName() {
        return UName;
    }

    public void setUName(String uname) {
    	UName = uname;
    }
}
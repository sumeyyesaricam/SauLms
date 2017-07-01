package sau.lms.model;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

public class VClass implements Serializable {

	@SerializedName("StudentId")
    private  int StudentId ;	
    
    @SerializedName("AttFirst")
    private  String AttFirst ;
    
    @SerializedName("AttLast")
    private  String AttLast ;
    
    @SerializedName("LiveCount")
    private  int LiveCount ;
    
    @SerializedName("ReplayCount")
    private  int ReplayCount ;
    
    @SerializedName("EnrollKey")
    private  String EnrollKey ;
    
    @SerializedName("VClassId")
    private  String VClassId ;
    
    @SerializedName("CourseId")
    private  int CourseId ;
    
    @SerializedName("ProviderId")
    private  String ProviderId ;

    @SerializedName("GroupId")
    private  int GroupId ;
    
    @SerializedName("VCKey")
    private  int VCKey ;
    
    @SerializedName("Url")
    private  String Url ;

    @SerializedName("Name")
    private  String Name;
    
    @SerializedName("StartDate")
    private  String StartDate;
    
    @SerializedName("Week")
    private  String Week ; 
 
    @SerializedName("Publish")
    private  byte  Publish;
    
    @SerializedName("Deleted")
    private  boolean Deleted;
    
    @SerializedName("CUId")
    private  int CUId;
    
    @SerializedName("CUName")
    private  String CUName;
    
    @SerializedName("CDate")
    private  String CDate;
    
    @SerializedName("UUId")
    private  int UUId;
    
    @SerializedName("UDate")
    private  String UDate;
    
    @SerializedName("Replay")
    private  boolean Replay;
    
    @SerializedName("Duration")
    private  int Duration;
    
    @SerializedName("ScheduleId")
    private  int ScheduleId;
 
    public boolean getReplay() {
        return Replay;
    }

    public void setReplay(boolean replay) {
    	Replay = replay;
    }
    
    public int getDuration() {
        return Duration;
    }

    public void setDuration(int duration) {
    	Duration = duration;
    }
    
    public int getScheduleId() {
        return ScheduleId;
    }

    public void setScheduleId(int scheduleId) {
    	ScheduleId = scheduleId;
    }
    
    public int getStudentId() {
        return StudentId;
    }

    public void setStudentId(int studentid) {
        StudentId = studentid;
    }

    public int getLiveCount() {
        return LiveCount;
    }

    public void setLiveCount(byte liveCount) {
    	LiveCount = liveCount;
    }

    public int getReplayCount() {
        return ReplayCount;
    }

    public void setReplayCount(int replayCount) {
    	ReplayCount = replayCount;
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

    public String getEnrollKey() {
        return EnrollKey;
    }

    public void setEnrollKey(String enrollKey) {
    	EnrollKey = enrollKey;
    }

    public String getVClassId() {
        return VClassId;
    }

    public void setVClassId(String vclassId) {
    	VClassId = vclassId;
    }

    public int getCourseId() {
        return CourseId;
    }

    public void setCourseId(int courseId) {
    	CourseId = courseId;
    }

    public String getProviderId() {
        return ProviderId;
    }

    public void setProviderId(String providerId) {
    	ProviderId = providerId;
    }
    
    public int getVCKey() {
        return VCKey;
    }

    public void setVCKey(int vcKey) {
    	VCKey = vcKey;
    }
    
    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
    	Url = url;
    }
    
    public int getGroupId() {
        return GroupId;
    }

    public void setGroupId(int groupid) {
    	GroupId = groupid;
    }
  
    public String getName() {
        return Name;
    }

    public void setName(String name) {
    	Name = name;
    }
    
    
    public String getWeek() {
        return Week;
    }

    public void setWeek(String week) {
    	Week = week;
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
    
    public boolean getDeleted() {
        return Deleted;
    }

    public void setDeleted(boolean deleted) {
    	Deleted = deleted;
    }
    
    public int getCUId() {
        return CUId;
    }

    public void setCUId(int cuid) {
    	CUId = cuid;
    }
    
    public String getCUName() {
        return CUName;
    }

    public void setCUName(String cuname) {
    	CUName = cuname;
    }
    
    public String getCDate() {
        return CDate;
    }

    public void setCDate(String cdate) {
    	CDate = cdate;
    }
    
    public int getUUId() {
        return UUId;
    }

    public void setUUId(int uuid) {
    	UUId = uuid;
    }
    
    public String getUDate() {
        return UDate;
    }

    public void setUDate(String udate) {
    	UDate = udate;
    }
    
}



package sau.lms.model;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

public class Content  implements Serializable {

	@SerializedName("StudentId")
    private  int StudentId ;
    
    @SerializedName("Status")
    private  byte Status ;

    @SerializedName("AttCount")
    private  int AttCount ;
    
    @SerializedName("AttFirst")
    private  String AttFirst ;
    
    @SerializedName("AttLast")
    private  String AttLast ;
    
    @SerializedName("Prog")
    private  long Prog ;
    
    @SerializedName("ProgData")
    private  String ProgData ;
    
    @SerializedName("ProgPercent")
    private  int ProgPercent ;
    
    @SerializedName("ContentId")
    private  int ContentId ;
    
    @SerializedName("Name")
    private  String Name ;

    @SerializedName("Type")
    private  byte Type ;

    @SerializedName("FileId")
    private  int FileId ;

    @SerializedName("FileUrl")
    private  String FileUrl ;

    @SerializedName("CourseId")
    private  int CourseId ;

    @SerializedName("FileSize")
    private  int FileSize ;
    
    @SerializedName("Url")
    private  String Url ;

    @SerializedName("GroupId")
    private  int GroupId ;

    @SerializedName("Width")
    private  int Width;

    @SerializedName("Heigth")
    private  int Heigth;
    
    @SerializedName("Publish")
    private  byte  Publish;
    
    @SerializedName("Deleted")
    private  boolean Deleted;
    
    @SerializedName("Tracking")
    private  boolean Tracking;
    
    @SerializedName("Week")
    private  int Week;
    
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
    
    @SerializedName("Icon")
    private  String Icon;
    
    @SerializedName("Converted")
    private  int Converted;

   

    public int getStudentId() {
        return StudentId;
    }

    public void setStudentId(int studentid) {
        StudentId = studentid;
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

    public long getProg() {
        return Prog;
    }

    public void setProg(long prog) {
    	Prog = prog;
    }

    public String getProgData() {
        return ProgData;
    }

    public void setProgData(String progdata) {
    	ProgData = progdata;
    }

    public int getProgPercent() {
        return ProgPercent;
    }

    public void setProgPercent(int progpercent) {
    	ProgPercent = progpercent;
    }

    public int getContentId() {
        return ContentId;
    }

    public void setContentId(int contentid) {
    	ContentId = contentid;
    }
    
    public int getCourseId() {
        return CourseId;
    }

    public void setCourseId(int courseid) {
    	CourseId = courseid;
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
    
    public byte getType() {
        return Type;
    }

    public void setType(byte type) {
    	Type = type;
    }
    
    public int getFileId() {
        return FileId;
    }

    public void setFileId(int fileid) {
    	FileId = fileid;
    }
    
    public String getFileUrl() {
        return FileUrl;
    }

    public void setFileUrl(String fileurl) {
    	FileUrl = fileurl;
    }
    
    public int getFileSize() {
        return FileSize;
    }

    public void setFileSize(int filesize) {
    	FileSize = filesize;
    }
    
    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
    	Url = url;
    }
    public int getWidth() {
        return Width;
    }

    public void setWidth(int width) {
    	Width = width;
    }
    
    public int getHeigth() {
        return Heigth;
    }

    public void setHeigth(int heigth) {
    	Heigth = heigth;
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
    
    public boolean getTracking() {
        return Tracking;
    }

    public void setTracking(boolean tracking) {
    	Tracking = tracking;
    }
    
    public int getWeek() {
        return Week;
    }

    public void setWeek(int week) {
    	Week = week;
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
    
    public String getIcon() {
        return Icon;
    }

    public void setIcon(String icon) {
    	Icon = icon;
    }
    
    public int getConverted() {
        return Converted;
    }

    public void setConverted(int converted) {
    	Converted = converted;
    }
}


package sau.lms.model;
import java.io.Serializable;
import com.google.gson.annotations.SerializedName;

public class Assigment implements Serializable {

	@SerializedName("StudentId")
    private  int StudentId ;
    
    @SerializedName("EnrollStatus")
    private  byte EnrollStatus ;

    @SerializedName("AttCount")
    private  int AttCount ;
    
    @SerializedName("AttFirst")
    private  String AttFirst ;
    
    @SerializedName("AttLast")
    private  String AttLast ;
    
    @SerializedName("Score")
    private  int Score ;
    
    @SerializedName("ScoreDesc")
    private  String ScoreDesc ;
    
    @SerializedName("EnrollFileId")
    private  int EnrollFileId ;
    
    @SerializedName("EnrollFileUrl")
    private  String EnrollFileUrl ;
    
    @SerializedName("EnrollFileSize")
    private  int EnrollFileSize ;
    
    @SerializedName("AssignmentId")
    private  int AssignmentId ;
    
    @SerializedName("Name")
    private  String Name ;

    @SerializedName("GroupId")
    private  int GroupId ;
    
    @SerializedName("TActivityId")
    private  int TActivityId ;
    
    @SerializedName("Desc")
    private  String Desc ;

    @SerializedName("UploadCount")
    private  int UploadCount;
    
    @SerializedName("StartDate")
    private  String StartDate;
    
    @SerializedName("EndDate")
    private  String EndDate ; 
 
    @SerializedName("Publish")
    private  byte  Publish;
    
    @SerializedName("Deleted")
    private  boolean Deleted;
    

    @SerializedName("FileId")
    private  int FileId ;

    @SerializedName("FileUrl")
    private  String FileUrl ;
    
    @SerializedName("FileSize")
    private  int FileSize ; 
  
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
 
    public int getStudentId() {
        return StudentId;
    }

    public void setStudentId(int studentid) {
        StudentId = studentid;
    }

    public byte getEnrollStatus() {
        return EnrollStatus;
    }

    public void setEnrollStatus(byte enrollstatus) {
    	EnrollStatus = enrollstatus;
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

    public int getEnrollFileId() {
        return EnrollFileId;
    }

    public void setEnrollFileId(int enrollfileId) {
    	EnrollFileId = enrollfileId;
    }

    public String getEnrollFileUrl() {
        return EnrollFileUrl;
    }

    public void setEnrollFileUrl(String enrollfileurl) {
    	EnrollFileUrl = enrollfileurl;
    }
    
    public int getEnrollFileSize() {
        return EnrollFileSize;
    }

    public void setEnrollFileSize(int enrollfilesize) {
    	EnrollFileSize = enrollfilesize;
    }
    
    public int getAssignmentId() {
        return AssignmentId;
    }

    public void setAssignmentId(int assignmentId) {
    	AssignmentId = assignmentId;
    }
    
    public String getDesc() {
        return Desc;
    }

    public void setDesc(String desc) {
    	Desc = desc;
    }
    
    public int getGroupId() {
        return GroupId;
    }

    public void setGroupId(int groupid) {
    	GroupId = groupid;
    }
    
    public int getTActivityId() {
        return TActivityId;
    }

    public void setTActivityId(int tactivityId) {
    	TActivityId = tactivityId;
    }
    
    public String getName() {
        return Name;
    }

    public void setName(String name) {
    	Name = name;
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
    
    public String getEndDate() {
        return EndDate;
    }

    public void setEndDate(String endDate) {
    	EndDate = endDate;
    }
    public int getUploadCount() {
        return UploadCount;
    }

    public void setUploadCount(int uploadCount) {
    	UploadCount = uploadCount;
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

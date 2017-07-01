package sau.lms.model;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

public class Course  implements Serializable {

    @SerializedName("EnrollmentId")
    private  int EnrollmentId ;

    @SerializedName("StudentId")
    private  int StudentId ;

    @SerializedName("AssignmentCount")
    private  int AssignmentCount ;

    @SerializedName("ExamCount")
    private  int ExamCount ;

    @SerializedName("VClassCount")
    private  int VClassCount ;

    @SerializedName("ContentCount")
    private  int ContentCount ;

    @SerializedName("CourseId")
    private  int CourseId ;

    @SerializedName("CourseName")
    private  String CourseName ;

    @SerializedName("GroupId")
    private  int GroupId ;

    @SerializedName("GroupName")
    private  String GroupName;


    public int getEnrollmentId() {
        return EnrollmentId;
    }

    public void setEnrollmentId(int enrollmentid) {
        EnrollmentId = enrollmentid;
    }

    public int getStudentId() {
        return StudentId;
    }

    public void setStudentId(int studentid) {
        StudentId = studentid;
    }

    public int getCourseId() {
        return CourseId;
    }

    public void setCourseId(int courseid) {
        CourseId = courseid;
    }

    public int getContentCount() {
        return ContentCount;
    }

    public void setContentCount(int contentcount) {
        ContentCount = contentcount;
    }

    public int getVClassCount() {
        return VClassCount;
    }

    public void setVClassCount(int vclasscount) {
        VClassCount = vclasscount;
    }

    public String getCourseName() {
        return CourseName;
    }

    public void setCourseName(String coursename) {
        CourseName = coursename;
    }

    public int getAssignmentCount() {
        return AssignmentCount;
    }

    public void setAssignmentCount(int assignmentcount) {
        AssignmentCount = assignmentcount;
    }

    public int getExamCount() {
        return ExamCount;
    }

    public void setExamCount(int examcount) {
        ExamCount = examcount;
    }

    public int getGroupId() {
        return GroupId;
    }

    public void setGroupId(int groupid) {
        GroupId = groupid;
    }

    public String getGroupName() {
        return GroupName;
    }

    public void setGroupName(String groupname) {
        GroupName = groupname;
    }
}



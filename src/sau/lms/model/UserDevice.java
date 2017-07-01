package sau.lms.model;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

public class UserDevice  implements Serializable{
	
    @SerializedName("RegId")
    private int RegId ;
    
    @SerializedName("UserId")
    private int UserId ;
    
    @SerializedName("Device")
    private int Device ;
    
    @SerializedName("DeviceKey")
    private String DeviceKey ;
    
    @SerializedName("RegDate")
    private String RegDate ;
    
    @SerializedName("Enable")
    private boolean Enable ;
    
    public int getRegId() {
        return RegId;
    }

    public void setRegId(int regId) {
    	RegId = regId;
    }
    
    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userid) {
    	UserId = userid;
    }
    public int getDevice() {
        return Device;
    }

    public void setDevice(int device) {
    	Device = device;
    }
    
    public String getDeviceKey() {
        return DeviceKey;
    }

    public void setDeviceKey(String deviceKey) {
    	DeviceKey = deviceKey;
    }

    public String getRegDate() {
        return RegDate;
    }

    public void setRegDate(String regDate) {
    	RegDate = regDate;
    }
    
    public boolean getEnable() {
        return Enable;
    }

    public void setEnable(boolean enable) {
    	Enable = enable;
    }
}


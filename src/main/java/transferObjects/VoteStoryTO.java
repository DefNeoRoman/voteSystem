package transferObjects;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class VoteStoryTO {
    private String userName;
    private String placeName;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date date;

    public VoteStoryTO(String userName, String placeName, Date date) {
        this.userName = userName;
        this.placeName = placeName;
        this.date = date;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

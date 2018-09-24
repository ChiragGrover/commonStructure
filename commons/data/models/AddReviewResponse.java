
package skycap.com.driver.go4er.data.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AddReviewResponse {

    @SerializedName("valid")
    @Expose
    private Boolean valid;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private List<AddReviewData> data = null;
    @SerializedName("code")
    @Expose
    private Integer code;

    public Boolean getValid() {
        return valid;
    }

    public void setValid(Boolean valid) {
        this.valid = valid;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<AddReviewData> getData() {
        return data;
    }

    public void setData(List<AddReviewData> data) {
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}

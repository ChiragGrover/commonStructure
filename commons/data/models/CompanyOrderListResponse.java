
package skycap.com.driver.go4er.data.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import skycap.com.driver.go4er.data.models.packageList.IncomingPackage;

public class CompanyOrderListResponse {

    @SerializedName("valid")
    @Expose
    private Boolean valid;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private List<IncomingPackage> data;
    @SerializedName("error")
    @Expose
    private Error error;
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

    public List<IncomingPackage> getData() {
        return data;
    }

    public void setData(List<IncomingPackage> data) {
        this.data = data;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}

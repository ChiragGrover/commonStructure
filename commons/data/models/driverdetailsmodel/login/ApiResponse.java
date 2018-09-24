package skycap.com.driver.go4er.data.models.driverdetailsmodel.login;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class ApiResponse {
    @SerializedName("valid")
    @Expose
    private Boolean valid;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private Data data;
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
    public Data getData() {
        return data;
    }
    public void setData(Data data) {
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

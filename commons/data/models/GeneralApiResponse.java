
package skycap.com.driver.go4er.data.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GeneralApiResponse<T> {

    @SerializedName("valid")
    @Expose
    private Boolean valid;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private T data;
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
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

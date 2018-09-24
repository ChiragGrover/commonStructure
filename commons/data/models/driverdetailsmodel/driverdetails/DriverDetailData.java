
package skycap.com.driver.go4er.data.models.driverdetailsmodel.driverdetails;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import skycap.com.driver.go4er.data.models.driverdetailsmodel.login.User;

public class DriverDetailData {

    @SerializedName("user")
    @Expose
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

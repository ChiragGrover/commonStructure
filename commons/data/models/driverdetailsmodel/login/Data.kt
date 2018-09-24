package skycap.com.driver.go4er.data.models.driverdetailsmodel.login

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import skycap.com.driver.go4er.data.models.OrderDetails.Order
import java.io.Serializable
import skycap.com.driver.go4er.data.models.signatureModel.Image

class Data: Serializable {
    @SerializedName("token")
    @Expose
    var token: Token? = null
    @SerializedName("user")
    @Expose
    var user: User? = null
    @SerializedName("package")
    @Expose
     var _package: Package? = null
    @SerializedName("order")
    @Expose
     var order: Order? = null
    @SerializedName("image")
    @Expose
     var image: List<Image>? = null



}

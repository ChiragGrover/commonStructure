package skycap.com.driver.go4er.data.models.driverdetailsmodel
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import skycap.com.driver.go4er.data.models.quotationSend.Data
import skycap.com.driver.go4er.data.models.quotationSend.Status
import java.io.Serializable
class CommonApiResponse : Serializable {
    @SerializedName("valid")
    @Expose
    var valid: Boolean? = null
    @SerializedName("message")
    @Expose
    var message: String? = null
    @SerializedName("code")
    @Expose
    var code: Int? = null
    @SerializedName("error")
    @Expose
    var error: String? = null
    @SerializedName("redirect")
    @Expose
    var redirect: String? = null
    @SerializedName("status")
    @Expose
     val status: List<Status>? = null
    @SerializedName("swal")
    @Expose
    var swal: String? = null
}

package skycap.com.driver.go4er.data.models.packageList

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class PackageListData {

    @SerializedName("incoming_packages")
    @Expose
    var incomingPackages: List<IncomingPackage>? = null
    @SerializedName("quotations_sent")
    @Expose
    var quotationsSent: List<IncomingPackage>? = null
}

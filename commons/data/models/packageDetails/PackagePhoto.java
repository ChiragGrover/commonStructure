
package skycap.com.driver.go4er.data.models.packageDetails;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PackagePhoto {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("package_id")
    @Expose
    private Integer packageId;
    @SerializedName("photo_path")
    @Expose
    private String photoPath;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("package_pic_url")
    @Expose
    private String packagePicUrl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPackageId() {
        return packageId;
    }

    public void setPackageId(Integer packageId) {
        this.packageId = packageId;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getPackagePicUrl() {
        return packagePicUrl;
    }

    public void setPackagePicUrl(String packagePicUrl) {
        this.packagePicUrl = packagePicUrl;
    }

}

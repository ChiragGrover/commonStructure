
package skycap.com.driver.go4er.data.models.packageDetails;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Quotation {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("provider_id")
    @Expose
    private Integer providerId;
    @SerializedName("package_id")
    @Expose
    private Integer packageId;
    @SerializedName("amount")
    @Expose
    private String amount;
    @SerializedName("proposal")
    @Expose
    private Object proposal;
    @SerializedName("is_accepted")
    @Expose
    private Integer isAccepted;
    @SerializedName("is_rejected")
    @Expose
    private String isRejected;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("status_label")
    @Expose
    private String statusLabel;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProviderId() {
        return providerId;
    }

    public void setProviderId(Integer providerId) {
        this.providerId = providerId;
    }

    public Integer getPackageId() {
        return packageId;
    }

    public void setPackageId(Integer packageId) {
        this.packageId = packageId;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public Object getProposal() {
        return proposal;
    }

    public void setProposal(Object proposal) {
        this.proposal = proposal;
    }

    public Integer getIsAccepted() {
        return isAccepted;
    }

    public void setIsAccepted(Integer isAccepted) {
        this.isAccepted = isAccepted;
    }

    public String getIsRejected() {
        return isRejected;
    }

    public void setIsRejected(String isRejected) {
        this.isRejected = isRejected;
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

    public String getStatusLabel() {
        return statusLabel;
    }

    public void setStatusLabel(String statusLabel) {
        this.statusLabel = statusLabel;
    }
}

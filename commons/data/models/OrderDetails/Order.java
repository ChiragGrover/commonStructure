package skycap.com.driver.go4er.data.models.OrderDetails;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by skycap.
 */
public class Order {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("order_no")
    @Expose
    private String orderNo;
    @SerializedName("account_id")
    @Expose
    private Integer accountId;
    @SerializedName("provider_id")
    @Expose
    private Integer providerId;
    @SerializedName("package_id")
    @Expose
    private Integer packageId;
    @SerializedName("quotation_id")
    @Expose
    private Integer quotationId;
    @SerializedName("amount")
    @Expose
    private String amount;
    @SerializedName("commission")
    @Expose
    private String commission;
    @SerializedName("net_amount")
    @Expose
    private String netAmount;
    @SerializedName("status_id")
    @Expose
    private Integer statusId;
    @SerializedName("expected_delivery_date")
    @Expose
    private Object expectedDeliveryDate;
    @SerializedName("delivery_date")
    @Expose
    private Object deliveryDate;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("is_correct_item")
    @Expose
    private Object isCorrectItem;
    @SerializedName("is_available")
    @Expose
    private Object isAvailable;
    @SerializedName("pickup_type")
    @Expose
    private Object pickupType;
    @SerializedName("sender_sign")
    @Expose
    private Object senderSign;
    @SerializedName("sender_name")
    @Expose
    private Object senderName;
    @SerializedName("sender_id_proof")
    @Expose
    private Object senderIdProof;
    @SerializedName("pickup_time")
    @Expose
    private Object pickupTime;
    @SerializedName("receiver_sign")
    @Expose
    private Object receiverSign;
    @SerializedName("receiver_name")
    @Expose
    private Object receiverName;
    @SerializedName("id_proof")
    @Expose
    private Object idProof;
    @SerializedName("is_seen")
    @Expose
    private Integer isSeen;
    @SerializedName("pickup_status")
    @Expose
    private String pickupStatus;
    @SerializedName("delivery_status")
    @Expose
    private String deliveryStatus;
    @SerializedName("driver_id")
    @Expose
    private Integer driverId;
    @SerializedName("order_status")
    @Expose
    private List<Object> orderStatus = null;
    @SerializedName("status")
    @Expose
    private Object status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
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

    public Integer getQuotationId() {
        return quotationId;
    }

    public void setQuotationId(Integer quotationId) {
        this.quotationId = quotationId;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCommission() {
        return commission;
    }

    public void setCommission(String commission) {
        this.commission = commission;
    }

    public String getNetAmount() {
        return netAmount;
    }

    public void setNetAmount(String netAmount) {
        this.netAmount = netAmount;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public Object getExpectedDeliveryDate() {
        return expectedDeliveryDate;
    }

    public void setExpectedDeliveryDate(Object expectedDeliveryDate) {
        this.expectedDeliveryDate = expectedDeliveryDate;
    }

    public Object getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Object deliveryDate) {
        this.deliveryDate = deliveryDate;
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

    public Object getIsCorrectItem() {
        return isCorrectItem;
    }

    public void setIsCorrectItem(Object isCorrectItem) {
        this.isCorrectItem = isCorrectItem;
    }

    public Object getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(Object isAvailable) {
        this.isAvailable = isAvailable;
    }

    public Object getPickupType() {
        return pickupType;
    }

    public void setPickupType(Object pickupType) {
        this.pickupType = pickupType;
    }

    public Object getSenderSign() {
        return senderSign;
    }

    public void setSenderSign(Object senderSign) {
        this.senderSign = senderSign;
    }

    public Object getSenderName() {
        return senderName;
    }

    public void setSenderName(Object senderName) {
        this.senderName = senderName;
    }

    public Object getSenderIdProof() {
        return senderIdProof;
    }

    public void setSenderIdProof(Object senderIdProof) {
        this.senderIdProof = senderIdProof;
    }

    public Object getPickupTime() {
        return pickupTime;
    }

    public void setPickupTime(Object pickupTime) {
        this.pickupTime = pickupTime;
    }

    public Object getReceiverSign() {
        return receiverSign;
    }

    public void setReceiverSign(Object receiverSign) {
        this.receiverSign = receiverSign;
    }

    public Object getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(Object receiverName) {
        this.receiverName = receiverName;
    }

    public Object getIdProof() {
        return idProof;
    }

    public void setIdProof(Object idProof) {
        this.idProof = idProof;
    }

    public Integer getIsSeen() {
        return isSeen;
    }

    public void setIsSeen(Integer isSeen) {
        this.isSeen = isSeen;
    }

    public String getPickupStatus() {
        return pickupStatus;
    }

    public void setPickupStatus(String pickupStatus) {
        this.pickupStatus = pickupStatus;
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public Integer getDriverId() {
        return driverId;
    }

    public void setDriverId(Integer driverId) {
        this.driverId = driverId;
    }

    public List<Object> getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(List<Object> orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Object getStatus() {
        return status;
    }

    public void setStatus(Object status) {
        this.status = status;
    }
}

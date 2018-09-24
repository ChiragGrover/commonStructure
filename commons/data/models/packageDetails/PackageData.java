
package skycap.com.driver.go4er.data.models.packageDetails;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import skycap.com.driver.go4er.data.models.OrderDetails.Order;
import skycap.com.driver.go4er.data.models.driverdetailsmodel.login.User;

public class PackageData {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("account_id")
    @Expose
    private Integer accountId;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("weight")
    @Expose
    private String weight;
    @SerializedName("delivery_type")
    @Expose
    private String deliveryType;
    @SerializedName("pickup_location")
    @Expose
    private String pickupLocation;
    @SerializedName("pickup_landmark")
    @Expose
    private String pickupLandmark;
    @SerializedName("pickup_city")
    @Expose
    private String pickupCity;
    @SerializedName("pickup_date")
    @Expose
    private String pickupDate;
    @SerializedName("pickup_time")
    @Expose
    private String pickupTime;
    @SerializedName("pickup_lat")
    @Expose
    private String pickupLat;
    @SerializedName("pickup_lng")
    @Expose
    private String pickupLng;
    @SerializedName("delivery_location")
    @Expose
    private String deliveryLocation;
    @SerializedName("delivery_landmark")
    @Expose
    private String deliveryLandmark;
    @SerializedName("delivery_city")
    @Expose
    private String deliveryCity;
    @SerializedName("delivery_date")
    @Expose
    private String deliveryDate;
    @SerializedName("delivery_time")
    @Expose
    private String deliveryTime;
    @SerializedName("delivery_lat")
    @Expose
    private String deliveryLat;
    @SerializedName("delivery_lng")
    @Expose
    private String deliveryLng;
    @SerializedName("user_type")
    @Expose
    private String userType;
    @SerializedName("package_name")
    @Expose
    private Object packageName;
    @SerializedName("instructions")
    @Expose
    private Object instructions;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("quotation")
    @Expose
    private List<Quotation> quotation = null;
    @SerializedName("bid_price")
    @Expose
    private Float bidPrice;
    @SerializedName("user_package_status")
    @Expose
    private String userPackageStatus;
    @SerializedName("weight_string")
    @Expose
    private String weightString;
    @SerializedName("order_id")
    @Expose
    private Object orderId;
    @SerializedName("order_stage")
    @Expose
    private Object orderStage;
    @SerializedName("created_at_date_time")
    @Expose
    private String createdAtDateTime;
    @SerializedName("pickup_date_time")
    @Expose
    private String pickupDateTime;
    @SerializedName("delivery_date_time")
    @Expose
    private String deliveryDateTime;
    @SerializedName("user")
    @Expose
    private User user;

    @SerializedName("order")
    @Expose
    private Order order;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @SerializedName("package_photo")
    @Expose
    private List<PackagePhoto> packagePhoto = null;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }

    public String getPickupLocation() {
        return pickupLocation;
    }

    public void setPickupLocation(String pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public String getPickupLandmark() {
        return pickupLandmark;
    }

    public void setPickupLandmark(String pickupLandmark) {
        this.pickupLandmark = pickupLandmark;
    }

    public String getPickupCity() {
        return pickupCity;
    }

    public void setPickupCity(String pickupCity) {
        this.pickupCity = pickupCity;
    }

    public String getPickupDate() {
        return pickupDate;
    }

    public void setPickupDate(String pickupDate) {
        this.pickupDate = pickupDate;
    }

    public String getPickupTime() {
        return pickupTime;
    }

    public void setPickupTime(String pickupTime) {
        this.pickupTime = pickupTime;
    }

    public String getPickupLat() {
        return pickupLat;
    }

    public void setPickupLat(String pickupLat) {
        this.pickupLat = pickupLat;
    }

    public String getPickupLng() {
        return pickupLng;
    }

    public void setPickupLng(String pickupLng) {
        this.pickupLng = pickupLng;
    }

    public String getDeliveryLocation() {
        return deliveryLocation;
    }

    public void setDeliveryLocation(String deliveryLocation) {
        this.deliveryLocation = deliveryLocation;
    }

    public String getDeliveryLandmark() {
        return deliveryLandmark;
    }

    public void setDeliveryLandmark(String deliveryLandmark) {
        this.deliveryLandmark = deliveryLandmark;
    }

    public String getDeliveryCity() {
        return deliveryCity;
    }

    public void setDeliveryCity(String deliveryCity) {
        this.deliveryCity = deliveryCity;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public String getDeliveryLat() {
        return deliveryLat;
    }

    public void setDeliveryLat(String deliveryLat) {
        this.deliveryLat = deliveryLat;
    }

    public String getDeliveryLng() {
        return deliveryLng;
    }

    public void setDeliveryLng(String deliveryLng) {
        this.deliveryLng = deliveryLng;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public Object getPackageName() {
        return packageName;
    }

    public void setPackageName(Object packageName) {
        this.packageName = packageName;
    }

    public Object getInstructions() {
        return instructions;
    }

    public void setInstructions(Object instructions) {
        this.instructions = instructions;
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

    public List<Quotation> getQuotation() {
        return quotation;
    }

    public void setQuotation(List<Quotation> quotation) {
        this.quotation = quotation;
    }

    public Float getBidPrice() {
        float price = 0f;
        if (bidPrice != null) {
            price = bidPrice;
        }
        return price;
    }

    public void setBidPrice(Float bidPrice) {
        this.bidPrice = bidPrice;
    }

    public String getUserPackageStatus() {
        return userPackageStatus;
    }

    public void setUserPackageStatus(String userPackageStatus) {
        this.userPackageStatus = userPackageStatus;
    }

    public String getWeightString() {
        return weightString;
    }

    public void setWeightString(String weightString) {
        this.weightString = weightString;
    }

    public Object getOrderId() {
        return orderId;
    }

    public void setOrderId(Object orderId) {
        this.orderId = orderId;
    }

    public Object getOrderStage() {
        return orderStage;
    }

    public void setOrderStage(Object orderStage) {
        this.orderStage = orderStage;
    }

    public String getCreatedAtDateTime() {
        return createdAtDateTime;
    }

    public void setCreatedAtDateTime(String createdAtDateTime) {
        this.createdAtDateTime = createdAtDateTime;
    }

    public String getPickupDateTime() {
        return pickupDateTime;
    }

    public void setPickupDateTime(String pickupDateTime) {
        this.pickupDateTime = pickupDateTime;
    }

    public String getDeliveryDateTime() {
        return deliveryDateTime;
    }

    public void setDeliveryDateTime(String deliveryDateTime) {
        this.deliveryDateTime = deliveryDateTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<PackagePhoto> getPackagePhoto() {
        return packagePhoto;
    }

    public void setPackagePhoto(List<PackagePhoto> packagePhoto) {
        this.packagePhoto = packagePhoto;
    }

}

package greater.pojo;
// Generated Mar 23, 2019 12:04:22 PM by Hibernate Tools 4.3.1



/**
 * ServiceCharges generated by hbm2java
 */
public class ServiceCharges  implements java.io.Serializable {


     private String serChargeId;
     private Double serviceCharge;
     private Double subTotal;
     private Double grandTotal;
     private String email;
     private String walkInGuestId;
     private String productDescription;
     private String createdDate;

    public ServiceCharges() {
    }

	
    public ServiceCharges(String serChargeId) {
        this.serChargeId = serChargeId;
    }
    public ServiceCharges(String serChargeId, Double serviceCharge, Double subTotal, Double grandTotal, String email, String walkInGuestId, String productDescription, String createdDate) {
       this.serChargeId = serChargeId;
       this.serviceCharge = serviceCharge;
       this.subTotal = subTotal;
       this.grandTotal = grandTotal;
       this.email = email;
       this.walkInGuestId = walkInGuestId;
       this.productDescription = productDescription;
       this.createdDate = createdDate;
    }
   
    public String getSerChargeId() {
        return this.serChargeId;
    }
    
    public void setSerChargeId(String serChargeId) {
        this.serChargeId = serChargeId;
    }
    public Double getServiceCharge() {
        return this.serviceCharge;
    }
    
    public void setServiceCharge(Double serviceCharge) {
        this.serviceCharge = serviceCharge;
    }
    public Double getSubTotal() {
        return this.subTotal;
    }
    
    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }
    public Double getGrandTotal() {
        return this.grandTotal;
    }
    
    public void setGrandTotal(Double grandTotal) {
        this.grandTotal = grandTotal;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public String getWalkInGuestId() {
        return this.walkInGuestId;
    }
    
    public void setWalkInGuestId(String walkInGuestId) {
        this.walkInGuestId = walkInGuestId;
    }
    public String getProductDescription() {
        return this.productDescription;
    }
    
    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }
    public String getCreatedDate() {
        return this.createdDate;
    }
    
    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }




}



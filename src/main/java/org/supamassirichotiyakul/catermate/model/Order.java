package org.supamassirichotiyakul.catermate.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="ORDERS")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String customerFirstName;

    private String customerLastName;

    private String deliveryAddress;

    private String customerPhone;

    private String deliveryOption;

    private String location;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date deliveryDate;

    @DateTimeFormat(pattern="HH:mm")
    @Temporal(TemporalType.TIME)
    private Date kitchenReadyTime;

    private double subTotal;

    private double tax;

    private double total;

    @OneToMany(mappedBy = "order", targetEntity = OrderItem.class, fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    private List<OrderItem> orderItemList;

    public Order() {
        orderItemList = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public void setCustomerFirstName(String customerFirstName) {
        this.customerFirstName = customerFirstName;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }

    public void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getDeliveryOption() {
        return deliveryOption;
    }

    public void setDeliveryOption(String deliveryOption) {
        this.deliveryOption = deliveryOption;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Date getKitchenReadyTime() {
        return kitchenReadyTime;
    }

    public void setKitchenReadyTime(Date kitchenReadyTime) {
        this.kitchenReadyTime = kitchenReadyTime;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public String getSubTotalDisplay() {
        return String.format("$%.2f", getSubTotal());
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public double getTax() {
        return tax;
    }

    public String getTaxDisplay() {
        return String.format("$%.2f", getTax());
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getTotal() {
        return total;
    }

    public String getTotalDisplay() {
        return String.format("$%.2f", getTotal());
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(List<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }
}
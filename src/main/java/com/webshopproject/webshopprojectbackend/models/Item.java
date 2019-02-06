package com.webshopproject.webshopprojectbackend.models;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long itemId;
    private String name;
    private int inStock;
    private String description;
    //summary?
    private boolean isActive;
    private String category;
//    private boolean isPriceBasedOnWeight; //Make if statement in angular html and boolean in ts file
    private double priceForOneItem; //double or string? might want to add 100kr. pr kilo
    private String weightMeasurement; //This is used for priceBasedOnWeight. For example g or kg
    private double priceBasedOnWeight;

    @CreationTimestamp //Hibernate annotation
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTimeCreated;

    @UpdateTimestamp //Hibernate annotation
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTimeEdited;

    @Temporal(TemporalType.DATE)
    private Date expirationDate;

    //canBeCollected

    //Add picture
    //@Lob
//    private byte[] thumpNail;

    //@Lob
//    private List<byte[]> images;

    //Relations
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    //Getters and setters
    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getInStock() {
        return inStock;
    }

    public void setInStock(int inStock) {
        this.inStock = inStock;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPriceForOneItem() {
        return priceForOneItem;
    }

    public void setPriceForOneItem(double priceForOneItem) {
        this.priceForOneItem = priceForOneItem;
    }

    public String getWeightMeasurement() {
        return weightMeasurement;
    }

    public void setWeightMeasurement(String weightMeasurement) {
        this.weightMeasurement = weightMeasurement;
    }

    public double getPriceBasedOnWeight() {
        return priceBasedOnWeight;
    }

    public void setPriceBasedOnWeight(double priceBasedOnWeight) {
        this.priceBasedOnWeight = priceBasedOnWeight;
    }

    public Date getDateTimeCreated() {
        return dateTimeCreated;
    }

    public void setDateTimeCreated(Date dateTimeCreated) {
        this.dateTimeCreated = dateTimeCreated;
    }

    public Date getDateTimeEdited() {
        return dateTimeEdited;
    }

    public void setDateTimeEdited(Date dateTimeEdited) {
        this.dateTimeEdited = dateTimeEdited;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

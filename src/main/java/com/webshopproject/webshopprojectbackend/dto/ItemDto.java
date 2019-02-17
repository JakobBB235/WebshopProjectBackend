package com.webshopproject.webshopprojectbackend.dto;

import com.webshopproject.webshopprojectbackend.models.Item;

import java.util.Date;

public class ItemDto {
    private long itemId;
    private String name;
    private int inStock;
    private String description;
    private boolean isActive;
    private String category;
    private double priceForOneItem; //double or string? might want to add 100kr. pr kilo
    private String weightMeasurement; //This is used for priceBasedOnWeight. For example g or kg
    private double priceBasedOnWeight;
    private Date dateTimeCreated;
    private Date dateTimeEdited;
    private Date expirationDate;
    private long userId;

    //Add new item item
    public Item convertToItem(){ //is this needed?
        Item theItem = new Item();
//        theItem.setItemId(this.getItemId());
        //Check if value is not null?
        theItem.setName(this.getName());
        theItem.setInStock(this.getInStock());
        theItem.setDescription(this.getDescription());
        theItem.setActive(this.isActive());
        theItem.setCategory(this.getCategory());
        theItem.setPriceForOneItem(this.getPriceForOneItem());
        theItem.setWeightMeasurement(this.getWeightMeasurement());
        theItem.setPriceBasedOnWeight(this.getPriceBasedOnWeight());
//        theItem.setDateTimeCreated(this.getDateTimeCreated());
//        theItem.setDateTimeEdited(this.getDateTimeEdited());
        theItem.setExpirationDate(this.getExpirationDate());

        return theItem;
    }

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

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}

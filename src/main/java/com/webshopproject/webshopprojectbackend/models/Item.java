package com.webshopproject.webshopprojectbackend.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long itemId;
    private String name;
    private int inStock;
    private String description;
    private boolean isActive;
    private String category;
//    private boolean isPriceBasedOnWeight; //Make if statement in angular html and boolean in ts file
    private double priceForOneItem; //double or string? might want to add 100kr. pr kilo
    private String weightMeasurement; //This is used for priceBasedOnWeight. For example g or kg
    private String priceBasedOnWeight;
    private Date dateTimeCreated;
    private Date dateTimeEdited;
    private Date expirationDate;

    //Add picture
    //@Lob
    //private byte[] thumpNail;

    //@Lob
    //private List<byte[]> images;

    //Relations


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


}

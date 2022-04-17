package com.hci.galleryFloor.gallery.dto;

import com.hci.galleryFloor.common.dto.TimestampedDTO;

import java.util.HashSet;
import java.util.Set;

public class ProductDTO  extends TimestampedDTO {

    private String name;
    private float width;
    private float height;
    private boolean status;
    private float quantity;
    private float price;
    private String description;
    private Set<OrderDTO> orders;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<OrderDTO> getOrders() {
        if(orders == null){
            orders = new HashSet<>();
        }
        return orders;
    }

    public void setOrders(Set<OrderDTO> orders) {
        this.orders = orders;
    }
}

package com.hci.galleryFloor.gallery.domain;

import com.hci.galleryFloor.common.domain.Timestamped;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Product extends Timestamped {

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private float width;
    @Column(nullable = false)
    private float height;
    @Column(nullable = false, columnDefinition = "boolean default false")
    private Boolean status;
    @Column(nullable = false)
    private float quantity;
    @Column(nullable = false)
    private float price;
    @Column(columnDefinition = "text")
    private String description;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name = "products_orders",
            joinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "orders_id", referencedColumnName = "id")
    )
    Set<OrderPlaced> orders;

    @ManyToOne(optional = false)
    @JoinColumn(name = "category_id")
    private Category category;

    public Product(String name, float width, float height, Boolean status, float quantity, float price, String description) {
        this.name = name;
        this.width = width;
        this.height = height;
        this.status = status;
        this.quantity = quantity;
        this.price = price;
        this.description = description;
    }

    public Product() {

    }

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

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Set<OrderPlaced> getOrders() {
        return orders;
    }

    public void setOrders(Set<OrderPlaced> orders) {
        this.orders = orders;
    }
}

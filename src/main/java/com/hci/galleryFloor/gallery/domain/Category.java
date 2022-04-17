package com.hci.galleryFloor.gallery.domain;

import com.hci.galleryFloor.common.domain.Timestamped;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Category extends Timestamped {

    private String name;

    public Category(String name) {
        this.name = name;
    }


    @OneToMany(mappedBy = "category")
    private Set<Product> products;

    public Category() {
        products = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}

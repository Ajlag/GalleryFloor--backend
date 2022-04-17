package com.hci.galleryFloor.gallery.dto;

import com.hci.galleryFloor.common.dto.TimestampedDTO;

import java.util.HashSet;
import java.util.Set;

public class CategoryDTO  extends TimestampedDTO {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private Set<ProductDTO> products;

    public Set<ProductDTO> getProducts() {
        if(products == null){
            products = new HashSet<>();
        }
        return products;
    }

    public void setProducts(Set<ProductDTO> products) {
        this.products = products;
    }
}

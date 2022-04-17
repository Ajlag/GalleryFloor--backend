package com.hci.galleryFloor.gallery.dto;

import com.hci.galleryFloor.common.dto.TimestampedDTO;

import java.util.HashSet;
import java.util.Set;

public class UserDTO extends TimestampedDTO {

    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private Boolean deleted;

    private Set<OrderDTO> orders;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
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

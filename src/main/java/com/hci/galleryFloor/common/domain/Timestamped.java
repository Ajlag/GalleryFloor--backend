package com.hci.galleryFloor.common.domain;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Objects;

@MappedSuperclass
public abstract class Timestamped {

    public static final String ISO_8601_TIMESTAMP_FORMAT = "yyyy-MM-dd'T'HH:mm:ssZZ";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if( o == null || getClass() !=o.getClass()) return  false;
        Timestamped that = (Timestamped) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {return Objects.hash(id);}
}

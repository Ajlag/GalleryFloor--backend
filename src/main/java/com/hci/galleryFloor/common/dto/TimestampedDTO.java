package com.hci.galleryFloor.common.dto;

import java.io.Serializable;
import java.util.Objects;

public abstract class TimestampedDTO implements Serializable {

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return  true;
        if(o==null || getClass() != o.getClass()) return false;
        TimestampedDTO that=(TimestampedDTO) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() { return Objects.hash(id);}
}

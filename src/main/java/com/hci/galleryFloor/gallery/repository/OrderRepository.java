package com.hci.galleryFloor.gallery.repository;

import com.hci.galleryFloor.gallery.domain.OrderPlaced;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<OrderPlaced, Long> {

    List<OrderPlaced> findAll();

    Optional<OrderPlaced> findByEmail(String email);


}
